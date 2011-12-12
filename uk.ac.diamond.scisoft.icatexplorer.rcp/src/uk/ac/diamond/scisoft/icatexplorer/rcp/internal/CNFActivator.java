package uk.ac.diamond.scisoft.icatexplorer.rcp.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;

/**
 * The activator class controls the plug-in life cycle
 */
public class CNFActivator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "uk.ac.diamond.scisoft.icatexplorer.rcp";

    // The shared instance
    private static CNFActivator plugin;
    
    // the logger
    private static final Logger logger = LoggerFactory.getLogger(CNFActivator.class); 

    /**
     * The constructor
     */
    public CNFActivator()
    {
    	
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
    	super.start(context);
        plugin = this;
        logger.debug("ICAT Explorer activator started");
        
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        plugin = null;
        super.stop(context);
     
    }

    /**
     * Returns the shared instance
     * @return the shared instance
     */
    public static CNFActivator getDefault()
    {

        return plugin;
    }
        

}
