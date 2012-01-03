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
