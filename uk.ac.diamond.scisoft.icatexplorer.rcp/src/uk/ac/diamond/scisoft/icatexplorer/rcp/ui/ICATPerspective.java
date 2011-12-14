package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import uk.ac.diamond.scisoft.analysis.rcp.views.DatasetInspectorView;
import uk.ac.diamond.scisoft.analysis.rcp.views.PlotView;
import uk.ac.diamond.scisoft.analysis.rcp.views.SidePlotView;

public class ICATPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.perspective";

	public void createInitialLayout(IPageLayout layout) {
		
		String loginViewID = LoginView.ID;	      
		IFolderLayout main = layout.createFolder("ICAT_Main", IPageLayout.LEFT, 0.2f, layout.getEditorArea());
		IFolderLayout right = layout.createFolder("ICAT_Right", IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
		IFolderLayout bottom = layout.createFolder("ICAT_Bottom", IPageLayout.BOTTOM, 0.55f, layout.getEditorArea());

		
		main.addPlaceholder(loginViewID + ":*");
		main.addView(loginViewID);
		
		String cnfViewID = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
		main.addPlaceholder(cnfViewID + ":*");

		// place holders for remaining views
		String plot = PlotView.ID + "DP";
		right.addPlaceholder(plot);
		
		right.addPlaceholder(SidePlotView.ID + ":*");

		String inspector = DatasetInspectorView.ID;
		bottom.addView("fable.imageviewer.views.HeaderView");
		bottom.addView(inspector);
		if (layout.getViewLayout(inspector) != null)
			layout.getViewLayout(inspector).setCloseable(false);

	}

}
