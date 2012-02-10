
package uk.ac.diamond.scisoft.icatexplorer.rcp.visits;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;

/**
 * Provides a label and icon for objects of type {@link VisitTreeData}. 
 * @since 3.2 
 */
public class VisitLabelProvider extends LabelProvider implements
		ILabelProvider, IDescriptionProvider, IStyledLabelProvider {
  

	public Image getImage(Object element) {
		if (element instanceof VisitTreeData){
			String imageKey = ISharedImages.IMG_OBJ_FOLDER;
		return PlatformUI.getWorkbench().getSharedImages()
				.getImage(imageKey);
		}
		return null;
	}

	public String getText(Object element) {
		
		if (element instanceof VisitTreeData) {
			return "" + getStyledText(element); 
		}  
		return null;
	}

	public String getDescription(Object anElement) {
		if (anElement instanceof VisitTreeData) {
			VisitTreeData data = (VisitTreeData) anElement;
			return "Investigation: " + data.getIcatInvestigation().getVisitId(); 
		}
		return null;
	}
	

	@Override
	public StyledString getStyledText(Object obj) {
		StyledString styledString = new StyledString();

		if (obj instanceof VisitTreeData) {
			styledString.append(((VisitTreeData) obj).getIcatInvestigation().getVisitId());
			styledString.append("   ");
			styledString.append(
					((VisitTreeData) obj).getIcatInvestigation().getInstrument()
							+ "   "
							+ UnitsConverter
									.gregorianToDate(((VisitTreeData) obj).getIcatInvestigation()
											.getInvStartDate())
							+ "   "
							+ UnitsConverter
									.gregorianToDate(((VisitTreeData) obj).getIcatInvestigation()
											.getInvEndDate()),
					StyledString.DECORATIONS_STYLER);

		}
		return styledString;
	}
  
}
