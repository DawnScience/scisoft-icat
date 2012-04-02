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
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	protected String truststorePass;
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


	public ICATClient(ICATConnection icatCon, String truststore,  String truststorePass, String downloadDir, String projectName){

		this.icatCon = icatCon;
		this.truststorePath = truststore;
		this.truststorePass = truststorePass;
		this.downloadDir = downloadDir;
		this.projectName = projectName;


		logger.debug("setting trust manager ...");

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


		logger.debug("truststore file set to: " + truststorePath + "  and truststore password set to: " + truststorePass);

	}

	public static ICAT getIcat() throws Exception {

		URL icatServiceWsdlLocation = getServiceWsdlLocation();

		ICATService service = new ICATService(icatServiceWsdlLocation, new QName("client.icat3.uk", "ICATService"));

		return service.getICATPort();
	}


	private static URL getServiceWsdlLocation() throws MalformedURLException {
		URL baseUrl = uk.icat3.client.ICATService.class.getResource(".");

		return new URL(baseUrl, icatCon.getWsdlLocation());
	}

	public String login(String fedid, String password) {

		try {

			this.fedid = fedid;
			this.password = password;

			ICAT icat = getIcat();

			sessionId = icat.login(fedid, password);

			logger.info("User " + this.fedid + " logged in icat. sessionId: " +
					sessionId);

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


	public void logout() {

		ICAT icat;
		try {
			icat = getIcat();
			if (this.sessionId != null) {

				icat.logout(this.sessionId);
				ICATSessions.remove(sessionId);

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
			return icat.getDatasetIncludes(this.sessionId, datasetId,
					DatasetInclude.DATASET_PARAMETERS_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
