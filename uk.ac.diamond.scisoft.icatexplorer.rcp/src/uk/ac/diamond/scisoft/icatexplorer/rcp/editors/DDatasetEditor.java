package uk.ac.diamond.scisoft.icatexplorer.rcp.editors;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDataset;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFContentProvider;
import uk.icat3.client.DatasetInclude;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.NoSuchObjectFoundException_Exception;
import uk.icat3.client.SessionException_Exception;



public class DDatasetEditor extends EditorPart implements ISelectionListener{
	public DDatasetEditor() {
	}
	
	public static final String ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.editors.dataseteditor";
	private uk.icat3.client.Dataset dataset;
	private DDatasetEditorInput input;
	private final static Logger logger = LoggerFactory.getLogger(DDatasetEditor.class);


	// Will be called before createPartControl
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (!(input instanceof DDatasetEditorInput)) {
			throw new RuntimeException("Wrong input");
		}

		//DDatasetEditorInput new_name = (DDatasetEditorInput) input;
		this.input = (DDatasetEditorInput) input;
		setSite(site);
		setInput(input);

		DDataset ddataset = this.input.getDDataset();

		// get the fully populated dataset from the icat DB		  
		try {
			dataset = ICATSessionDetails.icatClient.getIcat().getDatasetIncludes(ICATSessionDetails.icatClient.getSessionId(), ddataset.getId(), DatasetInclude.DATASET_PARAMETERS_ONLY);
//			System.out.println("\n----- invid: " + dataset.getInvestigationId());
//			System.out.println("\n----- sampleId: " + dataset.getSampleId());
//			System.out.println("\n----- datasetType: " + dataset.getDatasetType());
//
//			System.out.println("\n----- datasetStatus: " + dataset.getDatasetStatus());
//
//			System.out.println("\n----- location: " + dataset.getLocation());
//			System.out.println("\n----- description: " + dataset.getDescription());

		} catch (InsufficientPrivilegesException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchObjectFoundException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SessionException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setPartName("Dataset ID: " + ddataset.getId());
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		Table table;
		int itemCount = 8;
		Shell shell = new Shell();
		shell.setLayout(new GridLayout(1, false));
		shell.setSize(429, 306);
		shell.setText("ICAT DB Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.VIRTUAL);
		table.setHeaderVisible(true);

		// table.setItemCount(100);
		table.setItemCount(itemCount);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 350, 250);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn fieldColumn = new TableColumn(table, SWT.NONE);
		fieldColumn.setWidth(131);
		fieldColumn.setText("Field");
		
		TableColumn valueColumn = new TableColumn(table, SWT.NONE);
		valueColumn.setWidth(302);
		valueColumn.setText("Value");
		
		TableItem[] items = new TableItem[itemCount];
		for (int i =0 ; i<items.length; i++){
			items[i] = new TableItem(table, SWT.NONE);
		}
		
		try{
			items[0].setText(new String[] { "ID", ((uk.icat3.client.Dataset)dataset).getId().toString()});
		}catch(Exception e){
			//logger.debug("\nnull value fetched from database...");
			items[0].setText(new String[] { "ID",
			"null"});
		}
		
		try {
			items[1].setText(new String[] { "SAMPLE_ID",
					Long.toString(((uk.icat3.client.Dataset) dataset).getSampleId())});
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[1].setText(new String[] { "SAMPLE_ID",
			"null"});
		}
		
		try {
			items[2].setText(new String[] { "INVESTIGATION_ID",
					Long.toString(dataset.getInvestigationId()) });
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[2].setText(new String[] { "INVESTIGATION_ID",
			"null"});
		}

		try {
			items[3].setText(new String[] { "NAME",
					((uk.icat3.client.Dataset) dataset).getName() });
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[3].setText(new String[] { "NAME",
					"null"});
		}
			
		//items[1].setText(new String[] { "SAMPLE_ID", ((uk.icat3.client.Dataset)ddataset).getSampleId().toString()});
		try{
			items[4].setText(new String[] { "DATASET_TYPE", ((uk.icat3.client.Dataset)dataset).getDatasetType()});
		}catch(Exception e){
			//logger.debug("\nnull value fetched from database...");
			items[4].setText(new String[] { "DATASET_TYPE",
			"null"});
		}
		
		try{
			items[5].setText(new String[] { "DATASET_STATUS", ((uk.icat3.client.Dataset)dataset).getDatasetStatus()});
			}catch(Exception e){
			  //logger.debug("\nnull value fetched from database...");
			  items[5].setText(new String[] { "DATASET_STATUS",
			  "null"});
			}
		
		try{
			items[6].setText(new String[] { "LOCATION", ((uk.icat3.client.Dataset)dataset).getLocation()});
			}catch(Exception e){
				//logger.debug("\nnull value fetched from database...");
				items[6].setText(new String[] { "LOCATION",
				"null"});
			}
		
		try{
			items[7].setText(new String[] { "DESCRIPTION", ((uk.icat3.client.Dataset)dataset).getDescription()});
			}catch(Exception e){
				//logger.debug("\nnull value fetched from database...");
				items[7].setText(new String[] { "DESCRIPTION",
				"null"});
			}
		
		/*
		 * the following fields exist in the database but no method is provided by the icat 
		 * to retrieve them.
		 * MOD_TIME, MOD_ID, CREATE_TIME, CREATE_ID, FACILITY_ACQUIRED, DELETED
		 * */
		
//		GridLayout layout = new GridLayout();
//		layout.numColumns = 2;
//		parent.setLayout(layout);
//		Label label1 = new Label(parent, SWT.NONE);
//		label1.setText("Name: ");
//		Text text = new Text(parent, SWT.BORDER);
//		text.setText(ddataset.getName());
//		text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
//		new Label(parent, SWT.NONE).setText("Id: ");
//		Text lastName = new Text(parent, SWT.BORDER);
//		lastName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
//				false));
//		lastName.setText(ddataset.getId().toString());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// ddataset.getAddress().setCountry(text2.getText());
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isDirty() {

		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
		logger.debug("selection changed yyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		
	}

}
