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

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.wb.swt.ResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.preferences.ICATPreferenceInitializer;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils.NetworkUtils;


public class ICATWizardPage extends WizardPage implements KeyListener {

	private Text txtDirectory;
	private Text txtProject;
	private Text txtFedid;
	private Text txtPassword;
	private Text icatSiteNameText;
	private final String initProject;
	private final String initDirectory;
	private final String initFedid;

	private static final String ICAT_PLUGIN_ID = ICATExplorerActivator.PLUGIN_ID;

	private final IPreferenceStore preferenceStore;

	private static final Logger logger = LoggerFactory.getLogger(ICATWizardPage.class);
	private static String DELIMITER = null;

	private Combo icatIDCombo;
	private Text txtSftpServer;
	private Text txtTruststore;
	private Text txtTruststorePassword;
	private ScrolledComposite sc;
	private ExpansionAdapter expansionAdapter;
	private ExpandableComposite advancedOptionsExpander;


	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param prevDirectory
	 * @param prevFolder
	 * @param prevProject
	 */
	public ICATWizardPage(@SuppressWarnings("unused") ISelection selection, String prevProject,
			String prevFolder, String prevDirectory, String prevFedid, String prevPassword, String prevTruststore, String prevTruststorePass) {
		super("V4.2ICATNewWizard");

		this.initProject = "";
		this.initDirectory = prevDirectory != null ? prevDirectory : "";
		this.initFedid = prevFedid != null ? prevFedid : "";

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

		// Set up the composite to hold all the information
		sc = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		sc.setLayout(new FillLayout());

		final Composite composite = new Composite(sc, SWT.NULL);
		composite.setLocation(-708, 1);
		composite.setLayout(new GridLayout(2, false));

		// Specify the expansion Adapter
		expansionAdapter = new ExpansionAdapter() {
			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				composite.layout();
				sc.notifyListeners(SWT.Resize, null);
			}
		};

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("&ICAT site ID");

		icatIDCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_icatIDCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_icatIDCombo.widthHint = 269;
		icatIDCombo.setLayoutData(gd_icatIDCombo);
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
		
		/*
		 * populate wizard with current ICAT preferences
		 */
		icatIDCombo.removeAll();
		
		String[] tokens =  preferenceStore.getDefaultString("ICAT_ID_PREF").split(DELIMITER);
		logger.debug("tokens length: " + tokens.length);
		for(int count = 0; count <tokens.length ; count++){
			icatIDCombo.add(tokens[count]);
		}
		icatIDCombo.select(0);
		
		int index = icatIDCombo.getSelectionIndex();

		Label lblicatDatabase = new Label(composite, SWT.NONE);
		lblicatDatabase.setText("&ICAT site name:");

		icatSiteNameText = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_icatSiteNameText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_icatSiteNameText.widthHint = 260;
		icatSiteNameText.setLayoutData(gd_icatSiteNameText);
		icatSiteNameText.setEditable(false);
		icatSiteNameText.setText(getToken(index, preferenceStore.getString("ICAT_NAME_PREF"), DELIMITER));
		icatSiteNameText.setBounds(113, 53, 212, 27);


		Label fedidLbl = new Label(composite, SWT.NONE);
		fedidLbl.setText("&FedId:");

		txtFedid = new Text(composite, SWT.BORDER);
		GridData gd_txtFedid = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtFedid.widthHint = 260;
		txtFedid.setLayoutData(gd_txtFedid);
		txtFedid.setText(initFedid);
		txtFedid.addKeyListener(this);

		Label passwordLbl = new Label(composite, SWT.NONE);
		passwordLbl.setBounds(4, 139, 64, 13);
		passwordLbl.setText("&Password:");

		txtPassword = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		GridData gd_txtPassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtPassword.widthHint = 260;
		txtPassword.setLayoutData(gd_txtPassword);
		txtPassword.addKeyListener(this);

		/**
		 * set-up the standard GUI elements
		 * */
		Label lblProjectName = new Label(composite, SWT.NULL);
		lblProjectName.setText("&Project name:");
		txtProject = new Text(composite, SWT.BORDER);
		GridData gd_txtProject = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtProject.widthHint = 260;
		txtProject.setLayoutData(gd_txtProject);
		txtProject.setBounds(113, 173, 212, 27);
		txtProject.setText(initProject);
		txtProject.addKeyListener(this);
		sc.setContent(composite);
		sc.setExpandVertical(true);
		sc.setExpandHorizontal(true);

		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		/**
		 * advanced options
		 */
		advancedOptionsExpander = new ExpandableComposite(composite, SWT.NONE);
		GridData gd_advancedOptionsExpander = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_advancedOptionsExpander.widthHint = 242;
		advancedOptionsExpander.setLayoutData(gd_advancedOptionsExpander);
		advancedOptionsExpander.setLayout(new GridLayout(2, false));
		advancedOptionsExpander.setText("Advanced Options");
		advancedOptionsExpander.setExpanded(false);

