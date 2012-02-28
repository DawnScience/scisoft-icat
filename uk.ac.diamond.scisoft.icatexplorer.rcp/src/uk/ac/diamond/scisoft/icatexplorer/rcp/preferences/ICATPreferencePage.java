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

package uk.ac.diamond.scisoft.icatexplorer.rcp.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATConnection;
import uk.ac.diamond.scisoft.icatexplorer.rcp.internal.ICATExplorerActivator;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.NetworkUtils;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class ICATPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text textCATId;
	private Text textICATName;
	private Text textICATwsdl;
	private Text textICATsftpServer;
	private Text textiCATDownloaddir;
	private Text txtTestoutput;
	private Button btnSftpTest;
	private IPreferenceStore preferenceStore;

	private static Logger logger = LoggerFactory.getLogger(ICATPreferencePage.class);

	
	/**
	 * @wbp.parser.constructor
	 */
	public ICATPreferencePage() {
		preferenceStore = ICATExplorerActivator.getDefault().getPreferenceStore();
	}

	public ICATPreferencePage(String title) {
		super(title);
	}

	public ICATPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {

		logger.debug("init ICAT preferences");
		setPreferenceStore(ICATExplorerActivator.getDefault().getPreferenceStore());
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(7, false));
		new Label(composite, SWT.NONE);
		
		Label lblICATId = formToolkit.createLabel(composite, "ICAT SITE ID:", SWT.NONE);
		lblICATId.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		textCATId = formToolkit.createText(composite, "New Text", SWT.NONE);
		textCATId.setText(preferenceStore.getString("ICAT_ID_PREF"));
		textCATId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblICATName = formToolkit.createLabel(composite, "ICAT SITE NAME:", SWT.NONE);
		lblICATName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		textICATName = formToolkit.createText(composite, "New Text", SWT.NONE);
		textICATName.setText(preferenceStore.getString("ICAT_NAME_PREF"));
		textICATName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblICATwsdl = formToolkit.createLabel(composite, "WSDL URL:", SWT.NONE);
		lblICATwsdl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		textICATwsdl = formToolkit.createText(composite, "New Text", SWT.NONE);
		textICATwsdl.setText(preferenceStore.getString("ICAT_WSDL_PREF"));
		textICATwsdl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblICATsftpServer = formToolkit.createLabel(composite, "SFTP Server:", SWT.NONE);
		lblICATsftpServer.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		textICATsftpServer = formToolkit.createText(composite, "New Text", SWT.NONE);
		textICATsftpServer.setText(preferenceStore.getString("ICAT_SFTPSERVER_PREF"));
		textICATsftpServer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnSftpTest = new Button(composite, SWT.NONE);
		btnSftpTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*
				 * test server using ping
				 */
				if(NetworkUtils.isReachable(textICATsftpServer.getText())){
					Image okImage = (ResourceManager.getPluginImage("uk.ac.diamond.scisoft.icatexplorer.rcp", "icons/ok.png"));;
					btnSftpTest.setImage(okImage);
				}else{
					Image noImage = (ResourceManager.getPluginImage("uk.ac.diamond.scisoft.icatexplorer.rcp", "icons/no.png"));;
					btnSftpTest.setImage(noImage);
				}
			}
		});
		btnSftpTest.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(btnSftpTest, true, true);
		btnSftpTest.setText("Test");
		
		
		textICATsftpServer.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// server name changing so reset Test button
				btnSftpTest.setImage(null);
			}
		});
		
		new Label(composite, SWT.NONE);
		
		Label lblICATDownloaddir = formToolkit.createLabel(composite, "Download Directory:", SWT.NONE);
		lblICATDownloaddir.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		textiCATDownloaddir = formToolkit.createText(composite, "New Text", SWT.NONE);
		textiCATDownloaddir.setText(preferenceStore.getString("ICAT_DOWNLOADDIR_PREF"));
		textiCATDownloaddir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		
		Button btnBrowse = formToolkit.createButton(composite, "Browse...", SWT.NONE);
		btnBrowse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Button btnTestWS = formToolkit.createButton(composite, "Test ICAT webservice", SWT.NONE);
		btnTestWS.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTestWebservice();
			}

			private void handleTestWebservice() {
				
				Display.getDefault().syncExec( new Runnable() {  
					
					public void run() {
					final String wsdl = textICATwsdl.getText();
					String icatVersion = null;
					
					ICATClient icatClient = new ICATClient(new ICATConnection(wsdl), "", "");
					icatVersion = icatClient.getICATVersion();
						
					if (icatVersion.length() > 0) {
						txtTestoutput.setText("ICAT ONLINE running version: " + icatVersion);
						logger.debug("ICAT ONLINE running version: " + icatVersion);
					}else{
						txtTestoutput.setText("ICAT OFFLINE or connection details not correct.");
						logger.debug("problem connecting ICAT");
					}	
										
				} });
				
			}
		});
		btnTestWS.setImage(ResourceManager.getPluginImage("uk.ac.diamond.scisoft.icatexplorer.rcp", "icons/database.png"));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		txtTestoutput = formToolkit.createText(composite, "", SWT.NONE);
		txtTestoutput.setEditable(false);
		txtTestoutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		textICATwsdl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// wsdl url being modified so clear output message field
				txtTestoutput.setText("");
			}
		});
		
        return composite;
	}
	
	private void handleBrowse() {
		DirectoryDialog dirDialog = new DirectoryDialog(getShell(), SWT.OPEN);
		dirDialog.setFilterPath(getDirectory());
		final String filepath = dirDialog.open();
		if (filepath != null) {
			textiCATDownloaddir.setText(filepath);
		}
	}
	public String getDirectory() {
		return textiCATDownloaddir.getText();
	}
	
	@Override
	protected void performDefaults() {
		
		loadICATDefaultPreferences();
	}

	@Override
	public boolean performOk() {
		storeICATPreferences();
		txtTestoutput.setText("");
		btnSftpTest.setImage(null);
		
		return true;
	}
	

		public void loadICATDefaultPreferences() {
			logger.debug("loadDefaultPreferences ...");
			textCATId.setText(preferenceStore.getDefaultString("ICAT_ID_PREF"));
			textICATName.setText(preferenceStore.getDefaultString("ICAT_NAME_PREF"));
			textICATwsdl.setText(preferenceStore.getDefaultString("ICAT_WSDL_PREF"));
			textICATsftpServer.setText(preferenceStore.getDefaultString("ICAT_SFTPSERVER_PREF"));
			textiCATDownloaddir.setText(preferenceStore.getDefaultString("ICAT_DOWNLOADDIR_PREF"));	
		}
		
		public void storeICATPreferences() {
			logger.debug("storePreferences ...");
			preferenceStore.setValue("ICAT_ID_PREF", textCATId.getText());
			preferenceStore.setValue("ICAT_NAME_PREF", textICATName.getText());
			preferenceStore.setValue("ICAT_WSDL_PREF", textICATwsdl.getText());
			preferenceStore.setValue("ICAT_SFTPSERVER_PREF", textICATsftpServer.getText());
			preferenceStore.setValue("ICAT_DOWNLOADDIR_PREF", textiCATDownloaddir.getText());	

		}
		
}
