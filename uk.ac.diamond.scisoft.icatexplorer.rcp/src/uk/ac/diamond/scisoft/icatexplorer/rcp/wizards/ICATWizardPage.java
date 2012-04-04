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
import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.rcp.preferences.ICATPreferenceInitializer;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.NetworkUtils;


public class ICATWizardPage extends WizardPage implements KeyListener {

	private Text txtDirectory;
	private Text txtProject;
	private Text txtFedid;
	private Text txtPassword;
	private Text icatSiteNameText;
	private final String initProject;
	private final String initDirectory;
	private final String initFedid;
	//private final String initTruststore;
	//private final String initTruststorePass;

	private static final String ICAT_PLUGIN_ID = ICATExplorerActivator.PLUGIN_ID;

	private final IPreferenceStore preferenceStore;

	private static final Logger logger = LoggerFactory.getLogger(ICATWizardPage.class);
	private static String DELIMITER = null;

	private Combo icatIDCombo;
	private Text txtSftpServer;
	private Text txtTruststore;
	private Text txtTruststorePassword;


	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param prevDirectory
	 * @param prevFolder
	 * @param prevProject
	 */
	public ICATWizardPage(@SuppressWarnings("unused") ISelection selection, String prevProject,
			String prevFolder, String prevDirectory, String prevFedid, String prevPassword, String prevTruststore, String prevTruststorePass) {
		super("ICATWizardPage");

		this.initProject = "";//prevProject != null ? prevProject : "ICAT";
		//this.initFolder = prevFolder != null ? prevFolder : "myIcat";
		this.initDirectory = prevDirectory != null ? prevDirectory : "";
		this.initFedid = prevFedid != null ? prevFedid : "";
		//this.initTruststore = prevTruststore != null ? prevTruststore : "";
		//this.initTruststorePass = prevTruststorePass != null ? prevTruststorePass : "";

		preferenceStore = ICATExplorerActivator.getDefault().getPreferenceStore();
		DELIMITER = ICATPreferenceInitializer.DELIMITER;

		setTitle("ICAT Project Wizard - creates a connection to an ICAT database");
		setDescription("Wizard to create an ICAT connection to browse datafiles");
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
		txtFedid.setText(initFedid);
		txtFedid.setBounds(113, 93, 212, 27);
		txtFedid.addKeyListener(this);


		txtPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		//txtPassword.setText(initPassword);
		txtPassword.setBounds(113, 133, 212, 27);
		txtPassword.addKeyListener(this);

		dialogChanged();
		setControl(container);
		/*
		 * populate wizard with current ICAT preferences
		 */

		icatIDCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		icatIDCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				logger.debug("selection changed: " + icatIDCombo.getText());

				// change remaining parameters
				int index = icatIDCombo.getSelectionIndex();
				icatSiteNameText.setText(getToken(index, preferenceStore.getString("ICAT_NAME_PREF"), DELIMITER));
				txtSftpServer.setText(getToken(index, preferenceStore.getString("ICAT_SFTPSERVER_PREF"), DELIMITER));
				txtDirectory.setText(getToken(index, preferenceStore.getString("ICAT_DOWNLOADDIR_PREF"), DELIMITER));
				logger.debug("txtDirectory: " + txtDirectory.getText());
			}
		});

		String[] tokens =  preferenceStore.getDefaultString("ICAT_ID_PREF").split(DELIMITER);
		logger.debug("tokens length: " + tokens.length);

		icatIDCombo.removeAll();
		for(int count = 0; count <tokens.length ; count++){
			icatIDCombo.add(tokens[count]);
		}
		icatIDCombo.select(0);

		//icatIDCombo.setEditable(true);
		icatIDCombo.setBounds(113, 13, 212, 27);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(4, 20, 81, 17);
		lblNewLabel.setText("&ICAT site ID");

		icatSiteNameText = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		icatSiteNameText.setEditable(false);

		int index = icatIDCombo.getSelectionIndex();
		icatSiteNameText.setText(getToken(index, preferenceStore.getString("ICAT_NAME_PREF"), DELIMITER));
		icatSiteNameText.setBounds(113, 53, 212, 27);


		Label fedidLbl = new Label(container, SWT.NONE);
		fedidLbl.setText("&FedId:");
		fedidLbl.setBounds(4, 108, 64, 13);

		Group grpAdvanced = new Group(container, SWT.NONE);
		grpAdvanced.setText("Advanced");
		grpAdvanced.setBounds(10, 216, 563, 272);

		Label lbltruststorePassword = new Label(grpAdvanced, SWT.NONE);
		lbltruststorePassword.setBounds(10, 188, 135, 16);
		lbltruststorePassword.setText("&Truststore password:");

		txtTruststorePassword = new Text(grpAdvanced, SWT.BORDER | SWT.PASSWORD);
		txtTruststorePassword.setBounds(154, 177, 212, 27);
		txtTruststorePassword.setText(getToken(index, preferenceStore.getString("ICAT_TRUSTSTORE_PASS_PREF"), DELIMITER));//initTruststorePass);
		txtTruststorePassword.setEnabled(true);

		final Button btnShowPassword = new Button(grpAdvanced, SWT.CHECK);
		btnShowPassword.setBounds(376, 182, 135, 22);
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

		Label lbltruststorePath = new Label(grpAdvanced, SWT.NONE);
		lbltruststorePath.setBounds(10, 131, 103, 19);
		lbltruststorePath.setText("&Truststore path:");

		txtTruststore = new Text(grpAdvanced, SWT.BORDER);
		txtTruststore.setBounds(154, 131, 321, 27);
		txtTruststore.setText(getToken(index, preferenceStore.getString("ICAT_TRUSTSTORE_PATH_PREF"), DELIMITER));//(initTruststore);
		txtTruststore.setEnabled(true);
		txtTruststore.setEditable(true);

		Button BtnBrowseTruststore = new Button(grpAdvanced, SWT.NONE);
		BtnBrowseTruststore.setBounds(481, 131, 71, 27);
		BtnBrowseTruststore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTruststoreBrowse();
			}
		});
		BtnBrowseTruststore.setText("Browse...");
		txtDirectory = new Text(grpAdvanced, SWT.BORDER);
		txtDirectory.setBounds(154, 79, 321, 27);
		txtDirectory.setText(initDirectory);
		txtDirectory.setEditable(true);
		txtDirectory.setEnabled(true);

		txtDirectory.setText(getToken(index, preferenceStore.getString("ICAT_DOWNLOADDIR_PREF"), DELIMITER));

		Button BtnBrowseDirectory = new Button(grpAdvanced, SWT.PUSH);
		BtnBrowseDirectory.setBounds(481, 79, 71, 27);
		BtnBrowseDirectory.setText("Browse...");

		Label lbldownloadDirectory = new Label(grpAdvanced, SWT.NULL);
		lbldownloadDirectory.setBounds(10, 87, 135, 19);
		lbldownloadDirectory.setText("&Download directory:");


		Label sftpServerLbl = new Label(grpAdvanced, SWT.NONE);
		sftpServerLbl.setBounds(10, 44, 79, 13);
		sftpServerLbl.setText("&SFTP server:");

		txtSftpServer = new Text(grpAdvanced, SWT.BORDER | SWT.READ_ONLY);
		txtSftpServer.setBounds(154, 33, 212, 27);
		txtSftpServer.setEditable(true);
		txtSftpServer.setText(getToken(index, preferenceStore.getString("ICAT_SFTPSERVER_PREF"), DELIMITER));

		final Button btnSftpTest = new Button(grpAdvanced, SWT.NONE);
		btnSftpTest.setBounds(391, 33, 84, 29);
		btnSftpTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*
				 * test server using ping
				 */
				 if(NetworkUtils.isReachable(txtSftpServer.getText())){
					 Image okImage = (ResourceManager.getPluginImage(ICAT_PLUGIN_ID, "icons/ok.png"));;
					 btnSftpTest.setImage(okImage);
				 }else{
					 Image noImage = (ResourceManager.getPluginImage(ICAT_PLUGIN_ID, "icons/no.png"));;
					 btnSftpTest.setImage(noImage);
				 }
			}
		});
		btnSftpTest.setText("Test");

		txtSftpServer.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				btnSftpTest.setImage(null);
			}
		});
		BtnBrowseDirectory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDownloadDirBrowse();
			}
		});
		txtTruststorePassword.addKeyListener(this);

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

		if (getSftp().length() == 0) {
			updateStatus("sftp server must be specified.");
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

		String id = icatIDCombo.getText();
		String siteName = icatSiteNameText.getText();
		String sftpServer = txtSftpServer.getText();

		int index = icatIDCombo.getSelectionIndex();
		String wsdl =  getToken(index, preferenceStore.getString("ICAT_WSDL_PREF"), DELIMITER);

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

	private String getSftp() {
		return txtSftpServer.getText();
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

		if (e.getSource().equals(txtSftpServer)) {
			dialogChanged();
		}

		if (e.getSource().equals(txtTruststorePassword)) {
			dialogChanged();
		}
	}


	private String getToken(int index, String text, String delimiter){

		String[] tokens = text.split(delimiter);
		return tokens[index];
	}
}
