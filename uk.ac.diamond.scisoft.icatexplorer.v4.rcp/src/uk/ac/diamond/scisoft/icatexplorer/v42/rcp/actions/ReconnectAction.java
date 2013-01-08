
package uk.ac.diamond.scisoft.icatexplorer.v42.rcp.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.v42.rcp.wizards.ReconnectNewWizard;

public class ReconnectAction implements IHandler {
	
	
	private static Logger logger = LoggerFactory.getLogger(ReconnectAction.class);
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getActiveMenuSelection(event);
		
		IProject iproject = (IProject)selection.getFirstElement();
		
		logger.debug("reconnecting: " + iproject.getName());
		
		// get persistent properties needed to reconnect
		QualifiedName qNameProjectType = new QualifiedName("ICAT.PROJECT", "Type");
		QualifiedName qNameFedid       = new QualifiedName("FEDID","String");
		QualifiedName qNameSiteName    = new QualifiedName("SITE.NAME","String");
		QualifiedName qNameWsdl        = new QualifiedName("WSDL","String");
		QualifiedName qNameID          = new QualifiedName("ID","String");
		QualifiedName qNameDirectory   = new QualifiedName("DIRECTORY","String");
		QualifiedName qNameSftpServer  = new QualifiedName("SFTP_SERVER","String");
		QualifiedName qNameTruststorePath  = new QualifiedName("TRUSTSTORE_PATH","String");
		QualifiedName qNameTruststorePass  = new QualifiedName("TRUSTSTORE_PASSWORD","String");


		
		String projectType = null;
		String fedid = null;
		String siteName = null;
		String wsdl = null;
		String id = null;
		String directory = null;
		String sftpServer = null;
		String truststorePath = null;
		String truststorePass = null;		
		
	    try {
			projectType    = iproject.getPersistentProperty(qNameProjectType);
			fedid          = iproject.getPersistentProperty(qNameFedid);
			siteName       = iproject.getPersistentProperty(qNameSiteName);
			wsdl           = iproject.getPersistentProperty(qNameWsdl);
			id             = iproject.getPersistentProperty(qNameID);
			sftpServer     = iproject.getPersistentProperty(qNameSftpServer);
			directory      = iproject.getPersistentProperty(qNameDirectory);
			truststorePath = iproject.getPersistentProperty(qNameTruststorePath);
			truststorePass = iproject.getPersistentProperty(qNameTruststorePass);
		} catch (CoreException e) {
			logger.error("problem getting persistent property ", e);
		}
		
		logger.info("projectType: " + projectType );
		//logger.info("sessionId: " + sessionId );
		logger.info("fedid: " + fedid );
		logger.info("siteName: " + siteName );
		logger.info("wsdl: " + wsdl );
		logger.info("id: " + id );
		logger.info("sftpServer: " + sftpServer);
		logger.info("directory: " + directory );
		logger.info("truststorePath: " + truststorePath);
		logger.info("truststorePass: " + truststorePass);

		// create new connection
		ICATConnection icatCon = new ICATConnection(id, siteName, sftpServer, wsdl);
		
		// open wizard and fill with current connection values						
		ReconnectNewWizard reWizard = new ReconnectNewWizard(iproject, fedid, icatCon);
								
		WizardDialog dialog = new WizardDialog( reWizard.getShell(), reWizard);
		dialog.open();
				
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
