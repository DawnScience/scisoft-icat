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

import java.util.Random;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;


public class SftpJob extends Job {
	
	private String jobFamily;
	private JobTrainingBean dataBean;
	
	public SftpJob(String name, JobTrainingBean dataBean) {
		super(name);
		this.jobFamily = name;
		this.dataBean = dataBean;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		char [] inputText = dataBean.getInput().toCharArray();
		char [] backwards = new char[inputText.length];
		int stop = inputText.length;
		for (int i = 0; i<stop; i++){
			backwards[stop-i-1]=inputText[i];
		}
		monitor.beginTask("Going backwards", monitor.UNKNOWN);
		long time = System.currentTimeMillis();
		double delay = new Random().nextDouble()*3000+10000;
		while (System.currentTimeMillis()<(time+delay)){
			
			if(monitor.isCanceled())
				return Status.CANCEL_STATUS;
		}
		String temp = String.valueOf(backwards);
		dataBean.setBackwards(temp);
		//JobTraining.update();
		return Status.OK_STATUS;
	}
	
	@Override
	public boolean belongsTo(Object family) {
		return jobFamily.equals(family);
	}
}
