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
 
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
 
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;
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
 
                                String TRUSTSTORE_SUBDIR = properties.getProperty("truststore_subdir");
                               
                                Bundle bundle = Platform.getBundle("uk.ac.diamond.scisoft.icatexplorer.rcp");
                                Path path = new Path(TRUSTSTORE_SUBDIR);                                                        
                           
                                // pointing to the certificates folder within the application bundles
                                String bundleLoc = bundle.getLocation().replace("reference:file:", "");
                                File truststorePath = new File(bundleLoc, path.toString());
                                                                
                                String TRUSTSTORE_DLS = combine(truststorePath.getAbsolutePath(), properties.getProperty("truststore_dls"));
                                
                                logger.debug("==================");
                                logger.debug("bundleLoc: " + bundleLoc);                              
                                logger.debug("TRUSTSTORE_DLS: " + TRUSTSTORE_DLS);
                                logger.debug("==================");

                         
                                String TRUSTSTORE_ISIS = combine(truststorePath.getAbsolutePath() , properties.getProperty("truststore_isis"));
                               
                                String TRUSTSTORE_PASSWORD_DLS = properties.getProperty("truststore_password_dls");
                                String TRUSTSTORE_PASSWORD_ISIS = properties.getProperty("truststore_password_isis");
 
                                String SFTP_SERVER_DLS = properties.getProperty("sftp_server_dls");
                                String SFTP_SERVER_ISIS = properties.getProperty("sftp_server_isis");
 
                                store.setDefault("ICAT_ID_PREF", SITE_ID_DLS + DELIMITER + SITE_ID_ISIS);
                                store.setDefault("ICAT_NAME_PREF", SITE_NAME_DLS + DELIMITER + SITE_NAME_ISIS);
                                store.setDefault("ICAT_WSDL_PREF", WSDL_LOCATION_DLS + DELIMITER + WSDL_LOCATION_ISIS);
                                store.setDefault("ICAT_SFTPSERVER_PREF", SFTP_SERVER_DLS + DELIMITER + SFTP_SERVER_ISIS);
                                store.setDefault("ICAT_DOWNLOADDIR_PREF", System.getProperty("java.io.tmpdir") + DELIMITER+  System.getProperty("java.io.tmpdir"));
                               
                                store.setDefault("ICAT_TRUSTSTORE_PATH_PREF", TRUSTSTORE_DLS + DELIMITER +  TRUSTSTORE_ISIS);
                                store.setDefault("ICAT_TRUSTSTORE_PASS_PREF", TRUSTSTORE_PASSWORD_DLS + DELIMITER +  TRUSTSTORE_PASSWORD_ISIS);
 
                }
               
                public static String combine (String path1, String path2)
                {
                    File file1 = new File(path1);
                    File file2 = new File(file1, path2);
                    return file2.getPath();
                }
               
                private File getPluginsDirectory() {
                                Bundle b = Platform.getBundle(ICATExplorerActivator.PLUGIN_ID);
                                logger.debug("Bundle: {}", b);
                                try {
                                                File f = FileLocator.getBundleFile(b);
                                                logger.debug("Bundle location: {}", f.getParent());
 
//                                            if (isRunningInEclipse) {
//                                                            File git = f.getParentFile().getParentFile().getParentFile();
//                                                            File parent = git.getParentFile();
//                                                            String projectName = git.getName().replace(GIT_SUFFIX, "");
//                                                            File plugins = new File(parent, projectName + "/plugins");
//
//                                                            if (plugins.isDirectory()) {
//                                                                            logger.debug("Plugins location: {}", plugins);
//                                                                            return plugins;
//                                                            }
//                                            }
 
                                                return f.getParentFile();
                                } catch (IOException e) {
                                                e.printStackTrace();
                                }
                                return null;
                }
 
}
