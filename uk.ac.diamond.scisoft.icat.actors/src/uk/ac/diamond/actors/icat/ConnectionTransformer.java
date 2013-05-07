/*
 * Copyright 2013 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.diamond.actors.icat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dawb.passerelle.actors.file.SubstituteTransformer;
import org.dawb.passerelle.common.message.DataMessageComponent;
import org.dawb.passerelle.common.message.DataMessageException;
import org.dawb.passerelle.common.message.IVariable;
import org.dawb.passerelle.common.message.MessageUtils;
import org.dawb.passerelle.common.message.Variable;
import org.dawb.passerelle.common.message.IVariable.VARIABLE_TYPE;
import org.dawb.passerelle.editors.SubstitutionParticipant;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.data.expr.StringParameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

import com.isencia.passerelle.actor.ProcessingException;
import com.isencia.passerelle.actor.TerminationException;

public class ConnectionTransformer extends SubstituteTransformer implements SubstitutionParticipant{

	private static final long serialVersionUID = 1312885325541751197L;
	
	private static final String RUN_IN_ECLIPSE = "run.in.eclipse";

	private String token;
	protected String   wsdl;
	protected StringParameter   pass;
	protected StringParameter   downloadDir;
	protected String   truststore;
	protected String   truststorepass;


	public ConnectionTransformer(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super(container, name);
		
		Properties properties = PropertiesUtils.readConfigFile();
		
		this.templateParam.setDisplayName("WSDL Location");
		templateParam.setExpression(properties.getProperty("wsdl_location"));
		wsdl = templateParam.getExpression();
		
		this.outputParam.setDisplayName("TrustStore Path");
		/**
		 * pointing to the certificates folder within the application bundles
		 */
        Bundle bundle = Platform.getBundle(ICATActorActivator.PLUGIN_ID);

        String bundleLoc = bundle.getLocation().replace("reference:file:", "");
        bundleLoc = bundleLoc.replace("plugins/", "");
        
        String runProp = System.getProperty(RUN_IN_ECLIPSE);
    	boolean isRunningInEclipse = "true".equalsIgnoreCase(runProp);
    				
        File pluginsDir = getPluginsDirectory();
        File truststorePath = null;
        truststorePath = new File(combine(pluginsDir.getAbsolutePath(), bundleLoc), combine(properties.getProperty("truststore_subdir"), properties.getProperty("truststore_linux")));
        if(isRunningInEclipse)
        	truststorePath = new File(bundleLoc, combine(properties.getProperty("truststore_subdir"), properties.getProperty("truststore_linux")));
                                                                                                                                       
		outputParam.setExpression(truststorePath.getAbsolutePath());
		truststore = outputParam.getExpression();
		
		this.pass = new StringParameter(this, "TrustStore Password");
		pass.setExpression(properties.getProperty("truststore_password"));
		registerConfigurableParameter(pass);
		truststorepass = pass.getExpression();
		
		this.downloadDir = new StringParameter(this, "Download Directory");
		downloadDir.setExpression(System.getProperty("user.home"));
		registerConfigurableParameter(downloadDir);
		
	}

	@Override
	protected String getOperationName() {
		return "Creates a login ICAT actor";
	}

	public void attributeChanged(Attribute attribute) throws IllegalActionException {

		super.attributeChanged(attribute);
	}
	
	@Override
	public List<IVariable> getOutputVariables() {
		
		final List<IVariable> ret = super.getOutputVariables();
		ret.add(new Variable("wsdl",  VARIABLE_TYPE.SCALAR, wsdl,  String.class));
		ret.add(new Variable("truststore", VARIABLE_TYPE.SCALAR, truststore, Integer.class));
		ret.add(new Variable("token", VARIABLE_TYPE.SCALAR, token, String.class));
		
        return ret;
	}

	@Override
	protected DataMessageComponent getTransformedMessage(List<DataMessageComponent> cache) throws ProcessingException {

		final DataMessageComponent comp = new DataMessageComponent();

		try {
					
			final Map<String,String> scalar = MessageUtils.getScalar(cache);
			final String fedid    = scalar!=null ? scalar.get("fedid") : null;
			final String password = scalar!=null ? scalar.get("password") : null;

			ICATClient client = new ICATClient(wsdl, truststore, truststorepass, downloadDir.getExpression());
							
			token = client.login(fedid, password);
			
			Sessions.addSession(token, client);
			
			comp.addScalar(scalar);
			comp.putScalar("token", token);
			
		} catch (Throwable ne) {
			DataMessageException dme = super.createDataMessageException("Cannot login into ICAT!", ne);
			dme.getDataMessageComponent().putScalar("connection_error",  dme.getMessage());
			throw dme;
		}
		return comp; 
	}

	
	public void doWrapUp() throws TerminationException {
		super.doWrapUp();				
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionTransformer.class);

	@Override
	public String getDefaultSubstitution() {
		return null;
	}
	
    
    public static String combine (String path1, String path2)
    {
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }
   
    private File getPluginsDirectory() {
        Bundle b = Platform.getBundle(ICATActorActivator.PLUGIN_ID);
        logger.debug("Current plugin: {}", b);
        try {
                    File f = FileLocator.getBundleFile(b);
                    logger.debug("Bundle location: {}", f.getParent());

                    return f.getParentFile();
        } catch (IOException e) {
                        e.printStackTrace();
        }
        return null;
}
		
}
