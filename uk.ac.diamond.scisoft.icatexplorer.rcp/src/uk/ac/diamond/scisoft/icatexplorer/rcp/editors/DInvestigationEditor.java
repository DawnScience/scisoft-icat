package uk.ac.diamond.scisoft.icatexplorer.rcp.editors;


import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DInvestigation;
import uk.ac.diamond.scisoft.icatexplorer.rcp.provider.CNFContentProvider;




public class DInvestigationEditor extends EditorPart {
	
	public static final String ID = "uk.ac.diamond.scisoft.icatexplorer.rcp.editors.investigationeditor";
	private DInvestigation dinvestigation;
	private DInvestigationEditorInput input;
	//private final static Logger logger = Logger.getLogger(DInvestigationEditor.class);


	// Will be called before createPartControl
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (!(input instanceof DInvestigationEditorInput)) {
			throw new RuntimeException("Wrong input");
		}

		//dinvestigationEditorInput new_name = (dinvestigationEditorInput) input;
		this.input = (DInvestigationEditorInput) input;
		setSite(site);
		setInput(input);
		// CHANGE HERE
		dinvestigation = this.input.getDInvestigation();
		setPartName("Investigation ID: " + dinvestigation.getId());
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		Table table;
		int itemCount = 11;
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
			items[0].setText(new String[] { "ID", dinvestigation.getId().toString()});
			//logger.debug("\n====== dinvestigation.getId().toString() "+dinvestigation.getId().toString());
		}catch(Exception e){
			//logger.debug("\nnull value fetched from database...");
			items[0].setText(new String[] { "ID",
			"null"});
		}
		
		try {
			items[1].setText(new String[] { "TITLE", dinvestigation.getTitle() });
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[1].setText(new String[] { "TITLE",
			"null"});
		}
		
		try {
			items[2].setText(new String[] { "NB_DATASETS", Integer.toString(dinvestigation.getNbdatasets())});
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[2].setText(new String[] { "NB_DATASETS",
			"null"});
		}

		try {
			items[3].setText(new String[] { "VISIT_ID", dinvestigation.getVisitId()});
		} catch (Exception e) {
			//logger.debug("\nnull value fetched from database...");
			items[3].setText(new String[] { "VISIT_ID",
					"null"});
		}
			
		//items[1].setText(new String[] { "SAMPLE_ID", ((uk.icat3.client.Investigation)dinvestigation).getSampleId().toString()});
		try{
			items[4].setText(new String[] { "VISIT_ID", dinvestigation.getVisitId().toString()});
		}catch(Exception e){
			//logger.debug("\nnull value fetched from database...");
			items[4].setText(new String[] { "INVESTIGATION_ID",
			"null"});
		}
		
		try{
			items[5].setText(new String[] { "INSTRUMENT", (dinvestigation).getInstrument()});
			}catch(Exception e){
				//logger.debug("\nnull value fetched from database...");
				items[5].setText(new String[] { "INSTRUMENT",
				"null"});
			}
		
		try{
			items[6].setText(new String[] { "INV_NUMBER", dinvestigation.getInv_number()});
			}catch(Exception e){
				//logger.debug("\nnull value fetched from database...");
				items[6].setText(new String[] { "INV_NUMBER",
				"null"});
			}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// dinvestigation.getAddress().setCountry(text2.getText());
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
