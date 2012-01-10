package uk.ac.diamond.scisoft.icatexplorer.rcp.utils;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NetworkUtils {
	
	private static Logger logger = LoggerFactory.getLogger(NetworkUtils.class);

	public static boolean insideDLS(InetAddress addr) {

		String hostname = addr.getCanonicalHostName();
		
		if (hostname.contains("diamond.ac.uk")) {
			logger.debug("Connected from INSIDE Diamond: " + hostname);
			return true;
		} else {
			logger.debug("Connected from OUTSIDE Diamond: " + hostname);
			return false;
		}
	}

}
