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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
	private Text txtSftpServer;
	private Text txtTruststore;
	private Text txtTruststorePassword;
	private ScrolledComposite sc;
	private ExpansionAdapter expansionAdapter;
	private ExpandableComposite advancedOptionsExpander;
	
	
	QualifiedName qNameProjectType;
	QualifiedName qNameFedid;
	QualifiedName qNameSiteName;
	QualifiedName qNameWsdl;
	QualifiedName qNameID;
	QualifiedName qNameDirectory;
	QualifiedName qNameSftpServer;
	QualifiedName qNameTruststorePath;
	QualifiedName qNameTruststorePass;
	QualifiedName qNameFromDate;
	QualifiedName qNameToDate;
	
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
		qNameFromDate        = new QualifiedName("FROM_DATE","String");
		qNameToDate          = new QualifiedName("TO_DATE","String");		
				

		setTitle("ICAT v4 Reconnection Wizard - reconnect based on project parameters");
		setDescription("Wizard to reconnect a closed ICAT v4 connection");

	}

	public void createControl(Composite parent) {
		
		String icatID = icatCon.getId();

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

				// force shell resize
				Point size;
				if (e.getState())
					size = getShell().computeSize( 510, 540 );
				else
					size = getShell().computeSize( 550, 450 );

				getShell().setSize( size );

			}
		};

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("&Site Id");		
		
		icatIDText = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_icatIDText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_icatIDText.widthHint = 269;
		icatIDText.setLayoutData(gd_icatIDText);
		icatIDText.setText(icatID);
		icatIDText.setEditable(false);
		
		Label lblsiteName = new Label(composite, SWT.NONE);
		lblsiteName.setText("&Site Name");		
		
		icatSiteNameText = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_icatSiteNameText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_icatSiteNameText.widthHint = 269;
		icatIDText.setLayoutData(gd_icatSiteNameText);
		String siteName = icatCon.getSiteName();
		icatSiteNameText.setText(siteName);
		icatSiteNameText.setEditable(false);
		
		Label fedidLbl = new Label(composite, SWT.NONE);
		fedidLbl.setText("&FedId:");

		txtFedid = new Text(composite, SWT.BORDER);
		GridData gd_txtFedid = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtFedid.widthHint = 260;
		txtFedid.setLayoutData(gd_txtFedid);
		txtFedid.setEditable(false);
		try {
			txtFedid.setText(iproject.getPersistentProperty(qNameFedid));
		} catch (CoreException e1) {
			logger.error("can't set fedid");
		}
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
		txtProject.setEditable(false);
		txtProject.setText(iproject.getName());
		txtProject.addKeyListener(this);
		
		sc.setContent(composite);
		sc.setExpandVertical(true);
		sc.setExpandHorizontal(true);

		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		/**
		 * set-up advanced options GUI elements
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

		String sftpServer = icatCon.getSftpServer();
		txtSftpServer.setText(sftpServer);
		
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
		try {
			txtDirectory.setText(iproject.getPersistentProperty(qNameDirectory));
		} catch (CoreException e) {
			logger.error("can't set download directory: " + e);
		}
		txtDirectory.setEditable(true);
		txtDirectory.setEnabled(true);

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
		GridData gd_txtTruststore = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtTruststore.widthHint = 193;
		txtTruststore.setLayoutData(gd_txtTruststore);
		txtTruststore.setEnabled(true);
		txtTruststore.setEditable(true);
		try {
			txtTruststore.setText(iproject.getPersistentProperty(qNameTruststorePath));
		} catch (CoreException e) {
			logger.error("can't set truststore: " + e);
		}	

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
		GridData gd_txtTruststorePassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtTruststorePassword.widthHint = 193;
		txtTruststorePassword.setLayoutData(gd_txtTruststorePassword);
		txtTruststorePassword.setEnabled(true);	
		try {
			txtTruststorePassword.setText(iproject.getPersistentProperty(qNameTruststorePass));
		} catch (CoreException e) {
			logger.error("can't set truststore password: " + e);
		}
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
		String sftpServer = txtSftpServer.getText();

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

	public Calendar getFromDate() {
		String  startDate = "";
		Calendar cal = Calendar.getInstance();
		try {
			startDate =  iproject.getPersistentProperty(qNameFromDate);
			
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		    cal.setTime(sdf.parse(startDate));
		    
		} catch (CoreException e) {
			logger.error("Error extracting project start date bound");
		} catch (ParseException e) {
			logger.debug("Can't parse date: " + startDate);
		}
		return cal;
	}

	public Calendar getToDate() {
		
		String  endDate = "";
		Calendar cal = Calendar.getInstance();
		try {
			endDate = iproject.getPersistentProperty(qNameToDate);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			cal.setTime(sdf.parse(endDate));
			
		} catch (CoreException e) {
			logger.error("Error extracting project end date bound");
		} catch (ParseException e) {
			logger.debug("Can't parse date: " + endDate);
		}
		
		return cal;
	}
}
