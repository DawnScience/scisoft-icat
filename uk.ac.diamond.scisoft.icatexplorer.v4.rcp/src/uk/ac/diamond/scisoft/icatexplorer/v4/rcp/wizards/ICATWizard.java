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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.wizards;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.icatproject.Investigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.natures.ICATProjectNature;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.projects.ICATProjectSupport;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils.ICATHierarchyUtils;


public class ICATWizard extends Wizard implements INewWizard {

	private static final String ICAT_NATURE = ICATProjectNature.NATURE_ID;

	private static final Logger logger = LoggerFactory.getLogger(ICATWizard.class);

	private static final String ICAT_WIZARD = "V4.2ICATNewWizard";
	private ICATWizardPage page;
	private ISelection selection;
	public static final String DIALOG_SETTING_KEY_DIRECTORY = "directory";
	public static final String DIALOG_SETTING_KEY_FOLDER = "folder";
	public static final String DIALOG_SETTING_KEY_PROJECT = "project";
	public static final String DIALOG_SETTING_KEY_FEDID = "";
	public static final String DIALOG_SETTING_KEY_PASSWORD = "";
	public static final String DIALOG_SETTING_KEY_TRUSTSTORE = "truststore";
	public static final String DIALOG_SETTING_KEY_TRUSTSTORE_PASSWORD = "truststorePassword";
	protected static final String ALL_VISITS = "All Visits";
	protected static final String BEAMLINES = "Beamlines";

	/**
	 * Constructor for TestWizard.
	 */
	public ICATWizard() {
		super();
		setNeedsProgressMonitor(true);
		IDialogSettings dialogSettings = ICATExplorerActivator.getDefault().getDialogSettings();
		IDialogSettings section = dialogSettings.getSection(ICAT_WIZARD);
		if(section == null){
			section = dialogSettings.addNewSection(ICAT_WIZARD);
		}
		setDialogSettings(section);
	}

