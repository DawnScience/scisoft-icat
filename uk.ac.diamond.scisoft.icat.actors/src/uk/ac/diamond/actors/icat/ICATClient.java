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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.namespace.QName;

import org.icatproject.Datafile;
import org.icatproject.Dataset;
import org.icatproject.ICAT;
import org.icatproject.ICATService;
import org.icatproject.Investigation;
import org.icatproject.Login;
import org.icatproject.Login.Credentials.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ICATClient {

	URL icatURL = null;

	protected String fedid;
	protected String password;
	protected String sessionId;
	protected static String wsdl;
	protected String truststorePath;
	protected String truststorePass;
	protected String downloadDir;
	protected String projectName;

	List<Investigation> currentInvestigations = new ArrayList<Investigation>();
	

	private static final Logger logger = LoggerFactory.getLogger(ICATClient.class);


	public ICATClient(String wsdl, String truststore,  String pass, String downloadDir){

		this.truststorePath = truststore;
		this.truststorePass = pass;
		this.downloadDir = downloadDir;
		this.wsdl = wsdl;
				
		TrustManager[] trustAllCerts = new TrustManager[1];

		trustAllCerts[0] = new TrustManager();
		KeyStore ks; char ctPass[] = truststorePass.toCharArray();char ksPass[] = truststorePass.toCharArray();
		try {
			ks = KeyStore.getInstance("JKS");
			ks.load(new FileInputStream(truststorePath), ksPass);
			KeyManagerFactory kmf =
					KeyManagerFactory.getInstance("SunX509");
			kmf.init(ks, ctPass);
			try {
				SSLContext sc = SSLContext.getInstance("SSL");
				sc.init(kmf.getKeyManagers(), trustAllCerts, null);

				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			} catch (Exception e) {
			}

		} catch (KeyStoreException e) {
			logger.error("problem setting security context: ", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("problem setting security context: ", e);
		} catch (CertificateException e) {
			logger.error("problem setting security context: ", e);
		} catch (FileNotFoundException e) {
			logger.error("problem setting security context: ", e);
		} catch (IOException e) {
			logger.error("problem setting security context: ", e);
		} catch (UnrecoverableKeyException e) {
			logger.error("problem setting security context: ", e);
		}

	}

	public static ICAT getIcat() throws Exception {

        ICATService service = new ICATService(getServiceWsdlLocation(), new QName("http://icatproject.org", "ICATService"));
		return service.getICATPort();
	}

	private static URL getServiceWsdlLocation() throws MalformedURLException {
		URL baseUrl = ICATService.class.getResource(".");
		return new URL(baseUrl, wsdl);
	}
	
	public String login(String fedid, String password) {

			this.fedid = fedid;
			this.password = password;
			ICAT icat;
			try {
				icat = getIcat();
				
				org.icatproject.Login.Credentials credentials = new Login.Credentials(); 
	            List<Login.Credentials.Entry> entries = credentials.getEntry(); 
	            Entry e;
	            e = new Entry(); 
	            e.setKey("username"); 
	            e.setValue(fedid); 
	            entries.add(e); 
	            e = new Entry(); 
	            e.setKey("password"); 
	            e.setValue(password); 
	            entries.add(e); 
	            String authenticator = "ldap";

	            this.sessionId = icat.login(authenticator, credentials);
	            
	            if(sessionId == null){
	            	throw new Exception("Error connecting to ICAT!");
	            }
	            						
			} catch (Exception e1) {
				logger.error("error login into ICAT: ", e1);
			}
			
		return sessionId;
	}

	public String getICATVersion(){

		String versionId = "";

		ICAT icat;

		try {
			icat = getIcat();
			versionId =
					icat.getApiVersion();
		} catch (Exception e) {
			logger.error("problem getting ICAT api version: " + e);
		}

		return versionId;
	}


	public void logout() {

		ICAT icat;
		try {
			icat = getIcat();
			if (this.sessionId != null) {

				icat.logout(this.sessionId);
				//ICATSessions.remove(sessionId);

				logger.info("User " + this.fedid + " logged out");
			} else {
				logger.info("No user logged in to the ICAT");
			}
			this.fedid = "";
			this.password = "";
			this.sessionId = "";
		} catch (Exception e) {
			logger.error("problem logging out! ", e);
		}

	}

	public List<Investigation> getLightInvestigations(){

		ICAT icat;
		try {

			icat = getIcat();

			logger.debug("Calling getLightInvestigations()...sessionid: " + sessionId);
			
			String query = "Investigation INCLUDE InvestigationParameter, Instrument";
            List<?> result = icat.search(sessionId, query);
                        
            // populating currentInvestigations
            for (int count=0; count< result.size(); count++){
            	Investigation inv = (Investigation) result.get(count);
            	
            	currentInvestigations.add(inv);
            }
            
                                 
		} catch (Exception e) {
			logger.error("problem retrieving investigations for user: "	+ this.getFedId(), e);		
		}
		
		return currentInvestigations;
	}

	public List<Dataset> getDatasets(Long id) {
		// id of the parent investigation
		ICAT icat;
		List<Dataset> datasets = null;
		try {
			icat = getIcat();
			
			String query = "Investigation INCLUDE InvestigationParameter, Dataset";
            Investigation newInv = (Investigation)icat.get(sessionId, query, id);
			
			datasets = newInv.getDatasets();
			
		} catch (Exception e) {
			logger.error(
					"problem retrieving datasets for user: " + this.getFedId(),
					e);
		}

		return datasets;
	}

	public List<Datafile> getDatafiles(Long datasetId) {
		
		List<Datafile> datafiles = null;

		try {
			ICAT icat = getIcat();
			String query = "Dataset INCLUDE DatasetParameter, Datafile";
            Dataset dataset = (Dataset)icat.get(sessionId, query, datasetId);
			datafiles = dataset.getDatafiles();

		} catch (Exception e) {
			logger.error(
					"problem retrieving datafiles for user: " + this.getFedId(),
					e);
		}

		return datafiles;
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

	public String getDownloadDir() {
		return this.downloadDir;
	}

	public Dataset getDataset(Long datasetId) {

		ICAT icat;
		try {
			icat = getIcat();
			
			String query = "Dataset";
            Dataset dataset = (Dataset)icat.get(sessionId, query, datasetId);
            
            return dataset;
			
		} catch (Exception e) {
			logger.error("Error in getDataset: ", e);
			return null;

		}
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public List<Investigation> getCurrentInvestigations() {
		return currentInvestigations;
	}

	public List<?> getGenericResult(String query) {
		 List<?> resultList = null;
		
		try {
			
			ICAT icat = getIcat();
			resultList = icat.search(sessionId, query);
			 
		} catch (Exception e) {
			logger.error(
					"problem retrieving query result for user: " + this.getFedId(),
					e);
		}

		return resultList;
		
	}
	

}
