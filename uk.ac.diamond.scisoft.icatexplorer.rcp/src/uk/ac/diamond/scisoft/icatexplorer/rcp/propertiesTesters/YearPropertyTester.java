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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YearPropertyTester extends PropertyTester {
	private Pattern pattern;
	private Matcher matcher;

	private static final String YEAR_PATTERN = "((19|20)\\d\\d)";

	private static final Logger logger = LoggerFactory.getLogger(YearPropertyTester.class);
	
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {

		/*
		 * test whether folder name is a year i.e. has 4 digits and is included
		 * between 1900 and 2099
		 * and root project is an icat project
		 */
		
		try {
						
			return validateYear(receiver instanceof IResource? ((IResource) receiver).getName(): "") && validateRootProject(((IResource) receiver).getProject() instanceof IProject ? ((IResource) receiver).getProject(): null);

		} catch (Exception e) {
			logger.error("cannot check whether the selected folder is a year: " , e);
		}

		return false;

	}

	/**
	 * Validate year format with regular expression
	 * @param currentFolderName 
	 * 
	 * @return true valid year format, false invalid year format
	 */
	public boolean validateYear(String currentFolderName) {

		pattern = Pattern.compile(YEAR_PATTERN);
		matcher = pattern.matcher(currentFolderName);

		if (matcher.matches()) {

			matcher.reset();

			if (matcher.find()) {

				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Validate beamline format
	 * @param rootICATProject 
	 * 
	 * @return true if valid beamline format
	 */
	public boolean validateRootProject(IProject rootICATProject) {
		
		QualifiedName q1 = new QualifiedName("ICAT.PROJECT", "Type");

		try {

			return (rootICATProject.getPersistentProperty(q1)).equalsIgnoreCase("ICAT");
				
		} catch (CoreException e) {
			logger.debug("problem getting persistent property: ", e);
			return false;

		}
		
	}
}