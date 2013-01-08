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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.years;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.years.YearTreeData;

public class YearLabelProvider extends LabelProvider implements ILabelProvider,
		IDescriptionProvider, IStyledLabelProvider {

	public Image getImage(Object element) {
		if (element instanceof YearTreeData) {
			String imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(imageKey);
		}
		return null;
	}

	public String getText(Object element) {

		if (element instanceof YearTreeData) {
			return "" + getStyledText(element);
		}
		return null;
	}

	public String getDescription(Object anElement) {
		if (anElement instanceof YearTreeData) {
			YearTreeData data = (YearTreeData) anElement;
			return "Year: " + data.toString();
		}
		return null;
	}

	@Override
	public StyledString getStyledText(Object obj) {
		StyledString styledString = new StyledString();

		if (obj instanceof YearTreeData) {
			styledString.append(((YearTreeData) obj).toString());
		}
		return styledString;
	}

}
