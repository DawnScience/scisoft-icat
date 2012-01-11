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

package uk.ac.diamond.scisoft.icatexplorer.rcp.jobs;

import java.io.File;
import java.net.InetAddress;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
import uk.ac.diamond.scisoft.icatexplorer.rcp.sftpclient.SftpClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.NetworkUtils;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;
import uk.icat3.client.Datafile;
import uk.icat3.client.Dataset;
import uk.icat3.client.DatasetInclude;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.NoSuchObjectFoundException_Exception;
import uk.icat3.client.SessionException_Exception;

public class SftpTransferJob extends Job {

	 private static final Logger logger = LoggerFactory.getLogger(SftpTransferJob.class); 
		
		private IResource target;
		private String sftpServer;

		private String fedid;
		private String password;
		private SftpClient sftpClient;

		private List<?> elements;

		public SftpTransferJob(String name, List<?> elements, final IResource target) {
			super(name);
			this.target = target;
			this.elements = elements;
			
			logger.debug("reading properties file...");
			
			try {
				Properties properties = PropertiesUtils.readConfigFile();
				
				InetAddress addr = InetAddress.getLocalHost();
				
				if (NetworkUtils.insideDLS(addr)){
					sftpServer = properties.getProperty("internal.sftp.server");
				}else{
					sftpServer = properties.getProperty("external.sftp.server");
				}
					
			} catch (Exception e) {
				logger.error("cannot read properties file", e);
			}
			
			// preparing sftp connection
			fedid = ICATSessionDetails.icatClient.getFedId();
			password = ICATSessionDetails.icatClient.getPassword();
			sftpClient = new SftpClient();
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			    	
	    	// sftp the source into the target destination
			String finalDestination = null;
			
			for(Object element : elements){
				if (element instanceof Datafile){
					finalDestination = target.getLocation().toString();
					Datafile datafile = (Datafile) element;

					sftpClient.downloadFile(fedid, password, sftpServer, datafile.getDatafileLocation(), finalDestination);
					
				}else if(element instanceof DDataset){
					Dataset dataset = null;
										
					// get the datafiles collection
					try {
						dataset = (Dataset) ICATClient.getIcat().getDatasetIncludes(ICATSessionDetails.icatClient.getSessionId(), ((DDataset)element).getId(), DatasetInclude.DATASET_AND_DATAFILES_ONLY);
					} catch (InsufficientPrivilegesException_Exception e) {
						logger.error("problem getting dataset content from ICAT", e);
					} catch (NoSuchObjectFoundException_Exception e) {
						logger.error("problem getting dataset content from ICAT", e);
					} catch (SessionException_Exception e) {
						logger.error("problem getting dataset content from ICAT", e);
					} catch (Exception e) {
						logger.error("problem getting dataset content from ICAT", e);
					}
                	List<Datafile> datafilesList = dataset.getDatafileCollection();
                	/*
               	     *  create folder in target with dataset name
               	     *  all non-existent ancestor directories are
               	     *  automatically created
               	     */
                	boolean success = (new File(target.getLocation().toString(), dataset.getName())).mkdirs();
                	if (!success) {
                		logger.error("Error creating folder '" + dataset.getName() +"' into '" + target.getName()+"'" );
                	}
                	// move all dataset files into the newly created folder               	      
                	String parentFolder = dataset.getName();
                	finalDestination = (new File(target.getLocation().toString(), parentFolder)).getAbsolutePath();

                	for(Datafile datafile : datafilesList){
                    	sftpClient.downloadFile(fedid, password, sftpServer, datafile.getDatafileLocation(), finalDestination);
                	}
					
				}
			}   

			logger.debug("dataset successfully imported into project explorer.");
			
			String parentProject = target.getProject().getName();
	    	refreshProjectExplorer(parentProject);
	    	
            //MessageDialog.openInformation(getShell().getShell(),"Info", "All selected files moved into the Project Explorer");

//	    	MessageDialog.openInformation(
//					HandlerUtil.getActiveShell(event), "Your Popup ",
//					"Your job has finished.");

	    	
			return Status.OK_STATUS;
					
		}
		
		 private void refreshProjectExplorer(String parentProject) {
		    	
		    	try {
					logger.error("refreshing project: " + parentProject);
		    		ResourcesPlugin.getWorkspace().getRoot().getProject( parentProject ).refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor() );
				} catch (CoreException e) {
					logger.error("problem refreshing Project Explorer", e);
				}

		 }
	}
