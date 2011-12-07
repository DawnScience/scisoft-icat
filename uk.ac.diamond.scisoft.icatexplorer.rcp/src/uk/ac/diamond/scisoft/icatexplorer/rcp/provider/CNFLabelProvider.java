package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;

//import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDatafile;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DIcat;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;
import uk.icat3.client.Investigation;
import uk.icat3.client.Datafile;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Label provider for the parent child non-resource based CNF viewer
 * @author smw81327
 * @version $Id$
 */
public class CNFLabelProvider extends LabelProvider implements ILabelProvider, IDescriptionProvider, IStyledLabelProvider
{
	//private static Logger logger = LoggerFactory.getLogger(CNFLabelProvider.class);

	StyledString text = new StyledString();
	
    public String getText(Object element)
    {
    	return  "" + getStyledText(element.toString());

    }

    public String getDescription(Object element)
    {
        //String text = getText(element);
        //return "This is a description of " + text;
    	if (element instanceof DIcat) {    	
    		return "" + ((DIcat)element).getHost() + "@" + ((DIcat)element).getFedid();
    	}else if (element instanceof DInvestigation) {    	
    		return "" + ((DInvestigation)element).getVisitId() + " -- " + ((DInvestigation)element).getId();
    	}else if (element instanceof DDataset){
    		return "" + ((DDataset)element).getName() + " -- " + ((DDataset)element).getId();
    	}else if (element instanceof Datafile){
    		return "" + ((Datafile)element).getLocation() + " -- " + ((Datafile)element).getFileSize();
    	}
    	return null;
    }
    
    public Image getImage(Object element)
    {
    	if (element instanceof DIcat) 
        {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
        }else if (element instanceof DInvestigation) 
        {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
        } else if (element instanceof DDataset) 
        {
            return AbstractUIPlugin.imageDescriptorFromPlugin("uk.ac.diamond.scisoft.icatexplorer.rcp",
            				"icons/prop_ps.gif").createImage();//PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
        }else if (element instanceof Datafile) 
        {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
        }
        return null;
    }

	@Override
	public StyledString getStyledText(Object obj) {
		StyledString styledString = new StyledString();
		
		if(obj instanceof DIcat) {
			
			styledString.append(((DIcat)obj).getFedid() + "@DLS.ICAT ");
			//styledString.append("(" + ((DIcat)obj).getNbInvestigations()+ ")");
			//styledString.append(
                    //((DIcat)obj).getFedid()+
                    //"@icat"  , StyledString.DECORATIONS_STYLER);
			
			}else if (obj instanceof DInvestigation) {
				styledString.append(((DInvestigation)obj).getVisitId());
				styledString.append("   ");
				styledString.append(
	                    ((Investigation)obj).getInstrument() + "   " + UnitsConverter.gregorianToDate(((Investigation)obj).getInvStartDate()) + "   " + UnitsConverter.gregorianToDate(((Investigation)obj).getInvEndDate()), StyledString.DECORATIONS_STYLER);
				
			}else if (obj instanceof DDataset) {
				styledString.append(((DDataset)obj).getName());

			}else if (obj instanceof Datafile) {
				
				styledString.append(((Datafile)obj).getName());
				styledString.append("   ");
				
				String formattedSize = UnitsConverter.humanReadableByteCount( ((Datafile)obj).getFileSize());
				
				styledString.append(
						formattedSize + "   " + UnitsConverter.gregorianToString(((Datafile)obj).getDatafileCreateTime()), StyledString.DECORATIONS_STYLER);

			}
		
		
		return styledString;
	}
	
   
 


	
}
