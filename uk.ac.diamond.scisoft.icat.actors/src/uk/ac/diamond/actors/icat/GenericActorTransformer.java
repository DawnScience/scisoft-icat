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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.dawb.passerelle.common.actors.AbstractDataMessageTransformer;
import org.dawb.passerelle.common.message.IVariable;
import org.dawb.passerelle.common.message.IVariable.VARIABLE_TYPE;
import org.dawb.passerelle.common.message.IVariableProvider;
import org.dawb.passerelle.common.message.MessageUtils;
import org.dawb.passerelle.common.message.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.data.expr.StringParameter;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import uk.ac.diamond.scisoft.analysis.message.DataMessageComponent;

import com.isencia.passerelle.actor.ProcessingException;
import com.isencia.passerelle.actor.TerminationException;
import com.isencia.passerelle.util.ptolemy.FileParameter;
import com.thoughtworks.xstream.XStream;

public class GenericActorTransformer extends AbstractDataMessageTransformer implements IVariableProvider {

	private static final long serialVersionUID = 13128887976847L;

	private List<?> genericResult = null;
	private String query;
	private String outputFile;

	private StringParameter queryParam;
	private FileParameter outputFileParam;
	
	XStream xstream = new XStream();

	public GenericActorTransformer(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super(container, name);
		
		String queryExample = "Investigation INCLUDE InvestigationParameter, Instrument";
		
		queryParam = new StringParameter(this, "Query");
		queryParam.setExpression(queryExample);
		query = queryParam.getExpression();
		registerConfigurableParameter(queryParam);
		
		File fileExample = new File(System.getProperty("user.home"),"result.xml");

		outputFileParam = new FileParameter(this, "Result File");
		outputFileParam.setExpression(fileExample.getAbsolutePath());
		outputFile = outputFileParam.getExpression();
		registerConfigurableParameter(outputFileParam);

	}

	@Override
	protected String getOperationName() {
		return "Creates a generic ICAT actor";
	}

	public void attributeChanged(Attribute attribute) throws IllegalActionException {
		if (attribute == queryParam){
			query = queryParam.getExpression();
		}else if (attribute == outputFileParam){
			outputFile = outputFileParam.getExpression();
		}
		
		super.attributeChanged(attribute);
	}

	@Override
	protected DataMessageComponent getTransformedMessage(List<DataMessageComponent> cache) throws ProcessingException {

		final DataMessageComponent comp = new DataMessageComponent();

		try {
					
			final Map<String,String> scalar = MessageUtils.getScalar(cache);
			final String token    = scalar!=null ? scalar.get("token") : null;
														
			final ICATClient client = Sessions.getSession(token);	
							
			genericResult = client.getGenericResult(query);
			
			comp.addScalar(scalar);
			comp.putScalar("generic_result", xstream.toXML(genericResult));
			comp.putScalar("file_path", outputFile);
			
			// save result into file
			writeToFile( xstream.toXML(genericResult) , new File(outputFile));
						
		} catch (Exception ne) {
			
			comp.putScalar("error_text", "Error getting result from ICAT");
		}
		return comp; 
	}
	
	// write result to file
	private void writeToFile(String xml, File file) {
		
		try {
			 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(xml);
			bw.close();
 
			logger.debug("Result written to " + file.getAbsolutePath());
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<IVariable> getOutputVariables() {
		
		final List<IVariable> ret = super.getOutputVariables();
		ret.add(new Variable("query",  VARIABLE_TYPE.SCALAR, query,  String.class));
		ret.add(new Variable("generic_result",  VARIABLE_TYPE.SCALAR, xstream.toXML(genericResult),  String.class));
			
        return ret;
	}
	
	public void doWrapUp() throws TerminationException {
		super.doWrapUp();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionTransformer.class);
		
}
