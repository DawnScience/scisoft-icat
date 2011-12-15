package uk.ac.diamond.scisoft.icatexplorer.rcp.provider;

import java.io.File;
import java.net.InetAddress;
import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
import uk.ac.diamond.scisoft.icatexplorer.rcp.jobs.JobTrainingBean;
import uk.ac.diamond.scisoft.icatexplorer.rcp.sftpclient.SftpClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.FilenameUtils;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.OSDetector;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;
import uk.ac.gda.common.rcp.util.EclipseUtils;
import uk.icat3.client.Datafile;


/**
 * @author smw81327
 * @version $Id$
 */
public class CNFActionProvider extends CommonActionProvider
{

	private static Logger logger = LoggerFactory.getLogger(CNFActionProvider.class);
	
    private OpenChildAction openAction;
	public IWorkbenchPage page;
	private Properties properties;
	private String downloadDir;
	private String sftpServer;
	private static JobTrainingBean dataBean = new JobTrainingBean();;


    public CNFActionProvider()
    {
    	logger.debug("reading properties file...");
		
		try {
			properties = PropertiesUtils.readConfigFile();
			downloadDir = properties.getProperty("download.dir");
			
			InetAddress addr = InetAddress.getLocalHost();
			
			if (insideDLS(addr)){
				sftpServer = properties.getProperty("internal.sftp.server");
			}else{
				sftpServer = properties.getProperty("external.sftp.server");
			}
				
		} catch (Exception e) {
			//e.printStackTrace();
			logger.debug("cannot read icatexplorer");
		}

    }

    @Override
    public void init(ICommonActionExtensionSite site)
    {
        ICommonViewerSite viewSite = site.getViewSite();
        if (viewSite instanceof ICommonViewerWorkbenchSite) 
        {
            ICommonViewerWorkbenchSite workbenchSite = (ICommonViewerWorkbenchSite) viewSite;
            openAction = new OpenChildAction(workbenchSite.getPage(), workbenchSite.getSelectionProvider());
           
        }
    }
    
    
    

    @Override
    public void restoreState(IMemento memento)
    {
        super.restoreState(memento);
    }

    @Override
    public void saveState(IMemento memento)
    {
        super.saveState(memento);
    }

