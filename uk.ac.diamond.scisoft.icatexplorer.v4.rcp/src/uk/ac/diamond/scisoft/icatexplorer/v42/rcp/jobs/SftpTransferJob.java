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

package uk.ac.diamond.scisoft.icatexplorer.v42.rcp.jobs;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.icatproject.Datafile;
import org.icatproject.Dataset;
import org.icatproject.ICAT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.datafiles.DatafileTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.datasets.DatasetTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.sftpclient.SftpClient;


public class SftpTransferJob extends Job {

	private static final Logger logger = LoggerFactory.getLogger(SftpTransferJob.class);

	private IResource target;
	private String sftpServer;
	
	private String sessionId;
	private String fedid;
	private String password;
	private SftpClient sftpClient;

	private List<?> elements;

	public SftpTransferJob(String name, List<?> elements, final IResource target) {
		super(name);
		this.target = target;
		this.elements = elements;
		
		/* 
		 * Preparing sftp connection
		 * this is done by taking the fedid/password from one of the elements to move i.e. first datafile/dataset 
		 * in the list of elements to move
		 * Can be improved to use corresponding fedids/password for elements coming from different icat projects (connections) 
		 */
		IProject iproject = null;
		if (elements.get(0) instanceof DatasetTreeData){
			iproject = ((DatasetTreeData)elements.get(0)).getParentProject();
		}else if (elements.get(0) instanceof DatafileTreeData){
			iproject = ((DatafileTreeData)elements.get(0)).getParentProject();
		}
		
		QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
		try {
			sessionId = iproject.getPersistentProperty(qNameSessionId);
		} catch (CoreException e) {
			logger.error("problem retrieving sessionId for project: " + iproject.getName());
		}		
		
		fedid = ICATSessions.get(sessionId).getFedId();
		password = ICATSessions.get(sessionId).getPassword();
		sftpServer = ICATSessions.get(sessionId).getIcatCon().getSftpServer();
		sftpClient = new SftpClient();
		
		logger.debug("using sftp server: " + sftpServer);

	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {

		// sftp the source into the target destination
		String finalDestination = null;

		for (Object element : elements) {
			if (element instanceof DatafileTreeData) {
				
				finalDestination = target.getLocation().toString();
				DatafileTreeData datafile = (DatafileTreeData) element;

				try {
					sftpClient.downloadFile(fedid, password, sftpServer,
							datafile.getIcatDatafile().getLocation(), finalDestination);
				} catch (Exception e) {
					logger.error("error occured during the download of file: " + e.getMessage());
				}

			} else if (element instanceof DatasetTreeData) {
				Dataset dataset = null;

				// get the datafiles collection
				try {
					
					ICAT icat = ICATClient.getIcat();
					String query = "Dataset";
		            dataset = (Dataset)icat.get(sessionId, query, ((DatasetTreeData) element).getIcatDataset().getId());
					
//					dataset = ICATClient
//							.getIcat()
//							.getDatasetIncludes(
//									ICATSessions.get(sessionId)
//											.getSessionId(),
//									((DatasetTreeData) element).getIcatDataset().getId(),
//									DatasetInclude.DATASET_AND_DATAFILES_ONLY);
				} catch (Exception e) {
					logger.error("problem getting dataset content from ICAT", e);
				} 
				
				List<Datafile> datafilesList = dataset.getDatafiles();
				/*
				 * create folder in target with dataset name all non-existent
				 * ancestor directories are automatically created
				 */
				boolean success = (new File(target.getLocation().toString(),
						dataset.getName())).mkdirs();
				if (!success) {
					logger.error("Error creating folder '" + dataset.getName()
							+ "' into '" + target.getName() + "'");
				}
				// move all dataset files into the newly created folder
				String parentFolder = dataset.getName();
				finalDestination = (new File(target.getLocation().toString(),
						parentFolder)).getAbsolutePath();

				for (Datafile datafile : datafilesList) {
					try {
						sftpClient.downloadFile(fedid, password, sftpServer,
								datafile.getLocation(), finalDestination);
					} catch (Exception e) {
						logger.error("error occured during the download of file: " + e.getMessage());

					}
				}

			}
		}

		logger.debug("dataset successfully imported into project explorer.");

		String parentProject = target.getProject().getName();
		refreshProjectExplorer(parentProject);

//		 // display warning message
//		 MessageBox messageBox = new MessageBox(PlatformUI.getWorkbench().
//                getActiveWorkbenchWindow().getShell(), SWT.ICON_WARNING | SWT.OK );
//        
//		  String messageText = "";
//        messageBox.setText("Info");
//        messageBox.setMessage(messageText);
//        int buttonID = messageBox.open();

		return Status.OK_STATUS;

	}

	private void refreshProjectExplorer(String parentProject) {

		try {
			logger.debug("refreshing project: " + parentProject);
			ResourcesPlugin
					.getWorkspace()
					.getRoot()
					.getProject(parentProject)
					.refreshLocal(IResource.DEPTH_INFINITE,
							new NullProgressMonitor());
		} catch (CoreException e) {
			logger.error("problem refreshing Project Explorer", e);
		}

	}
}
