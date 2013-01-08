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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datasets;

import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datafiles.DatafileTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.visits.VisitTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.years.YearTreeData;

import org.icatproject.Dataset;
import org.icatproject.Investigation;


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
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {

		Object[] children = null;
		if (parentElement instanceof VisitTreeData) { 
			
			logger.debug("getting project name : " + ((VisitTreeData)parentElement).getParentProject());
						
			return getDatasets(((VisitTreeData)parentElement).getIcatInvestigation().getId(), ((VisitTreeData)parentElement).getParentProject());
		} else if(parentElement instanceof IFolder) {
			
			logger.debug("getting project name for IFolder: " + ((VisitTreeData)parentElement).getFolder());
			String[] temp;
			String delimiter = "/";
			temp = ((VisitTreeData)parentElement).getFolder().getName().split(delimiter);		
			IProject currentProject = ResourcesPlugin.getWorkspace().getRoot().getProject(temp[1]);
						
			return getDatasets(((Investigation)parentElement).getId(), currentProject);
			
		}   
		return children != null ? children : NO_CHILDREN;
	}  
	/**
	 * @param id 
	 * @return
	 */
	private Object[] getDatasets(Long id, IProject parentProject) {
		
		QualifiedName qNameSessionId = new QualifiedName("SESSIONID", "String");
		String sessionId = null;
		try {
			sessionId = parentProject.getPersistentProperty(qNameSessionId);
		} catch (CoreException e) {
			logger.error("error getting sessionid from project: " + parentProject.getName(), e);
		}
		
		ICATClient icatClient = ICATSessions.get(sessionId);
		List<org.icatproject.Dataset> result = null;
		result = icatClient.getDatasets(id);
		DatasetTreeData[] datasetsTree = new DatasetTreeData[result.size()];
		
		for(int i=0; i< result.size(); i++){	
			
			Dataset icatDataset = result.get(i);
			DatasetTreeData dataset = new DatasetTreeData(icatDataset, parentProject);
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
