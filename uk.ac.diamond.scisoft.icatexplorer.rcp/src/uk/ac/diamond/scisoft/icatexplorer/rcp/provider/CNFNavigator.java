package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.navigator.CommonNavigator;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.Root;


/**
 * @author smw81327
 * @version $Id$
 */
public class CNFNavigator extends CommonNavigator 
{
    protected Object getInitialInput()
    {	
   	return new Root();
    }

}
