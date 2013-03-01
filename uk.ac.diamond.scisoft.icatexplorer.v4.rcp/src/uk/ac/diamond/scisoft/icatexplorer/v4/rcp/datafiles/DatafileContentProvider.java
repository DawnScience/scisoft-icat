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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datafiles;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.icatproject.Datafile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datasets.DatasetTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATSessions;


public class DatafileContentProvider implements ITreeContentProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(DatafileContentProvider.class);
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children = null;
		if (parentElement instanceof DatasetTreeData) { 
			
			return getDatafiles(((DatasetTreeData)parentElement).getIcatDataset().getId(), ((DatasetTreeData)parentElement).getParentProject());
		} 
		
		return children != null ? children : NO_CHILDREN;
	}

	/**
	 * @param parentElement
	 * @return
	 */
	private Object[] getDatafiles(long id, IProject parentProject) {
			
		QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
		String sessionId = null;
		try {
			sessionId = parentProject.getPersistentProperty(qNameSessionId);
		} catch (CoreException e) {
			logger.error("error in getting sessionid from project: " + parentProject.getName());
		}
		
		ICATClient icatClient = ICATSessions.get(sessionId);
		List<Datafile> result = null;
		result = icatClient.getDatafiles(id);
		DatafileTreeData[] datafilesTree = new DatafileTreeData[result.size()];
				
		for(int i=0; i< result.size(); i++){	
			Datafile icatDatafile = result.get(i);
			DatafileTreeData datafile = new DatafileTreeData(icatDatafile, parentProject);
			datafilesTree[i] = datafile;
		}
				
		return datafilesTree;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

}
