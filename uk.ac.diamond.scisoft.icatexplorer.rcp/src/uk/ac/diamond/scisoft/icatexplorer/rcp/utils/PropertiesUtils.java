package uk.ac.diamond.scisoft.icatexplorer.rcp.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class PropertiesUtils {
	
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class); 

	
	/* *
	 * Reads properties from configuration file.
	 * @returns set of properties
	 */
	public static Properties readConfigFile() {
		ResourceBundle bundle = null;
		Properties properties = null;

		boolean wsdlLocationVerified = false;
		boolean namespaceUriVerified = false;
		boolean namespaceLocalPartVerified = false;
		boolean truststoreWindowsPathVerified = false;
		boolean truststoreUnixPathVerified = false;
		boolean truststorePasswordVerified = false;
		boolean downloadDirVerified = false;
		boolean inServerVerified = false;
		boolean exServerVerified = false;

		try {
			bundle = new PropertyResourceBundle(
					PropertiesUtils.class
					.getResourceAsStream("/conf/icatexplorer.properties"));
			
			logger.debug("properties file loaded");
			
			properties = new Properties();
			Enumeration<String> keys = bundle.getKeys();
						
			while (keys.hasMoreElements()) {
				String prop = (String) keys.nextElement();
				//logger.debug("prop= " + prop);
				String val = bundle.getString(prop);

				// check whether all required keys and (non null) values are
				// present
				if ((prop != null) && (prop.equals("wsdl.location"))) {
					if ((val != null) && (val.length() > 0))
						wsdlLocationVerified = true;
					//logger.debug("wsdlLocation = " + val);
				}
				if ((prop != null) && (prop.equals("namespace.uri"))) {
					if ((val != null) && (val.length() > 0))
						namespaceUriVerified = true;
				}
				if ((prop != null) && (prop.equals("namespace.localpart"))) {
					if ((val != null) && (val.length() > 0))
						namespaceLocalPartVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore.path.windows"))) {
					if ((val != null) && (val.length() > 0))
						truststoreWindowsPathVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore.path.unix"))) {
					if ((val != null) && (val.length() > 0))
						truststoreUnixPathVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore.password"))) {
					if ((val != null) && (val.length() > 0))
						truststorePasswordVerified = true;
				}
				if ((prop != null) && (prop.equals("download.dir"))) {
					if ((val != null) && (val.length() > 0))
						downloadDirVerified = true;
				}
				if ((prop != null) && (prop.equals("internal.sftp.server"))) {
					if ((val != null) && (val.length() > 0))
						inServerVerified = true;
				}
				if ((prop != null) && (prop.equals("external.sftp.server"))) {
					if ((val != null) && (val.length() > 0))
						exServerVerified = true;
				}
				
				properties.setProperty(prop, val);
			}// end while

			// in case one of the keys/values is missing
			if (!wsdlLocationVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that wsdl.location key is supplied");
			if (!namespaceUriVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that namespace.uri key is supplied");
			if (!namespaceLocalPartVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that namespace.localpart key is supplied");
			if (!truststoreWindowsPathVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that trustore.path.windows key is supplied");
			if (!truststoreUnixPathVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that trustore.path.unix key is supplied");
			if (!truststorePasswordVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that truststore.password key is supplied");
			if (!downloadDirVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that download.dir key is supplied");
			if (!inServerVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that internal.sftp.server key is supplied");
			if (!exServerVerified)
				throw new Exception(
						"Please check icatexplorer.properties file to ensure that external.sftp.server key is supplied");

		} catch (Exception io) {
			io.printStackTrace();
			System.exit(0);
		}// end try/catch

		return properties;
	}

	/*
	 * to simplify testing - should be removed in production
	 * **/ 
	public static Properties readCredentialsFile() {
		ResourceBundle bundle = null;
		Properties properties = null;

		boolean fedidVerified = false;
		boolean passwordVerified = false;
		
		try {
			bundle = new PropertyResourceBundle(
					PropertiesUtils.class
					.getResourceAsStream("/conf/credentials.properties"));
			
			logger.debug("credential config file loaded");
			
			properties = new Properties();
			Enumeration<String> keys = bundle.getKeys();
						
			int counter = 0;
			while (keys.hasMoreElements()) {
				String prop = (String) keys.nextElement();
				String val = bundle.getString(prop);

				// check whether all required keys and (non null) values are
				// present
				if ((prop != null) && (prop.equals("fedid"))) {
					if ((val != null) && (val.length() > 0))
						fedidVerified = true;
				}
				if ((prop != null) && (prop.equals("passsword"))) {
					if ((val != null) && (val.length() > 0))
						passwordVerified = true;
				}
				
				properties.setProperty(prop, val);
			}// end while

			// in case one of the keys/values is missing
			if (!fedidVerified)
				throw new Exception(
						"Please check credentials.properties file to ensure that fedid key is supplied");
			if (!passwordVerified)
				throw new Exception(
						"Please check credentials.properties file to ensure that password key is supplied");
			
		} catch (Exception io) {
			//io.printStackTrace();
			//System.exit(0);
			
			logger.debug("credentials.properties does not exist");
			
		}// end try/catch

		return properties;
	}
}
