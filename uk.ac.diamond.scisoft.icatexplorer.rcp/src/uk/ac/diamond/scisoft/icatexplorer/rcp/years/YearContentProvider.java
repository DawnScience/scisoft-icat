package uk.ac.diamond.scisoft.icatexplorer.rcp.years;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
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
		
			ICATClient icatClient = ICATSessions.get(currentProject);
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
					VisitTreeData visit = new VisitTreeData(icatInvestigation, currentProject);
					//visitsTree[i] = visit;
					
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
			return visitArray;//visitsTree;
		
	}

	@Override
	public Object getParent(Object element) {
		logger.debug("getParent");
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		logger.debug("hasChildren");
		return (element instanceof VisitTreeData || element instanceof IResource
				|| element instanceof DatasetTreeData || element instanceof YearTreeData  || element instanceof DatafileTreeData);
	}
	
	/**
	 * @param name
	 */
	private YearTreeData[] getYearsByBeamline(String beamline) {
		logger.debug("calling getYearsByBeamline() for beamline: " + beamline);
		
		String activeProject = "";//TO MODIFY
		ICATClient icatClient = ICATSessions.get(activeProject);//new ICATClient();
		List<Investigation> result = null;
		try {
			result = icatClient.getLightInvestigations();
		} catch (MalformedURLException e) {
			
			logger.error("a problem occured getting investigations from the ICAT: ", e);
		} catch (SessionException e) {
			
			logger.error("a problem occured getting investigations from the ICAT: ", e);
		} catch (InsufficientPrivilegesException_Exception e) {
			
			logger.error("a problem occured getting investigations from the ICAT: ", e);
		} catch (NoSuchUserException_Exception e) {
			
			logger.error("a problem occured getting investigations from the ICAT: ", e);
		}
		List<String> yearsList = ICATHierarchyUtils.getYearsByBeamline(result, beamline);
		YearTreeData[] yearsTree = new YearTreeData[yearsList.size()];
		
		for(int i=0; i< result.size(); i++){	
						
			YearTreeData year = new YearTreeData(yearsList.get(i).toUpperCase(), activeProject);
			yearsTree[i] = year;

		}
				
		return yearsTree;
		
	}

}
