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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils.NetworkUtils;


public class ReconnectWizardPage extends WizardPage implements KeyListener {

	private Text txtDirectory;
	private Text txtProject;
	private Text txtFedid;
	private Text txtPassword;
	private Text icatSiteNameText;
	private final ICATConnection icatCon;
	private final IProject iproject;

	private static final String ICAT_PLUGIN_ID = ICATExplorerActivator.PLUGIN_ID;

	private static final Logger logger = LoggerFactory.getLogger(ReconnectWizardPage.class);

	private Text icatIDText;
	private Text sftpServerText;
	private Text txtTruststore;
	private Text txtTruststorePassword;
	
	QualifiedName qNameProjectType;
	QualifiedName qNameFedid;
	QualifiedName qNameSiteName;
	QualifiedName qNameWsdl;
	QualifiedName qNameID;
	QualifiedName qNameDirectory;
	QualifiedName qNameSftpServer;
	QualifiedName qNameTruststorePath;
	QualifiedName qNameTruststorePass;


	/**
	 * Constructor for ReconnectWizardPage.
	 * 
	 */
	public ReconnectWizardPage(IProject iproject, String prevProject,
			String prevFolder, String prevDirectory, String prevFedid, String prevPassword, String prevTruststore, String prevTruststorePassword, ICATConnection icatCon) {
		super("V4ICATReconnectWizardPage");

		this.icatCon = icatCon;
		this.iproject = iproject;
		
		/*
		 *  extracting persistent properties 
		 *  to feed the reconnect wizard page
		 */
		qNameProjectType     = new QualifiedName("ICAT.PROJECT", "Type");
		qNameFedid           = new QualifiedName("FEDID","String");
		qNameSiteName        = new QualifiedName("SITE.NAME","String");
		qNameWsdl        	 = new QualifiedName("WSDL","String");
		qNameID          	 = new QualifiedName("ID","String");
		qNameDirectory   	 = new QualifiedName("DIRECTORY","String");
		qNameSftpServer  	 = new QualifiedName("SFTP_SERVER","String");
		qNameTruststorePath  = new QualifiedName("TRUSTSTORE_PATH","String");
		qNameTruststorePass  = new QualifiedName("TRUSTSTORE_PASSWORD","String");
				
				

		setTitle("ICAT Reconnection Wizard - reconnect based on project parameters");
		setDescription("Wizard to reconnect a closed ICAT connection");

	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLocation(-708, 1);
		container.setLayout(null);
		Label lblProjectName = new Label(container, SWT.NULL);
		lblProjectName.setBounds(4, 174, 103, 16);
		lblProjectName.setText("&Project name:");
		txtProject = new Text(container, SWT.BORDER);
		txtProject.setBounds(113, 173, 212, 27);
		txtProject.setText(iproject.getName());
		txtProject.setEditable(false);
		txtProject.addKeyListener(this);
		Composite composite = new Composite(container, SWT.NULL);
		composite.setBounds(708, 37, 64, 64);
		Composite composite_1 = new Composite(container, SWT.NULL);
		composite_1.setBounds(708, 108, 64, 64);

		Label lblicatDatabase = new Label(container, SWT.NONE);
		lblicatDatabase.setText("&ICAT site name:");
		lblicatDatabase.setBounds(4, 63, 103, 13);

		Label passwordLbl = new Label(container, SWT.NONE);
		passwordLbl.setBounds(4, 139, 64, 13);
		passwordLbl.setText("&Password:");

		txtFedid = new Text(container, SWT.BORDER);
		txtFedid.setEditable(false);
		try {
			txtFedid.setText(iproject.getPersistentProperty(qNameFedid));
		} catch (CoreException e1) {
			logger.error("can't set fedid");
		}
		txtFedid.setBounds(113, 93, 212, 27);
		txtFedid.addKeyListener(this);


		txtPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(113, 133, 212, 27);
		txtPassword.addKeyListener(this);

		setControl(container);
		
		icatIDText = new Text(container, SWT.BORDER | SWT.READ_ONLY);

		String icatID = icatCon.getId();
		icatIDText.setText(icatID);

		icatIDText.setEditable(false);
		icatIDText.setBounds(113, 13, 212, 27);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(4, 20, 81, 17);
		lblNewLabel.setText("&ICAT site ID");

		icatSiteNameText = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		icatSiteNameText.setEditable(false);

		String siteName = icatCon.getSiteName();
		icatSiteNameText.setText(siteName);
		icatSiteNameText.setBounds(113, 53, 212, 27);

		String sftpServer = icatCon.getSftpServer();

		Label fedidLbl = new Label(container, SWT.NONE);
		fedidLbl.setText("&FedId:");
		fedidLbl.setBounds(4, 108, 64, 13);

		Group grpAdvanced = new Group(container, SWT.NONE);
		grpAdvanced.setText("Advanced");
		grpAdvanced.setBounds(0, 213, 578, 213);

		Label lbltruststorePassword = new Label(grpAdvanced, SWT.NONE);
		lbltruststorePassword.setBounds(10, 173, 135, 19);
		lbltruststorePassword.setText("&Truststore password:");

		Label lbltruststorePath = new Label(grpAdvanced, SWT.NONE);
		lbltruststorePath.setBounds(10, 130, 135, 19);
		lbltruststorePath.setText("&Truststore path:");

		Label lbldownloadDirectory = new Label(grpAdvanced, SWT.NULL);
		lbldownloadDirectory.setBounds(10, 82, 135, 19);
		lbldownloadDirectory.setText("&Download directory:");


		Label sftpServerLbl = new Label(grpAdvanced, SWT.NONE);
		sftpServerLbl.setBounds(10, 41, 79, 13);
		sftpServerLbl.setText("&SFTP server:");

		txtTruststorePassword = new Text(grpAdvanced, SWT.BORDER | SWT.PASSWORD);
		txtTruststorePassword.setBounds(151, 165, 212, 27);
		try {
			txtTruststorePassword.setText(iproject.getPersistentProperty(qNameTruststorePass));
		} catch (CoreException e) {
			logger.error("can't set truststore password: " + e);
		}

		txtTruststore = new Text(grpAdvanced, SWT.BORDER);
		txtTruststore.setBounds(151, 122, 321, 27);
		try {
			txtTruststore.setText(iproject.getPersistentProperty(qNameTruststorePath));
		} catch (CoreException e) {
			logger.error("can't set truststore: " + e);
		}		
		txtTruststore.setEnabled(true);
		txtTruststore.setEditable(true);
		
		txtDirectory = new Text(grpAdvanced, SWT.BORDER);
		txtDirectory.setBounds(151, 82, 321, 27);
		try {
			txtDirectory.setText(iproject.getPersistentProperty(qNameDirectory));
		} catch (CoreException e) {
			logger.error("can't set download directory: " + e);
		}
		txtDirectory.setEditable(true);
		txtDirectory.setEnabled(true);

		final Button btnShowPassword = new Button(grpAdvanced, SWT.CHECK);
		btnShowPassword.setBounds(369, 170, 125, 22);
		btnShowPassword.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnShowPassword.getSelection()){
					txtTruststorePassword.setEchoChar((char)0);
				}else{
					txtTruststorePassword.setEchoChar('*');
				}
			}
		});
		btnShowPassword.setText("Show password");

		Button BtnBrowseTruststore = new Button(grpAdvanced, SWT.NONE);
		BtnBrowseTruststore.setBounds(478, 122, 71, 27);
		BtnBrowseTruststore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTruststoreBrowse();
			}
		});
		BtnBrowseTruststore.setText("Browse...");

		Button button = new Button(grpAdvanced, SWT.PUSH);
		button.setBounds(478, 82, 71, 27);
		button.setText("Browse...");

		sftpServerText = new Text(grpAdvanced, SWT.BORDER | SWT.READ_ONLY);
		sftpServerText.setBounds(151, 41, 212, 27);
		sftpServerText.setEditable(true);
		sftpServerText.setText(sftpServer);

		final Button btnSftpTest = new Button(grpAdvanced, SWT.NONE);
		btnSftpTest.setBounds(388, 39, 84, 29);
		btnSftpTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				/*
				 * ping test server for reachability
				 */
				if(NetworkUtils.isReachable(sftpServerText.getText())){
					Image okImage = (ResourceManager.getPluginImage(ICAT_PLUGIN_ID, "icons/ok.png"));;
					btnSftpTest.setImage(okImage);
				}else{
					Image noImage = (ResourceManager.getPluginImage(ICAT_PLUGIN_ID, "icons/no.png"));;
					btnSftpTest.setImage(noImage);
				}

			}
		});
		btnSftpTest.setText("Test");

		sftpServerText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {

				// server name changing so reset Test button
				btnSftpTest.setImage(null);
			}
		});
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDownloadDirBrowse();
			}
		});
		txtDirectory.addKeyListener(this);
		txtTruststore.addKeyListener(this);
		txtTruststorePassword.addKeyListener(this);

		dialogChanged();

	}

	/**
	 * Uses the standard container selection dialog to choose the new value for the container field.
	 */

	private void handleDownloadDirBrowse() {
		DirectoryDialog dirDialog = new DirectoryDialog(getShell(), SWT.OPEN);
		dirDialog.setFilterPath(getDirectory());
		final String filepath = dirDialog.open();
		if (filepath != null) {
			txtDirectory.setText(filepath);
			dialogChanged();
		}
	}

	private void handleTruststoreBrowse() {
		FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN);
		fileDialog.setFilterPath(getTruststore());
		final String filepath = fileDialog.open();
		if (filepath != null) {
			txtTruststore.setText(filepath);
			dialogChanged();
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		if (getFedid().length() == 0) {
			updateStatus("Fedid must be specified.");
			return;
		}

		if (getPassword().length() == 0) {
			updateStatus("Password must be specified.");
			return;
		}

		if (getProject().length() == 0) {
			updateStatus("Project name must be specified");
			return;
		}

		if (getDirectory().length() == 0) {
			updateStatus("Directory where to store downloaded data files must be specified.");
			return;
		}

		if (getTruststore().length() == 0) {
			updateStatus("Truststore path must be specified.");
			return;
		}

		if (getTruststorePass().length() == 0) {
			updateStatus("Truststore password must be specified.");
			return;
		}

		updateStatus(null);
	}


	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public ICATConnection getIcatCon(){

		String id         = icatIDText.getText();
		String siteName   = icatSiteNameText.getText();
		String sftpServer = sftpServerText.getText();

		String wsdl = icatCon.getWsdlLocation();

		ICATConnection icatCon = new ICATConnection(id, siteName, sftpServer, wsdl);

		return icatCon;
	}

	public String getFedid(){
		return txtFedid.getText();
	}

	public String getPassword(){
		return txtPassword.getText();
	}

	public String getProject() {
		return txtProject.getText();
	}

	public String getDirectory() {
		return txtDirectory.getText();
	}

	public String getTruststore() {
		return txtTruststore.getText();
	}

	public String getTruststorePass() {
		return txtTruststorePassword.getText();
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getSource().equals(txtProject)) {
			dialogChanged();
		}

		if (e.getSource().equals(txtFedid)) {
			dialogChanged();
		}
		if (e.getSource().equals(txtPassword)) {
			dialogChanged();
		}

		if (e.getSource().equals(txtTruststorePassword)) {
			dialogChanged();
		}
	}
}
