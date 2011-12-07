package uk.ac.diamond.scisoft.icatexplorer.rcp.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;
import uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DDatasetEditor;
import uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DDatasetEditorInput;
import uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DInvestigationEditor;
import uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DInvestigationEditorInput;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFContentProvider;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFNavigator;


public class OpenInvestigationHandler extends AbstractHandler{
	
	//private final static Logger logger = Logger.getLogger(OpenInvestigationHandler.class);

	@SuppressWarnings("deprecation")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//logger.debug("open investigation called ...");
		// Get the view
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		page.closeAllEditors(false);
		//String viewId = "uk.ac.diamond.scisoft.icatexplorer.rcp.datasetview";
		//DDatasetView ddatasetView = (DDatasetView) page.findView(viewId);
		//DDatasetEditor ddatasetEditor = (DDatasetEditor) page.findView(viewId);			
				
		CNFNavigator navigatorView = (CNFNavigator) page.findView("uk.ac.diamond.scisoft.icatexplorer.rcp.view");
		
		// Get the selection
		ISelection selection = navigatorView.getSite().getSelectionProvider()
				.getSelection();

		if (selection != null && selection instanceof IStructuredSelection) {

			Object obj = ((IStructuredSelection) selection).getFirstElement();

			// If we had a selection lets open the editor
			if (obj != null) {
				DInvestigation dinvestigation = (DInvestigation) obj;
//				logger.debug("\nddataset name: "+ddataset.getName());
//				DDatasetEditorInput input = new DDatasetEditorInput(
//						ddataset.getId());
				try {
					DInvestigationEditorInput input = new DInvestigationEditorInput(dinvestigation); 					
					page.openEditor((IEditorInput) input, DInvestigationEditor.ID);
					
					//page.showView("uk.ac.diamond.scisoft.icatexplorer.rcp.datasetview");//
//
				} catch (PartInitException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}

}

			
