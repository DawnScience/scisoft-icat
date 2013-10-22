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


package uk.ac.diamond.scisoft.icatexplorer.rcp.actions;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.rcp.natures.ICATProjectNature;
import uk.ac.diamond.scisoft.icatexplorer.rcp.projects.ICATProjectSupport;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.ICATHierarchyUtils;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.NoSuchUserException_Exception;
import uk.icat3.client.SessionException;

public class RefreshAction implements IHandler {
	
	protected static final String ALL_VISITS = "All Visits";
	protected static final String BEAMLINES = "Beamlines";
	
	String projectType = null;
	String fedid = null;
	String siteName = null;
	String wsdl = null;
	String id = null;
	String directory = null;
	String sftpServer = null;
	String truststorePath = null;
	String truststorePass = null;
	String sessionId = null;
	String projectName = "";
	
	private static Logger logger = LoggerFactory.getLogger(RefreshAction.class);
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		final IProject iproject = (IProject)selection.getFirstElement();
		projectName = iproject.getName();
		
		logger.debug("refreshing: " + iproject.getName());
		
		// get persistent properties needed to reconnect
		QualifiedName qNameProjectType 		= new QualifiedName("ICAT.PROJECT", "Type");
		QualifiedName qNameFedid       		= new QualifiedName("FEDID","String");
		QualifiedName qNameSiteName    		= new QualifiedName("SITE.NAME","String");
		QualifiedName qNameWsdl        		= new QualifiedName("WSDL","String");
		QualifiedName qNameID          		= new QualifiedName("ID","String");
		QualifiedName qNameDirectory   		= new QualifiedName("DIRECTORY","String");
		QualifiedName qNameSftpServer  		= new QualifiedName("SFTP_SERVER","String");
		QualifiedName qNameTruststorePath  	= new QualifiedName("TRUSTSTORE_PATH","String");
		QualifiedName qNameTruststorePass  	= new QualifiedName("TRUSTSTORE_PASSWORD","String");
		QualifiedName qNameSessionID       	= new QualifiedName("SESSIONID", "String");

		
	    try {
			projectType    = iproject.getPersistentProperty(qNameProjectType);
			fedid          = iproject.getPersistentProperty(qNameFedid);
			siteName       = iproject.getPersistentProperty(qNameSiteName);
			wsdl           = iproject.getPersistentProperty(qNameWsdl);
			id             = iproject.getPersistentProperty(qNameID);
			sftpServer     = iproject.getPersistentProperty(qNameSftpServer);
			directory      = iproject.getPersistentProperty(qNameDirectory);
			truststorePath = iproject.getPersistentProperty(qNameTruststorePath);
			truststorePass = iproject.getPersistentProperty(qNameTruststorePass);
			sessionId      = iproject.getPersistentProperty(qNameSessionID);
		} catch (CoreException e) {
			logger.error("problem getting persistent property ", e);
		}
		
		logger.info("projectType: " + projectType );
	    logger.info("sessionId: " + sessionId );
		logger.info("fedid: " + fedid );
		logger.info("siteName: " + siteName );
		logger.info("wsdl: " + wsdl );
		logger.info("id: " + id );
		logger.info("sftpServer: " + sftpServer);
		logger.info("directory: " + directory );
		logger.info("truststorePath: " + truststorePath);
		logger.info("truststorePass: " + truststorePass);

		// get current client and connection  from project properties
		final ICATClient icatClient = ICATSessions.get(sessionId);
		final ICATConnection icatCon = icatClient.getIcatCon(); //new ICATConnection(id, siteName, sftpServer, wsdl);
		
