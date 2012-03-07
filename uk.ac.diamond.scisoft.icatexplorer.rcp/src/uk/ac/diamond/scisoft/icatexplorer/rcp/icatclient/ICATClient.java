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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.sftpclient.SftpClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.OSDetector;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;
import uk.icat3.client.Datafile;
import uk.icat3.client.Dataset;
import uk.icat3.client.DatasetInclude;
import uk.icat3.client.ICAT;
import uk.icat3.client.ICATService;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.InvestigationInclude;
import uk.icat3.client.NoSuchUserException_Exception;
import uk.icat3.client.SessionException;


public class ICATClient {

	URL icatURL = null;
	static Properties properties;
	
	protected static String icatdb;
	protected String fedid;
	protected String password;
	protected String sessionId;
	protected String truststorePath;
	protected String downloadDir;
	protected String projectName;
	static protected ICATConnection icatCon;

	
	public ICATConnection getIcatCon() {
		return icatCon;
	}

	public static void setIcatCon(ICATConnection icatCon) {
		ICATClient.icatCon = icatCon;
	}

	private static final Logger logger = LoggerFactory.getLogger(ICATClient.class);
	
	
	public ICATClient(ICATConnection icatCon, String downloadDir, String projectName) {

		String tpath = null;
		this.icatCon = icatCon;
		this.downloadDir = downloadDir;
		this.projectName = projectName;
		
		try {
			logger.info("reading properties file");
			properties = PropertiesUtils.readConfigFile();

		} catch (Exception e) {
			logger.error("problem reading properties file", e);
		}

//		logger.debug("truststore.location: "
//				+ properties.getProperty("truststore.location." + icatCon.getId()));
//		logger.debug("(A) truststore: "
//				+ System.getProperty("javax.net.ssl.trustStore"));

//		try {
//			tpath = getTruststorePath2(properties
//					.getProperty("truststore.location." + icatCon.getId()));
//		} catch (IOException e) {
//			logger.error("error setting truststore file: ", e);
//		}
		///
		tpath = "/dls/bl-misc/dropfiles2/certs/cacerts.jks";
		///
		System.setProperty("javax.net.ssl.trustStore", tpath);
		System.setProperty("javax.net.ssl.trustStorePassword",
				properties.getProperty("truststore.password"));

		logger.debug("using truststore: "
				+ System.getProperty("javax.net.ssl.trustStore"));

		// // dynamically load the trust store as a stream and initialise it
		// InputStream trustStream;
		// try {
		//
		// trustStream = new
		// FileInputStream(getTruststorePath(properties.getProperty("truststore.location")));//"c:\\certs\\cacerts.jks");
		// KeyStore trustStore =
		// KeyStore.getInstance("jks");//KeyStore.getDefaultType());
		//
		// // if your store is password protected then declare it (it can be
		// null however)
		// char[] trustPassword =
		// properties.getProperty("truststore.password").toCharArray();
		//
		// // load the stream to your store
		// trustStore.load(trustStream, trustPassword);
		//
		// // initialise a trust manager factory with the trusted store
		// TrustManagerFactory trustFactory =
		// TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		// trustFactory.init(trustStore);
		//
		// // get the trust managers from the factory
		// TrustManager[] trustManagers = trustFactory.getTrustManagers();
		//
		// // initialise an ssl context to use these managers and set as default
		// SSLContext sslContext = SSLContext.getInstance("SSL");
		// sslContext.init(null, trustManagers, null);
		// SSLContext.setDefault(sslContext);
		//
		// logger.debug("(B) truststore: " +
		// System.getProperty("javax.net.ssl.trustStore"));
		// } catch (FileNotFoundException e) {
		// logger.error("Can't find truststore file: ", e);
		// } catch (KeyStoreException e) {
		// logger.error("Keystore problem: ", e);
		// } catch (NoSuchAlgorithmException e) {
		// logger.error("algorithm problem: ", e);
		// } catch (CertificateException e) {
		// logger.error("certificate problem: ", e);
		// } catch (IOException e) {
		// logger.error("file exception: ", e);
		// } catch (KeyManagementException e) {
		// logger.error("ssk key problem: ", e);
		//
		// }

		// // temporary fix to make it work with windows
		// if (!OSDetector.isWindows()){
		// logger.debug("non-Windows system detected");
		// System.setProperty("javax.net.ssl.trustStore",
		// getTruststorePath(properties.getProperty("truststore.location")));
		// }
		// System.setProperty("javax.net.ssl.trustStorePassword",
		// properties.getProperty("truststore.password"));
		//
		// logger.debug("using truststore:" +
		// System.getProperty("javax.net.ssl.trustStore"));

	}

