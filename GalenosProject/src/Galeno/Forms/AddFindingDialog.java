package Galeno.Forms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Dialog;

import Galenos.classes.AddNewItem;
import Galenos.classes.AddNewSignCode;
import Galenos.classes.AddNewTestCode;
import Galenos.classes.AllSigns;
import Galenos.classes.AllTests;
import Galenos.classes.Logic;
import Galenos.classes.ClinicalElement;
import Galenos.classes.ShowMessage;
import Galenos.classes.SnomedConcepts;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class AddFindingDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table TBFindings;
	private Button btnAddSelected;
	private Text text;
	private int type;
	private TableItem itemselected; 
	private TableColumn tblclmnSnomedId;
	private TableColumn tblclmnName;
	private Group grpCreateNewFinding;
	private Label lblFindingName;
	private Button btnCreate;
	private String[] ceId ; 
	private int origen;
	List<ClinicalElement> findings = new ArrayList<ClinicalElement>();
	List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
	List<ClinicalElement> findingselements = new ArrayList<ClinicalElement>();
	
	ClinicalElement ce ;
	SnomedConcepts sc = new SnomedConcepts();
	List<String> codes = new ArrayList<String>();
	Logic lg = new Logic();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public AddFindingDialog(Shell parent, int style, int type, Logic lg, int origen) {
		super(parent, style);
		setText("SWT Dialog");
		this.type = type;
		this.lg = lg;
		this.origen = origen;
}

	public void llenarlistafindings(int type)
	{
		findings.clear();
		
		if(type == 1){  //Llenar tabla con signs
			System.out.println("recibo tipo "+type);
		
			AllSigns as = new AllSigns(); //Se crea un objeto de tipo AllSigns
			System.out.println("objeto as creado");
			try {
				
      	findings = as.GetAllSigns(lg); //trae todos los signos definidos en las ontologías
		System.out.println("se encontraron "+findings.size()+ " findings ");	   	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error tras llamar al método GetAllSigns "+e.getMessage());
			}
			//findings = obj.ordenalista(findings, "Signs List");
			findings = new Logic().ordenalista(findings, "Signs List"); //se ordena la lista
		    for (int i = 0 ; i< findings.size() ; i++){
		        TableItem item = new TableItem(TBFindings, SWT.NONE);
		        item.setText (0, findings.get(i).getId().toString());
		        item.setText (1, findings.get(i).getNombre().toString());
		     }
			
		}
		if(type == 2){
			AllTests at = new AllTests(); //se crea un objeto de tipo AllTests
			try {
				findings = at.GetAllTest(lg); //trae todos los test definidos en las ontologías
			   	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//findings = obj.ordenalista(findings, "Signs List");
			findings = lg.ordenalista(findings, "Tests List");  //Se ordena la lista de test
		    for (int i = 0 ; i< findings.size() ; i++){
		        TableItem item = new TableItem(TBFindings, SWT.NONE);
		        item.setText (0, findings.get(i).getId().toString());
		        item.setText (1, findings.get(i).getNombre().toString());
		     }
		}
	}
	public void setIden(List<ClinicalElement> findingelements){
		 this.findingselements = findingelements;
		
	}
	public List<ClinicalElement> getIden(){
		return findingselements;
	}
	private boolean buscarconceptosnomed(String concept){
		boolean resp=false;
		try {
			elements.clear();
			elements = sc.Concepts(concept);
		   System.out.println("La tabla tendrá "+elements.size()+" nuevos elementos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(elements.size()>0)
		{
			resp = true; //se encontraron elementos tras la búsqueda
		}
		else
		{
			resp = false; //no se encontraron elementos tras la búsqueda
		}
		return resp;
	}
	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		if(origen==2){
			grpCreateNewFinding.setVisible(false);
		}
		llenarlistafindings(type);
		
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 419);
		shell.setText("  ");
		shell.setLayout(null);
		
		Group grpFinding = new Group(shell, SWT.NONE);
		if(type==1)
		grpFinding.setText("Signs/Disorders");
		if(type==2)
			grpFinding.setText("Diagnostic Tests");
		grpFinding.setBounds(10, 0, 424, 228);
		
		btnAddSelected = new Button(grpFinding, SWT.NONE);
		btnAddSelected.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				List<ClinicalElement> findingelements = new ArrayList<ClinicalElement>();
				TableItem selectedItems[] = TBFindings.getSelection();
				for(int i =0; i<selectedItems.length; i++){
					ce = new ClinicalElement();
					ce.setId(selectedItems[i].getText(0));
					ce.setNombre(selectedItems[i].getText(1));
					findingelements.add(ce);
				}
				setIden(findingelements);
			    shell.close();
			}
		});
		
		btnAddSelected.setEnabled(false);
		btnAddSelected.setBounds(333, 195, 81, 25);
		btnAddSelected.setText("Add Selected");
		
		TBFindings = new Table(grpFinding, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		TBFindings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
		      btnAddSelected.setEnabled(true);
			}
		});
		TBFindings.setBounds(10, 22, 404, 167);
		TBFindings.setHeaderVisible(true);
		TBFindings.setLinesVisible(true);
		
		tblclmnSnomedId = new TableColumn(TBFindings, SWT.NONE);
		tblclmnSnomedId.setWidth(100);
		tblclmnSnomedId.setText("Snomed ID");
		
		tblclmnName = new TableColumn(TBFindings, SWT.NONE);
		tblclmnName.setWidth(299);
		tblclmnName.setText("Name");
		
		grpCreateNewFinding = new Group(shell, SWT.NONE);
		if(type==1)
		grpCreateNewFinding.setText("Create new Sign/Disorder");
		if(type==2)
			grpCreateNewFinding.setText("Create new Diagnostic Test");
		grpCreateNewFinding.setBounds(10, 234, 424, 120);
		
	    lblFindingName = new Label(grpCreateNewFinding, SWT.NONE);
		lblFindingName.setBounds(10, 28, 120, 15);
		
		if(type==1)
		lblFindingName.setText("Sign/Disorder name:");
		if(type==2)
			lblFindingName.setText("Diagnostic Test name:");
		
		text = new Text(grpCreateNewFinding, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				btnCreate.setEnabled(true);
			}
		});
		text.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				btnCreate.setEnabled(true);
			}
		});
		text.setBounds(10, 49, 404, 21);
		
	    btnCreate = new Button(grpCreateNewFinding, SWT.NONE);
	    btnCreate.addSelectionListener(new SelectionAdapter() {
	    	private String name;
			private String code;

			@Override
	    	public void widgetSelected(SelectionEvent arg0) {
	    		ComprobarInternet CI = new ComprobarInternet();
	    		boolean estado = CI.ComprobarConexion();
	    		if(estado==true){
	    		String concept = text.getText();
	    	    boolean snomedresp = buscarconceptosnomed(concept);
	    	    if(snomedresp == true){
	    		CreateFindingUsingSnomed CFUS = new CreateFindingUsingSnomed(shell, SWT.Close|SWT.MIN|SWT.BORDER, elements, concept, lg, type);
	    		CFUS.open();
	    		ClinicalElement element = CFUS.getSnomedIden();
	    		System.out.println(element.getId()+"------"+element.getNombre());
	    		String Id = element.getId();
	    		if(!Id.equalsIgnoreCase("")&&!Id.equalsIgnoreCase("0") ){
	    		TableItem findings = new TableItem(TBFindings, SWT.NONE);
	    		if(!Id.contains("I")){
      	        findings.setText (0, "I"+Id.toString());
      	        findings.setText (1, element.getNombre());
	    		}
	    		else{
	    			findings.setText (0, Id.toString());
	      	        findings.setText (1, element.getNombre());
	    		}
	    		}
	    	    }
	    	    else{
	    	    	int rc = ShowMessage.showConfirmDialog("","There are no results for this search, do you want to add the term", shell);
	    	    	System.out.println("Se ha presionado el boton "+rc);
	    	    	if(rc == 32){
	    	    		boolean resp=true;
	    	    		name = text.getText();
	    				if(type==1){
	    					AddNewSignCode ANSC = new AddNewSignCode();
	    					AddNewItem ANI = new AddNewItem();
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
	    				   AddNewItem ANI = new AddNewItem();
	    				   try{
	    						name = name.substring(0,1).toUpperCase()+(name.substring(1,name.length())).trim();	
	    						resp = ANI.searchfinding(code, name);
	    						if(resp == false){
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
	    	    }
	    	}
	    		else{
	    			ShowMessage.showMessage("Internet conection", "Please check your internet conection", type, shell);
	    		

	    		}
	    	}
	    });
		btnCreate.setEnabled(false);
		btnCreate.setBounds(339, 85, 75, 25);
		btnCreate.setText("Create");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			shell.close();
			}
		});
		btnCancel.setBounds(346, 356, 88, 25);
		btnCancel.setText("Close");
   }
}
