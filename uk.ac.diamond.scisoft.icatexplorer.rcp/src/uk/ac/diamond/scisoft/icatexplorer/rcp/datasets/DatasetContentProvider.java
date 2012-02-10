package uk.ac.diamond.scisoft.icatexplorer.rcp.datasets;

import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.datafiles.DatafileTreeData;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.visits.VisitTreeData;
import uk.ac.diamond.scisoft.icatexplorer.rcp.years.YearTreeData;
import uk.icat3.client.Dataset;
import uk.icat3.client.Investigation;

public class DatasetContentProvider implements ITreeContentProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(DatasetContentProvider.class);

	private static final Object[] NO_CHILDREN = new Object[0];

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		logger.debug("in getElements");
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		logger.debug("in getChildren - parentElement is: " + parentElement.getClass().toString());
		Object[] children = null;
		if (parentElement instanceof VisitTreeData) { 
			
			logger.debug("getting project name : " + ((VisitTreeData)parentElement).getParentProject());
						
			return getDatasets(((VisitTreeData)parentElement).getIcatInvestigation().getId(), ((VisitTreeData)parentElement).getParentProject());
		} else if(parentElement instanceof IFolder) {
			
			logger.debug("getting project name for IFolder: " + ((VisitTreeData)parentElement).getFolder());
			String[] temp;
			String delimiter = "/";
			temp = ((VisitTreeData)parentElement).getFolder().getName().split(delimiter);		
			String currentProject = temp[1];
						
			return getDatasets(((Investigation)parentElement).getId(), currentProject);
			
		}   
		return children != null ? children : NO_CHILDREN;
	}  
	/**
	 * @param id 
	 * @return
	 */
	private Object[] getDatasets(Long id, String projectName) {

		ICATClient icatClient = ICATSessions.get(projectName);
		List<Dataset> result = null;
		result = icatClient.getDatasets(id);
		DatasetTreeData[] datasetsTree = new DatasetTreeData[result.size()];
		
		for(int i=0; i< result.size(); i++){	
			
			Dataset icatDataset = result.get(i);
			DatasetTreeData dataset = new DatasetTreeData(icatDataset, projectName);
			datasetsTree[i] = dataset;

		}
				
		return datasetsTree;
	}
	

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return (element instanceof VisitTreeData || element instanceof IResource
				|| element instanceof DatasetTreeData || element instanceof YearTreeData  || element instanceof DatafileTreeData);
	}

}