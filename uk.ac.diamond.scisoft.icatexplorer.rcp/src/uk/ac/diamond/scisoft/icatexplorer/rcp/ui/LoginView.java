package uk.ac.diamond.scisoft.icatexplorer.rcp.ui;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swtdesigner.ResourceManager;
import com.swtdesigner.SWTResourceManager;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATClient;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;


public class LoginView extends ViewPart {
	
	private static Logger logger = LoggerFactory.getLogger(LoginView.class);

	public static final String ID = "uk.ac.diamond.scisoft.icatlogin.rcp.ui.LoginView"; //$NON-NLS-1$
	
	private String fedid = "";
	private String password="";
	private Properties properties;
	
	private Text fedidText;
	private Text passwordText;
	private Label messageLbl;
	private Button loginBtn;

	public LoginView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		container.setBackground(com.swtdesigner.SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		fedidText = new Text(container, SWT.BORDER);
		fedidText.setBounds(98, 71, 138, 19);
		
		passwordText = new Text(container, SWT.BORDER);
		passwordText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//logger.debug("key pressed: " + e.keyCode);
				if(e.keyCode == 13){ //ENTER key pressed
					logger.debug("ENTER button pressed");
					login();
				}
			}
		});
		passwordText.setEchoChar('*');
		passwordText.setBounds(98, 96, 138, 19);
		passwordText.setText(password);
		//
		
		Label fedidLbl = new Label(container, SWT.NONE);
		fedidLbl.setFont(com.swtdesigner.SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		fedidLbl.setBackground(com.swtdesigner.SWTResourceManager.getColor(SWT.COLOR_WHITE));
		fedidLbl.setBounds(27, 71, 49, 13);
		fedidLbl.setText("FedId");
		
		Label passwordLdl = new Label(container, SWT.NONE);
		passwordLdl.setFont(com.swtdesigner.SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		passwordLdl.setBackground(com.swtdesigner.SWTResourceManager.getColor(SWT.COLOR_WHITE));
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
				//fedidText.setText("");
				//passwordText.setText("");
				messageLbl.setText("");
				
				fedidText.setEditable(true);
	    		fedidText.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
	    		passwordText.setEditable(true);
	    		passwordText.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		resetBtn.setBounds(98, 134, 66, 29);
		resetBtn.setText("Reset");
		
		messageLbl = new Label(container, SWT.NONE);
		messageLbl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		messageLbl.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		messageLbl.setBounds(76, 178, 324, 19);
		
		Label icatImageLabel = new Label(container, SWT.NONE);
		icatImageLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		icatImageLabel.setImage(org.eclipse.wb.swt.ResourceManager.getPluginImage("uk.ac.diamond.scisoft.icatexplorer.rcp", "icons/icat_logo.gif"));
		icatImageLabel.setBounds(76, 224, 284, 163);

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
	
	public void login(){
		messageLbl.setText("");
		
		// perform icat authentication
		ICATClient icat = new ICATClient();
		ICATSessionDetails sessionDetails = new ICATSessionDetails(icat);
	
		
		String fedid    = fedidText.getText();
		String password = passwordText.getText();
    	
    	if ( icat.login(fedid, password) != null){
    		logger.info("authentication successful!");
    		
    		fedidText.setEditable(false);
    		fedidText.setForeground(com.swtdesigner.SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
    		passwordText.setEditable(false);
    		passwordText.setForeground(com.swtdesigner.SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
    		
    		/*
    		 * open CNF view
    		 * */
    		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    		try {
    		 		    		
    		 /*
    		  * check first whether an icat content view is already opened
    		  */   		

    		 IViewPart[] viewParts = window.getActivePage().getViews();
    		 String cnfViewId = "uk.ac.diamond.scisoft.icatexplorer.rcp.view";
    		 for (IViewPart view : viewParts)
    		 {
    			 if (view.getSite().getId().equalsIgnoreCase(cnfViewId)){
    				 // a previous ICAT content view is opened, close it		    				 
    				 window.getActivePage().hideView(view);
    			 }
    		 }
    		 
    		 // open a fresh icat content view	
    		 String cnf = "uk.ac.diamond.scisoft.icatexplorer.rcp.view"; 
    		 logger.debug("showing view: " + cnf);
    		 window.getActivePage().showView(cnf);
    		
    		 
    		 //close login view
//    		 IViewPart[] viewParts = window.getActivePage().getViews();
//    		 for (IViewPart view : viewParts)
//    		 {
//    		 if (view instanceof LoginView)
//    		 {
//    		 window.getActivePage().hideView(view);
//    		 }
//    		 }
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
}
