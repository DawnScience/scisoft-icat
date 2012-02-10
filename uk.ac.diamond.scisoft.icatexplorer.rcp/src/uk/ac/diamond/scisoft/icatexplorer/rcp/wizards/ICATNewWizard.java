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
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.Activator;
import uk.ac.diamond.scisoft.icatexplorer.rcp.projects.ICATProjectSupport;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.ICATHierarchyUtils;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.NoSuchUserException_Exception;
import uk.icat3.client.SessionException;


public class ICATNewWizard extends Wizard implements INewWizard {
	private static final Logger logger = LoggerFactory.getLogger(ICATNewWizard.class);
	
	private static final String ICAT_WIZARD = "ICATNewWizard";  
	public static final String DIALOG_SETTING_KEY_DIRECTORY = "directory"; 
	public static final String DIALOG_SETTING_KEY_FOLDER = "folder";  
	public static final String DIALOG_SETTING_KEY_PROJECT = "project";  
	public static final String DIALOG_SETTING_KEY_FEDID = ""; 
	public static final String DIALOG_SETTING_KEY_PASSWORD = ""; 
	protected static final String ALL_VISITS = "AllVisits";
	protected static final String BEAMLINES = "Beamlines";	
	private ICATWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for TestWizard.
	 */
	public ICATNewWizard() {
		super();
		setNeedsProgressMonitor(true);
		IDialogSettings dialogSettings = Activator.getDefault().getDialogSettings();
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
		String prevProject = null , prevFolder = null, prevDirectory = null, prevFedid = null, prevPassword = null;
		IDialogSettings  settings = getDialogSettings();
		if( settings != null){
			prevProject = settings.get(DIALOG_SETTING_KEY_PROJECT);
			prevFolder = settings.get(DIALOG_SETTING_KEY_FOLDER);
			prevDirectory = settings.get(DIALOG_SETTING_KEY_DIRECTORY);
			prevFedid = settings.get(DIALOG_SETTING_KEY_FEDID);
			prevPassword = "";//settings.get(DIALOG_SETTING_KEY_PASSWORD);
		}
		page = new ICATWizardPage(selection, prevProject, prevFolder, prevDirectory, prevFedid, prevPassword);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	@Override
	public boolean performFinish() {
	
		final String directory = page.getDirectory();
		//final String folder = page.getFolder();
		final String icatdb    = page.getIcatdb();
		final String fedid     = page.getFedid();
		final String password  = page.getPassword();
		final String project   = page.getProject();// + "@"+ icatdb + ".icat" ;
				
		final Job loadDataProject = new Job("Load metadata from ICAT") { 

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				monitor.beginTask("Creating an ICAT explorer instance for your data", 100); 
				try {
					//ProjectUtils.createImportProjectAndFolder(project, folder, directory, ICATProjectNature.NATURE_ID, null, monitor);
					
					// initiate ICAT connection									
					ICATClient icatClient = new ICATClient(icatdb, directory, project);
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
					iproject.create(progressMonitor);
					iproject.open(progressMonitor);
					
					// associating the icat nature to the newly created project
					try {
					      IProjectDescription description = iproject.getDescription();
					      String[] natures = description.getNatureIds();
					      String[] newNatures = new String[natures.length + 1];
					      System.arraycopy(natures, 0, newNatures, 0, natures.length);
					    
					      newNatures[natures.length] = "uk.ac.diamond.scisoft.icatexplorer.rcp.icat.nature";
					      description.setNatureIds(newNatures);
					      iproject.setDescription(description, progressMonitor);

						} catch (CoreException e) {
					      logger.error("problem setting ICAT nature to project: " + project + " - Error: " + e);
					   }
					
					// Create a qualified Name for state of the resource 
					QualifiedName q1 = new QualifiedName  
					 ("ICAT.PROJECT", "Type");
					iproject.setPersistentProperty(q1, "ICAT");

					logger.debug("project created: " + project);
					
					// populate allVisits folder with available visits
					String[] visits = new String[allVisits.size()];
					ArrayList<String> years = new ArrayList<String>();
					ArrayList<String> beamlines = new ArrayList<String>();
					for(int i =0; i< allVisits.size(); i++){
						logger.debug("["+i+"] " + (allVisits.get(i)).getInvNumber());
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
					logger.debug("years: " + years.toString());
					logger.debug("beamlines: " + beamlines.toString());
					
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
						logger.debug("resolving beamline: " + beamlines.get(i));
						String initialPath = BEAMLINES+"/" + beamlines.get(i).toUpperCase();
						List<String> yearsByBeamline = ICATHierarchyUtils.getYearsByBeamline(allVisits, beamlines.get(i));
						
						// years by beamline 
						for(int j=0; j< yearsByBeamline.size(); j++){
							String path = initialPath + "/" + yearsByBeamline.get(j);
//							List<Investigation> visitsByBeamlineYear = ICATHierarchyUtils.getVisitsByBeamlineYear(allVisits, beamlines.get(i), yearsByBeamline.get(j));
//
//								// visits by years/beamline 
//								for(int k=0; k< visitsByBeamlineYear.size(); k++){
//									path = path + "/" + ((Investigation)(visitsByBeamlineYear.get(k))).getVisitId().toString();
//									pathList.add(path);							
//									logger.debug("adding path: " + path);
//								}
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
				return new Status(IStatus.OK, Activator.PLUGIN_ID, "Project " + project + " created");
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
		this.selection = selection;
	}
}
