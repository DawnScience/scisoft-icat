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

package uk.ac.diamond.scisoft.icatexplorer.rcp.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.sda.meta.views.MetadataPageView;

public class ICATPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.perspective";

	private static Logger logger = LoggerFactory.getLogger(ICATPerspective.class);

	@Override
	public void createInitialLayout(IPageLayout layout) {
		
		IFolderLayout bottom = layout.createFolder("ICAT_Bottom",
				IPageLayout.BOTTOM, 0.55f, layout.getEditorArea());

		bottom.addView(MetadataPageView.ID);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(MetadataPageView.ID);
		} catch (PartInitException e) {
			logger.error("can't open Metadata View", e);
		}

	}

}
