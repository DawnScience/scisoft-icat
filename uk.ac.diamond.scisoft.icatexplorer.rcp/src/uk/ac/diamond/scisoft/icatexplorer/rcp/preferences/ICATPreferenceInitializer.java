/*
 * Copyright © 2011 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package uk.ac.diamond.scisoft.icatexplorer.rcp.preferences;

import java.util.Properties;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;

public class ICATPreferenceInitializer extends AbstractPreferenceInitializer {

	public static final String DELIMITER =  "-----";

	private static Logger logger = LoggerFactory.getLogger(ICATPreferenceInitializer.class);

	public ICATPreferenceInitializer() {
		super();
	}

	@Override
	public void initializeDefaultPreferences() {

		logger.debug("initializing ICAT preferences...");

		IPreferenceStore store = ICATExplorerActivator.getDefault().getPreferenceStore();
		
		Properties properties = new Properties();
		try {
			logger.info("reading properties file");
			properties = PropertiesUtils.readConfigFile();

		} catch (Exception e) {
			logger.error("problem reading properties file", e);
		}

		// Initialising default parameters from configuration file
		String SITE_ID_DLS = properties.getProperty("site_id_dls") ;
		String SITE_ID_ISIS = properties.getProperty("site_id_isis");

		String SITE_NAME_DLS = properties.getProperty("site_name_dls") ;
		String SITE_NAME_ISIS = properties.getProperty("site_name_isis");

		String WSDL_LOCATION_DLS = properties.getProperty("wsdl_location_dls") ;
		String WSDL_LOCATION_ISIS = properties.getProperty("wsdl_location_isis");

//		TODO to be used later on		
//		String TRUSTSTORE_LINUX_DLS = properties.getProperty("truststore_linux_dls");
//		String TRUSTSTORE_LINUX_ISIS = properties.getProperty("truststore_linux_isis");
//
//		String TRUSTSTORE_WINDOWS_DLS = properties.getProperty("truststore_windows_dls");
//		String TRUSTSTORE_WINDOWS_ISIS = properties.getProperty("truststore_windows_isis");
//
//		String TRUSTSTORE_PASSWORD_DLS = properties.getProperty("truststore_password_dls");
//		String TRUSTSTORE_PASSWORD_ISIS = properties.getProperty("truststore_password_isis");

		String SFTP_SERVER_DLS = properties.getProperty("sftp_server_dls");
		String SFTP_SERVER_ISIS = properties.getProperty("sftp_server_isis");	
		
		
		logger.debug("collected SITE_ID_DLS= " + SITE_ID_DLS);
		logger.debug("collected SITE_NAME_DLS= " + SITE_NAME_DLS);
		
		store.setDefault("ICAT_ID_PREF", SITE_ID_DLS + DELIMITER + SITE_ID_ISIS);
		store.setDefault("ICAT_NAME_PREF", SITE_NAME_DLS + DELIMITER + SITE_NAME_ISIS);
		store.setDefault("ICAT_WSDL_PREF", WSDL_LOCATION_DLS + DELIMITER + WSDL_LOCATION_ISIS);
		store.setDefault("ICAT_SFTPSERVER_PREF", SFTP_SERVER_DLS + DELIMITER + SFTP_SERVER_ISIS);		
		store.setDefault("ICAT_DOWNLOADDIR_PREF", System.getProperty("user.home") + DELIMITER+  System.getProperty("user.home"));

	}

}
