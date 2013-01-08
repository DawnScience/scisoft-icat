package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.natures.DiscICATProjectNature;

public class SweepICATActionToolbar implements IViewActionDelegate {
	
	static final String DISC_ICAT_NATURE = DiscICATProjectNature.NATURE_ID;
	
	private static Logger logger = LoggerFactory.getLogger(SweepICATActionToolbar.class);

	@Override
	public void run(IAction action) {

    	logger.debug("delete all disconnected ICATs ...");
    	
    	/*
    	 * delete closed icat connections projects
    	 */
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		// get list of existing icat projects
		IProject[] projectsList = root.getProjects();
		for (int count = 0; count < projectsList.length; count++) {

				IProject currentProject = ((IProject) projectsList[count]);

				boolean isDiscICATProject = false;
				try {
					isDiscICATProject = currentProject.hasNature(DISC_ICAT_NATURE);
				} catch (CoreException e) {
					logger.error("problem retrieving project nature");
				}

				if (isDiscICATProject) {

						/*
						 * delete disconnected ICAT from project explorer view
						 */
					try {
						currentProject.delete(true, true, null);
					} catch (CoreException e) {
						logger.error("problem deleting project: " + currentProject.getName());
					}
					logger.debug("project deleted: " + currentProject.getName());
					}						
									

		}
		
		refresh(action);

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
		refresh(action);	
	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub

	}
	
	private void refresh(IAction action){

		action.setEnabled(false);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		/*
		 *  check whether there is at least one disconnected ispyb project
		 *  in order to enable the sweep icat button
		 */
		IProject[] projectsList = root.getProjects();
		for (int count = 0; count < projectsList.length; count++) {

				IProject currentProject = ((IProject) projectsList[count]);

				boolean isDiscICATProject = false;
				try {
					isDiscICATProject = currentProject.hasNature(DISC_ICAT_NATURE);
				} catch (CoreException e) {
					logger.error("problem retrieving project nature");
				}

				if (isDiscICATProject) {
					action.setEnabled(true);
					break;
					}						
		}
	}

}
