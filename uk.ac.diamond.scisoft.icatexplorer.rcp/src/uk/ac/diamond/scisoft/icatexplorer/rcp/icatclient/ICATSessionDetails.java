package uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;

public final class ICATSessionDetails {
	
    private static final Logger logger = LoggerFactory.getLogger(ICATSessionDetails.class); 

	public static ICATClient icatClient = null;
	
	public ICATSessionDetails(ICATClient icatClient){
		
		this.icatClient = icatClient;	
		logger.debug("icatClient object initialized");
	}
	
	public static void setICAT(ICATClient icat){
		icatClient = icat;
		logger.debug("icatClient object initialized");

	}
	
}
