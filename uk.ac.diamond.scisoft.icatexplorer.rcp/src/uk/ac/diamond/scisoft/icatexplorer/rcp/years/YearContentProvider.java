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

package uk.ac.diamond.scisoft.icatexplorer.rcp.years;

import java.net.MalformedURLException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.datafiles.DatafileTreeData;
import uk.ac.diamond.scisoft.icatexplorer.rcp.datasets.DatasetTreeData;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.ICATHierarchyUtils;
import uk.ac.diamond.scisoft.icatexplorer.rcp.visits.VisitTreeData;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.NoSuchUserException_Exception;
import uk.icat3.client.SessionException;



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
		logger.debug("in getChildren");
		logger.debug("---> parentElement: " + parentElement.toString());
		Object[] children = null;
		
		if(parentElement instanceof IFolder) {
		
		String currentBeamline = null;
		//check whether we are in a 'Beamlines' folder. If so extract beamline
		if(parentElement.toString().contains(BEAMLINES)){
			
			String delimiter = "/";
			String[] temp = parentElement.toString().split(delimiter);
			
			currentBeamline = temp[temp.length - 2];
			logger.debug("found beamline: " + currentBeamline);
		}
		
		// extracting current project
		logger.debug("getting project name for IFolder: " + parentElement.toString());
		String[] temp;
		String delimiter = "/";
		temp = parentElement.toString().split(delimiter);		
		String currentProject = temp[1];
				
		String currentYear = ((IFolder) parentElement).getName();
		
		logger.debug("opening year: " + currentYear + " beamline: " + currentBeamline + " project: " + currentProject);
			
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
			try {
				result = icatClient.getLightInvestigations();
			} catch (MalformedURLException e) {
				logger.error("problem getting investigations: " + e);
			} catch (SessionException e) {
				logger.error("problem getting investigations: " + e);
			} catch (InsufficientPrivilegesException_Exception e) {
				logger.error("problem getting investigations: " + e);
			} catch (NoSuchUserException_Exception e) {
				logger.error("problem getting investigations: " + e);
			}
			
			logger.debug("result size: " + result.size());
			ArrayList<VisitTreeData> visitsTree = new ArrayList<VisitTreeData>(); 
			//VisitTreeData[] visitsTree = new VisitTreeData[result.size()];
			
			for(int i=0; i< result.size(); i++){	
				Investigation icatInvestigation = result.get(i);
				
				// filter by year and by beamline
				String year = String.valueOf(result.get(i).getInvStartDate().getYear());
				logger.debug("got year: " + year + " current year is: " + currentYear);
				
				if(year.equalsIgnoreCase(currentYear)){
									
					VisitTreeData visit = new VisitTreeData(icatInvestigation, parentProject);
					
					// check beamline if we are in 'Beamlines' hierarchy
					if(currentBeamline !=  null){
						String beamline = result.get(i).getInstrument();
						
						if (beamline.equalsIgnoreCase(currentBeamline)){
							visitsTree.add(visit);
							logger.debug("added visit: " + visit.getIcatInvestigation().getInvNumber());
						}
					}else {
						visitsTree.add(visit);
					}
					
					logger.debug("create visitTree  '" + i + "' - " + visit.getIcatInvestigation().getInvNumber());
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
