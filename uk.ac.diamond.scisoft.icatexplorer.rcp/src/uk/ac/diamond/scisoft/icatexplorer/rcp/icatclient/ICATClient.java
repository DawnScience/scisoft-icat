/*
 * Copyright 2012 Diamond Light Source Ltd.
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

package uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient;

import static java.nio.file.StandardCopyOption.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.OSDetector;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;
import uk.icat3.client.Dataset;
import uk.icat3.client.DatasetInclude;
import uk.icat3.client.ICAT;
import uk.icat3.client.ICATService;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.InvestigationInclude;
import uk.icat3.client.NoSuchObjectFoundException_Exception;
import uk.icat3.client.SessionException_Exception;

public class ICATClient{
	
	URL icatURL = null;
	static Properties properties;
	
	protected String fedid;
	protected String password; 
	protected String sessionId;
	protected String truststorePath;
	
    private static final Logger logger = LoggerFactory.getLogger(ICATClient.class); 
    

 	public ICATClient(){
 				
 		try {

 			logger.info("reading properties file");
 			properties = PropertiesUtils.readConfigFile();

 		} catch (Exception e) {
 			logger.error( "problem reading properties file", e);
 		}

 		logger.debug("truststore.location: " + properties.getProperty("truststore.location"));
 		System.out.println("(A) truststore: " + System.getProperty("javax.net.ssl.trustStore"));

 		// dynamically load the trust store as a stream and initialise it
 		InputStream trustStream;
 		try {
 			
 			trustStream = new FileInputStream(getTruststorePath2(properties.getProperty("truststore.location")));//"c:\\certs\\cacerts.jks");
 			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  

 			// if your store is password protected then declare it (it can be null however)
 			char[] trustPassword = properties.getProperty("truststore.password").toCharArray();

 			// load the stream to your store
 			trustStore.load(trustStream, trustPassword);

 			// initialise a trust manager factory with the trusted store
 			TrustManagerFactory trustFactory = 
 					TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());    
 			trustFactory.init(trustStore);

 			// get the trust managers from the factory
 			TrustManager[] trustManagers = trustFactory.getTrustManagers();

 			// initialise an ssl context to use these managers and set as default
 			SSLContext sslContext = SSLContext.getInstance("SSL");
 			sslContext.init(null, trustManagers, null);
 			SSLContext.setDefault(sslContext);

 			System.out.println("(B) truststore: " + System.getProperty("javax.net.ssl.trustStore"));
 		} catch (FileNotFoundException e) {
 			logger.error("Can't find truststore file: ", e);
 		} catch (KeyStoreException e) {
 			logger.error("Keystore problem: ", e);
 		} catch (NoSuchAlgorithmException e) {
 			logger.error("algorithm problem: ", e);
 		} catch (CertificateException e) {
 			logger.error("certificate problem: ", e);
 		} catch (IOException e) {
 			logger.error("file exception: ", e);
 		} catch (KeyManagementException e) {
 			logger.error("ssk key problem: ", e);

 		}    
 			
 		
// 		// temporary fix to make it work with windows 		
// 		if (!OSDetector.isWindows()){
// 			logger.debug("non-Windows system detected");
//			System.setProperty("javax.net.ssl.trustStore", getTruststorePath(properties.getProperty("truststore.location")));
//		} 		
// 		System.setProperty("javax.net.ssl.trustStorePassword", properties.getProperty("truststore.password"));
//		
// 		logger.debug("using truststore:" + System.getProperty("javax.net.ssl.trustStore"));
		
	}
	
	public static ICAT getIcat() throws Exception {
		
		URL icatServiceWsdlLocation = getServiceWsdlLocation();
							
		ICATService service = new ICATService(icatServiceWsdlLocation, new QName(properties.getProperty("namespace.uri"), properties.getProperty("namespace.localpart")));
				
		return service.getICATPort();
	}


	private static URL getServiceWsdlLocation() throws MalformedURLException {
		URL baseUrl = uk.icat3.client.ICATService.class.getResource(".");
		return new URL(baseUrl, properties.getProperty("wsdl.location"));
	}
		
		
    public String login(String fedid, String password) {
    	ICAT icat;
		try {
			this.fedid = fedid;
			this.password = password;
			
			icat = getIcat();
			this.sessionId = icat.login(fedid, password); 
			logger.info("User " + this.fedid + " logged in icat. sessionId: "+ this.sessionId);			
		
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("failed to authenticate! " , e);			
		}
		
		return sessionId;
    }
    
    
//    public String login(String fedid, String password) {
//    	
//        uk.icat3.client.admin.ICATAdmin icatAdminPort = null;
//        uk.icat3.client.ICAT icatPort = null;
//
//        try {
//
//            // Call Web Service Operation
//            URL adminURL = new URL("https://facilities02.esc.rl.ac.uk:8181/ICATAdminService/ICATAdmin?wsdl");//properties.getProperty("icatadmin_endpoint"));
//            icatAdminPort = new uk.icat3.client.admin.ICATAdminService(adminURL, new QName("admin.client.icat3.uk", "ICATAdminService")).getICATAdminPort();
//
//            ((BindingProvider)icatAdminPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://facilities02.esc.rl.ac.uk:8181/ICATAdminService/ICATAdmin?wsdl");//properties.getProperty("icatadmin_endpoint"));
//            ((BindingProvider)icatAdminPort).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "DLS-admin");//properties.getProperty("username"));
//            ((BindingProvider)icatAdminPort).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "TaunWuOd5");//properties.getProperty("password"));            
//                       
//            /*URL*/ icatURL =  new URL("https://facilities02.esc.rl.ac.uk:8181/ICATService/ICAT?wsdl");//new URL(properties.getProperty("icat_endpoint"));
//                        
//            icatPort = new uk.icat3.client.ICATService(icatURL, new QName("client.icat3.uk", "ICATService")).getICATPort();
//            ((BindingProvider)icatPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://facilities02.esc.rl.ac.uk:8181/ICATService/ICAT?wsdl");//properties.getProperty("icat_endpoint"));
//
//            logger.debug("Logging in...");
//            this.sessionId = icatAdminPort.loginAdmin(fedid);
//            this.fedid = fedid;
//            this.password = password;
//            
//            logger.debug("SessionId = " + sessionId);
//
//            
//
//        } catch (Exception ex) {
//            //ex.printStackTrace();
//            return null;
//        }
//        
//        return this.sessionId;
//				
//    }
      
    public void logout() {
    	
    	ICAT icat;
		try {			
			icat = getIcat();
			if (this.sessionId != null){
			icat.logout(this.sessionId);
			logger.info("User " + this.fedid + " logged out");			
			}else{
				logger.info("No user logged in to the ICAT");			
			}
			this.fedid = "";
			this.password = "";
			this.sessionId = "";
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("problem logging out! " , e);
		}
				
    }
    
    
    public List<Investigation> getLightInvestigations() throws MalformedURLException, SessionException_Exception, InsufficientPrivilegesException_Exception, NoSuchObjectFoundException_Exception{
        
    	ICAT icat;
    	List<Investigation> myInvestigations = null;
		try {
			
			long startTime = System.currentTimeMillis();
			icat = getIcat();
			
			logger.debug("Calling getInvestigations()...");
			myInvestigations = icat.getMyInvestigationsIncludes(this.sessionId, InvestigationInclude.NONE);
			
			long endTime = System.currentTimeMillis();
			long millis = endTime - startTime;

	        logger.info("execution time to retrieve [" + myInvestigations.size() + "] DATASETS is: " +String.format("%d min, %d sec", 		
				    TimeUnit.MILLISECONDS.toMinutes(millis),
				    TimeUnit.MILLISECONDS.toSeconds(millis) - 
				    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
				));
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error( "problem retrieving investigations for user: " + this.getFedId(), e);
		}
    	        
        return myInvestigations; 
    }
    
	public List<Dataset> getDatasets(Long id) {

		ICAT icat;
		List<Dataset> datasets = null;
		try {
			icat = getIcat();
			Investigation newInv = icat.getInvestigationIncludes(this.sessionId, id,
					InvestigationInclude.DATASETS_AND_DATASET_PARAMETERS_ONLY);

			datasets = newInv.getDatasetCollection();
			logger.debug("dataset collection size: "
					+ newInv.getDatasetCollection().size());
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error( "problem retrieving datasets for user: " + this.getFedId(), e);
		}
		
		return datasets;
	}
    

	public String getSessionId() {
		return this.sessionId;
	}
	
	public String getFedId() {
		return this.fedid;
	}
	
	public void setFedId(String fedid) {
		this.fedid = fedid;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getIcatHost(){
		
		URL url = null;
		try {
			url = new URL(properties.getProperty("wsdl.location"));
		} catch (MalformedURLException e) {
			logger.error("error parsing URL: " + url.toString(), e);
			//e.printStackTrace();
		}
		return url.getHost();
	}
	
	String getTruststorePath(String truststoreLocation) throws IOException {
		java.security.ProtectionDomain pd = ICATClient.class
				.getProtectionDomain();
		if (pd == null)
			return null;
		java.security.CodeSource cs = pd.getCodeSource();
		if (cs == null)
			return null;
		java.net.URL url = cs.getLocation();
		if (url == null)
			return null;
		java.io.File f = new File(url.getFile());
		if (f == null)
			return null;
		
		File truststorePath = new File(f.getAbsolutePath(), truststoreLocation);
			
		logger.debug("initial truststore in: " + truststorePath.getAbsolutePath());
		
		//Runtime.getRuntime().exec("chmod 777 " + truststorePath.getAbsolutePath());
		
		return truststorePath.getAbsolutePath();
		
	}
	
	String getTruststorePath2(String truststoreLocation) throws IOException {
		// getting home directory
		String tmpDir = System.getProperty("java.io.tmpdir");
		
		// copy truststore to current tmp directory
		java.security.ProtectionDomain pd = ICATClient.class
				.getProtectionDomain();
		if (pd == null)
			return null;
		java.security.CodeSource cs = pd.getCodeSource();
		if (cs == null)
			return null;
		java.net.URL url = cs.getLocation();
		if (url == null)
			return null;
		java.io.File f = new File(url.getFile());
		if (f == null)
			return null;
		
		File truststorePath = new File(f.getAbsolutePath(), truststoreLocation);
			
		logger.debug("initial truststore in: " + truststorePath.getAbsolutePath());
		
		// copy
		String filename = truststoreLocation.substring(truststoreLocation.indexOf("/"));
		File destFile = new File(tmpDir, filename);
        logger.debug("copying from " + truststorePath.getAbsolutePath() + " to " + destFile.getAbsolutePath());
	    copy(truststorePath.getAbsolutePath(), destFile.getAbsolutePath());    
		
		// set permissions on new truststore
		// for all except Windows
		if (!OSDetector.isWindows()){
		try {
			Runtime.getRuntime().exec("chmod 777 " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		return destFile.getAbsolutePath();		
	}

	public Dataset getDataset(Long datasetId) {
		
		ICAT icat;
		try {
			icat = getIcat();
			return icat.getDatasetIncludes(this.sessionId, datasetId, DatasetInclude.DATASET_PARAMETERS_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void copy(String fromFileName, String toFileName){
		    FileInputStream fIn;
		    FileOutputStream fOut;
		    FileChannel fIChan, fOChan;
		    long fSize;
		    MappedByteBuffer mBuf;

		    try {
		      fIn = new FileInputStream(fromFileName);
		      fOut = new FileOutputStream(toFileName);

		      fIChan = fIn.getChannel();
		      fOChan = fOut.getChannel();

		      fSize = fIChan.size();

		      mBuf = fIChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

		      fOChan.write(mBuf); // this copies the file

		      fIChan.close();
		      fIn.close();

		      fOChan.close();
		      fOut.close();
		    } catch (IOException e) {
		      logger.error("problem copying file: ", e);
		    } 
		  }
	
}
