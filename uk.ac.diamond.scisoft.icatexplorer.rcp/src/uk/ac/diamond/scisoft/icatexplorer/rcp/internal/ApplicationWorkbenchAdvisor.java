package uk.ac.diamond.scisoft.icatexplorer.rcp.internal;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import uk.ac.diamond.scisoft.icatexplorer.rcp.ui.ICATPerspective;


/**
 * Workbench advisor
 * @author smw81327
 * @version $Id$
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor
{

    public void initialize(IWorkbenchConfigurer configurer)
    {
     }

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer)
    {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

    public String getInitialWindowPerspectiveId()
    {
        return ICATPerspective.PERSPECTIVE_ID;
    }

}
