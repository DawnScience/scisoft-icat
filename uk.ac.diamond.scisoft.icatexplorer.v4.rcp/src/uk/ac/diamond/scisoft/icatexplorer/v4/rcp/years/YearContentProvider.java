/*
 * Copyright 2012 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.years;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.icatproject.Investigation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datafiles.DatafileTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datasets.DatasetTreeData;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.visits.VisitTreeData;


public class YearContentProvider implements ITreeContentProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(YearContentProvider.class);

	private static final Object[] NO_CHILDREN = new Object[0];

	private static final CharSequence BEAMLINES = "Beamlines";

	
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

		if(parentElement instanceof IFolder) {
		
		String currentBeamline = null;
		//check whether we are in a 'Beamlines' folder. If so extract beamline
		if(parentElement.toString().contains(BEAMLINES)){
			
			String delimiter = "/";
			String[] temp = parentElement.toString().split(delimiter);
			
			currentBeamline = temp[temp.length - 2];
		}
		
		// extracting current project
		//logger.debug("getting project name for IFolder: " + parentElement.toString());
		String[] temp;
		String delimiter = "/";
		temp = parentElement.toString().split(delimiter);		
		String currentProject = temp[1];
				
		String currentYear = ((IFolder) parentElement).getName();
		
		return getVisitsByYear(currentYear, currentBeamline, currentProject);
		
		}
			 
		return children != null ? children : NO_CHILDREN;
	}

	/**
	 * @param currentYear
	 * @return
	 */
	private VisitTreeData[] getVisitsByYear(String currentYear, String currentBeamline, String currentProject) {
			
		IProject parentProject = ResourcesPlugin.getWorkspace().getRoot().getProject(currentProject);

		QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
		String sessionId = null;
		try {
			sessionId = parentProject.getPersistentProperty(qNameSessionId);
		} catch (CoreException e) {
			logger.error("error in getting sessionid from project: " + parentProject.getName());
		}
			ICATClient icatClient = ICATSessions.get(sessionId);
			List<Investigation> result = null;
			result = icatClient.getCurrentInvestigations();
			
			ArrayList<VisitTreeData> visitsTree = new ArrayList<VisitTreeData>(); 
			//VisitTreeData[] visitsTree = new VisitTreeData[result.size()];
			
			for(int i=0; i< result.size(); i++){	
				Investigation icatInvestigation = result.get(i);
				
				// filter by year and by beamline
				String year = String.valueOf(((Investigation)result.get(i)).getStartDate().getYear());
				
				if(year.equalsIgnoreCase(currentYear)){
									
					VisitTreeData visit = new VisitTreeData(icatInvestigation, parentProject);
					
					// check beamline if we are in 'Beamlines' hierarchy
					if(currentBeamline !=  null){
						String beamline = result.get(i).getInstrument().getName();
						
						if (beamline.equalsIgnoreCase(currentBeamline)){
							visitsTree.add(visit);
						}
					}else {
						visitsTree.add(visit);
					}
					
					logger.debug("create visitTree  '" + i + "' - " + visit.getIcatInvestigation().getVisitId());
				  }

			}
			
						
			VisitTreeData [] visitArray = visitsTree.toArray(new VisitTreeData[visitsTree.size()]);
			return visitArray;
		
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return (element instanceof VisitTreeData || element instanceof IResource
				|| element instanceof DatasetTreeData || element instanceof YearTreeData  || element instanceof DatafileTreeData);
	}

}
