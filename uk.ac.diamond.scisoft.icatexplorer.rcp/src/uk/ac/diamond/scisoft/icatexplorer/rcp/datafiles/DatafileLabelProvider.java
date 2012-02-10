package uk.ac.diamond.scisoft.icatexplorer.rcp.datafiles;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;


public class DatafileLabelProvider implements ILabelProvider, IStyledLabelProvider {
	
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
		
		styledString.append(((DatafileTreeData) obj).getIcatDatafile().getName());
		styledString.append("   ");

		String formattedSize = UnitsConverter
				.humanReadableByteCount(((DatafileTreeData) obj).getIcatDatafile().getFileSize());

		return styledString.append(
				formattedSize
						+ "   "
						+ UnitsConverter.gregorianToString(((DatafileTreeData) obj).getIcatDatafile()
								.getDatafileCreateTime()),
				StyledString.DECORATIONS_STYLER);
	}

}
