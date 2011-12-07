package uk.ac.diamond.scisoft.icatexplorer.rcp.editors;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;


public class DInvestigationEditorInput implements IEditorInput {

    private long id;
	private DInvestigation DInvestigation;
    
    public DInvestigationEditorInput(DInvestigation DInvestigation){
    	this.DInvestigation = DInvestigation;
    }
    
    public DInvestigation getDInvestigation() {
		return DInvestigation;
	}

	public void setDInvestigation(DInvestigation DInvestigation) {
		this.DInvestigation = DInvestigation;
	}
    
    public DInvestigationEditorInput(long l) {
        this.id = l;
    }
    public long getId() {
        return id;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return "Displays an investigation info";
    }

    @Override
    public Object getAdapter(Class adapter) {
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + id);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DInvestigationEditorInput other = (DInvestigationEditorInput) obj;
        if (id != other.id)
            return false;
        return true;
    }
   

}