    @Override
    public void fillActionBars(IActionBars actionBars)
    {
        if (openAction.isEnabled())
        {
            actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openAction);
        }
    }
    
    @Override
    public void fillContextMenu(IMenuManager menu)
    {
        if (openAction.isEnabled())
        {
            menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openAction);
        }
    }

    
    /**
     * 
     * 
     * 
     */
    class OpenChildAction extends Action
    {
		private ISelectionProvider provider;
        private Object /*DDataset*/ data;

        public OpenChildAction(IWorkbenchPage workbenchPage, ISelectionProvider selectionProvider)
        {
            //super("Open item");
            //provider = selectionProvider;
        	setText("Open");
        	page = workbenchPage;
        	provider = selectionProvider;

        }
        

        @Override
        public void run()
        {
            
            if (data != null)
            {
                logger.debug("open called on " + data.getClass().getName());
        		       		        				
    			// If we had a selection lets open the editor
    			if (data instanceof DInvestigation) {
    				DInvestigation dinvestigation = (DInvestigation) data;

//    				try {
//    					DInvestigationEditorInput input = new DInvestigationEditorInput(dinvestigation); 					
//    					page.openEditor((IEditorInput) input, DInvestigationEditor.ID);
//    					
//    				} catch (PartInitException e) {
//    					throw new RuntimeException(e);
//    				}
    			}else if (data instanceof DDataset) {
    				DDataset ddataset = (DDataset) data;

//    				try {
//    					DDatasetEditorInput input = new DDatasetEditorInput(ddataset); 					
//    					page.openEditor((IEditorInput) input, DDatasetEditor.ID);    					    				
//    					
//    				} catch (PartInitException e) {
//    					throw new RuntimeException(e);
//    				}
    		         		     
    			}else if (data instanceof Datafile) {
    				Datafile datafile = (Datafile) data;
    				logger.debug("opening " + datafile.getLocation() + " with id: " +datafile.getId());
    				
//    				// open datafile editor
//    				try {
//    					DatafileEditorInput input = new DatafileEditorInput(datafile); 					
//    					page.openEditor((IEditorInput) input, DatafileEditor.ID);
//    					
//    				} catch (PartInitException e) {
//    					throw new RuntimeException(e);
//    				}
    				
    				// check current operating system
    				if (OSDetector.isUnix()){
    					try {

    						EclipseUtils.openExternalEditor(datafile.getLocation());
        					
    					} catch (PartInitException e) {
    						logger.error("Cannot open file "+datafile.getLocation(), e);
    					}
    				}else{//windows os detected
    					
    					logger.info("non-unix system detected...proceed with downloading the file");
    					
    					/*
    					 * check whether temporary download location exists.
    					 * if not create it in home directory
    					 * all non-existent ancestor directories are
    					 * automatically created?
    					 */
    				     
    					File file1 = new File(System.getProperty("user.home"));
    				    File file2 = new File(file1, downloadDir);
    					File file3 = new File(file2.getPath());
    					
    					// computing the local file path
    					FilenameUtils fileUtils = new FilenameUtils(datafile.getLocation(), '/', '.');    					
    				    File file4 = new File(file2, fileUtils.filename());
    				    File file5 = new File(file4.getPath());
    				    
    				    String localFilePath = file5.getPath();
    				 
    				if(!file3.exists()){// download dir does not exist yet, create it
    					
						logger.error("Creating: "+ file3.getPath());

    				    boolean success = (new File(file2.getPath())).mkdirs();
    						if (success) {
    							
        						logger.debug("Successfully created: "+ file3.getPath());

    						}else {
    							// Directory creation failed
        						logger.error("Failed creating download directory: "+ downloadDir);
    						}
    						
    				      }else {//folder exists already, create it
    						
   							logger.debug("Download Dir exists: "+ file3.getPath());
   							
   							
   							logger.debug("file exists? " + (Boolean.toString(file5.exists())).toUpperCase() + " - " + localFilePath);
    						if(!(new File(localFilePath)).exists()){
   							// download file to temp dir
							logger.info("downloading datafile id: " + datafile.getId());
							//String fileURL = ICATSessionDetails.icatClient.getIcat().downloadDatafile(ICATSessionDetails.icatClient.getSessionId(), datafile.getId());
							
							String fedid = ICATSessionDetails.icatClient.getFedId();
							String password = ICATSessionDetails.icatClient.getPassword();
							
							SftpClient sftpClient = new SftpClient();
							localFilePath = sftpClient.downloadFile(fedid, password, sftpServer, datafile.getLocation(), file2.getPath()/*downloadDir*/);
							
							logger.info("file successfully downloaded to " + localFilePath);
    				      }else{
    				    	  
    				    	  logger.debug("file: " + localFilePath + " already exist in local filesystem");
    				      }
							
							// open editor
							try {
								logger.debug("open file in editor:  " + datafile.getLocation());
	        					EclipseUtils.openExternalEditor(localFilePath);
	    					} catch (PartInitException e) {
	    						logger.error("Cannot open file "+datafile.getLocation(), e);
	    					}
				
    				      }
    					
    				}
    				
    			}
    			}// end if data <> null	
            super.run();
        }
        
        // handle single click
        @Override
        public boolean isEnabled()
        {
            ISelection selection = provider.getSelection();
            
            if (!selection.isEmpty())
            {
                IStructuredSelection sSelection = (IStructuredSelection) selection;
                if (sSelection.size() == 1 && sSelection.getFirstElement() instanceof DInvestigation) 
                {
                    data = (DInvestigation)sSelection.getFirstElement();
                    
//            		try {
//    					DInvestigationEditorInput input = new DInvestigationEditorInput((DInvestigation)data); 					
//    					page.openEditor((IEditorInput) input, DInvestigationEditor.ID);
//    					
//    				} catch (PartInitException e) {
//    					throw new RuntimeException(e);
//    				}
                    
                    return true;
                }else if (sSelection.size() == 1 && sSelection.getFirstElement() instanceof DDataset) 
                {
                    data = (DDataset) sSelection.getFirstElement();                    
                    return true;
                }else if (sSelection.getFirstElement() instanceof Datafile) 
                {
                    data = (Datafile) sSelection.getFirstElement();
                    
                   // open datafile editor
//    				try {
//    					DatafileEditorInput input = new DatafileEditorInput((Datafile)data); 					
//    					page.openEditor((IEditorInput) input, DatafileEditor.ID);
//    					
//    				} catch (PartInitException e) {
//    					throw new RuntimeException(e);
//    				}
                    
                    return true;
                }
            }
            return false;
        }

        
        
    }

	private boolean insideDLS(InetAddress addr) {

		String hostname = addr.getCanonicalHostName();
		
		if (hostname.contains("diamond.ac.uk")) {
			logger.debug("Connected from INSIDE Diamond: " + hostname);
			return true;
		} else {
			logger.debug("Connected from OUTSIDE Diamond: " + hostname);
			return false;
		}
	}
	
}
