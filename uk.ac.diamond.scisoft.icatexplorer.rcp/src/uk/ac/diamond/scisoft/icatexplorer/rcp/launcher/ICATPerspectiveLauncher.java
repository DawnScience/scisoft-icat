package uk.ac.diamond.scisoft.icatexplorer.rcp.launcher;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

import uk.ac.diamond.scisoft.icatexplorer.rcp.ui.ICATPerspective;

public class ICATPerspectiveLauncher implements IWorkbenchWindowActionDelegate {

	@Override
	public void run(IAction action) {
		try {
			PlatformUI.getWorkbench().showPerspective(ICATPerspective.PERSPECTIVE_ID,PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		} catch (WorkbenchException e) {
			e.printStackTrace();
		} 	

	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}


	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {
		// TODO Auto-generated method stub
		
	}


}
