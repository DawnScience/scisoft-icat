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
		boolean isYear = false;
		
		try {
			IProject rootICATProject = ((IResource) receiver).getProject();
			isYear = validateYear(((IResource) receiver).getName()) && validateRootProject(rootICATProject);

		} catch (Exception e) {
		}

		return isYear;

	}

	/**
	 * Validate year format with regular expression
	 * @param currentFolderName 
	 * 
	 * @return true valid year format, false invalid year format
	 */
	public boolean validateYear(String currentFolderName) {
		//logger.debug("currentFolderName: " + currentFolderName);
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
	 * Validate beamline format with regular expression
	 * @param parentFolderName 
	 * 
	 * @return true valid beamline format, false invalid beamline format
	 */
	public boolean validateRootProject(IProject rootICATProject) {
		
		QualifiedName q1 = new QualifiedName("ICAT.PROJECT", "Type");

		try {

			if ((rootICATProject.getPersistentProperty(q1)).equalsIgnoreCase("ICAT")){
				return true;
			}
		} catch (CoreException e) {
			logger.debug("problem getting persistent property");
		}
		
		return false;
	}
}