	public static ICAT getIcat() throws Exception {

		URL icatServiceWsdlLocation = getServiceWsdlLocation();
		
		//logger.debug("icatServiceWsdlLocation: " + icatServiceWsdlLocation.toString());

		ICATService service = new ICATService(icatServiceWsdlLocation, new QName("client.icat3.uk", "ICATService"));

		return service.getICATPort();
	}
	
	
	private static URL getServiceWsdlLocation() throws MalformedURLException {
		URL baseUrl = uk.icat3.client.ICATService.class.getResource(".");
				
		return new URL(baseUrl, icatCon.getWsdlLocation());//properties.getProperty("wsdl.location." + icatdb));
	}

	public String login(String fedid, String password) {
		
		try {
			
			this.fedid = fedid;
			this.password = password;
			
			ICAT icat = getIcat();
			
			sessionId = icat.login(fedid, password);
									
			logger.info("User " + this.fedid + " logged in icat. sessionId: " + 
					sessionId);
			
			// initialise sessionDetails // TO CHECK AS DONE FROM WIZARD
			ICATSessions.add(projectName, this);
			
		} catch (Exception e) {
			logger.error("failed to authenticate! ", e);
		}

		return sessionId;
	}
	
	public String getICATVersion(){
		
		String versionId = "";
		
		ICAT icat;
		
		try {
			icat = getIcat();
			versionId = 
					icat.getICATAPIVersion("x");
		} catch (Exception e) {
			logger.error("problem getting ICAT api version: " + e);
		}
		
		return versionId;
	}

//	public String login(String fedid, String password) {
//		
//		logger.debug("(1) loggin in ...> ");
//		
//		//fedid = "DLS-admin";
//		//password = "10Aqzq!Jr9$Y" ;
//		ICATAdmin icatAdminPort = null;
//		ICAT icatPort = null;
//
//		try {
//
//			// Call Web Service Operation
//			URL adminURL = new
//					URL("https://facilities02.esc.rl.ac.uk:8181/ICATAdminService/ICATAdmin?wsdl");//properties.getProperty("icatadmin_endpoint"));
//			icatAdminPort = new ICATAdminService(adminURL, new
//					QName("admin.client.icat3.uk", "ICATAdminService")).getICATAdminPort();
//
//			logger.debug("(2) logging in ...> ");
//
//			
//			((BindingProvider)icatAdminPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//					"https://facilities02.esc.rl.ac.uk:8181/ICATAdminService/ICATAdmin?wsdl");//properties.getProperty("icatadmin_endpoint"));
//			((BindingProvider)icatAdminPort).getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
//					"DLS-admin");//properties.getProperty("username"));
//			((BindingProvider)icatAdminPort).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
//					"10Aqzq!Jr9$Y");//properties.getProperty("password"));
//			
//			logger.debug("(3) logging in ...> ");
//
//			
//			/*URL*/ icatURL = new
//					URL("https://facilities02.esc.rl.ac.uk:8181/ICATService/ICAT?wsdl");//new URL(properties.getProperty("icat_endpoint"));
//
//			icatPort = new uk.icat3.client.ICATService(icatURL, new
//					QName("client.icat3.uk", "ICATService")).getICATPort();
//			
//			logger.debug("(4) loggin in ...> ");
//
//			
//			((BindingProvider)icatPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//					"https://facilities02.esc.rl.ac.uk:8181/ICATService/ICAT?wsdl");//properties.getProperty("icat_endpoint"));
//
//			logger.debug("Logging in...");
//			this.sessionId = icatAdminPort.loginAdmin(fedid);
//			this.fedid = fedid;
//			this.password = password;
//
//			logger.debug("SessionId = " + sessionId);
//
//
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			//return null;
//		}
//
//		return this.sessionId;
//
//	}

