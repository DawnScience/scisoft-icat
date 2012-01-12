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

package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.ViewPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.analysis.rcp.views.DatasetInspectorView;
import uk.ac.diamond.scisoft.analysis.rcp.views.PlotView;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;

import com.swtdesigner.SWTResourceManager;

public class LoginView extends ViewPart {

	private static Logger logger = LoggerFactory.getLogger(LoginView.class);

	public static final String ID = "uk.ac.diamond.scisoft.icatlogin.rcp.ui.LoginView"; //$NON-NLS-1$

	private Text fedidText;
	private Text passwordText;
	private Label messageLbl;
	private Button loginBtn;

	public LoginView() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// if ENTER key pressed, launch login
				logger.debug("Key pressed: " + e.keyCode);
				if (e.keyCode == 13) { // ENTER key pressed
					logger.debug("ENTER button pressed");
					login();
				}

			}
		});

		container.setBackground(com.swtdesigner.SWTResourceManager
				.getColor(SWT.COLOR_WHITE));

		fedidText = new Text(container, SWT.BORDER);
		fedidText.setBounds(98, 71, 138, 19);

		passwordText = new Text(container, SWT.BORDER);
		passwordText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13 || e.keyCode == 16777296) { // ENTER key
																// pressed
					logger.debug("ENTER button pressed");
					login();
				}
			}
		});
		passwordText.setEchoChar('*');
		passwordText.setBounds(98, 96, 138, 19);

		Label fedidLbl = new Label(container, SWT.NONE);
		fedidLbl.setFont(com.swtdesigner.SWTResourceManager.getFont("Tahoma",
				9, SWT.BOLD));
		fedidLbl.setBackground(com.swtdesigner.SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		fedidLbl.setBounds(27, 71, 49, 13);
		fedidLbl.setText("FedId");

		Label passwordLdl = new Label(container, SWT.NONE);
		passwordLdl.setFont(com.swtdesigner.SWTResourceManager.getFont(
				"Tahoma", 9, SWT.BOLD));
		passwordLdl.setBackground(com.swtdesigner.SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		passwordLdl.setBounds(10, 96, 66, 13);
		passwordLdl.setText("Password");

		loginBtn = new Button(container, SWT.NONE);
		loginBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				login();

			}
		});
		loginBtn.setBounds(170, 134, 66, 29);
		loginBtn.setText("Login");

		Button resetBtn = new Button(container, SWT.NONE);
		resetBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// fedidText.setText("");
				// passwordText.setText("");
				messageLbl.setText("");

				fedidText.setEditable(true);
				fedidText.setForeground(SWTResourceManager
						.getColor(SWT.COLOR_BLACK));
				passwordText.setEditable(true);
				passwordText.setForeground(SWTResourceManager
						.getColor(SWT.COLOR_BLACK));
			}
		});
		resetBtn.setBounds(98, 134, 66, 29);
		resetBtn.setText("Reset");

		messageLbl = new Label(container, SWT.NONE);
		messageLbl.setFont(org.eclipse.wb.swt.SWTResourceManager.getFont(
				"Tahoma", 8, SWT.BOLD));
		messageLbl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		messageLbl.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		messageLbl.setBounds(27, 178, 324, 19);

		Label icatImageLabel = new Label(container, SWT.NONE);
		icatImageLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		icatImageLabel.setImage(org.eclipse.wb.swt.ResourceManager
				.getPluginImage("uk.ac.diamond.scisoft.icatexplorer.rcp",
						"icons/icat_logo.gif"));
		icatImageLabel.setBounds(32, 203, 225, 163);

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	public void login() {

		messageLbl.setForeground(com.swtdesigner.SWTResourceManager
				.getColor(SWT.COLOR_BLACK));
		messageLbl.setText("Authenticating, please wait...");

		// perform icat authentication
		ICATClient icat = new ICATClient();
		ICATSessionDetails.setICAT(icat);

		String fedid = fedidText.getText();
		String password = passwordText.getText();

		if (icat.login(fedid, password) != null) {

			messageLbl.setText("User '" + fedid + "' logged into the ICAT.");// should
																				// take
																				// into
																				// account
																				// session
			logger.info("authentication successful!");

			fedidText.setEditable(false);
			fedidText.setForeground(com.swtdesigner.SWTResourceManager
					.getColor(SWT.COLOR_GRAY));
			passwordText.setEditable(false);
			passwordText.setForeground(com.swtdesigner.SWTResourceManager
					.getColor(SWT.COLOR_GRAY));

			/*
			 * open CNF view
			 */
			IWorkbenchWindow window = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			try {

				/*
				 * check first whether an icat content view is already opened
				 */

				IViewPart[] viewParts = window.getActivePage().getViews();
				String cnfViewId = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
				for (IViewPart view : viewParts) {
					if (view.getSite().getId().equalsIgnoreCase(cnfViewId)) {
						// a previous ICAT content view is opened, close it
						window.getActivePage().hideView(view);
					}
				}

				// open a fresh icat content view
				String cnf = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
				logger.debug("showing view: " + cnf);
				window.getActivePage().showView(cnf);

				// open data plot view
				String plot = PlotView.ID + "DP";
				logger.debug("showing view: " + plot);
				window.getActivePage().showView(plot);

				// open data inspector view
				String inspector = DatasetInspectorView.ID;
				logger.debug("showing view: " + inspector);
				window.getActivePage().showView(inspector);

				// open header table view
				String headerTable = "fable.imageviewer.views.HeaderView";
				logger.debug("showing view: " + headerTable);
				window.getActivePage().showView(headerTable);
				
				// open project explorer view
				String projectExplorer = ProjectExplorer.VIEW_ID;
				logger.debug("showing view: " + projectExplorer);
				window.getActivePage().showView(projectExplorer);

			} catch (PartInitException e1) {
				logger.error("can't open view: ", e1);
			}

		} else {
			String message = "failed to authenticate, please check your fedid and password!";
			messageLbl.setForeground(com.swtdesigner.SWTResourceManager
					.getColor(SWT.COLOR_RED));
			messageLbl.setText(message);
			logger.error(message);
		}
	}
}
