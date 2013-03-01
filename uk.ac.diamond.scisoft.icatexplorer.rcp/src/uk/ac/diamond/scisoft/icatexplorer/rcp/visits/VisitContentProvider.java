/*
 * Copyright © 2011 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package uk.ac.diamond.scisoft.icatexplorer.rcp.visits;

import java.net.MalformedURLException;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
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
	}

	/**
	 * Return the model elements for a *.properties IFile or
	 * NO_CHILDREN for otherwise.
	 */
	public Object[] getChildren(Object parentElement) {  
		Object[] children = null;
		if (parentElement instanceof VisitTreeData) { 
			children = NO_CHILDREN;
		} else if(parentElement instanceof IFolder) {
			String[] temp;
			String delimiter = "/";
			temp = parentElement.toString().split(delimiter);		
			//String currentProject = temp[1];
			IProject parentProject = ResourcesPlugin.getWorkspace().getRoot().getProject(temp[1]);
			
			return getVisits(parentProject);
			
		}   
		return children != null ? children : NO_CHILDREN;
	}  

	/**
	 * @param parentProject 
	 * @return
	 */
	private VisitTreeData[] getVisits(IProject parentProject) {
						
		QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
		String sessionId = null;
		try {
			sessionId = parentProject.getPersistentProperty(qNameSessionId);
		} catch (CoreException e1) {
			logger.error("error getting the sessionId for project " + parentProject.getName(), e1);
		}
		
		ICATClient icatClient = ICATSessions.get(sessionId);
		
		logger.debug("current sessionid= " + sessionId);
		logger.debug("icatClient.getCurrentInvestigations().size()= " + icatClient.getCurrentInvestigations().size());

		
		List<Investigation> result = null;
		
		result = icatClient.getCurrentInvestigations();
		
		VisitTreeData[] visitsTree = new VisitTreeData[result.size()];
		
		for(int i=0; i< result.size(); i++){	
			Investigation icatInvestigation = result.get(i);
			VisitTreeData visit = new VisitTreeData(icatInvestigation, parentProject);
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
	}
/**
	 * @return
	 */
	private String[] getNames() {
		String[] names = new String[]{"123", "456", "789"};
		return names;
	}

	public Object getParent(Object element) {
		if (element instanceof VisitTreeData) {
			VisitTreeData data = (VisitTreeData) element;
			return data.getFolder();
		} 
		return null;
	}

	public boolean hasChildren(Object element) {	
		return (element instanceof VisitTreeData || element instanceof IResource
				|| element instanceof DatasetTreeData || element instanceof YearTreeData  || element instanceof DatafileTreeData);
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {}

	public void inputChanged(Viewer aViewer, Object oldInput, Object newInput) {
		
		viewer = (StructuredViewer) aViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {

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
