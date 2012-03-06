package uk.ac.diamond.scisoft.icatexplorer.rcp.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.natures.DiscICATProjectNature;

public class SweepAction implements IHandler {

static final String DISC_ICAT_NATURE = DiscICATProjectNature.NATURE_ID;
	
	private static Logger logger = LoggerFactory.getLogger(SweepAction.class);
	
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

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getActiveMenuSelection(event);
		
		IProject iproject = (IProject)selection.getFirstElement();
		
		logger.debug("delete ICAT: " + iproject.getName());
		

		boolean isDiscICATProject = false;
		try {
			isDiscICATProject = iproject.hasNature(DISC_ICAT_NATURE);
		} catch (CoreException e) {
			logger.error("problem retrieving project nature");
		}

		if (isDiscICATProject) {

				/*
				 * delete disconnected ICAT from project explorer view
				 */
			try {
				iproject.delete(true, true, null);
			} catch (CoreException e) {
				logger.error("problem deleting project: " + iproject.getName());
			}
			logger.debug("project deleted: " + iproject.getName());
			}	
    	
		
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
