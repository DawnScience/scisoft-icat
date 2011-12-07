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
import uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DDatasetEditor;
import uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DDatasetEditorInput;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFContentProvider;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFNavigator;


public class OpenDatasetHandler extends AbstractHandler{
	
	//private final static Logger logger = Logger.getLogger(OpenDatasetHandler.class);

	@SuppressWarnings("deprecation")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//logger.debug("open dataset called ...");
		// Get the view
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		page.closeAllEditors(false);
		//String viewId = "uk.ac.diamond.scisoft.icatexplorer.rcp.datasetview";
		//DDatasetView ddatasetView = (DDatasetView) page.findView(viewId);
		//DDatasetEditor ddatasetEditor = (DDatasetEditor) page.findView(viewId);	
		
  		for(int i =0; i< page.getViews().length; i++){
  	  		System.out.println("view ("+i+")" + page.getViews().toString());

  		}
				
		CNFNavigator navigatorView = (CNFNavigator) page.findView("uk.ac.diamond.scisoft.icatexplorer.rcp.view");
		
		// Get the selection
		ISelection selection = navigatorView.getSite().getSelectionProvider()
				.getSelection();

		if (selection != null && selection instanceof IStructuredSelection) {

			Object obj = ((IStructuredSelection) selection).getFirstElement();

			// If we had a selection lets open the editor
			if (obj != null) {
				DDataset ddataset = (DDataset) obj;
//				logger.debug("\nddataset name: "+ddataset.getName());
//				DDatasetEditorInput input = new DDatasetEditorInput(
//						ddataset.getId());
				try {
					DDatasetEditorInput input = new DDatasetEditorInput(ddataset); 					
					page.openEditor((IEditorInput) input, DDatasetEditor.ID);
					
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

			
