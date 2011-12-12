package uk.ac.diamond.scisoft.icatexplorer.rcp.internal;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Window advisor
 * @author smw81327
 * @version $Id$
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor
{
    private static final Logger logger = LoggerFactory.getLogger(ApplicationWorkbenchWindowAdvisor.class); 

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer)
    {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer)
    {	
        return new ApplicationActionBarAdvisor(configurer);
    }

    public void preWindowOpen()
    {	

        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(1000, 300));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
        configurer.setTitle("ICAT Explorer");
                
     // important in order to display progress of long running operations
     	configurer.setShowProgressIndicator(true);
     	
    }
}
