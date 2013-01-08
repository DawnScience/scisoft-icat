package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ConnICATProjectNature implements IProjectNature {

	public static final String NATURE_ID = "uk.ac.diamond.scisoft.icatexplorer.v4.rcp.conn.icat.nature"; //$NON-NLS-1$

	
	private IProject project;
	
    @Override
    public void configure() throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public void deconfigure() throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(IProject project) {
        this.project = project;

    }

}
