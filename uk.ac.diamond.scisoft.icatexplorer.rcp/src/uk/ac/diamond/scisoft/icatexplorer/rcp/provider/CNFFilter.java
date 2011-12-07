package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;


/**
 * @author Simon Zambrovski
 * @version $Id$
 */
public class CNFFilter extends ViewerFilter
{

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element)
    {
        if (element instanceof DInvestigation) 
        {
            DInvestigation dInvestigation = (DInvestigation) element;
            return (dInvestigation.getVisitId().equals("DInvestigation 11"));
        } else {
            return true;
        }
    }

}
