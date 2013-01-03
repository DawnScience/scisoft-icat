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

package uk.ac.diamond.scisoft.icatexplorer.v42.rcp.jobs;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.icatproject.ICAT;
import org.icatproject.Login;
import org.icatproject.Login.Credentials.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ICATLoginJob extends Job {

	private static final Logger logger = LoggerFactory
			.getLogger(ICATLoginJob.class);

	private String fedid;
	private String password;
	private ICAT icat;

	public final AtomicReference<String> sessionId = new AtomicReference<String>();

	public ICATLoginJob(String name, String fedid, String password, ICAT icat) {
		super(name);

		this.fedid = fedid;
		this.password = password;
		this.icat = icat;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {

		try {
				org.icatproject.Login.Credentials credentials = new Login.Credentials(); 
	            List<Login.Credentials.Entry> entries = credentials.getEntry(); 
	            Entry e;
	            e = new Entry(); 
	            e.setKey("username"); 
	            e.setValue(fedid); 
	            entries.add(e); 
	            e = new Entry(); 
	            e.setKey("password"); 
	            e.setValue(password); 
	            entries.add(e); 
	            String authenticator = "db";

	            sessionId.set(this.icat.login(authenticator, credentials));			
				
		} catch (Exception e) {
			logger.error("failed to authenticate! ", e);
			// TODO open error dialog
		}

		logger.debug("returning sessionid= " + sessionId.toString());
		return Status.OK_STATUS;

	}

}
