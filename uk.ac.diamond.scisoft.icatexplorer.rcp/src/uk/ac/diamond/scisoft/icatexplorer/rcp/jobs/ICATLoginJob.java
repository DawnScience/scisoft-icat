package uk.ac.diamond.scisoft.icatexplorer.rcp.jobs;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.icat3.client.ICAT;

public class ICATLoginJob extends Job {

	private static final Logger logger = LoggerFactory
			.getLogger(ICATLoginJob.class);

	private String fedid;
	private String password;
	private ICAT icat;
	// private String sessionId;
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

			sessionId.set(this.icat.login(fedid, password));
			logger.info("User " + this.fedid + " logged in icat. sessionId: "
					+ sessionId);

		} catch (Exception e) {
			logger.error("failed to authenticate! ", e);
		}

		logger.debug("returning sessionid= " + sessionId.toString());
		return Status.OK_STATUS;

	}

}