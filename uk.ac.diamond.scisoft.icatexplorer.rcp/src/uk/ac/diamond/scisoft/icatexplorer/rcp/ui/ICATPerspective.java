package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.analysis.rcp.views.DatasetInspectorView;
import uk.ac.diamond.scisoft.analysis.rcp.views.PlotView;
import uk.ac.diamond.scisoft.analysis.rcp.views.SidePlotView;

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
		IFolderLayout main = layout.createFolder("ICAT_Main", IPageLayout.LEFT, 1.0f, layout.getEditorArea());
		IFolderLayout right = layout.createFolder("ICAT_Right", IPageLayout.RIGHT, 0.2f, "ICAT_Main");
		IFolderLayout bottom = layout.createFolder("ICAT_Bottom", IPageLayout.BOTTOM, 0.8f, "ICAT_Right");

		
		main.addPlaceholder(loginViewID + ":*");
		main.addView(loginViewID);
		
		String cnfViewID = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
		main.addPlaceholder(cnfViewID + ":*");

		
		// place holders for remaining views
		String plot = PlotView.ID + "DP";
		//layout.addView(plot, IPageLayout.RIGHT, 0.25f, layout.getEditorArea());
		right.addPlaceholder(plot + ":*");
		if (layout.getViewLayout(plot) != null)
			layout.getViewLayout(plot).setCloseable(false);

		String sidePlot = SidePlotView.ID + ":Dataset Plot";
		//layout.addView(sidePlot, IPageLayout.RIGHT, 0.60f, plot);
		right.addPlaceholder(sidePlot + ":*");
		if (layout.getViewLayout(sidePlot) != null)
			layout.getViewLayout(sidePlot).setCloseable(false);

		String inspector = DatasetInspectorView.ID;
		//layout.addStandaloneView(inspector, false, IPageLayout.BOTTOM, 0.60f, layout.getEditorArea());
		bottom.addPlaceholder(inspector + ":*");
		if (layout.getViewLayout(inspector) != null)
			layout.getViewLayout(inspector).setCloseable(false);
	    //
		
		layout.setEditorAreaVisible(false);

	}

}
