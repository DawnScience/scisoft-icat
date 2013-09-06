package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.actions;

import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.wizards.ICATWizard;

public class ICATWizardAction extends Action implements IIntroAction {

	private static final Logger logger = LoggerFactory.getLogger(ICATWizardAction.class);

	/**
	 * Default constructor
	 */
	public ICATWizardAction() {
	}

	/**
	 * Run action. Try to download and install sample feature if not present.
	 */
	@Override
	public void run(IIntroSite site, Properties params) {

		//		sampleId = params.getProperty("id"); //$NON-NLS-1$
		// if (sampleId == null)
		// return;
		//
		Runnable r = new Runnable() {
			@Override
			public void run() {

				// Install sample data project from this plugin

				ICATWizard wizard = new ICATWizard();
				wizard.init(PlatformUI.getWorkbench(), null);

				// Create the wizard dialog
				WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						wizard);

				// Open the wizard dialog
				int ret = dialog.open();
				if (ret == Window.CANCEL) {
					logger.debug("Installation of sampledata canceled.");
				} else {
					logger.debug("Installation of sampledata finished OK.");

					MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"New ICAT Project Wizard", "New ICAT Project was successfully created");
				}

			}
		};

		Shell currentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		currentShell.getDisplay().asyncExec(r);
	}

}
