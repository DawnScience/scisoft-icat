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

package uk.ac.diamond.scisoft.icatexplorer.rcp.wizards;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
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


public class ReconnectNewWizard extends Wizard implements INewWizard {

	private static final String ICAT_NATURE = ICATProjectNature.NATURE_ID;

	private static final Logger logger = LoggerFactory.getLogger(ReconnectNewWizard.class);

	private static final String RECONNECT_ICAT_WIZARD = "ReconnectNewWizard";
	public static final String DIALOG_SETTING_KEY_DIRECTORY = "directory";
	public static final String DIALOG_SETTING_KEY_PROJECT = "project";
	public static final String DIALOG_SETTING_KEY_FEDID = "";
	public static final String DIALOG_SETTING_KEY_PASSWORD = "";
	protected static final String ALL_VISITS = "AllVisits";
	protected static final String BEAMLINES = "Beamlines";
	private ReconnectWizardPage page;
	private IProject iproject;
	private final ICATConnection icatCon;

	private final String projectName;
	private final String fedid;
	private String directory;

	/**
	 * Constructor for TestWizard.
	 * @param iproject
	 */
	public ReconnectNewWizard(IProject iproject, String fedid, ICATConnection icatCon) {
		super();
		setNeedsProgressMonitor(true);
		IDialogSettings dialogSettings = ICATExplorerActivator.getDefault().getDialogSettings();
		IDialogSettings section = dialogSettings.getSection(RECONNECT_ICAT_WIZARD);
		if(section == null){
			section = dialogSettings.addNewSection(RECONNECT_ICAT_WIZARD);
		}
		setDialogSettings(section);

		this.icatCon = icatCon;
		this.projectName = iproject.getName();
		this.fedid = fedid;
		this.iproject = iproject;
		
	}

	/**
	 * Adding the page to the wizard.
	 */
	@Override
	public void addPages() {
		String prevProject = null , prevFolder = null, prevDirectory = null, prevFedid = null, prevPassword = null, prevTruststore = null, prevTruststorePassword = null;
		IDialogSettings  settings = getDialogSettings();
		if( settings != null){
			prevProject = projectName;//settings.get(DIALOG_SETTING_KEY_PROJECT);
			prevFolder = "";//settings.get(DIALOG_SETTING_KEY_FOLDER);
			prevDirectory = directory;//settings.get(DIALOG_SETTING_KEY_DIRECTORY);
			prevFedid = fedid;//settings.get(DIALOG_SETTING_KEY_FEDID);
			prevPassword = "";//settings.get(DIALOG_SETTING_KEY_PASSWORD);
			prevTruststore =""; //settings.get(DIALOG_SETTING_KEY_TRUSTSTORE);
			prevTruststorePassword = "";//settings.get(DIALOG_SETTING_KEY_TRUSTSTORE_PASSWORD);
		}
		page = new ReconnectWizardPage(iproject, prevProject, prevFolder, prevDirectory, prevFedid, prevPassword, prevTruststore, prevTruststorePassword, icatCon);
		addPage(page);

	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	@Override
	public boolean performFinish() {

		final String directory        = page.getDirectory();
		final ICATConnection icatCon  = page.getIcatCon();
		final String fedid            = page.getFedid();
		final String password         = page.getPassword();
		final String project          = page.getProject();
		final String truststore       = page.getTruststore();
		final String truststorePass   = page.getTruststorePass();

		final Job loadDataProject = new Job("Load metadata from ICAT") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				monitor.beginTask("Creating an ICAT explorer instance for your data", 100);
				try {
					//ProjectUtils.createImportProjectAndFolder(project, folder, directory, ICATProjectNature.NATURE_ID, null, monitor);

					logger.debug("using connection: ID= " + icatCon.getId() + " - Name: " + icatCon.getSiteName() + " - wsdl: "+ icatCon.getWsdlLocation());

					ICATClient icatClient = new ICATClient(icatCon, truststore, truststorePass, directory, project);
					String sessionid = icatClient.login(fedid, password);

					logger.debug("sessionID = " + sessionid);

					// add new icat connection to the list of connections
					ICATSessions.add(sessionid, icatClient);

					// getting the list of visits
					List<Investigation> allVisits = icatClient.getLightInvestigations();


					// create project
					IProgressMonitor progressMonitor = new NullProgressMonitor();
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

					IProject iproject = root.getProject(project);
					iproject.delete(true, progressMonitor);
					iproject.create(progressMonitor);
					iproject.open(progressMonitor);

					// associating the icat nature to the newly created project
					try {
						IProjectDescription description = iproject.getDescription();
						String[] natures = description.getNatureIds();
						String[] newNatures = new String[natures.length + 1];
						System.arraycopy(natures, 0, newNatures, 0, natures.length);

						newNatures[natures.length] = ICAT_NATURE;
						description.setNatureIds(newNatures);
						iproject.setDescription(description, progressMonitor);

					} catch (CoreException e) {
						logger.error("problem setting ICAT nature to project: " + project + " - Error: " + e);
					}

					// adding persistent properties needed to reconnect
					QualifiedName qNameProjetcType = new QualifiedName("ICAT.PROJECT", "Type");
					QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
					QualifiedName qNameFedid       = new QualifiedName("FEDID","String");
					QualifiedName qNameSiteName    = new QualifiedName("SITE.NAME","String");
					QualifiedName qNameWsdl        = new QualifiedName("WSDL","String");
					QualifiedName qNameID          = new QualifiedName("ID","String");
					QualifiedName qNameDirectory   = new QualifiedName("DIRECTORY","String");
					QualifiedName qNameSftpServer  = new QualifiedName("SFTP_SERVER","String");
					QualifiedName qNameTruststorePath  = new QualifiedName("TRUSTSTORE_PATH","String");
					QualifiedName qNameTruststorePass  = new QualifiedName("TRUSTSTORE_PASSWORD","String");

					iproject.setPersistentProperty(qNameProjetcType, "ICAT");
					iproject.setPersistentProperty(qNameSessionId, sessionid);
					iproject.setPersistentProperty(qNameFedid, fedid);
					iproject.setPersistentProperty(qNameSiteName, icatCon.getSiteName());
					iproject.setPersistentProperty(qNameWsdl, icatCon.getWsdlLocation());
					iproject.setPersistentProperty(qNameID, icatCon.getId());
					iproject.setPersistentProperty(qNameDirectory, directory);
					iproject.setPersistentProperty(qNameSftpServer, icatCon.getSftpServer());
					iproject.setPersistentProperty(qNameTruststorePath, truststore);
					iproject.setPersistentProperty(qNameTruststorePass, truststorePass);

					logger.debug("project created: " + project);

					// populate allVisits folder with available visits
					String[] visits = new String[allVisits.size()];
					ArrayList<String> years = new ArrayList<String>();
					ArrayList<String> beamlines = new ArrayList<String>();
					for(int i =0; i< allVisits.size(); i++){
						//logger.debug("["+i+"] " + (allVisits.get(i)).getInvNumber());
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
				return new Status(IStatus.OK, ICATExplorerActivator.PLUGIN_ID, "Project " + project + " created");
			}
		};

		loadDataProject.setUser(true);
		loadDataProject.setPriority(Job.DECORATE);
		loadDataProject.schedule(100);


		IDialogSettings settings = getDialogSettings();
		if( settings != null){
			settings.put(DIALOG_SETTING_KEY_PROJECT, project);
			settings.put(DIALOG_SETTING_KEY_FEDID, fedid);
			settings.put(DIALOG_SETTING_KEY_DIRECTORY, directory);
		}
		return true;
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialise from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		//this.iproject = iproject;
	}
}
