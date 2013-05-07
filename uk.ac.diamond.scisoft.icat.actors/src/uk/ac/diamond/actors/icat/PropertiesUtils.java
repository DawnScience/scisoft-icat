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
	 * 
	 * @returns set of properties
	 */
	public static Properties readConfigFile() {
		ResourceBundle bundle = null;
		Properties properties = null;

		boolean dlsWsdlLocationVerified = false;
		boolean dlsTruststoreLinuxVerified = false;	
		boolean dlsTruststoreWindowsVerified = false;	
		boolean dlsTruststorePasswordVerified = false;
		boolean dlsSftpServerVerified = false;

		
		try {
			bundle = new PropertyResourceBundle(PropertiesUtils.class.getResourceAsStream("/conf/icatexplorer.properties"));

			logger.debug("properties file loaded");

			properties = new Properties();
			Enumeration<String> keys = bundle.getKeys();

			while (keys.hasMoreElements()) {
				String prop = keys.nextElement();
				String val = bundle.getString(prop);

				/*
				 *  check whether all required keys and (non null) values are
				 *  present
				 */
				if ((prop != null) && (prop.equals("wsdl_location"))) {
					if ((val != null) && (val.length() > 0))
						dlsWsdlLocationVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore_linux"))) {
					if ((val != null) && (val.length() > 0))
						dlsTruststoreLinuxVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore_windows"))) {
					if ((val != null) && (val.length() > 0))
						dlsTruststoreWindowsVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore_password"))) {
					if ((val != null) && (val.length() > 0))
						dlsTruststorePasswordVerified = true;
				}
				if ((prop != null) && (prop.equals("sftp_server"))) {
					if ((val != null) && (val.length() > 0))
						dlsSftpServerVerified = true;
				}

				properties.setProperty(prop, val);
			}// end while
			
			// in case one of the keys/values is missing
			if (!dlsWsdlLocationVerified)
				logger.error("Please check icatexplorer.properties file to ensure that wsdl_location key is supplied");	
			if (!dlsTruststoreLinuxVerified)
				logger.error("Please check icatexplorer.properties file to ensure that truststore_linux key is supplied");
			if (!dlsTruststoreWindowsVerified)
				logger.error("Please check icatexplorer.properties file to ensure that truststore_windows key is supplied");
			if (!dlsTruststorePasswordVerified)
				logger.error("Please check icatexplorer.properties file to ensure that truststore_password key is supplied");			
			if (!dlsSftpServerVerified)
				logger.error("Please check icatexplorer.properties file to ensure that sftp_server key is supplied");

		} catch (Exception io) {
			io.printStackTrace();
			System.exit(0);
		}// end try/catch

		return properties;
	}

}
