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

package uk.ac.diamond.scisoft.icatexplorer.rcp.perspectives;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.analysis.rcp.views.DatasetInspectorView;
import uk.ac.diamond.scisoft.analysis.rcp.views.PlotView;
import uk.ac.diamond.scisoft.analysis.rcp.views.SidePlotView;
//import uk.ac.diamond.scisoft.icatexplorer.rcp.actions.OpenActionProvider;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.wizards.ICATNewWizard;
import uk.ac.diamond.sda.meta.views.MetadataPageView;

public class ICATPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.perspective";

	private static Logger logger = LoggerFactory
			.getLogger(ICATPerspective.class);

	@Override
	public void createInitialLayout(IPageLayout layout) {

		// String loginViewID = LoginView.ID;
		// IFolderLayout main = layout.createFolder("ICAT_Main",
		// IPageLayout.LEFT,
		// 0.2f, layout.getEditorArea());
		IFolderLayout right = layout.createFolder("ICAT_Right",
				IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
		IFolderLayout bottom = layout.createFolder("ICAT_Bottom",
				IPageLayout.BOTTOM, 0.55f, layout.getEditorArea());

		// main.addPlaceholder("org.eclipse.ui.navigator.ProjectExplorer");
		// main.addView("org.eclipse.ui.navigator.ProjectExplorer" + ":*");

		// String cnfViewID = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
		// main.addPlaceholder(cnfViewID + ":*");

		// place holders for remaining views
		String plot = PlotView.ID + "DP";
		right.addPlaceholder(plot);
		right.addPlaceholder(SidePlotView.ID + ":*");

		bottom.addView(MetadataPageView.ID);//("fable.imageviewer.views.HeaderView");
		String inspector = DatasetInspectorView.ID;
		bottom.addView(inspector);
		if (layout.getViewLayout(inspector) != null)
			layout.getViewLayout(inspector).setCloseable(false);

//		// delete closed icat connections
//		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();	
//		// get list of existing icat projects
//		IProject[] projectsList = root.getProjects();
//		for(int count=0; count< projectsList.length; count++){
//			try {
//				for (int natureCount=0; natureCount < ((IProject)projectsList[count]).getDescription().getNatureIds().length; natureCount++){
//					logger.debug("checking ICAT project: " + ((IProject)projectsList[count]).getName() +" - " + ((IProject)projectsList[count]).getDescription().getNatureIds()[natureCount]);
//
//					boolean isICATProject = ((IProject)projectsList[count]).getDescription().getNatureIds()[natureCount].toString().equalsIgnoreCase("uk.ac.diamond.scisoft.icatexplorer.rcp.icat.nature");
//					ICATClient currentIcatClient = ICATSessions.get(((IProject)projectsList[count]).getName());
//					//logger.debug("currentIcatClient: " + currentIcatClient);
//					boolean isICATSessionClosed = (currentIcatClient == null);
//					if( isICATProject && isICATSessionClosed){
//						// remove icat project from project explorer
//						logger.info("deleting project: " + projectsList[count].getName());
//						((IProject)projectsList[count]).delete(true, null);						
//					}
//				}
//			} catch (CoreException e) {
//				logger.debug("problem cleaning dead icat projects");
//			}						
//
//		}

		/*
		 *  change icon of ICAT dead connections to a grayed one
		 */
		Job job = new Job("Check disconnected ICATs job") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				sweepICATConnections();
				updatePExplorer();
				// Use this to open a Shell in the UI thread
				return Status.OK_STATUS;
			}

		};
		job.setUser(true);
		job.schedule();
		
		
//		// check whether there is an active session to icat webservice
//		if (ICATSessions.icatsMap.isEmpty()) {
//			
//			// no open session so show icat connection wizard
//			logger.info("no active session detected... showing the icat wizard");
//			WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench()
//					.getActiveWorkbenchWindow().getShell(), new ICATNewWizard());
//			dialog.open();
//			
//		}
	}

	protected void updatePExplorer() {
		logger.debug("=============> updating project explorer");
 	    }

	protected void sweepICATConnections() {
		logger.debug("--------------> sweepICATConnections");
		Iterator it = ICATSessions.icatsMap.entrySet().iterator();
 	    while (it.hasNext()) {
 	        Map.Entry pairs = (Map.Entry)it.next();
 	        logger.debug("=============> " + pairs.getKey() + " = " + pairs.getValue());
 	        it.remove(); // avoids a ConcurrentModificationException		
 	    }
 	    
	}

}
