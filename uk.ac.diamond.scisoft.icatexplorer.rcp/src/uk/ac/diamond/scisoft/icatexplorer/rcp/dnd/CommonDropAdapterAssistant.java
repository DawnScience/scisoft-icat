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

package uk.ac.diamond.scisoft.icatexplorer.rcp.dnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CopyFilesAndFoldersOperation;
import org.eclipse.ui.actions.MoveFilesAndFoldersOperation;
import org.eclipse.ui.actions.ReadOnlyStateChecker;
import org.eclipse.ui.internal.navigator.resources.plugin.WorkbenchNavigatorMessages;
import org.eclipse.ui.internal.navigator.resources.plugin.WorkbenchNavigatorPlugin;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.jobs.SftpTransferJob;

public class CommonDropAdapterAssistant extends
		org.eclipse.ui.navigator.CommonDropAdapterAssistant{

    private static final Logger logger = LoggerFactory.getLogger(CommonDropAdapterAssistant.class); 
	
	private static final boolean DEBUG = false;
	private static final IResource[] NO_RESOURCES = new IResource[0];
	
	public CommonDropAdapterAssistant() {}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#isSupportedType(org.eclipse.swt.dnd.TransferData)
	 */
	public boolean isSupportedType(TransferData aTransferType) {

		return super.isSupportedType(aTransferType)
				|| FileTransfer.getInstance().isSupportedType(aTransferType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#validateDrop(java.lang.Object,
	 *      int, org.eclipse.swt.dnd.TransferData)
	 */
	  @Override
	    public IStatus validateDrop(Object target, int operation, TransferData transferType) {

		  // target shouldn't be a virtual folder to copy to
		  if (target instanceof IResource && !((IResource)target).isVirtual()) {
	            return Status.OK_STATUS;
	        }
	        return Status.CANCEL_STATUS;
	    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#handleDrop(CommonDropAdapter,
	 *      DropTargetEvent, Object)
	 */
	@Override
    public IStatus handleDrop(CommonDropAdapter dropAdapter, DropTargetEvent dropTargetEvent, Object dropTarget) {
        
        /* 
         * check whether the destination target is a folder
         * If not drop to parent folder
         */
        IContainer targetContainer = getActualTarget((IResource)dropTarget);
        
        if (LocalSelectionTransfer.getTransfer().isSupportedType(dropAdapter.getCurrentTransfer())) {              
        	  handleDropMove((IResource)targetContainer);       	
            }
        return null;
    }
	
	 private void handleDropMove(final IResource target) {
		 	ISelection s = LocalSelectionTransfer.getTransfer()
					.getSelection();
		 		 	
	        if (s instanceof IStructuredSelection) {
            List<?> selectedElements = ((IStructuredSelection) s).toList();
            				
			SftpTransferJob transferJob = new SftpTransferJob("Transfering from DLS... ", selectedElements, target);
			transferJob.setUser(true);// shows the dialog for 'run in background' and 'details' 
			transferJob.schedule();
            
	        }
       
	 }
		 	
//	        if (s instanceof IStructuredSelection) {
//	            List<?> selectedElements = ((IStructuredSelection) s).toList();
//	            for (Object o : selectedElements) {
//	                if (o instanceof uk.icat3.client.Datafile) {
//	                    Datafile element = (Datafile) o;
//	                    moveDatafileTo(element, target, null);
//	                }else if(o instanceof DDataset){
//	                	logger.debug("moving a dataset");
//	                	DDataset ddataset = ((DDataset)o);
//	                	uk.icat3.client.Dataset dataset = null;
//	                	try {
//							dataset = ICATClient.getIcat().getDatasetIncludes(ICATSessionDetails.icatClient.getSessionId(), ddataset.getId(), DatasetInclude.DATASET_AND_DATAFILES_ONLY);
//						} catch (InsufficientPrivilegesException_Exception e) {
//							logger.error("problem getting dataset content from ICAT", e);
//						} catch (NoSuchObjectFoundException_Exception e) {
//							logger.error("problem getting dataset content from ICAT", e);
//						} catch (SessionException_Exception e) {
//							logger.error("problem getting dataset content from ICAT", e);
//						} catch (Exception e) {
//							logger.error("problem getting dataset content from ICAT", e);
//						}
//	                	datafilesList. = dataset.getDatafileCollection();
//	                	int nbFiles = datafilesList.size();        	
//	                 	
//	                	logger.debug("number of files in dataset " + ddataset.getName() + ": " + nbFiles);
//	                	/*
//	                	 *  create folder in target with dataset name
//	                	 *  all non-existent ancestor directories are
//	                	 *  automatically created
//	                	 */
//	                	boolean success = (new File(target.getLocation().toString(), ddataset.getName())).mkdirs();
//	                	if (!success) {
//		                	 logger.error("error creating folder '" + ddataset.getName() +"' into '" + target.getName()+"'" );
//	                	}
//	                	// move all dataset files into the newly created folder               	      
//	  	                String parentFolder = ddataset.getName();
//	  	                moveDatasetTo(parentFolder, datafilesList, target, parentFolder);      	
//	                	
//	                }
////                	getShell().getShell().getDisplay().asyncExec
////                    (new Runnable() {
////                        public void run() {
////                            MessageDialog.openInformation(getShell().getShell(),"Info", "All selected files moved into the Project Explorer");
////                        }
////                    });        
//                	logger.info("ALL selected files moved!");
//	            }
//	            // gathered all selected elements to be moved
//	            moveDatafilesTo(parentFolder, datafilesList, target, parentFolder);      	
//	        }
	          
//	    }
	 

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#validatePluginTransferDrop(org.eclipse.jface.viewers.IStructuredSelection,
	 *      java.lang.Object)
	 */
	public IStatus validatePluginTransferDrop(
			IStructuredSelection aDragSelection, Object aDropTarget) {
				
		if (!(aDropTarget instanceof IResource)) {
			return WorkbenchNavigatorPlugin
					.createStatus(
							IStatus.INFO,
							0,
							WorkbenchNavigatorMessages.DropAdapter_targetMustBeResource,
							null);
		}
		return Status.OK_STATUS;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#handlePluginTransferDrop(org.eclipse.jface.viewers.IStructuredSelection, java.lang.Object)
	 */
	public IStatus handlePluginTransferDrop(IStructuredSelection aDragSelection, Object aDropTarget) {
	
		IContainer target = getActualTarget((IResource) aDropTarget);
		IResource[] resources = getSelectedResources(aDragSelection);
		
		MoveFilesAndFoldersOperation operation = new MoveFilesAndFoldersOperation(
				 getShell());
		operation.copyResources(resources, target);

		if (target != null && target.isAccessible()) {
			try {
				target.refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e) {
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * Returns the actual target of the drop, given the resource under the
	 * mouse. If the mouse target is a file, then the drop actually occurs in
	 * its parent. If the drop location is before or after the mouse target and
	 * feedback is enabled, the target is also the parent.
	 */
	private IContainer getActualTarget(IResource mouseTarget) {
		
		/* if cursor is on a file, return the parent */
		if (mouseTarget.getType() == IResource.FILE) {
			logger.debug("selected target is a FILE, moving instead to parent folder: " + mouseTarget.getParent());
			return mouseTarget.getParent();
		}
		/* otherwise the mouseTarget is the real target */
		return (IContainer) mouseTarget;
	}

	/**
	 * Returns the resource selection from the LocalSelectionTransfer.
	 * 
	 * @return the resource selection from the LocalSelectionTransfer
	 */
	private IResource[] getSelectedResources() {
			
		ISelection selection = LocalSelectionTransfer.getTransfer()
				.getSelection();
				//ICATTransfer.getTransfer().getSelection(); 
				
		if (selection instanceof IStructuredSelection) {

			return getSelectedResources((IStructuredSelection)selection);
		} 
		return NO_RESOURCES;
	}

	/**
	 * Returns the resource selection from the LocalSelectionTransfer.
	 * 
	 * @return the resource selection from the LocalSelectionTransfer
	 */
	private IResource[] getSelectedResources(IStructuredSelection selection) {
				
		ArrayList selectedResources = new ArrayList();

		for (Iterator i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof IResource) {
				selectedResources.add(o);
			} else if (o instanceof IAdaptable) {
				IAdaptable a = (IAdaptable) o;
				IResource r = (IResource) a.getAdapter(IResource.class);
				if (r != null) {
					selectedResources.add(r);
				}else{
					System.out.println("r is NULL");
				}
			}
		}
		return (IResource[]) selectedResources
				.toArray(new IResource[selectedResources.size()]);
	}

	/**
	 * Performs a resource copy
	 */
	private IStatus performResourceCopy(CommonDropAdapter dropAdapter,
			Shell shell, IResource[] sources) {
				
		MultiStatus problems = new MultiStatus(PlatformUI.PLUGIN_ID, 1,
				WorkbenchNavigatorMessages.DropAdapter_problemsMoving, null);
		mergeStatus(problems, validateTarget(dropAdapter.getCurrentTarget(),
				dropAdapter.getCurrentTransfer(), dropAdapter
						.getCurrentOperation()));

		IContainer target = getActualTarget((IResource) dropAdapter
				.getCurrentTarget());
		CopyFilesAndFoldersOperation operation = new CopyFilesAndFoldersOperation(
				shell);
		operation.copyResources(sources, target);

		return problems;
	}

	/**
	 * Performs a resource move
	 */
	private IStatus performResourceMove(CommonDropAdapter dropAdapter,
			IResource[] sources) {
		
		MultiStatus problems = new MultiStatus(PlatformUI.PLUGIN_ID, 1,
				WorkbenchNavigatorMessages.DropAdapter_problemsMoving, null);
		mergeStatus(problems, validateTarget(dropAdapter.getCurrentTarget(),
				dropAdapter.getCurrentTransfer(), dropAdapter
						.getCurrentOperation()));

		IContainer target = getActualTarget((IResource) dropAdapter
				.getCurrentTarget());
		ReadOnlyStateChecker checker = new ReadOnlyStateChecker(getShell(),
				WorkbenchNavigatorMessages.MoveResourceAction_title,
				WorkbenchNavigatorMessages.MoveResourceAction_checkMoveMessage);
		sources = checker.checkReadOnlyResources(sources);
		MoveFilesAndFoldersOperation operation = new MoveFilesAndFoldersOperation(
				getShell());
		operation.copyResources(sources, target);

		return problems;
	}

	/**
	 * Performs a drop using the FileTransfer transfer type.
	 */
	private IStatus performFileDrop(CommonDropAdapter anAdapter, Object data) {
				
		MultiStatus problems = new MultiStatus(PlatformUI.PLUGIN_ID, 0,
				WorkbenchNavigatorMessages.DropAdapter_problemImporting, null);
		mergeStatus(problems,
				validateTarget(anAdapter.getCurrentTarget(), anAdapter
						.getCurrentTransfer(), anAdapter.getCurrentOperation()));

		final IContainer target = getActualTarget((IResource) anAdapter
				.getCurrentTarget());
		final String[] names = (String[]) data;
		// Run the import operation asynchronously.
		// Otherwise the drag source (e.g., Windows Explorer) will be blocked
		// while the operation executes. Fixes bug 16478.
		Display.getCurrent().asyncExec(new Runnable() {
			public void run() {
				getShell().forceActive();
				CopyFilesAndFoldersOperation operation = new CopyFilesAndFoldersOperation(
						getShell());
				operation.copyFiles(names, target);
			}
		});
		return problems;
	}

	/**
	 * Ensures that the drop target meets certain criteria
	 */
	private IStatus validateTarget(Object target, TransferData transferType,
			int dropOperation) {
				
		if (!(target instanceof IResource)) {
			return WorkbenchNavigatorPlugin
					.createInfoStatus(WorkbenchNavigatorMessages.DropAdapter_targetMustBeResource);
		}
		IResource resource = (IResource) target;
		if (!resource.isAccessible()) {
			return WorkbenchNavigatorPlugin
					.createErrorStatus(WorkbenchNavigatorMessages.DropAdapter_canNotDropIntoClosedProject);
		}
		IContainer destination = getActualTarget(resource);
		if (destination.getType() == IResource.ROOT) {
			return WorkbenchNavigatorPlugin
					.createErrorStatus(WorkbenchNavigatorMessages.DropAdapter_resourcesCanNotBeSiblings);
		}
		String message = null;
		// drag within Eclipse?
		if (LocalSelectionTransfer.getTransfer().isSupportedType(transferType)) {
			IResource[] selectedResources = getSelectedResources();

			if (selectedResources.length == 0) {
				message = WorkbenchNavigatorMessages.DropAdapter_dropOperationErrorOther;
			} else {
				CopyFilesAndFoldersOperation operation;
				if (dropOperation == DND.DROP_COPY) {
					operation = new CopyFilesAndFoldersOperation(getShell());
				} else {
					operation = new MoveFilesAndFoldersOperation(getShell());
				}
				message = operation.validateDestination(destination,
						selectedResources);
			}
		} // file import?
		else if (FileTransfer.getInstance().isSupportedType(transferType)) {
			String[] sourceNames = (String[]) FileTransfer.getInstance()
					.nativeToJava(transferType);
			if (sourceNames == null) {
				// source names will be null on Linux. Use empty names to do
				// destination validation.
				// Fixes bug 29778
				sourceNames = new String[0];
			}
			CopyFilesAndFoldersOperation copyOperation = new CopyFilesAndFoldersOperation(
					getShell());
			message = copyOperation.validateImportDestination(destination,
					sourceNames);
		}
		if (message != null) {
			return WorkbenchNavigatorPlugin.createErrorStatus(message);
		}
		return Status.OK_STATUS;
	}

	/**
	 * Adds the given status to the list of problems. Discards OK statuses. If
	 * the status is a multi-status, only its children are added.
	 */
	private void mergeStatus(MultiStatus status, IStatus toMerge) {

		if (!toMerge.isOK()) {
			status.merge(toMerge);
		}
	}

	/**
	 * Opens an error dialog if necessary. Takes care of complex rules necessary
	 * for making the error dialog look nice.
	 */
	private void openError(IStatus status) {
		if (status == null) {
			return;
		}

		String genericTitle = WorkbenchNavigatorMessages.DropAdapter_title;
		int codes = IStatus.ERROR | IStatus.WARNING;

		// simple case: one error, not a multistatus
		if (!status.isMultiStatus()) {
			ErrorDialog
					.openError(getShell(), genericTitle, null, status, codes);
			return;
		}

		// one error, single child of multistatus
		IStatus[] children = status.getChildren();
		if (children.length == 1) {
			ErrorDialog.openError(getShell(), status.getMessage(), null,
					children[0], codes);
			return;
		}
		// several problems
		ErrorDialog.openError(getShell(), genericTitle, null, status, codes);
	}

}
