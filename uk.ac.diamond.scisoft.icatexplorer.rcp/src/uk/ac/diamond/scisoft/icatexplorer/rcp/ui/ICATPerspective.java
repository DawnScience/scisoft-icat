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

package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import uk.ac.diamond.scisoft.analysis.rcp.views.DatasetInspectorView;
import uk.ac.diamond.scisoft.analysis.rcp.views.PlotView;
import uk.ac.diamond.scisoft.analysis.rcp.views.SidePlotView;

public class ICATPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.perspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {

//		IFolderLayout main = layout.createFolder("ICAT_Main", IPageLayout.LEFT,
//				0.2f, layout.getEditorArea());
		IFolderLayout right = layout.createFolder("ICAT_Right",
				IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
		IFolderLayout bottom = layout.createFolder("ICAT_Bottom",
				IPageLayout.BOTTOM, 0.55f, layout.getEditorArea());

		
		
		// place holders for remaining views
		String plot = PlotView.ID + "DP";
		right.addPlaceholder(plot);
		right.addPlaceholder(SidePlotView.ID + ":*");

		bottom.addView("fable.imageviewer.views.HeaderView");
		String inspector = DatasetInspectorView.ID;
		bottom.addView(inspector);
		if (layout.getViewLayout(inspector) != null)
			layout.getViewLayout(inspector).setCloseable(false);

	}

}
