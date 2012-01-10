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

package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DIcat;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.Root;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
import uk.ac.diamond.scisoft.icatexplorer.rcp.jobs.CompletionAction;
import uk.ac.diamond.scisoft.icatexplorer.rcp.jobs.OpenDatasetJob;
import uk.ac.diamond.scisoft.icatexplorer.rcp.jobs.SftpTransferJob;
import uk.icat3.client.Datafile;
import uk.icat3.client.Dataset;
import uk.icat3.client.DatasetInclude;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.Investigation;
import uk.icat3.client.InvestigationInclude;
import uk.icat3.client.NoSuchObjectFoundException_Exception;
import uk.icat3.client.SessionException_Exception;


/**
 * Content provider for the parent child non-resource based CNF viewer
 * @author smw81327
 * @version $Id$
 */
public class CNFContentProvider implements ITreeContentProvider
{
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private DIcat[] dIcats;

    private static final Logger logger = LoggerFactory.getLogger(CNFContentProvider.class); 

    public Object[] getChildren(Object parentElement)
    {
    	logger.info("object triggered is of type ---> " + parentElement.getClass().getName());   	
    	
        if (parentElement instanceof Root)
        {
        	if (dIcats == null)
            {        
            	fillDIcats(parentElement);
            }
            return this.dIcats;
        } else if (parentElement instanceof DIcat)
        {

        	return ((DIcat) parentElement).getChildren();

        }else if (parentElement instanceof DInvestigation)
        {	
        	fillDInvestigations(parentElement);
        	return ((DInvestigation) parentElement).getChildren();       	
        	
        } else if (parentElement instanceof DDataset)
        {
        	        	
        	Datafile[] ddatafiles = null;
        	try {
    			logger.debug("populating dataset id: " + ((DDataset) parentElement).getId());
    			String sessionId = ICATSessionDetails.icatClient.getSessionId();
    			
    			long startTime = System.currentTimeMillis();
    			Dataset dataset = ICATSessionDetails.icatClient.getIcat().getDatasetIncludes(sessionId, ((DDataset) parentElement).getId(), DatasetInclude.DATASET_AND_DATAFILES_ONLY);
    			
//    			OpenDatasetJob openDataset = new OpenDatasetJob("populating dataset: " + ((DDataset)parentElement).getName(), sessionId, ((DDataset)parentElement));
//    			openDataset.setUser(false);// hides the dialog for 'run in background' and 'details'
//    			openDataset.schedule();
//    			
//    			ddatafiles = openDataset.getDatafiles();
//    			while(ddatafiles == null){
//    				ddatafiles = openDataset.getDatafiles();
//    			}
				   			
    			    			
    			long endTime = System.currentTimeMillis();
    			long millis = endTime - startTime;
    	        
    			ddatafiles = new Datafile[dataset.getDatafileCollection().size()];
    	        
    	        logger.info("execution time to retrieve [" + dataset.getDatafileCollection().size() + "] DATAFILES is: " +String.format("%d min, %d sec", 
    				    TimeUnit.MILLISECONDS.toMinutes(millis),
    				    TimeUnit.MILLISECONDS.toSeconds(millis) - 
    				    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
    				));
    	        logger.info("time in mills: " + millis);
    			
    	        
    	        for(int k=0; k< ddatafiles.length; k++){
    				
    				ddatafiles[k] = dataset.getDatafileCollection().get(k); //.setChildren[datafile];//dataset.getDatafiles().add(datafile);
    				
    			}
    		} catch (InsufficientPrivilegesException_Exception e) {
    			e.printStackTrace();
    		} catch (NoSuchObjectFoundException_Exception e) {
    			e.printStackTrace();
    		} catch (SessionException_Exception e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	
        	return ddatafiles;
        	
        } else
        {
            return EMPTY_ARRAY;
        }
    }
    
    private void fillDInvestigations(Object parentElement) {
    	Investigation filledInv = null;
    	String sessionId = ICATSessionDetails.icatClient.getSessionId();
    	long dinvId = ((DInvestigation) parentElement).getId();
    	Dataset[] datasetList = null;
    	DDataset[] children = null;
    	
    	DInvestigation dinv = (DInvestigation) parentElement;
    	
    	try {
    	
    		sessionId = ICATSessionDetails.icatClient.getSessionId();
        	dinvId = ((DInvestigation) parentElement).getId();
        	filledInv = ICATSessionDetails.icatClient.getIcat().getInvestigationIncludes(sessionId, dinvId, InvestigationInclude.DATASETS_ONLY);
						
			int datasetColSize = filledInv.getDatasetCollection().size();
							
			datasetList = new Dataset[datasetColSize];
			
			children = new DDataset[datasetList.length];
			
			for (int i=0; i< datasetColSize; i++) {
                Dataset dataset = (Dataset)filledInv.getDatasetCollection().get(i);
                
            	DDataset ddataset = new DDataset(dataset.getId(), dataset.getName(), dataset.getDatasetStatus(),
    			dataset.getDatasetType(), dataset.getDescription(), dataset.getInvestigationId(), dataset.getLocation(),
    			dataset.getSampleId(), dataset.getUniqueId());
                
				children[i] = ddataset;
            }
						
    	} catch (InsufficientPrivilegesException_Exception e) {
			e.printStackTrace();
		} catch (NoSuchObjectFoundException_Exception e) {
			e.printStackTrace();
		} catch (SessionException_Exception e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dinv.setChildren(children);	
    	
	}

	public Object getParent(Object element)
    {
        if (element instanceof DDataset)
        {
            return ((DDataset) element).getParent();
        } else if (element instanceof DInvestigation)
        {
            return ((DInvestigation) element).getParent();
        }else if (element instanceof DIcat)
        {
            return ((DIcat) element).getRoot();
        }
        return null;
    }

    public boolean hasChildren(Object element)
    {
        return (element instanceof Root || element instanceof DIcat || element instanceof DInvestigation || element instanceof DDataset);
    }

    public Object[] getElements(Object inputElement)
    {
        logger.info("calling getElements() on " + inputElement.getClass());
    	return getChildren(inputElement);	
    	
    }

    public void dispose()
    {
    	this.dIcats = null;
    	//this.dInvestigations = null;
    }

      
    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
//    	logger.debug("ContentProvider.inputChanged: old: ");
//    	if ( oldInput != null ) {
//    		System.out.print( oldInput.getClass().getName() ); //$NON-NLS-1$
//    	}
//    	logger.debug(" new: ");
//    	if ( newInput != null ) {
//    		logger.debug( newInput.getClass().getName() ); //$NON-NLS-2$
//    	}
    }

	/**
	 * Init code for dIcat
	 */
    private void fillDIcats(Object parentElement) {


    	if (ICATSessionDetails.icatClient != null){
    		
    		this.dIcats = new DIcat[1];
    		
    		DIcat dicat = new DIcat(ICATSessionDetails.icatClient.getFedId(), ICATSessionDetails.icatClient.getIcatHost());
    		this.dIcats[0] = dicat;
    		this.dIcats[0].setRoot(parentElement);

    		// call icat webserivce with current user and get list of investigations
    		List InvestigationsList = null;
    		List<Investigation> datasetInvList = null;

    		try {
    			InvestigationsList = ICATSessionDetails.icatClient.getLightInvestigations();
    			logger.info("InvestigationsList.size(): "
    					+ InvestigationsList.size());
    		} catch (MalformedURLException e) {
    			logger.error("can't retrieve investigation list", e);
    		} catch (SessionException_Exception e) {
    			logger.error("can't retrieve investigation list", e);
    		} catch (InsufficientPrivilegesException_Exception e) {
    			logger.error("can't retrieve investigation list", e);
    		} catch (NoSuchObjectFoundException_Exception e) {
    			logger.error("can't retrieve investigation list", e);
    		}
    		// populate investigations
    		int nbInv = InvestigationsList.size();
    		DInvestigation[] children = new DInvestigation[nbInv];
    		for (int i = 0; i < children.length; i++) {
    			uk.icat3.client.Investigation inv = (uk.icat3.client.Investigation) InvestigationsList
    					.get(i);

    			DInvestigation dinv = new DInvestigation(inv.getId(), inv.getVisitId());
    			dinv.setInstrument(inv.getInstrument());
    			dinv.setInvStartDate(inv.getInvStartDate());
    			dinv.setInvEndDate(inv.getInvEndDate());

    			children[i] = dinv;
    		}

    		// set children for the current dicat
    		this.dIcats[0].setChildren(children);
    		this.dIcats[0].setNbInvestigations(nbInv);

    	}else{
    		logger.debug("user not logged yet in ICAT");
    	}
    } 
}
