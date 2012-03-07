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

package uk.ac.diamond.scisoft.icatexplorer.rcp.propertiesTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AllVisitsPropertyTester extends PropertyTester {
	
	private static final Logger logger = LoggerFactory.getLogger(AllVisitsPropertyTester.class);
	
	
	public AllVisitsPropertyTester() {
		// TODO Auto-generated constructor stub
	}

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		/*
		 * test whether root project is an icat project
		 */
		
		try {
			return validateRootProject(receiver instanceof IResource && ((IResource) receiver).getProject() instanceof IProject ? (IProject) ((IResource) receiver).getProject() : null);

		} catch (Exception e) {
		}

		return false;
	}

	/**
	 * Validate beamline format with regular expression
	 * @param parentFolderName 
	 * 
	 * @return true valid beamline format, false invalid beamline format
	 */
	public boolean validateRootProject(IProject rootICATProject) {
		
		QualifiedName q1 = new QualifiedName("ICAT.PROJECT", "Type");

		try {

			return ((rootICATProject.getPersistentProperty(q1)).equalsIgnoreCase("ICAT"));
			
		} catch (CoreException e) {
			logger.error("problem getting persistent property: ", e);
			return false;
		}
		
	}	

}