		final Job loadDataProject = new Job("Refresh metadata from ICAT") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				monitor.beginTask("Creating an ICAT explorer instance for your data", 100);
				try {
					//ProjectUtils.createImportProjectAndFolder(project, folder, directory, ICATProjectNature.NATURE_ID, null, monitor);

					logger.debug("using connection: ID= " + icatCon.getId() + " - Name: " + icatCon.getSiteName() + " - wsdl: "+ icatCon.getWsdlLocation());

					// getting the list of visits
					List<Investigation> allVisits = icatClient.getLightInvestigations();
					
					// delete icat project before recreating it
					IProgressMonitor progressMonitor = new NullProgressMonitor();
					iproject.delete(true, progressMonitor);
					
					// create project
					//IProgressMonitor progressMonitor = new NullProgressMonitor();
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

					IProject iproject = root.getProject(projectName);
					iproject.create(monitor);
					iproject.open(monitor);

					// adding persistent properties needed to reconnect
					QualifiedName qNameProjectType = new QualifiedName("ICAT.PROJECT", "Type");
					QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
					QualifiedName qNameFedid       = new QualifiedName("FEDID","String");
					QualifiedName qNameSiteName    = new QualifiedName("SITE.NAME","String");
					QualifiedName qNameWsdl        = new QualifiedName("WSDL","String");
					QualifiedName qNameDirectory   = new QualifiedName("DIRECTORY","String");
					QualifiedName qNameID          = new QualifiedName("ID","String");
					QualifiedName qNameSftpServer  = new QualifiedName("SFTP_SERVER","String");
					QualifiedName qNameTruststorePath  = new QualifiedName("TRUSTSTORE_PATH","String");
					QualifiedName qNameTruststorePass  = new QualifiedName("TRUSTSTORE_PASSWORD","String");

					iproject.setPersistentProperty(qNameProjectType, "ICAT");
					iproject.setPersistentProperty(qNameSessionId, sessionId);
					iproject.setPersistentProperty(qNameFedid, fedid);
					iproject.setPersistentProperty(qNameSiteName, icatCon.getSiteName());
					iproject.setPersistentProperty(qNameWsdl, icatCon.getWsdlLocation());
					iproject.setPersistentProperty(qNameDirectory, directory);
					iproject.setPersistentProperty(qNameID, icatCon.getId());
					iproject.setPersistentProperty(qNameSftpServer, icatCon.getSftpServer());
					iproject.setPersistentProperty(qNameTruststorePath, truststorePath);
					iproject.setPersistentProperty(qNameTruststorePass, truststorePass);

					// associating the icat nature to the newly created project
					try {
						IProjectDescription description = iproject.getDescription();
						String[] natures = description.getNatureIds();
						String[] newNatures = new String[natures.length + 1];
						System.arraycopy(natures, 0, newNatures, 0, natures.length);

						newNatures[natures.length] = ICATProjectNature.NATURE_ID;
						description.setNatureIds(newNatures);
						iproject.setDescription(description, monitor);

					} catch (CoreException e) {
						logger.error("problem setting ICAT nature to project: " + iproject.getName() + " - Error: " + e);
					}

					logger.debug("ICAT project CREATED: " + iproject.getName());


					// populate allVisits folder with available visits
					String[] visits = new String[allVisits.size()];
					ArrayList<String> years = new ArrayList<String>();
					ArrayList<String> beamlines = new ArrayList<String>();
					for(int i =0; i< allVisits.size(); i++){
						visits[i] =  (allVisits.get(i)).getVisitId();

						// get years
						String year = Integer.toString((allVisits.get(i)).getInvStartDate().getYear());
						if(!years.contains(year)){
							years.add(year);
						}

						// get beamlines
						String beamline = (allVisits.get(i)).getInstrument();
						if(!beamlines.contains(beamline)){
							beamlines.add(beamline);
						}
					}

					// get all available years
					List<String> pathList = new ArrayList<String>();

					// create years folders
					for (int i=0; i< years.size(); i++){
						pathList.add(years.get(i));
					}

					// create allVisits
					pathList.add(ALL_VISITS);

					/*
					 * create beamlines folder and structure
					 * */
					// beamlines
					for(int i =0; i<beamlines.size(); i++){
						String initialPath = BEAMLINES+"/" + beamlines.get(i).toUpperCase();
						List<String> yearsByBeamline = ICATHierarchyUtils.getYearsByBeamline(allVisits, beamlines.get(i));

						// years by beamline
						for(int j=0; j< yearsByBeamline.size(); j++){
							String path = initialPath + "/" + yearsByBeamline.get(j);
							logger.debug("adding path: " + path);
							pathList.add(path);
						}
					}

					//convert pathsArrayList into a path array
					String [] paths = pathList.toArray(new String[pathList.size()]);

					ICATProjectSupport.addToProjectStructure(iproject, paths);

					logger.debug("project structure for " + iproject.getName() + " REFRESHED.");


				} catch (MalformedURLException e) {
					logger.error("Problem occured: ", e);
				} catch (SessionException e) {
					logger.error("Problem occured: ", e);
				} catch (InsufficientPrivilegesException_Exception e) {
					logger.error("Problem occured: ", e);
				} catch (NoSuchUserException_Exception e) {
					logger.error("Problem occured: ", e);
				} catch (CoreException e) {
					logger.error("Problem occured: ", e);
				}
				return new Status(IStatus.OK, ICATExplorerActivator.PLUGIN_ID, "Project " + iproject.getName() + " created");
			}
		};

		loadDataProject.setUser(true);
		loadDataProject.setPriority(Job.DECORATE);
		loadDataProject.schedule(100);
				
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
