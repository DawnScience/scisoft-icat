package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ICATPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.perspective";

	private static final Logger logger = LoggerFactory
			.getLogger(ICATPerspective.class);

	public void createInitialLayout(IPageLayout layout) {
		// layout.setFixed(false);

		// show login view
		/*logger.debug("showing Login View ");
		String loginView = LoginView.ID;
		layout.addView(loginView, IPageLayout.LEFT, 0.5f, layout.getEditorArea());*/
		
		// create folders (create the main folder first as a reference)
		//IFolderLayout main = layout.createFolder( "IConstants.FOLDER_MAIN", IPageLayout.LEFT, (float) 1.0, layout.getEditorArea() );
		//IFolderLayout left = layout.createFolder( "IConstants.FOLDER_LEFT", IPageLayout.LEFT, (float) 0.2, "IConstants.FOLDER_MAIN" );
		//IFolderLayout bottom = layout.createFolder( "IConstants.FOLDER_BOTTOM", IPageLayout.BOTTOM, 0.8f, "IConstants.FOLDER_MAIN" );

		// add placeholders for the views
		//main.addPlaceholder("*.ui.main.*:*");
		//left.addPlaceholder("*.ui.left.*:*");
		//bottom.addPlaceholder("*.ui.bottom.*:*");
		
		String loginViewID = LoginView.ID;	      
		IFolderLayout left = layout.createFolder("ICAT_Folder", IPageLayout.LEFT, 0.3f, layout.getEditorArea());
		left.addPlaceholder(loginViewID + ":*");
		left.addView(loginViewID);
		
		String cnfViewID = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
		left.addPlaceholder(cnfViewID + ":*");
		//view added programmatically
		      
		layout.setEditorAreaVisible(true);

	}

}
