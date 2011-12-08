package uk.ac.diamond.scisoft.icatexplorer.rcp.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.progress.UIJob;



public class JobTrainingBean {

	private String input = "" ;
	private String lowercase = "";
	private String uppercase = "" ;
	private String backwards = "" ;
	
	public JobTrainingBean() {
			
	}
	public String getLowercase() {
		return lowercase;
	}
	public void setLowercase(String lowercase) {
		this.lowercase = lowercase;
	}
	public String getUppercase() {
		return uppercase;
	}
	public void setUppercase(String uppercase) {
		this.uppercase = uppercase;
	}
	public String getBackwards() {
		return backwards;
	}
	public void setBackwards(String backwards) {
		this.backwards = backwards;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}

	
}
