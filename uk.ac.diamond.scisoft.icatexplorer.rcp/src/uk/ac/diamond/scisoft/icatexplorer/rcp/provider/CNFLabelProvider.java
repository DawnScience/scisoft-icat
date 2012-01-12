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

package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DIcat;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;
import uk.icat3.client.Datafile;
import uk.icat3.client.Investigation;

/**
 * Label provider for the parent child non-resource based CNF viewer
 * 
 * @author smw81327
 * @version $Id$
 */
public class CNFLabelProvider extends LabelProvider implements ILabelProvider,
		IDescriptionProvider, IStyledLabelProvider {
	// private static Logger logger =
	// LoggerFactory.getLogger(CNFLabelProvider.class);

	FileIconService iconService = new FileIconService();
	StyledString text = new StyledString();

	@Override
	public String getText(Object element) {
		return "" + getStyledText(element.toString());

	}

	@Override
	public String getDescription(Object element) {
		// String text = getText(element);
		// return "This is a description of " + text;
		if (element instanceof DIcat) {
			return "" + ((DIcat) element).getHost() + "@"
					+ ((DIcat) element).getFedid();
		} else if (element instanceof DInvestigation) {
			return "" + ((DInvestigation) element).getVisitId() + " -- "
					+ ((DInvestigation) element).getId();
		} else if (element instanceof DDataset) {
			return "" + ((DDataset) element).getName() + " -- "
					+ ((DDataset) element).getId();
		} else if (element instanceof Datafile) {
			return "" + ((Datafile) element).getDatafileLocation() + " -- "
					+ ((Datafile) element).getFileSize();
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof DIcat) {
			String imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(imageKey);
		} else if (element instanceof DInvestigation) {
			String imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(imageKey);
		} else if (element instanceof DDataset) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(
					"uk.ac.diamond.scisoft.icatexplorer.rcp",
					"icons/prop_ps.gif").createImage();// PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		} else if (element instanceof Datafile) {

			return iconService.getIcon(((Datafile) element)
					.getDatafileLocation());
		}
		return null;
	}

	@Override
	public StyledString getStyledText(Object obj) {
		StyledString styledString = new StyledString();

		if (obj instanceof DIcat) {

			styledString.append(((DIcat) obj).getFedid());
			styledString.append("   ");
			styledString.append("icat@" + ((DIcat) obj).getHost(),
					StyledString.COUNTER_STYLER);
			// styledString.append(
			// ((DIcat)obj).getFedid()+
			// "@icat" , StyledString.DECORATIONS_STYLER);

		} else if (obj instanceof DInvestigation) {
			styledString.append(((DInvestigation) obj).getVisitId());
			styledString.append("   ");
			styledString.append(
					((Investigation) obj).getInstrument()
							+ "   "
							+ UnitsConverter
									.gregorianToDate(((Investigation) obj)
											.getInvStartDate())
							+ "   "
							+ UnitsConverter
									.gregorianToDate(((Investigation) obj)
											.getInvEndDate()),
					StyledString.DECORATIONS_STYLER);

		} else if (obj instanceof DDataset) {
			styledString.append(((DDataset) obj).getName());

		} else if (obj instanceof Datafile) {

			styledString.append(((Datafile) obj).getName());
			styledString.append("   ");

			String formattedSize = UnitsConverter
					.humanReadableByteCount(((Datafile) obj).getFileSize());

			styledString.append(
					formattedSize
							+ "   "
							+ UnitsConverter.gregorianToString(((Datafile) obj)
									.getDatafileCreateTime()),
					StyledString.DECORATIONS_STYLER);

		}

		return styledString;
	}

}