	public void logout() {

		ICAT icat;
		try {
			icat = getIcat();
			if (this.sessionId != null) {
				
				icat.logout(this.sessionId);
				ICATSessions.add(projectName, this);
				
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

	public List<Investigation> getLightInvestigations()
			throws MalformedURLException, SessionException,
			InsufficientPrivilegesException_Exception,
			NoSuchUserException_Exception {

		ICAT icat;
		List<Investigation> myInvestigations = null;
		try {

			long startTime = System.currentTimeMillis();
			icat = getIcat();

			logger.debug("Calling getInvestigations()...sessionid: " + sessionId);
			myInvestigations = icat.getMyInvestigationsIncludes(this.sessionId,
					InvestigationInclude.NONE);

			long endTime = System.currentTimeMillis();
			long millis = endTime - startTime;

			logger.info("execution time to retrieve ["
					+ myInvestigations.size()
					+ "] DATASETS is: "
					+ String.format(
							"%d min, %d sec",
							TimeUnit.MILLISECONDS.toMinutes(millis),
							TimeUnit.MILLISECONDS.toSeconds(millis)
									- TimeUnit.MINUTES
											.toSeconds(TimeUnit.MILLISECONDS
													.toMinutes(millis))));

		} catch (Exception e) {
			logger.error(
					"problem retrieving investigations for user: "
							+ this.getFedId(), e);
		}

		return myInvestigations;
	}

	public List<Dataset> getDatasets(Long id) {

		ICAT icat;
		List<Dataset> datasets = null;
		try {
			icat = getIcat();
			Investigation newInv = icat.getInvestigationIncludes(
					this.sessionId, id,
					InvestigationInclude.DATASETS_AND_DATASET_PARAMETERS_ONLY);

			datasets = newInv.getDatasetCollection();
			logger.debug("dataset collection size: "
					+ newInv.getDatasetCollection().size());

		} catch (Exception e) {
			// e.printStackTrace();
			logger.error(
					"problem retrieving datasets for user: " + this.getFedId(),
					e);
		}

		return datasets;
	}
	
	public List<Datafile> getDatafiles(Long datasetId) {

		List<Datafile> datafiles = null;
		try {
			Dataset dataset = ICATClient.getIcat()
					.getDatasetIncludes(sessionId, datasetId,
							DatasetInclude.DATASET_AND_DATAFILES_ONLY);

			datafiles = dataset.getDatafileCollection();
			
			logger.debug("datafiles number: " + datafiles.size());


		} catch (Exception e) {
			// e.printStackTrace();
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

//	public String getIcatHost() {
//
//		URL url = null;
//		try {
//			url = new URL(properties.getProperty("wsdl.location"));
//		} catch (MalformedURLException e) {
//			logger.error("error parsing URL: " + url.toString(), e);
//			// e.printStackTrace();
//		}
//		return url.getHost();
//	}

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

		logger.debug("initial truststore in: "
				+ truststorePath.getAbsolutePath());

		// set permissions on new truststore
		// for all except Windows
		if (!OSDetector.isWindows()) {
			try {
				Runtime.getRuntime().exec(
						"chmod 777 " + truststorePath.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		logger.debug("returning truststore: "
				+ truststorePath.getAbsolutePath());
		return truststorePath.getAbsolutePath();

	}

	String getTruststorePath2(String truststoreLocation) throws IOException {
		// getting home directory
		String tmpDir = System.getProperty("java.io.tmpdir");
		logger.debug("java.io.tmpdir: " + tmpDir);

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

		logger.debug("initial truststore in: "
				+ truststorePath.getAbsolutePath());

		// copy
		String filename = truststoreLocation.substring(truststoreLocation
				.indexOf("/"));
		File destFile = new File(tmpDir, filename);
		logger.debug("copying from " + truststorePath.getAbsolutePath()
				+ " to " + destFile.getAbsolutePath());
		try {
			copyFile(truststorePath, destFile);
		} catch (Exception e1) {
			logger.error("error copying file: ", e1);
		}

		// set permissions on new truststore
		// for all except Windows
		if (!OSDetector.isWindows()) {
			try {
				Runtime.getRuntime().exec(
						"chmod 777 " + destFile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		logger.debug("returning truststore: " + destFile.getAbsolutePath());
		return destFile.getAbsolutePath();
	}

	public Dataset getDataset(Long datasetId) {

		ICAT icat;
		try {
			icat = getIcat();
			return icat.getDatasetIncludes(this.sessionId, datasetId,
					DatasetInclude.DATASET_PARAMETERS_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void copyFile(File in, File out) throws Exception {
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


}
