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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.projects;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
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

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATSessions;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.natures.DiscICATProjectNature;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.natures.ICATProjectNature;

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
		// re-decorate closed icat connections
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		// get list of existing icat projects

		IProject[] projectsList = root.getProjects();
		for (int count = 0; count < projectsList.length; count++) {

			IProject currentProject = projectsList[count];

			if(currentProject.isOpen()){

				try {

					boolean isICATProject = currentProject.hasNature(ICAT_NATURE);

					if (isICATProject) {

						QualifiedName qNameSessionId   = new QualifiedName("SESSIONID", "String");
						String sessionId = currentProject.getPersistentProperty(qNameSessionId);

						boolean isICATSessionClosed = (!ICATSessions.hasSessionId(sessionId));
						if (isICATSessionClosed) {

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

		logger.debug("disconnecting: " + projectName);

		// create project
		//IProgressMonitor monitor = new NullProgressMonitor();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject iproject = root.getProject(projectName);
		try {

			IProjectDescription description = iproject.getDescription();
			String[] newNatures = new String[] { nature };
			description.setNatureIds(newNatures);
			iproject.setDescription(description, new NullProgressMonitor());

			iproject.open(new NullProgressMonitor());

		} catch (CoreException e1) {
			logger.error("problem opening project: " + iproject.getName());
		}

		// remove disconnected project content
		deleteDirContent(new File(iproject.getLocation().toOSString()));

		// refresh project explorer
		refreshProjectExplorer(iproject.getName());

		logger.debug("ICAT project disconnected: " + projectName);

	}

	private void deleteDirContent(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirContent(files[i]);
				} else {
					if(!(files[i].getName().equalsIgnoreCase(".project"))){
						boolean status  = files[i].delete();
						//logger.debug(files[i].getName() + " deleted?" + status);
					}
				}
			}
		} else {
			logger.error("path doesn't exist:  " + path.getName());
		}

		logger.debug("deleting:  " + path.getName());
		path.delete() ;
	}


	private void refreshProjectExplorer(String parentProject) {

		try {
			logger.debug("refreshing project: " + parentProject);
			ResourcesPlugin
			.getWorkspace()
			.getRoot()
			.getProject(parentProject)
			.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			logger.error("problem refreshing Project Explorer", e);
		}

	}

}
