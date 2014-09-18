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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datafiles;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils.UnitsConverter;


public class DatafileLabelProvider implements ILabelProvider, IStyledLabelProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(DatafileLabelProvider.class);

	FileIconService iconService = new FileIconService();

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		return iconService.getIcon(((DatafileTreeData) element).getIcatDatafile().getLocation());
	}

	@Override
	public String getText(Object element) {
		return "" + getStyledText(element.toString());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
	 */
	@Override
	public StyledString getStyledText(Object obj) {
		
		StyledString styledString = new StyledString();

		if (obj instanceof DatafileTreeData) {
		//logger.debug("datafile name: " + ((DatafileTreeData) obj).getIcatDatafile().getName());
		
		styledString.append(((DatafileTreeData) obj).getIcatDatafile().getName());
		styledString.append("   ");

		String formattedSize = "N/A";
		try{
			formattedSize =UnitsConverter
				.humanReadableByteCount(((DatafileTreeData) obj).getIcatDatafile().getFileSize());
		}catch(Exception e){
			logger.error("Error getting size for: " + ((DatafileTreeData) obj).getIcatDatafile().getName());
		}
		
		styledString = styledString.append(
				formattedSize
				+ "   "
				+ UnitsConverter.gregorianToString(((DatafileTreeData) obj).getIcatDatafile()
						.getDatafileCreateTime()),
		StyledString.DECORATIONS_STYLER);
		}
		
		return styledString;
	}

}
