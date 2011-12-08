package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

import java.awt.Color;
import java.util.Properties;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
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
import org.eclipse.ui.part.ViewPart;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.PropertiesUtils;


public class LoginView extends ViewPart {
	
	private static Logger logger = LoggerFactory.getLogger(LoginView.class);

	public static final String ID = "uk.ac.diamond.scisoft.icatlogin.rcp.ui.LoginView"; //$NON-NLS-1$
	
	private String fedid = "";
	private String password="";
	private Properties properties;
	
	private Text fedidText;
	private Text passwordText;
	private Label messageLbl;

	public LoginView() {
		
		logger.debug("reading credentials config file if it exists");
		
		try {
			properties = PropertiesUtils.readCredentialsFile();
			fedid = properties.getProperty("fedid");
			password = properties.getProperty("password");
		} catch (Exception e) {
			//e.printStackTrace();
			logger.debug("cannot read credentials.properties file. No effect! Carry on...");
		}
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		fedidText = new Text(container, SWT.BORDER);
		fedidText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				messageLbl.setText("");
			}
		});
		fedidText.setBounds(76, 68, 136, 19);
		
		passwordText = new Text(container, SWT.BORDER);
		passwordText.setEchoChar('*');
		passwordText.setBounds(76, 103, 136, 19);
		
		// for testing only - can be removed in production
		fedidText.setText(fedid);
		passwordText.setText(password);
		//
		
		Label fedidLbl = new Label(container, SWT.NONE);
		fedidLbl.setBounds(27, 71, 49, 13);
		fedidLbl.setText("FedId");
		
		Label passwordLdl = new Label(container, SWT.NONE);
		passwordLdl.setBounds(10, 106, 49, 13);
		passwordLdl.setText("Password");
		
		Button loginBtn = new Button(container, SWT.NONE);
		loginBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// perform icat authentication
				
				ICATClient icat = new ICATClient();
				ICATSessionDetails sessionDetails = new ICATSessionDetails(icat);
			
				
				String fedid    = fedidText.getText();
				String password = passwordText.getText();
		    	
		    	if ( icat.login(fedid, password) != null){
		    		logger.info("authentication successful!");
		    		
		    		/*
		    		 * open CNF view
		    		 * */
		    		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		    		try {
		    		 // store login information
		    		 //icat.setFedId(fedid);
		    		 //icat.setPassword(password);
		    		
		    		//window.getActivePage().closeAllEditors(true);
		    		 window.getActivePage().showView("uk.ac.diamond.scisoft.icatexplorer.rcp.view");
		    		 
		    		 //close login view
		    		 IViewPart[] viewParts = window.getActivePage().getViews();
		    		 for (IViewPart view : viewParts)
		    		 {
		    		 if (view instanceof LoginView)
		    		 {
		    		 window.getActivePage().hideView(view);
		    		 }
		    		 }
    		} catch (PartInitException e1) {
		    		 // TODO Auto-generated catch block
		    		 e1.printStackTrace();
		    		}
		    		
		    		
		    	}else{
		    		String message = "failed to authenticate, please check your fedid and password!";
		    		messageLbl.setText(message);
		    		logger.error(message);
		    	}    
				
			}
		});
		loginBtn.setBounds(146, 134, 66, 23);
		loginBtn.setText("Login");
		
		Button clearBtn = new Button(container, SWT.NONE);
		clearBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fedidText.setText("");
				passwordText.setText("");
				messageLbl.setText("");
			}
		});
		clearBtn.setBounds(76, 134, 66, 23);
		clearBtn.setText("Clear");
		
		messageLbl = new Label(container, SWT.NONE);
		messageLbl.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		messageLbl.setBounds(76, 178, 324, 13);

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
}
