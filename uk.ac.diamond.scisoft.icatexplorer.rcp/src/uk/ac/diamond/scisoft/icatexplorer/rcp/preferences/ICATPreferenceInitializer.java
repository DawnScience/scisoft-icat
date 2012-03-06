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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.ICATExplorerActivator;

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
		
		store.setDefault("ICAT_ID_PREF", "DLS"+ DELIMITER + "ISIS");
		store.setDefault("ICAT_NAME_PREF", "Diamond Light Source Ltd." + DELIMITER + "ISIS");
		store.setDefault("ICAT_WSDL_PREF", "https://facilities02.esc.rl.ac.uk:8181/ICATService/ICAT?wsdl"+ DELIMITER + "https://facilities01.esc.rl.ac.uk:8181/ICATService/ICAT?wsdl");
		store.setDefault("ICAT_SFTPSERVER_PREF", "linux.diamond.ac.uk" + DELIMITER+ "sftp.isis.ac.uk");		
		store.setDefault("ICAT_DOWNLOADDIR_PREF", System.getProperty("user.home") + DELIMITER+  System.getProperty("user.home"));
		
	}

}
