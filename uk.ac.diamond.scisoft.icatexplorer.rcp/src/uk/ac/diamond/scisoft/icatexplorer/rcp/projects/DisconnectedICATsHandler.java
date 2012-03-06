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

package uk.ac.diamond.scisoft.icatexplorer.rcp.projects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.rcp.natures.DiscICATProjectNature;
import uk.ac.diamond.scisoft.icatexplorer.rcp.natures.ICATProjectNature;

public class DisconnectedICATsHandler extends ViewerFilter {

	static final String ICAT_NATURE = ICATProjectNature.NATURE_ID;
	static final String DISC_ICAT_NATURE = DiscICATProjectNature.NATURE_ID;

	private static Logger logger = LoggerFactory
			.getLogger(DisconnectedICATsHandler.class);

	public DisconnectedICATsHandler() {
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		//logger.debug("handle disconnected ICAT projects");
		
		IProgressMonitor monitor = new NullProgressMonitor();
		// redecorate closed icat connections
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		// get list of existing icat projects
		IProject[] projectsList = root.getProjects();
		for (int count = 0; count < projectsList.length; count++) {
			
			IProject currentProject = ((IProject) projectsList[count]);
			
			if(currentProject.isOpen()){
			
			try {
								
				boolean isICATProject = currentProject.hasNature(ICAT_NATURE);

				if (isICATProject) {

					ICATClient currentIcatClient = ICATSessions
							.get(currentProject.getName());

					boolean isICATSessionClosed = (currentIcatClient == null);
					if (isICATSessionClosed) {
						
						//currentProject.close(monitor);

						/*
						 * change icon of icat project and delete its hierarchy
						 */
						createProject(currentProject.getName(), DISC_ICAT_NATURE);

					}
				}
			} catch (CoreException e) {
				logger.debug("problem cleaning dead icat projects: ", e);
			}
		}

		}

		return true;
	}

	private void createProject(String projectName, String nature) {

		logger.debug("modify nature");

		// create project
		IProgressMonitor openMonitor = new NullProgressMonitor();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject iproject = root.getProject(projectName);
		try {
			iproject.open(openMonitor);
		} catch (CoreException e1) {
			logger.error("problem opening project: " + iproject.getName());
		}

		
		

//		try {
//			iproject.delete(true, progressMonitor);
//			iproject.create(progressMonitor);		
//			iproject.open(progressMonitor);
//		} catch (CoreException e1) {
//			logger.error("problem creating project: " + projectName + " : ", e1);
// 	}
		
		// associating the icat nature to the newly created project
		IProgressMonitor modifyMonitor = new NullProgressMonitor();
		try {
			IProjectDescription description = iproject.getDescription();
			String[] newNatures = new String[] { nature };

			description.setNatureIds(newNatures);
			iproject.setDescription(description, modifyMonitor);

		} catch (CoreException e) {
			logger.error("problem setting ICAT nature to project: "
					+ projectName + " - Error: " + e);
		}
		
		logger.debug("project created: " + projectName);

	}

}
