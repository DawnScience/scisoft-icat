package uk.ac.diamond.scisoft.icatexplorer.rcp.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFContentProvider;


public class DeleteAction implements IObjectActionDelegate
{
	//private final static Logger logger = Logger.getLogger(DeleteAction.class);

    private DDataset data;

    /**
     * Constructor for Action1.
     */
    public DeleteAction()
    {
        super();
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart)
    {
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    public void run(IAction action)
    {
        if (data != null)
        {
            System.out.println("Delete on " + data.getName());
        }
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {
        if (!selection.isEmpty())
        {
            IStructuredSelection sSelection = (IStructuredSelection) selection;
            if (sSelection.size() == 1 && sSelection.getFirstElement() instanceof DDataset)
            {

                if (sSelection.getFirstElement() instanceof DDataset)
                {
                    data = (DDataset) sSelection.getFirstElement();
                }
            }
        }
    }

}
