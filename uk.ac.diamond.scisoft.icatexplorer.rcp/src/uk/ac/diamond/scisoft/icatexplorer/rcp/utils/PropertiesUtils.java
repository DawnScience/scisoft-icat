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

package uk.ac.diamond.scisoft.icatexplorer.rcp.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PropertiesUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(PropertiesUtils.class);

	/* *
	 * Reads properties from configuration file.
	 * 
	 * @returns set of properties
	 */
	public static Properties readConfigFile() {
		ResourceBundle bundle = null;
		Properties properties = null;

		boolean wsdlLocationDLSVerified = false;
		boolean wsdlLocationISISVerified = false;
		boolean namespaceUriVerified = false;
		boolean namespaceLocalPartVerified = false;
		boolean truststoreDLSLocationVerified = false;
		boolean truststoreISISLocationVerified = false;
		boolean truststorePasswordVerified = false;
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
				String prop = keys.nextElement();
				// logger.debug("prop= " + prop);
				String val = bundle.getString(prop);

				// check whether all required keys and (non null) values are
				// present
				if ((prop != null) && (prop.equals("wsdl.location.dls"))) {
					if ((val != null) && (val.length() > 0))
						wsdlLocationDLSVerified = true;
					// logger.debug("wsdlLocation = " + val);
				}
				if ((prop != null) && (prop.equals("wsdl.location.isis"))) {
					if ((val != null) && (val.length() > 0))
						wsdlLocationISISVerified = true;
				}
				if ((prop != null) && (prop.equals("namespace.uri"))) {
					if ((val != null) && (val.length() > 0))
						namespaceUriVerified = true;
				}
				if ((prop != null) && (prop.equals("namespace.localpart"))) {
					if ((val != null) && (val.length() > 0))
						namespaceLocalPartVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore.location.dls"))) {
					if ((val != null) && (val.length() > 0))
						truststoreDLSLocationVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore.location.isis"))) {
					if ((val != null) && (val.length() > 0))
						truststoreISISLocationVerified = true;
				}
				if ((prop != null) && (prop.equals("truststore.password"))) {
					if ((val != null) && (val.length() > 0))
						truststorePasswordVerified = true;
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
			if (!wsdlLocationDLSVerified)
				logger.error("Please check icatexplorer.properties file to ensure that wsdl.location.dls key is supplied");
			if (!wsdlLocationISISVerified)
				logger.error("Please check icatexplorer.properties file to ensure that wsdl.location.isis key is supplied");
			if (!namespaceUriVerified)
				logger.error("Please check icatexplorer.properties file to ensure that namespace.uri key is supplied");
			if (!namespaceLocalPartVerified)
				logger.error("Please check icatexplorer.properties file to ensure that namespace.localpart key is supplied");
			if (!truststoreDLSLocationVerified)
				logger.error("Please check icatexplorer.properties file to ensure that truststore.location.dls key is supplied");
			if (!truststoreISISLocationVerified)
				logger.error("Please check icatexplorer.properties file to ensure that truststore.location.isis key is supplied");
			if (!truststorePasswordVerified)
				logger.error("Please check icatexplorer.properties file to ensure that truststore.password key is supplied");
			if (!inServerVerified)
				logger.error("Please check icatexplorer.properties file to ensure that internal.sftp.server key is supplied");
			if (!exServerVerified)
				logger.error("Please check icatexplorer.properties file to ensure that external.sftp.server key is supplied");

		} catch (Exception io) {
			io.printStackTrace();
			System.exit(0);
		}// end try/catch

		return properties;
	}

	/*
	 * to simplify testing - should be removed in production *
	 */
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
				String prop = keys.nextElement();
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
				logger.error("Please check credentials.properties file to ensure that fedid key is supplied");
			if (!passwordVerified)
				logger.error("Please check credentials.properties file to ensure that password key is supplied");

		} catch (Exception io) {
			// io.printStackTrace();
			// System.exit(0);

			logger.debug("credentials.properties does not exist");

		}// end try/catch

		return properties;
	}
}
