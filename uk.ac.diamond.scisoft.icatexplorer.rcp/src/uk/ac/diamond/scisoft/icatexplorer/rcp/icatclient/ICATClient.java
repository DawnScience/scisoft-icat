
package uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;
//import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.OSDetector;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;
import uk.icat3.client.Dataset;
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
	
    private static final Logger logger = LoggerFactory.getLogger(ICATClient.class); 
    

 	public ICATClient(){
 		try {
 			
 			logger.info("reading properties file");
 			properties = PropertiesUtils.readConfigFile();
 			 			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error( "problem reading properties file", e);
		}
 		 		
 		// set ssl system properties
		if (OSDetector.isWindows()){
 	 		logger.debug("Windows OS detected");
 			System.setProperty("javax.net.ssl.trustStore", properties.getProperty("truststore.path.windows"));
 		}else{
 	 		logger.debug("non-Windows OS detected");
 	 		System.setProperty("javax.net.ssl.trustStore",properties.getProperty("truststore.path.unix"));
 		}
		
 		System.setProperty("javax.net.ssl.trustStorePassword", properties.getProperty("truststore.password"));
		
 		logger.debug("current system truststore: " + System.getProperty("javax.net.ssl.trustStore"));
		
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
}
