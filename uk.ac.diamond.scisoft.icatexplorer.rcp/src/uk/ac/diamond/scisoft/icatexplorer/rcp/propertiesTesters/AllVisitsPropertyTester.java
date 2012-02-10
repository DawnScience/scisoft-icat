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
			IProject rootICATProject = ((IResource) receiver).getProject();
			return validateRootProject(rootICATProject);

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

			if ((rootICATProject.getPersistentProperty(q1)).equalsIgnoreCase("ICAT")){
				return true;
			}
		} catch (CoreException e) {
			logger.debug("problem getting persistent property");
		}
		
		return false;
	}	

}
