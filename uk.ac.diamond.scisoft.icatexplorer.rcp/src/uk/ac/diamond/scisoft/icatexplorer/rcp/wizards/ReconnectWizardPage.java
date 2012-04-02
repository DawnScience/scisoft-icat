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

package uk.ac.diamond.scisoft.icatexplorer.rcp.wizards;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.NetworkUtils;


public class ReconnectWizardPage extends WizardPage implements KeyListener {

	private Text txtDirectory;
	private Text txtProject;
	private Text txtFedid;
	private Text txtPassword;
	private Text icatSiteNameText;
	private String initProject = "";
	private String initDirectory = "";
	private final String initFedid;
	private final ICATConnection icatCon;

	private static final String ICAT_PLUGIN_ID = ICATExplorerActivator.PLUGIN_ID;

	private static final Logger logger = LoggerFactory.getLogger(ReconnectWizardPage.class);

	private Text icatIDText;
	private Text sftpServerText;
	private Text txtTruststore;
	private Text txtTruststorePassword;


	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param prevDirectory
	 * @param prevFolder
	 * @param prevProject
	 * @param icatCon
	 */
	public ReconnectWizardPage(@SuppressWarnings("unused") ISelection selection, String prevProject,
			String prevFolder, String prevDirectory, String prevFedid, String prevPassword, String prevTruststore, String prevTruststorePassword, ICATConnection icatCon) {
		super("ICATReconnectWizardPage");

		this.initProject = prevProject; //prevProject != null ? prevProject : "ICAT";
		this.initDirectory = prevDirectory != null ? prevDirectory : "";
		this.initFedid = prevFedid != null ? prevFedid : "";

		setTitle("ICAT Reconnection Wizard - reconnect based on previous parameters");
		setDescription("Wizard to reconnect a closed ICAT connection");

		this.icatCon = icatCon;
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
		txtProject.setText(initProject);
		txtProject.setEditable(false);
		txtProject.addKeyListener(this);
		Composite composite = new Composite(container, SWT.NULL);
		composite.setBounds(708, 37, 64, 64);
		Composite composite_1 = new Composite(container, SWT.NULL);
		composite_1.setBounds(708, 108, 64, 64);

		Label lbldownloadDirectory = new Label(container, SWT.NULL);
		lbldownloadDirectory.setBounds(4, 258, 135, 19);
		lbldownloadDirectory.setText("&Download directory:");
		txtDirectory = new Text(container, SWT.BORDER);
		txtDirectory.setBounds(150, 253, 321, 27);
		txtDirectory.setText(initDirectory);
		txtDirectory.setEditable(true);
		txtDirectory.setEnabled(true);
		txtDirectory.addKeyListener(this);

		Button button = new Button(container, SWT.PUSH);
		button.setBounds(485, 253, 71, 27);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDownloadDirBrowse();
			}
		});

		Label lblicatDatabase = new Label(container, SWT.NONE);
		lblicatDatabase.setText("&ICAT site name:");
		lblicatDatabase.setBounds(4, 63, 103, 13);

		Label passwordLbl = new Label(container, SWT.NONE);
		passwordLbl.setBounds(4, 139, 64, 13);
		passwordLbl.setText("&Password:");

		txtFedid = new Text(container, SWT.BORDER);
		txtFedid.setEditable(false);
		txtFedid.setText(initFedid);
		txtFedid.setBounds(113, 93, 212, 27);
		txtFedid.addKeyListener(this);


		txtPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		//txtPassword.setText(initPassword);
		txtPassword.setBounds(113, 133, 212, 27);
		txtPassword.addKeyListener(this);


		Label sftpServerLbl = new Label(container, SWT.NONE);
		sftpServerLbl.setBounds(4, 219, 79, 13);
		sftpServerLbl.setText("&SFTP server:");

		setControl(container);
		/*
		 * populate wizard with current ICAT preferences
		 */

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

		sftpServerText = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		sftpServerText.setEditable(true);

		String sftpServer = icatCon.getSftpServer();
		sftpServerText.setText(sftpServer);

		sftpServerText.setBounds(113, 213, 212, 27);

		Label fedidLbl = new Label(container, SWT.NONE);
		fedidLbl.setText("&FedId:");
		fedidLbl.setBounds(4, 108, 64, 13);

		final Button btnSftpTest = new Button(container, SWT.NONE);
		btnSftpTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				/*
				 * test server using ping
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
		btnSftpTest.setBounds(331, 213, 84, 29);
		btnSftpTest.setText("Test");

		Label lbltruststorePath = new Label(container, SWT.NONE);
		lbltruststorePath.setText("&Truststore path:");
		lbltruststorePath.setBounds(4, 296, 135, 19);

		txtTruststore = new Text(container, SWT.BORDER);
		txtTruststore.setText("");
		txtTruststore.setEnabled(true);
		txtTruststore.setEditable(true);
		txtTruststore.setBounds(150, 296, 321, 27);
		txtTruststore.addKeyListener(this);

		Label lbltruststorePassword = new Label(container, SWT.NONE);
		lbltruststorePassword.setText("&Truststore password:");
		lbltruststorePassword.setBounds(4, 342, 135, 19);

		txtTruststorePassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtTruststorePassword.setBounds(150, 342, 212, 27);
		txtTruststorePassword.addKeyListener(this);

		final Button btnShowPassword = new Button(container, SWT.CHECK);
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
		btnShowPassword.setBounds(368, 342, 125, 22);
		btnShowPassword.setText("Show password");

		Button BtnBrowseTruststore = new Button(container, SWT.NONE);
		BtnBrowseTruststore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTruststoreBrowse();
			}
		});
		BtnBrowseTruststore.setText("Browse...");
		BtnBrowseTruststore.setBounds(485, 296, 71, 27);

		sftpServerText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {

				// server name changing so reset Test button
				btnSftpTest.setImage(null);
			}
		});

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
		fileDialog.setFilterPath(getDirectory());
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
