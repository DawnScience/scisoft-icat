package uk.ac.diamond.scisoft.icatexplorer.rcp.editors;

import java.text.SimpleDateFormat;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;
import uk.icat3.client.Datafile;

public class DatafileEditor extends EditorPart {
	public DatafileEditor() {
	}

	public static final String ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.editors.DatafileEditor"; //$NON-NLS-1$

	private Datafile datafile;
	private DatafileEditorInput input;
	//private final static Logger logger = Logger.getLogger(DatafileEditor.class);


	// Will be called before createPartControl
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (!(input instanceof DatafileEditorInput)) {
			throw new RuntimeException("Wrong input");
		}

		//DatafileEditorInput new_name = (DatafileEditorInput) input;
		this.input = (DatafileEditorInput) input;
		setSite(site);
		setInput(input);
		// CHANGE HERE
		datafile = this.input.getDatafile();
		setPartName("Datafile ID: " + datafile.getId());
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		Table table;
		int itemCount = 15;
		Shell shell = new Shell();
		shell.setLayout(new GridLayout(1, false));
		shell.setSize(450, 300);
		shell.setText("ICAT DB Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.VIRTUAL);
		table.setHeaderVisible(true);

		// table.setItemCount(100);
		table.setItemCount(itemCount);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 429, 306);
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
			items[0].setText(new String[] { "ID", ((uk.icat3.client.Datafile)datafile).getId().toString()});
		}catch(Exception e){
			//logger.debug("\nnull value fetched from database...");
			items[0].setText(new String[] { "ID",
			"null"});
		}
		
		try {
			items[1].setText(new String[] { "DATASET_ID",
					((uk.icat3.client.Datafile)datafile).getDatasetId().toString()});
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[1].setText(new String[] { "DATASET_ID",
			"null"});
		}
		
		try {
			items[2].setText(new String[] { "NAME",
					datafile.getName() });
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[2].setText(new String[] { "NAME",
			"null"});
		}

		try {
			items[3].setText(new String[] { "DESCRIPTION",
					((uk.icat3.client.Datafile) datafile).getDescription()});
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[3].setText(new String[] { "DESCRIPTION",
					"null"});
		}
			
		//items[1].setText(new String[] { "SAMPLE_ID", ((uk.icat3.client.Dataset)datafile).getSampleId().toString()});
		try{
			items[4].setText(new String[] { "DATAFILE_VERSION", ((uk.icat3.client.Datafile)datafile).getDatafileVersion()});
		}catch(Exception e){
			//logger.debug("\nnull value fetched from database...");
			items[4].setText(new String[] { "DATAFILE_VERSION",
			"null"});
		}
		
		try{
			items[5].setText(new String[] { "DATAFILE_VERIOSN_COMMENT", ((uk.icat3.client.Datafile)datafile).getDatafileVersionComment()});
			}catch(Exception e){
				//logger.debug("\nnull value fetched from database...");
				items[5].setText(new String[] { "DATAFILE_VERIOSN_COMMENT",
				"null"});
			}
		
		try{
			items[6].setText(new String[] { "LOCATION", ((uk.icat3.client.Datafile)datafile).getLocation()});
			}catch(Exception e){
				//logger.debug("\nnull value fetched from database...");
				items[6].setText(new String[] { "LOCATION",
				"null"});
			}
		try{
			items[7].setText(new String[] { "DATAFILE_FORMAT", ((uk.icat3.client.Datafile)datafile).getDatafileFormat().getFormatType()});
			}catch(Exception e){
				items[7].setText(new String[] { "DATAFILE_FORMAT",
				"null"});
			}
		try{
			items[8].setText(new String[] { "DATAFILE_FORMAT_VERSION", ((uk.icat3.client.Datafile)datafile).getDatafileVersion()});
			}catch(Exception e){
				items[8].setText(new String[] { "DATAFILE_FORMAT_VERISON",
				"null"});
			}
		try{
			items[9].setText(new String[] { "DATAFILE_CREATE_TIME", UnitsConverter.gregorianToString(((uk.icat3.client.Datafile)datafile).getDatafileCreateTime())});
			}catch(Exception e){
				items[9].setText(new String[] { "DATAFILE_CREATE_TIME",
				"null"});
			}
		try{
			items[10].setText(new String[] { "DATAFILE_MODIFY_TIME", UnitsConverter.gregorianToString(((uk.icat3.client.Datafile)datafile).getDatafileModifyTime())});
			}catch(Exception e){
				items[10].setText(new String[] { "DATAFILE_MODIFY_TIME",
				"null"});
			}
		try{
			items[11].setText(new String[] { "FILE_SIZE", Integer.toString(((uk.icat3.client.Datafile)datafile).getFileSize())});
			}catch(Exception e){
				items[11].setText(new String[] { "FILE_SIZE",
				"null"});
			}
		try{
			items[12].setText(new String[] { "COMMAND", ((uk.icat3.client.Datafile)datafile).getCommand() });
			}catch(Exception e){
				items[12].setText(new String[] { "COMMAND",
				"null"});
			}
		try{
			items[13].setText(new String[] { "CHECKSUM", ((uk.icat3.client.Datafile)datafile).getCommand() });
			}catch(Exception e){
				items[13].setText(new String[] { "CHECKSUM",
				"null"});
			}
		try{
			items[14].setText(new String[] { "SIGNATURE", ((uk.icat3.client.Datafile)datafile).getSignature()});
			}catch(Exception e){
				items[14].setText(new String[] { "SIGNATURE",
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
//		text.setText(datafile.getName());
//		text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
//		new Label(parent, SWT.NONE).setText("Id: ");
//		Text lastName = new Text(parent, SWT.BORDER);
//		lastName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
//				false));
//		lastName.setText(datafile.getId().toString());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// datafile.getAddress().setCountry(text2.getText());
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
	
}
