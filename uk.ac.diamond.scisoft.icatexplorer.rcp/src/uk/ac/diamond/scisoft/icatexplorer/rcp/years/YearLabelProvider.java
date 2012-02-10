package uk.ac.diamond.scisoft.icatexplorer.rcp.years;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;

import uk.ac.diamond.scisoft.icatexplorer.rcp.years.YearTreeData;

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