		Composite optionsComposite = new Composite(advancedOptionsExpander, SWT.NONE);
		optionsComposite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		optionsComposite.setLayout(new GridLayout(3, false));
	
		Label sftpServerLbl = new Label(optionsComposite, SWT.NONE);
		sftpServerLbl.setText("&SFTP server:");

		txtSftpServer = new Text(optionsComposite, SWT.BORDER);
		GridData gd_txtSftpServer = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtSftpServer.widthHint = 193;
		txtSftpServer.setLayoutData(gd_txtSftpServer);
		txtSftpServer.setEditable(true);
		txtSftpServer.setText(getToken(index, preferenceStore.getString("ICAT_SFTPSERVER_PREF"), DELIMITER));

		final Button btnSftpTest = new Button(optionsComposite, SWT.NONE);
		GridData gd_btnSftpTest = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSftpTest.widthHint = 100;
		btnSftpTest.setLayoutData(gd_btnSftpTest);
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
		
		Label lbldownloadDirectory = new Label(optionsComposite, SWT.NULL);
		lbldownloadDirectory.setText("&Download directory:");

		txtDirectory = new Text(optionsComposite, SWT.BORDER);
		GridData gd_txtDirectory = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtDirectory.widthHint = 193;
		txtDirectory.setLayoutData(gd_txtDirectory);
		txtDirectory.setEditable(true);
		txtDirectory.setEnabled(true);

		txtDirectory.setText(getToken(index, preferenceStore.getString("ICAT_DOWNLOADDIR_PREF"), DELIMITER));

		Button BtnBrowseDirectory = new Button(optionsComposite, SWT.PUSH);
		GridData gd_BtnBrowseDirectory = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_BtnBrowseDirectory.widthHint = 100;
		BtnBrowseDirectory.setLayoutData(gd_BtnBrowseDirectory);
		BtnBrowseDirectory.setText("Browse...");
		BtnBrowseDirectory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDownloadDirBrowse();
			}
		});

		Label lbltruststorePath = new Label(optionsComposite, SWT.NONE);
		lbltruststorePath.setBounds(10, 131, 103, 19);
		lbltruststorePath.setText("&Truststore path:");

		txtTruststore = new Text(optionsComposite, SWT.BORDER);
		txtTruststore.setText(getToken(index, preferenceStore.getString("ICAT_TRUSTSTORE_PATH_PREF"), DELIMITER));
		GridData gd_txtTruststore = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtTruststore.widthHint = 193;
		txtTruststore.setLayoutData(gd_txtTruststore);
		txtTruststore.setEnabled(true);
		txtTruststore.setEditable(true);

		Button BtnBrowseTruststore = new Button(optionsComposite, SWT.PUSH);
		GridData gd_BtnBrowseTruststore = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_BtnBrowseTruststore.widthHint = 100;
		BtnBrowseTruststore.setLayoutData(gd_BtnBrowseTruststore);
		BtnBrowseTruststore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTruststoreBrowse();
			}
		});
		BtnBrowseTruststore.setText("Browse...");
		
		Label lbltruststorePassword = new Label(optionsComposite, SWT.NONE);
		lbltruststorePassword.setText("&Truststore password:");

		txtTruststorePassword = new Text(optionsComposite, SWT.BORDER | SWT.PASSWORD);
		txtTruststorePassword.setText(getToken(index, preferenceStore.getString("ICAT_TRUSTSTORE_PASS_PREF"), DELIMITER));
		GridData gd_txtTruststorePassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtTruststorePassword.widthHint = 193;
		txtTruststorePassword.setLayoutData(gd_txtTruststorePassword);
		txtTruststorePassword.setEnabled(true);	
		txtTruststorePassword.addKeyListener(this);

		final Button btnShowPassword = new Button(optionsComposite, SWT.CHECK);
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
	
		advancedOptionsExpander.setClient(optionsComposite);
		advancedOptionsExpander.addExpansionListener(expansionAdapter);
		setControl(composite);

		dialogChanged();
		
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
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
		try{
			return tokens[index];
		}catch(Exception e){
			return "";
		}
	}
}