	/**
	 * Adding the page to the wizard.
	 */
	@Override
	public void addPages() {
		String prevProject = null , prevFolder = null, prevDirectory = null, prevFedid = null, prevPassword = null, prevTruststore = null, prevTruststorePassword = null;
		IDialogSettings  settings = getDialogSettings();
		if( settings != null){
			prevProject = settings.get(DIALOG_SETTING_KEY_PROJECT);
			prevFolder = settings.get(DIALOG_SETTING_KEY_FOLDER);
			prevDirectory = settings.get(DIALOG_SETTING_KEY_DIRECTORY);
			prevFedid = settings.get(DIALOG_SETTING_KEY_FEDID);
			prevTruststore = settings.get(DIALOG_SETTING_KEY_TRUSTSTORE);
			prevTruststorePassword = settings.get(DIALOG_SETTING_KEY_TRUSTSTORE_PASSWORD);
		}
		page = new ICATWizardPage(selection, prevProject, prevFolder, prevDirectory, prevFedid, prevPassword, prevTruststore, prevTruststorePassword);
		addPage(page);

	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	@Override
	public boolean performFinish() {

		final ICATConnection icatCon  = page.getIcatCon();
		final String fedid       = page.getFedid();
		final String password    = page.getPassword();
		final String project     = page.getProject();
		final String directory   = page.getDirectory() + "/"+ project;
		final String truststore  = page.getTruststore();
		final String truststorePass  = page.getTruststorePass();
		final Calendar fromDate  = page.getFromDate();
		final Calendar toDate    = page.getToDate();



		final Job loadDataProject = new Job("Load metadata from ICAT V4.2") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				monitor.beginTask("Creating an ICAT V4.2 explorer instance for your data", 100);


				String errorMessage = "Problem occured: ";
				try {

					logger.debug("using connection: ID= " + icatCon.getId() + " - Name: " + icatCon.getSiteName() + " - wsdl: "+ icatCon.getWsdlLocation());

					ICATClient icatClient = new ICATClient(icatCon, truststore, truststorePass, directory, project);
					String sessionid = icatClient.login(fedid, password);

					if (sessionid != null){

						// add new icat connection to the list of connections
						ICATSessions.add(sessionid, icatClient);

						// getting the list of visits
						List<Investigation> allVisits = icatClient.getLightInvestigations(fromDate, toDate);

						// create project
						//IProgressMonitor progressMonitor = new NullProgressMonitor();
						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

						IProject iproject = root.getProject(project);
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
						QualifiedName qNameFromDate  	   = new QualifiedName("FROM_DATE","String");
						QualifiedName qNameToDate          = new QualifiedName("TO_DATE","String");

						iproject.setPersistentProperty(qNameProjectType, "ICATV4");
						iproject.setPersistentProperty(qNameSessionId, sessionid);
						iproject.setPersistentProperty(qNameFedid, fedid);
						iproject.setPersistentProperty(qNameSiteName, icatCon.getSiteName());
						iproject.setPersistentProperty(qNameWsdl, icatCon.getWsdlLocation());
						iproject.setPersistentProperty(qNameDirectory, directory);
						iproject.setPersistentProperty(qNameID, icatCon.getId());
						iproject.setPersistentProperty(qNameSftpServer, icatCon.getSftpServer());
						iproject.setPersistentProperty(qNameTruststorePath, truststore);
						iproject.setPersistentProperty(qNameTruststorePass, truststorePass);
						iproject.setPersistentProperty(qNameFromDate, calendarToString(fromDate));
						iproject.setPersistentProperty(qNameToDate, calendarToString(toDate));

						// associating the icat nature to the newly created project
						try {
							IProjectDescription description = iproject.getDescription();
							String[] natures = description.getNatureIds();
							String[] newNatures = new String[natures.length + 1];
							System.arraycopy(natures, 0, newNatures, 0, natures.length);

							newNatures[natures.length] = ICAT_NATURE;
							description.setNatureIds(newNatures);
							iproject.setDescription(description, monitor);

						} catch (CoreException e) {
							logger.error("problem setting ICAT nature to project: " + iproject.getName() + " - Error: " + e);
						}

						logger.debug("ICAT project created: " + project);

						// populate allVisits folder with available visits
						String[] visits = new String[allVisits.size()];
						ArrayList<String> years = new ArrayList<String>();
						ArrayList<String> beamlines = new ArrayList<String>();
						logger.info("allVisits.size()= " + allVisits.size());

						for(int i =0; i< allVisits.size(); i++){
							visits[i] =  (allVisits.get(i)).getVisitId();
							
							String year = "uknown";
							// get years
							if((allVisits.get(i)).getStartDate() != null){
								year = Integer.toString((allVisits.get(i)).getStartDate().getYear());
							}
							
							if(!years.contains(year)){
								years.add(year);
							}

							// get beamlines
							String beamline = ((allVisits.get(i)).getInstrument().getName());
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
								pathList.add(path);
							}
						}

						//convert pathsArrayList into a path array
						String [] paths = pathList.toArray(new String[pathList.size()]);

						ICATProjectSupport.addToProjectStructure(iproject, paths);

						logger.debug("project structure for " + iproject.getName() + " created.");
						/*
						 * create an additional project in structure to hold downloaded files
						 * */
						try{
							
						final String DOWNLOAD_NAME =  "-downloadedFiles";
						IProject dproject = root.getProject(project + DOWNLOAD_NAME);
						
						File file = new File(directory);
						URI location = file.toURI();
						URI projectLocation = location;
						if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
							projectLocation = null;
						}
						
						IProjectDescription desc = dproject.getWorkspace().newProjectDescription(dproject.getName());
						desc.setLocationURI(projectLocation);
						dproject.create(desc, new NullProgressMonitor());
						dproject.open(new NullProgressMonitor());
																								
						logger.debug("download project " + dproject.getName() + " created.");
					}catch(Exception e){
							logger.error("exception occured when creating associate project: " + e.getMessage());
						}

					}else{
						logger.debug("cannot login into ICAT v4.2");			
					}

				} catch (CoreException e) {
					logger.error(errorMessage, e);
				}
				return new Status(IStatus.OK, ICATExplorerActivator.PLUGIN_ID, "Project " + project + " created");
			}
		};

		loadDataProject.setUser(true);
		loadDataProject.setPriority(Job.INTERACTIVE);
		loadDataProject.schedule(100);


		IDialogSettings settings = getDialogSettings();
		if( settings != null){
			settings.put(DIALOG_SETTING_KEY_PROJECT, project);
			settings.put(DIALOG_SETTING_KEY_FEDID, fedid);
			settings.put(DIALOG_SETTING_KEY_DIRECTORY, directory);
			settings.put(DIALOG_SETTING_KEY_TRUSTSTORE, truststore);
			settings.put(DIALOG_SETTING_KEY_TRUSTSTORE_PASSWORD, truststorePass);

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
		this.selection = selection;
	}
	
	private String calendarToString(Calendar calendarDate){
	    return calendarDate.get(Calendar.DAY_OF_MONTH)+"/"+ calendarDate.get(Calendar.MONTH) + "/" + calendarDate.get(Calendar.YEAR);
		
	}
}
