package Galeno.Forms;

import java.util.ArrayList;
import Galenos.classes.Logic;
import java.util.List;
import org.eclipse.swt.widgets.Dialog;
import Galenos.classes.AddNewItem;
import Galenos.classes.AddNewSign;
import Galenos.classes.AddNewSignCode;
import Galenos.classes.AddNewTest;
import Galenos.classes.AddNewTestCode;
import Galenos.classes.ShowMessage;
import Galenos.classes.SnomedConcepts;
import Galenos.classes.ClinicalElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CreateFindingUsingSnomed extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table table;
	private Button btnAddSelected;
	SnomedConcepts sc = new SnomedConcepts();
	List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
	List<String> codes = new ArrayList<String>();
	ClinicalElement myelement;
	ClinicalElement ce;
	String code="";
	String name = "";
	Logic lg = new Logic();
	private int type;
	private int style;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CreateFindingUsingSnomed(Shell parent, int style, List<ClinicalElement> elements, String concept, Logic lg, int type) {
	   
		super(parent, style);
		setText("SWT Dialog");
		this.elements = elements;
		this.name = concept;
		this.lg = lg;
		this.type = type;
		this.style = style;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		
		createContents();
		shell.layout();
		if(elements.size()>0){
			System.out.println("elements tiene "+elements.size()+" items");
		llenartabla();
		shell.open();
		}
		else
		{
			ShowMessage.showMessage("Research Results", "There are no results for the concept, please try to be more specific", style, shell);
			btnAddSelected.setEnabled(false);
		}
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		return result;
	}

private void llenartabla(){
	try{
		
	for(int i=0; i<elements.size(); i++){
		ce = new ClinicalElement();
		ce = elements.get(i);
		TableItem snomedsigns = new TableItem(table, SWT.NONE);
        snomedsigns.setText (0, ce.getId().toString());
        snomedsigns.setText (1, ce.getNombre());	
	}
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
public void setSnomedIden(TableItem[] ids){
	try{
		
		code = ids[0].getText(0);
		name = ids[0].getText(1);
		System.out.println("Se ha seleccionado "+code+"-"+name);	
		
		}
		catch(Exception e){
			e.printStackTrace();
		} 
	
}	
public ClinicalElement getSnomedIden(){
	ClinicalElement element = new ClinicalElement();
	element.setId(code);
	element.setNombre(name);
	return element;
}
/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 309);
		shell.setText("  ");
		shell.setLayout(null);
		
		Group grpFinding = new Group(shell, SWT.NONE);
		if(type==1)
		grpFinding.setText("Sign/Disorder");
		if(type==2)
		grpFinding.setText("Diagnostic Test");
		grpFinding.setBounds(10, 0, 424, 228);
		
		table = new Table(grpFinding, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				btnAddSelected.setEnabled(true);
				
			}
		});
		table.setBounds(10, 22, 404, 167);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnSnomedId = new TableColumn(table, SWT.NONE);
		tblclmnSnomedId.setWidth(100);
		tblclmnSnomedId.setText("Snomed ID");
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(299);
		tblclmnName.setText("Name");
		
		btnAddSelected = new Button(grpFinding, SWT.NONE);
		btnAddSelected.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				TableItem selectedItems[] = table.getSelection();
				if(type==1){
				code = selectedItems[0].getText(0);
				name = selectedItems[0].getText(1);
				AddNewSign ANS = new AddNewSign();
				try {
					ANS.AddTheNewSign(code, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ANS.agregacode_enfichero(code, name);
				setSnomedIden(selectedItems);
				   lg.vacialistsigns();
				   lg.llenarlistsigns();
				}
				if(type==2){
							
							code = selectedItems[0].getText(0);
							name = selectedItems[0].getText(1);
							AddNewTest ANT = new AddNewTest();
							try {
								ANT.AddTheNewTest(code, name);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							ANT.agregacode_enfichero(code, name);
							setSnomedIden(selectedItems);
							lg.vaciarlisttests();
							lg.llenarlisttests();
						}
			    shell.close();
			}
		});
		btnAddSelected.setEnabled(false);
		btnAddSelected.setBounds(333, 195, 81, 25);
		btnAddSelected.setText("Add Selected");
		
		Button btnNoThanksAdd = new Button(grpFinding, SWT.NONE);
		btnNoThanksAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddNewItem ANI = new AddNewItem();
				boolean resp=true;
				if(type==1){
				AddNewSignCode ANSC = new AddNewSignCode();
				
				try{
					name = name.substring(0,1).toUpperCase()+(name.substring(1,name.length())).trim();
					resp = ANI.searchfinding(code, name);
					if(resp==false){
					code = String.valueOf(ANSC.AddNewCode(name));
					System.out.println("El codigo de vuelta es "+code);
					if(!code.equalsIgnoreCase("0")){
					ANI.newglobalsign(code, name);
					ANI.agregarsignenfichero(code, name);
					ANSC.actualizarficheronuevoscodigos(Integer.parseInt(code));
					}
					else{
						System.out.println("no se agregará ningún item nuevo");
					}
					}
					else{
						ShowMessage.showMessage("Error", "The concept al ready exists in the knowledge base", 1, shell);
						
					}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   lg.vacialistsigns();
				   lg.llenarlistsigns();
				}
		   if(type==2){
			   AddNewTestCode ANTC = new AddNewTestCode();
			    try{
					name = name.substring(0,1).toUpperCase()+(name.substring(1,name.length())).trim();	
					resp = ANI.searchfinding(code, name);
					if(resp==false){
					code = String.valueOf(ANTC.AddNewCode(name));
					System.out.println("El codigo de vuelta es "+code);
					if(!code.equalsIgnoreCase("0")){
					ANI.newglobaltest(code, name);
					ANI.agregarsignenfichero(code, name);
					ANTC.actualizarficheronuevoscodigos(Integer.parseInt(code));
					}
					else{
						System.out.println("no se agregará ningún item nuevo");
						}
					}
					else{
						ShowMessage.showMessage("Error", "The concept al ready exists in the knowledge base", 1, shell);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					lg.vaciarlisttests();
					lg.llenarlisttests();
				}

				shell.close();
			}
		});
		btnNoThanksAdd.setText("No, thanks. Add the one that I've introduced");
		btnNoThanksAdd.setBounds(71, 195, 256, 25);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
		});
		btnCancel.setBounds(346, 234, 75, 25);
		btnCancel.setText("Close");

	}
}
