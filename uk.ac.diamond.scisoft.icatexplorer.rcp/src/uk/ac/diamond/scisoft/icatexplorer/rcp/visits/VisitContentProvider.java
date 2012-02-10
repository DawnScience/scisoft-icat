
package uk.ac.diamond.scisoft.icatexplorer.rcp.visits;

import java.net.MalformedURLException;
import java.rmi.activation.Activator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.views.navigator.ResourceNavigator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.datafiles.DatafileTreeData;
import uk.ac.diamond.scisoft.icatexplorer.rcp.datasets.DatasetTreeData;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.years.YearTreeData;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.NoSuchUserException_Exception;
import uk.icat3.client.SessionException;


/**
 * Provides the properties contained in a *.properties file as children of that
 * file in a Common Navigator.  
 * @since 3.2 
 */
public class VisitContentProvider implements ITreeContentProvider
		/*, IResourceChangeListener, IResourceDeltaVisitor */{
  
	private static final Logger logger = LoggerFactory.getLogger(VisitContentProvider.class);
	
	private static final Object[] NO_CHILDREN = new Object[0];
	
	private String parentProject;

	private StructuredViewer viewer;
	
	/**
	 * Create the VisitContentProvider instance.
	 * 
	 * Adds the content provider as a resource change listener to track changes on disk.
	 *
	 */
	public VisitContentProvider() {
		//ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * Return the model elements for a *.properties IFile or
	 * NO_CHILDREN for otherwise.
	 */
	public Object[] getChildren(Object parentElement) {  
		logger.debug("in getChildren");
		Object[] children = null;
		if (parentElement instanceof VisitTreeData) { 
			children = NO_CHILDREN;
		} else if(parentElement instanceof IFolder) {
			logger.debug("getting project name for IFolder: " + parentElement.toString());
			String[] temp;
			String delimiter = "/";
			temp = parentElement.toString().split(delimiter);		
			String currentProject = temp[1];
			
			return getVisits(currentProject);
			
		}   
		return children != null ? children : NO_CHILDREN;
	}  

	/**
	 * @param currentProject 
	 * @return
	 */
	private VisitTreeData[] getVisits(String currentProject) {
				
				
		logger.debug("visit belongs to project: " + currentProject);
		
		ICATClient icatClient = ICATSessions.get(currentProject);
		
		List<Investigation> result = null;
		try {
			result = icatClient.getLightInvestigations();
		} catch (MalformedURLException e) {
			logger.error("error getting visits from ICAT");
		} catch (SessionException e) {
			logger.error("error getting visits from ICAT");
		} catch (InsufficientPrivilegesException_Exception e) {
			logger.error("error getting visits from ICAT");
		} catch (NoSuchUserException_Exception e) {
			logger.error("error getting visits from ICAT");
		}
		VisitTreeData[] visitsTree = new VisitTreeData[result.size()];
		
		for(int i=0; i< result.size(); i++){	
			Investigation icatInvestigation = result.get(i);
			VisitTreeData visit = new VisitTreeData(icatInvestigation, currentProject);
			visitsTree[i] = visit;

		}
				
		return visitsTree;
	}

	
	/**
	 * Load the model from the given file, if possible.  
	 * @param modelFolder The IFile which contains the persisted model 
	 */ 
	private synchronized String[] updateModel(IFolder modelFolder) { 
		
		return getNames();
		
//		if(PROPERTIES_EXT.equals(modelFolder.getFileExtension()) ) {
//			Properties model = new Properties();
//			if (modelFolder.exists()) {
//				try {
//					//model.load(modelFolder.getName());//.getContents()); 
//					
//					String propertyName; 
//					List properties = new ArrayList();
//					for(Enumeration names = model.propertyNames(); names.hasMoreElements(); ) {
//						propertyName = (String) names.nextElement();
//						properties.add(new VisitTreeData(propertyName,  model.getProperty(propertyName), modelFolder));
//					}
//					VisitTreeData[] visitsTreeData = (VisitTreeData[])
//						properties.toArray(new VisitTreeData[properties.size()]);
//					
//					cachedModelMap.put(modelFolder, visitsTreeData);
//					return getNames();//model; 
//				} catch (IOException e) {
//				} catch (CoreException e) {
//				}
//			} else {
//				cachedModelMap.remove(modelFolder);
//			}
//		}
//		return null; 
	}
/**
	 * @return
	 */
	private String[] getNames() {
		String[] names = new String[]{"123", "456", "789"};
		return names;
	}

//	private synchronized Properties updateModel(IFile modelFile) { 
//		
//		if(PROPERTIES_EXT.equals(modelFile.getFileExtension()) ) {
//			Properties model = new Properties();
//			if (modelFile.exists()) {
//				try {
//					model.load(modelFile.getContents()); 
//					
//					String propertyName; 
//					List properties = new ArrayList();
//					for(Enumeration names = model.propertyNames(); names.hasMoreElements(); ) {
//						propertyName = (String) names.nextElement();
//						properties.add(new VisitTreeData(propertyName,  model.getProperty(propertyName), modelFile));
//					}
//					VisitTreeData[] propertiesTreeData = (VisitTreeData[])
//						properties.toArray(new VisitTreeData[properties.size()]);
//					
//					cachedModelMap.put(modelFile, propertiesTreeData);
//					return model; 
//				} catch (IOException e) {
//				} catch (CoreException e) {
//				}
//			} else {
//				cachedModelMap.remove(modelFile);
//			}
//		}
//		return null; 
//	}

	public Object getParent(Object element) {
		logger.debug("in getParent");
		if (element instanceof VisitTreeData) {
			VisitTreeData data = (VisitTreeData) element;
			logger.debug("visit.getFolder(): " + data.getFolder().getName());
			return data.getFolder();
		} 
		return null;
	}

	public boolean hasChildren(Object element) {	
		logger.debug("in hasChildren");
		return (element instanceof VisitTreeData || element instanceof IResource
				|| element instanceof DatasetTreeData || element instanceof YearTreeData  || element instanceof DatafileTreeData);
	}

	public Object[] getElements(Object inputElement) {
		logger.debug("in getElements");
		return getChildren(inputElement);
	}

	public void dispose() {
//		cachedModelMap.clear();
//		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this); 
	}

	public void inputChanged(Viewer aViewer, Object oldInput, Object newInput) {
		
		viewer = (StructuredViewer) aViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {

//		IResourceDelta delta = event.getDelta();
//		try {
//			delta.accept(this);
//		} catch (CoreException e) { 
//			e.printStackTrace();
//		} 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
	 */
	public boolean visit(IResourceDelta delta) {

		return false;
	} 
	
}
