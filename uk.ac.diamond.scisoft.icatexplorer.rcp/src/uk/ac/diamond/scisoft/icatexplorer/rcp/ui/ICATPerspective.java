package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;


import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ICATPerspective implements IPerspectiveFactory
{

    public static final String PERSPECTIVE_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.perspective";
   
    private static final Logger logger = LoggerFactory.getLogger(ICATPerspective.class); 


    public void createInitialLayout(IPageLayout layout)
    {
    	layout.setEditorAreaVisible(true);
        layout.setFixed(false);
        
    	IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		 
		 //close CNF view
//		 IViewPart[] viewParts = window.getActivePage().getViews();
//		 for (IViewPart view : viewParts)
//		 {
//		 if (view instanceof CNFNavigator)
//		 {
//		 window.getActivePage().hideView(view);
//		 }
//		 }
       
		// show login view 
    	logger.debug("showing Login View ");
        layout.addView("uk.ac.diamond.scisoft.icatlogin.rcp.ui.LoginView", IPageLayout.LEFT, 0.5f,IPageLayout.ID_EDITOR_AREA);
        layout.setEditorAreaVisible(true);
    }
  
 
}
