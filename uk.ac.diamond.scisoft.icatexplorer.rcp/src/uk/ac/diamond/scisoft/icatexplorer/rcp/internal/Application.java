package uk.ac.diamond.scisoft.icatexplorer.rcp.internal;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;


/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication
{
	
    private static final Logger logger = LoggerFactory.getLogger(Application.class); 

	public Object start(IApplicationContext context) throws Exception {
    	
    	Display display = PlatformUI.createDisplay();
        try
        {
            int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());

            if (returnCode == PlatformUI.RETURN_RESTART)
            {
                logger.debug("ICAT Explorer application RESTARTED");
                return IApplication.EXIT_RESTART;
            }
            
        logger.debug("ICAT Explorer application started");
            
            return IApplication.EXIT_OK;
        } finally
        {
            display.dispose();
        }

    }
        

    public void stop()
    {
    	final IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench == null)
            return;
        final Display display = workbench.getDisplay();
        display.syncExec(new Runnable() {
            public void run()
            {
                if (!display.isDisposed())
                    workbench.close();
            }
        });
        
        logger.debug("Application stopped");

    }
    
       
//    private boolean login(final Session session) {
//    	  while (session.getConnection() == null ||
//    	      !session.getConnection().isAuthenticated()) {
//    	    LoginDialog loginDialog = new LoginDialog(null);
//    	    if (loginDialog.open() != Window.OK)
//    	      return false;
//    	    session.setConnectionDetails(loginDialog.getConnectionDetails());
//    	    connectWithProgress(session);
//    	  }
//    	  return true;
//    	}
//    
//    private void connectWithProgress(final Session session) {
//    	  ProgressMonitorDialog progress = new ProgressMonitorDialog(null);
//    	  progress.setCancelable(true);
//    	  try {
//    	    progress.run(true, true, new IRunnableWithProgress() {
//    	      public void run(IProgressMonitor monitor)
//    	          throws InvocationTargetException {
//    	        try {
//    	          session.connectAndLogin(monitor);
//    	        } catch (XMPPException e) {
//    	          throw new InvocationTargetException(e);
//    	        }
//    	      }
//    	    });
//    	  } catch (InvocationTargetException e) {
//    	  } catch (InterruptedException e) {
//    	  }
//    	}


}
