package uk.ac.diamond.scisoft.icatexplorer.rcp.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;


import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFContentProvider;


/**
 * @author smw81327
 * @version $Id$
 */
public class RenameHandler extends AbstractHandler
{
	//private final static Logger logger = Logger.getLogger(RenameHandler.class);

    /* (non-Javadoc)
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
        //logger.debug("Rename from main plugin " + currentSelection);
                     
        return null;
    }

}
