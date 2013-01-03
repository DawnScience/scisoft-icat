/*
 * Copyright © 2011 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package uk.ac.diamond.scisoft.icatexplorer.v42.rcp.datasets;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.internal.ICATExplorerActivator;

public class DatasetLabelProvider extends LabelProvider implements
ILabelProvider, IDescriptionProvider, IStyledLabelProvider {


	public Image getImage(Object element) {
		if (element instanceof DatasetTreeData){
			String iconName = "prop_ps.gif";
			return AbstractUIPlugin.imageDescriptorFromPlugin(
					ICATExplorerActivator.PLUGIN_ID,
					"icons/" + iconName).createImage();
		}
		return null;
	}

	public String getText(Object element) {

		if (element instanceof DatasetTreeData) {
			return "" + getStyledText(element); 
		}  
		return null;
	}

	public String getDescription(Object anElement) {
		if (anElement instanceof DatasetTreeData) {
			DatasetTreeData data = (DatasetTreeData) anElement;
			return "Dataset: " + data.getIcatDataset().getName(); 
		}
		return null;
	}


	@Override
	public StyledString getStyledText(Object obj) {
		StyledString styledString = new StyledString();

		if (obj instanceof DatasetTreeData) {
			styledString.append(((DatasetTreeData) obj).getIcatDataset().getName());
		}
		return styledString;
	}

}
