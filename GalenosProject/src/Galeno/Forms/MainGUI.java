package Galeno.Forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import Galenos.classes.ClinicalElement;
import Galenos.classes.Diagnosis;
import Galenos.classes.Logic;
import Galenos.classes.MailAdjunto;
import Galenos.classes.OnlySigns;
import Galenos.classes.OriginalSigns;
import Galenos.classes.OriginalTests;
import Galenos.classes.ShowMessage;
import Galenos.classes.UnZipFiles;
import Galenos.classes.ZipOntologiesFull;
import Galenos.classes.OnlySigns;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class MainGUI {

	protected Shell shlGandhiTesis;
	private Table TBDiseases;
	private Table TBSigns;
	private Table TBDTs;
	private Table TBSignsDDx;
	private Table TBDTsDDx;
	private Text TXTName;
	private Text TXTEmail;
	private Text TXTComments;
	private Button BTAddSign;
	private Button BTDelSign;
	private Button BTAddDT;   
	private Button BTDelDT;
	private Button BTSave;
	private Button BTAddSignDDx;
	private Button BTDelSignDDx;
	private Button BTAddDTDDx;
	private Button BTDelDTDDx;
	private Button btnGetResults;
	private Group grpDiseases_1;
	private Button BTSendResults;
	
	String claveSigno = "";
    String clavePrueba = "";
    String claveSnomed = "";
    String claveSignoDiagnostico = "";
    String clavePruebaDiagnostico = "";
    String nombreusuario="";
    String emailusuario = "";
    String comments="";
    boolean bandselectenfermedad = false;
    boolean bandselecteddiagnosticsign = false;
    boolean bandselecteddiagnostictest = false;
    String claveEnfermedad = "";
    ClinicalElement ce = new ClinicalElement();
    List<String> name = new ArrayList<String>();
    Logic lg = new Logic();
   Logic loc = new Logic();
   private Table TBDiseasesResults;
   private Table TBSignsEv;
   private Table TBDtEv;
   private Table table;
   private Table table_1;
 
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainGUI window = new MainGUI();
		    window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		lg.cargarmodelos();
		Display display = Display.getDefault();
		createContents();
		shlGandhiTesis.open();
		shlGandhiTesis.layout();
		llenaListaEnfermedades();
		while (!shlGandhiTesis.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void llenaListaEnfermedades() {
		// TODO Auto-generated method stub
		List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
	    try
	    {
	      elements = lg.getOriginalDiseases();
	    } catch (Exception ex) {
	      System.out.println(ex.getMessage());
	    }
	    
	    elements = lg.ordenalista(elements, "Diseases List");
	    for (int i = 0 ; i< elements.size() ; i++){
	        TableItem item = new TableItem(TBDiseases, SWT.NONE);
	        item.setText (0, elements.get(i).getId().toString());
	        item.setText (1, elements.get(i).getNombre().toString());
	     }
	    
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlGandhiTesis = new Shell(SWT.Close|SWT.MIN|SWT.BORDER);
		shlGandhiTesis.setModified(true);
		shlGandhiTesis.setSize(705, 652);
		shlGandhiTesis.setText("GALENO");
		shlGandhiTesis.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
		TabFolder tabFolder = new TabFolder(shlGandhiTesis, SWT.NONE);
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Edit KB");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(composite);
		composite.setLayout(new FormLayout());
		
		Group grpDiseases = new Group(composite, SWT.NONE);
		FormData fd_grpDiseases = new FormData();
		fd_grpDiseases.bottom = new FormAttachment(0, 179);
		fd_grpDiseases.top = new FormAttachment(0, 10);
		fd_grpDiseases.left = new FormAttachment(0, 10);
		fd_grpDiseases.right = new FormAttachment(0, 577);
		grpDiseases.setLayoutData(fd_grpDiseases);
		grpDiseases.setText("Diseases");
		grpDiseases.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TBDiseases = new Table(grpDiseases, SWT.BORDER | SWT.FULL_SELECTION);
		TBDiseases.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
			List<ClinicalElement> signoselements = new ArrayList<ClinicalElement>();
			List<ClinicalElement> disorderelements = new ArrayList<ClinicalElement>();
			List<ClinicalElement> testelements = new ArrayList<ClinicalElement>();
			 TableItem item = (TableItem) event.item;
			 
			 claveEnfermedad = item.getText();
	          System.out.println (claveEnfermedad);
	          TBSigns.removeAll();
	          TBDTs.removeAll();
	          BTAddSign.setEnabled(true);
	          BTDelSign.setEnabled(true);
	          BTAddDT.setEnabled(true);
	          BTDelDT.setEnabled(true);
	          BTSave.setEnabled(true);
	          try{
	        	  signoselements = lg.getsignsfromdisease(claveEnfermedad);
	        	  disorderelements = lg.getdisordersfromdisease(claveEnfermedad);
	        	  for(int i=0; i<disorderelements.size(); i++){
	        		  ce = new ClinicalElement();
	        		  ce = disorderelements.get(i);
	        		  signoselements.add(ce);
	        	  }
	        	  signoselements = lg.ordenalista(signoselements, "Signs an Disorders List");
	        	  for (int i = 0 ; i< signoselements.size() ; i++){
	        		  TableItem sign = new TableItem(TBSigns, SWT.NONE);
	        		sign.setText (0, signoselements.get(i).getId().toString());
	      	        sign.setText (1, signoselements.get(i).getNombre().toString());
	      	      }
	          }
	          catch(Exception ex){
              System.out.println(ex.getMessage());		        	  
	          }
	        try{
	        	  testelements = lg.ordenalista(lg.gettestfromdisease(claveEnfermedad), "Test List");
	        	  for (int i = 0 ; i< testelements.size() ; i++){
	      	        TableItem test = new TableItem(TBDTs, SWT.NONE);
	      	        test.setText (0, testelements.get(i).getId().toString());
	      	        test.setText (1, testelements.get(i).getNombre().toString());
	      	     }
	          }
	          catch(Exception ex){
              System.out.println(ex.getMessage());		        	  
	          }
			}
		});
		TBDiseases.setHeaderVisible(true);
		TBDiseases.setLinesVisible(true);
		
		TableColumn tblclmnSnomedId = new TableColumn(TBDiseases, SWT.NONE);
		tblclmnSnomedId.setWidth(182);
		tblclmnSnomedId.setText("SNOMED ID");
		
		TableColumn tblclmnName = new TableColumn(TBDiseases, SWT.NONE);
		tblclmnName.setWidth(375);
		tblclmnName.setText("Name");
		
		Group grpFindings = new Group(composite, SWT.NONE);
		grpFindings.setText("Findings");
		FormData fd_grpFindings = new FormData();
		fd_grpFindings.top = new FormAttachment(grpDiseases, 6);
		fd_grpFindings.left = new FormAttachment(grpDiseases, 0, SWT.LEFT);
		fd_grpFindings.right = new FormAttachment(100, -10);
		grpFindings.setLayoutData(fd_grpFindings);
		
		Group grpSigns = new Group(grpFindings, SWT.NONE);
		grpSigns.setText("Signs");
		grpSigns.setBounds(10, 21, 547, 156);
		
		TBSigns = new Table(grpSigns, SWT.BORDER | SWT.FULL_SELECTION);
		
		TBSigns.setBounds(10, 22, 501, 124);
		TBSigns.setHeaderVisible(true);
		TBSigns.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(TBSigns, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Snomed ID");
		
		TableColumn tblclmnName_1 = new TableColumn(TBSigns, SWT.NONE);
		tblclmnName_1.setWidth(397);
		tblclmnName_1.setText("Name");
		
		BTAddSign = new Button(grpSigns, SWT.NONE);
		BTAddSign.setEnabled(false);
		BTAddSign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				AddFindingDialog AFD = new AddFindingDialog(shlGandhiTesis, SWT.Close|SWT.MIN|SWT.BORDER, 1, lg, 1);
				AFD.open();
				System.out.println("item seleccionado "+AFD.getIden());
				List<ClinicalElement> els = AFD.getIden();
				ClinicalElement el;
				String nombre="";
		    	TableItem items[] = TBSigns.getItems();
				String codigo="";
				int cont =0;
				//comprueba que el nuevo item no se encuentre en la lista 
				if(items.length>0){
				for(int i = 0; i<els.size(); i++){
					cont = 0;
					ce = new ClinicalElement();
					ce=els.get(i);
					for(int j=0; j<items.length; j++){
						codigo=items[j].getText();
						if(!codigo.equalsIgnoreCase(ce.getId().toString())){
							cont++;
						}
					if(cont>=items.length){
					nombre = ce.getNombre().toString();
					TableItem signs = new TableItem(TBSigns, SWT.NONE);
	      	        signs.setText (0, ce.getId().toString());
	      	        signs.setText (1, nombre);
				}
			    }
				}
				}
				else{
					for(int i =0; i<els.size(); i++){
						ce = new ClinicalElement();
						ce = els.get(i);
						nombre = ce.getNombre().toString();
						TableItem signs = new TableItem(TBSigns, SWT.NONE);
		      	        signs.setText (0, ce.getId().toString());
		      	        signs.setText (1, nombre);
					}
				}
			}
		});
		BTAddSign.setBounds(517, 22, 25, 25);
		BTAddSign.setText("[+]");
		
		TBSigns.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				BTAddSign.setEnabled(true);
				BTDelSign.setEnabled(true);
			}
		});
		
	    BTDelSign = new Button(grpSigns, SWT.NONE);
		BTDelSign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Eliminar de la lista el elemento seleccionado
				try{
					int indices[] = TBSigns.getSelectionIndices();
					for(int i =0; i<indices.length; i++){
						TBSigns.remove(indices[i]);
					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		});
		BTDelSign.setEnabled(false);
		BTDelSign.setText("[-]");
		BTDelSign.setBounds(517, 121, 25, 25);
		
		Group grpDiagnosticTests = new Group(grpFindings, SWT.NONE);
		grpDiagnosticTests.setText("Diagnostic Tests");
		grpDiagnosticTests.setBounds(10, 183, 547, 156);
		
		TBDTs = new Table(grpDiagnosticTests, SWT.BORDER | SWT.FULL_SELECTION);
		TBDTs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			BTAddDT.setEnabled(true);
			BTDelDT.setEnabled(true);
			}
		});
		TBDTs.setLinesVisible(true);
		TBDTs.setHeaderVisible(true);
		TBDTs.setBounds(10, 22, 501, 124);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(TBDTs, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Snomed ID");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(TBDTs, SWT.NONE);
		tblclmnNewColumn_4.setWidth(397);
		tblclmnNewColumn_4.setText("Name");
		
		BTAddDT = new Button(grpDiagnosticTests, SWT.NONE);
		BTAddDT.setEnabled(false);
		BTAddDT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddFindingDialog AFD = new AddFindingDialog(shlGandhiTesis, SWT.Close|SWT.MIN|SWT.BORDER, 2, lg, 1);
				AFD.open();
				System.out.println("item seleccionado "+AFD.getIden());
				List<ClinicalElement> els = AFD.getIden();
				ClinicalElement el;
				String nombre="";
		    	TableItem items[] = TBDTs.getItems();
				String codigo="";
				int cont =0;
				if(items.length>0){
					for(int i = 0; i<els.size(); i++){
						cont = 0;
						ce = new ClinicalElement();
						ce=els.get(i);
						for(int j=0; j<items.length; j++){
							codigo=items[j].getText();
							if(!codigo.equalsIgnoreCase(ce.getId().toString())){
								cont++;
							}
						if(cont>=items.length){
						nombre = ce.getNombre().toString();
						//nombre = nombre.substring(0, nombre.lastIndexOf("(")).trim();
						TableItem test = new TableItem(TBDTs, SWT.NONE);
		      	        test.setText (0, ce.getId().toString());
		      	        test.setText (1, nombre);
					}
				    }
					}
					}
					else{
						for(int i =0; i<els.size(); i++){
							ce = new ClinicalElement();
							ce = els.get(i);
							nombre = ce.getNombre().toString();
							//nombre = nombre.substring(0, nombre.lastIndexOf("(")).trim();
							TableItem test = new TableItem(TBDTs, SWT.NONE);
			      	        test.setText (0, ce.getId().toString());
			      	        test.setText (1, nombre);
						}
					}
				}
			});
			
		
		BTAddDT.setText("[+]");
		BTAddDT.setBounds(517, 22, 25, 25);
		
		BTDelDT = new Button(grpDiagnosticTests, SWT.NONE);
		BTDelDT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Eliminar de la lista el elemento seleccionado
				try{
					int indices[] = TBDTs.getSelectionIndices();
					for(int i =0; i<indices.length; i++){
						TBDTs.remove(indices[i]);
					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		});
		BTDelDT.setEnabled(false);
		BTDelDT.setText("[-]");
		BTDelDT.setBounds(517, 121, 25, 25);
		
		BTSave = new Button(composite, SWT.NONE);
		BTSave.setEnabled(false);
		BTSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			List<ClinicalElement> newsigns = new ArrayList<ClinicalElement>();
			List<ClinicalElement> newtests = new ArrayList<ClinicalElement>();
			ClinicalElement ce;
			boolean respsigns=false;
			boolean respdisorders = false;
			boolean resptest = false;
			//Leer la enfermedad seleccionada
            System.out.println("la enfermedad seleccionada es "+claveEnfermedad);
			  //Recorrer tabla de signs
				//TBSigns
				TableItem SignsselectedItems[] = TBSigns.getItems();
				for(int i =0; i<SignsselectedItems.length; i++){
					System.out.println(SignsselectedItems[i].getText(0)+"--"+SignsselectedItems[i].getText(1));
					//Armar lista de ClinicalElements para los signs
					ce = new ClinicalElement();
					ce.setId(SignsselectedItems[i].getText(0));
					newsigns.add(ce);
			}
			
				//Recorrer tabla de test
				//TBDTs
				TableItem TestsselectedItems[] = TBDTs.getItems();
				for(int i =0; i<TestsselectedItems.length; i++){
					System.out.println(TestsselectedItems[i].getText(0)+"--"+TestsselectedItems[i].getText(1));
					//Armar la lista de ClinicalElements para los tests
					ce = new ClinicalElement();
					ce.setId(TestsselectedItems[i].getText(0));
					newtests.add(ce);
			}
				//Lamar a los métodos updatesigns y update test
				respsigns = lg.updatesignlist(newsigns, claveEnfermedad);
				respdisorders = lg.updatedisorderlist(newsigns, claveEnfermedad);
		        resptest = lg.updatetestlist(newtests, claveEnfermedad);
				System.out.println("respuesta de updatesigns = "+respsigns);
				System.out.println("respuesta de updatesigns = "+resptest);
				//Volver a cargar modelos para llenar lista de signs y lista de test
				// llenarmodelosigns();
				lg.llenarmodelosigns();
		        //llenarmodelotest();
				lg.llenarmodelotest();
			   //llenamodelodisorder
				lg.llenarmodelodisorders();
			}
		});
		fd_grpFindings.bottom = new FormAttachment(100, -39);
		FormData fd_BTSave = new FormData();
		fd_BTSave.top = new FormAttachment(grpFindings, 6);
		fd_BTSave.right = new FormAttachment(grpDiseases, 0, SWT.RIGHT);
		fd_BTSave.left = new FormAttachment(100, -99);
		BTSave.setLayoutData(fd_BTSave);
		BTSave.setText("Save");
		
		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("DDx");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(composite_1);
		composite_1.setLayout(null);
		
		Group group_1 = new Group(composite_1, SWT.NONE);
		group_1.setText("Findings");
		group_1.setBounds(10, 10, 567, 348);
		
		Group group_2 = new Group(group_1, SWT.NONE);
		group_2.setText("Signs");
		group_2.setBounds(10, 21, 547, 156);
		
		TBSignsDDx = new Table(group_2, SWT.BORDER | SWT.FULL_SELECTION);
		TBSignsDDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				BTDelSignDDx.setEnabled(true);
				btnGetResults.setEnabled(true);
			}
		});
		TBSignsDDx.setLinesVisible(true);
		TBSignsDDx.setHeaderVisible(true);
		TBSignsDDx.setBounds(10, 22, 501, 124);
		
		TableColumn tableColumn_2 = new TableColumn(TBSignsDDx, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Snomed ID");
		
		TableColumn tableColumn_3 = new TableColumn(TBSignsDDx, SWT.NONE);
		tableColumn_3.setWidth(397);
		tableColumn_3.setText("Name");
		
		BTAddSignDDx = new Button(group_2, SWT.NONE);
		BTAddSignDDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddFindingDialog AFD = new AddFindingDialog(shlGandhiTesis, SWT.Close|SWT.MIN|SWT.BORDER, 1, lg, 2);
				AFD.open();
				System.out.println("item seleccionado "+AFD.getIden());
				List<ClinicalElement> els = AFD.getIden();
				ClinicalElement el;
				String nombre="";
		    	TableItem items[] = TBSignsDDx.getItems();
				String codigo="";
				int cont =0;
				//comprueba que el nuevo item no se encuentre en la lista 
				if(items.length>0){
				for(int i = 0; i<els.size(); i++){
					cont = 0;
					ce = new ClinicalElement();
					ce=els.get(i);
					for(int j=0; j<items.length; j++){
						codigo=items[j].getText();
						if(!codigo.equalsIgnoreCase(ce.getId().toString())){
							cont++;
						}
					if(cont>=items.length){
					nombre = ce.getNombre().toString();
					TableItem signs = new TableItem(TBSignsDDx, SWT.NONE);
	      	        signs.setText (0, ce.getId().toString());
	      	        signs.setText (1, nombre);
				}
			    }
				}
				}
				else{
					for(int i =0; i<els.size(); i++){
						ce = new ClinicalElement();
						ce = els.get(i);
						nombre = ce.getNombre().toString();
						TableItem signs = new TableItem(TBSignsDDx, SWT.NONE);
		      	        signs.setText (0, ce.getId().toString());
		      	        signs.setText (1, nombre);
					}
				}
			}
		});
		BTAddSignDDx.setText("[+]");
		BTAddSignDDx.setBounds(517, 22, 25, 25);
		
		BTDelSignDDx = new Button(group_2, SWT.NONE);
		BTDelSignDDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Eliminar de la lista el elemento seleccionado
				try{
					int indices[] = TBSignsDDx.getSelectionIndices();
					for(int i =0; i<indices.length; i++){
						TBSignsDDx.remove(indices[i]);
					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		});
		BTDelSignDDx.setEnabled(false);
		BTDelSignDDx.setText("[-]");
		BTDelSignDDx.setBounds(517, 121, 25, 25);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Diagnostic Tests");
		group_3.setBounds(10, 183, 547, 156);
		
		TBDTsDDx = new Table(group_3, SWT.BORDER | SWT.FULL_SELECTION);
		TBDTsDDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				BTDelDTDDx.setEnabled(true);
			}
		});
		TBDTsDDx.setLinesVisible(true);
		TBDTsDDx.setHeaderVisible(true);
		TBDTsDDx.setBounds(10, 22, 501, 124);
		
		TableColumn tableColumn_4 = new TableColumn(TBDTsDDx, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("Snomed ID");
		
		TableColumn tableColumn_5 = new TableColumn(TBDTsDDx, SWT.NONE);
		tableColumn_5.setWidth(397);
		tableColumn_5.setText("Name");
		
		BTAddDTDDx = new Button(group_3, SWT.NONE);
		BTAddDTDDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddFindingDialog AFD = new AddFindingDialog(shlGandhiTesis, SWT.Close|SWT.MIN|SWT.BORDER, 2, lg, 2);
				AFD.open();
				System.out.println("item seleccionado "+AFD.getIden());
				List<ClinicalElement> els = AFD.getIden();
				ClinicalElement el;
				String nombre="";
		    	TableItem items[] = TBDTsDDx.getItems();
				String codigo="";
				int cont =0;
				if(items.length>0){
					for(int i = 0; i<els.size(); i++){
						cont = 0;
						ce = new ClinicalElement();
						ce=els.get(i);
						for(int j=0; j<items.length; j++){
							codigo=items[j].getText();
							if(!codigo.equalsIgnoreCase(ce.getId().toString())){
								cont++;
							}
						if(cont>=items.length){
						nombre = ce.getNombre().toString();
						TableItem test = new TableItem(TBDTsDDx, SWT.NONE);
		      	        test.setText (0, ce.getId().toString());
		      	        test.setText (1, nombre);
					}
				    }
					}
					}
					else{
						for(int i =0; i<els.size(); i++){
							ce = new ClinicalElement();
							ce = els.get(i);
							nombre = ce.getNombre().toString();
							TableItem test = new TableItem(TBDTsDDx, SWT.NONE);
			      	        test.setText (0, ce.getId().toString());
			      	        test.setText (1, nombre);
						}
					}
			}
		});
		BTAddDTDDx.setText("[+]");
		BTAddDTDDx.setBounds(517, 22, 25, 25);
		
		BTDelDTDDx = new Button(group_3, SWT.NONE);
		BTDelDTDDx.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Eliminar de la lista el elemento seleccionado
				try{
					int indices[] = TBDTsDDx.getSelectionIndices();
					for(int i =0; i<indices.length; i++){
						TBDTsDDx.remove(indices[i]);
					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		});
		BTDelDTDDx.setEnabled(false);
		BTDelDTDDx.setText("[-]");
		BTDelDTDDx.setBounds(517, 121, 25, 25);
		
		btnGetResults = new Button(composite_1, SWT.NONE);
		btnGetResults.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Recorrer la lista de signs y de test y almacenarla en una lista de ClinicalElement
				List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
				List<ClinicalElement> resultdiagnosis = new ArrayList<ClinicalElement>();
				ClinicalElement ce;
				String diagnosiscode="";
				TableItem SignsselectedItems[] = TBSignsDDx.getItems();
				for(int i =0; i<SignsselectedItems.length; i++){
					System.out.println(SignsselectedItems[i].getText(0)+"--"+SignsselectedItems[i].getText(1));
					//Armar lista de ClinicalElements para los signs
					ce = new ClinicalElement();
					diagnosiscode = SignsselectedItems[i].getText(0);
					diagnosiscode = diagnosiscode.substring(1, diagnosiscode.length());
					ce.setId(diagnosiscode);
					ce.setTipo("sign");
					elements.add(ce);
			}
				TableItem TestselectedItems[] = TBDTsDDx.getItems();
				for(int i =0; i<TestselectedItems.length; i++){
					System.out.println(TestselectedItems[i].getText(0)+"--"+TestselectedItems[i].getText(1));
					//Armar lista de ClinicalElements para los test
					ce = new ClinicalElement();
					diagnosiscode = SignsselectedItems[i].getText(0);
					diagnosiscode = diagnosiscode.substring(1, diagnosiscode.length());
					ce.setId(diagnosiscode);
					ce.setTipo("test");
					elements.add(ce);
			}
			    Diagnosis dig = new Diagnosis();
			    try {
			    	resultdiagnosis = dig.GetDiagnosis(elements, "global");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0 ; i< resultdiagnosis.size() ; i++){
			        TableItem item = new TableItem(TBDiseasesResults, SWT.NONE);
			        item.setText (0, resultdiagnosis.get(i).getId().toString());
			        item.setText (1, resultdiagnosis.get(i).getNombre().toString());
			     }
			}
		});
		btnGetResults.setEnabled(false);
		btnGetResults.setBounds(467, 364, 110, 25);
		btnGetResults.setText("Get results");
		
		grpDiseases_1 = new Group(composite_1, SWT.NONE);
		grpDiseases_1.setText("Diseases");
		grpDiseases_1.setBounds(36, 415, 541, 156);
		
		TBDiseasesResults = new Table(grpDiseases_1, SWT.BORDER | SWT.FULL_SELECTION);
		TBDiseasesResults.setBounds(10, 29, 521, 109);
		TBDiseasesResults.setHeaderVisible(true);
		TBDiseasesResults.setLinesVisible(true);
		
		TableColumn tblclmnSnomedId_1 = new TableColumn(TBDiseasesResults, SWT.NONE);
		tblclmnSnomedId_1.setWidth(169);
		tblclmnSnomedId_1.setText("Snomed ID");
		
		TableColumn tblclmnName_2 = new TableColumn(TBDiseasesResults, SWT.NONE);
		tblclmnName_2.setWidth(386);
		tblclmnName_2.setText("Name");
		
		TabItem tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("Send results");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_2.setControl(composite_2);
		composite_2.setLayout(null);
		
		Group grpSendResults = new Group(composite_2, SWT.NONE);
		grpSendResults.setText("Send results");
		grpSendResults.setBounds(10, 10, 567, 450);
		
		Label lblOnceYouHave = new Label(grpSendResults, SWT.NONE);
		lblOnceYouHave.setBounds(10, 24, 547, 15);
		lblOnceYouHave.setText("Once you have finished the edition of the knowledge base based on the instructions provided, ");
		
		Label lblPleaseSendThe = new Label(grpSendResults, SWT.NONE);
		lblPleaseSendThe.setText("please, send the results.");
		lblPleaseSendThe.setBounds(10, 38, 547, 15);
		
		Label lblIntroduceYourInformation = new Label(grpSendResults, SWT.NONE);
		lblIntroduceYourInformation.setBounds(10, 73, 157, 15);
		lblIntroduceYourInformation.setText("Introduce your information:");
		
		Label lblName = new Label(grpSendResults, SWT.NONE);
		lblName.setBounds(10, 114, 55, 15);
		lblName.setText("Name");
		
		TXTName = new Text(grpSendResults, SWT.BORDER);
		TXTName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				BTSendResults.setEnabled(true);
			}
		});
		TXTName.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			BTSendResults.setEnabled(true);
			}
		});
		TXTName.setBounds(71, 111, 486, 21);
		
		Label lblEmail = new Label(grpSendResults, SWT.NONE);
		lblEmail.setText("Email");
		lblEmail.setBounds(10, 138, 55, 15);
		
		TXTEmail = new Text(grpSendResults, SWT.BORDER);
		TXTEmail.setBounds(71, 135, 486, 21);
		
		Label lblComments = new Label(grpSendResults, SWT.NONE);
		lblComments.setText("Comments");
		lblComments.setBounds(10, 169, 75, 15);
		
		TXTComments = new Text(grpSendResults, SWT.BORDER | SWT.MULTI);
		TXTComments.setBounds(10, 190, 547, 250);
		
	    BTSendResults = new Button(composite_2, SWT.NONE);
	    BTSendResults.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent arg0) {
	    		nombreusuario = TXTName.getText();
	    		emailusuario = TXTEmail.getText();
	    		comments = TXTComments.getText();
	    		boolean conexion=false;
	    		ComprobarInternet ci = new ComprobarInternet();
	    		if(nombreusuario.equalsIgnoreCase("")||emailusuario.equalsIgnoreCase("")||comments.equalsIgnoreCase("")){
	    			ShowMessage.showMessage("Uncomplete data", "Please fill all the fields", 1, shlGandhiTesis);
	    		}
	    		else{
	    		ZipOntologiesFull zof = new ZipOntologiesFull();
	    		try {
					zof.zipOntologies();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  	try{
			  		conexion = ci.ComprobarConexion();
			  		if(conexion==false){
			  			ShowMessage.showMessage("Connection", "The mail can't be sent. Please check your Internet Connection", 1, shlGandhiTesis);
			  		}
			  		else{
			  			 MailAdjunto obMailA = new MailAdjunto();
				    	  obMailA.setNombreArchivo("ontologies.zip");
				          obMailA.setRutaArchivo("C:\\gandhi\\ontologies.zip");
				          obMailA.setMensaje(TXTComments.getText().trim());
				          String alerta = obMailA.enviarEmailA();
				          ShowMessage.showMessage("Alert", alerta, 1, shlGandhiTesis);
				          TXTComments.setText("");
				          TXTName.setText("");
				          TXTEmail.setText("");
			  		}
			  	}
			  	catch(Exception e){
			  		e.printStackTrace();
			  	}
	    	 
	    		}
	    	}
	    });
		BTSendResults.setEnabled(false);
		BTSendResults.setBounds(476, 472, 101, 25);
		BTSendResults.setText("Send");
		
		TabItem tbtmEvaluation = new TabItem(tabFolder, SWT.NONE);
		tbtmEvaluation.setText("Training");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmEvaluation.setControl(composite_3);
		composite_3.setLayout(null);
		
		Group grpEvaluation = new Group(composite_3, SWT.NONE);
		grpEvaluation.setText("Evaluation");
		grpEvaluation.setBounds(0, 0, 671, 580);
		
		Group grpSignsAndDts = new Group(grpEvaluation, SWT.NONE);
		grpSignsAndDts.setText("Signs");
		grpSignsAndDts.setBounds(21, 25, 527, 117);
		
		TBSignsEv = new Table(grpSignsAndDts, SWT.BORDER | SWT.FULL_SELECTION);
		TBSignsEv.setLinesVisible(true);
		TBSignsEv.setHeaderVisible(true);
		TBSignsEv.setBounds(10, 25, 501, 83);
		
		TableColumn tableColumn = new TableColumn(TBSignsEv, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Snomed ID");
		
		TableColumn tableColumn_1 = new TableColumn(TBSignsEv, SWT.NONE);
		tableColumn_1.setWidth(397);
		tableColumn_1.setText("Name");
		
		Group group = new Group(grpEvaluation, SWT.NONE);
		group.setText("Diagnostic Tests");
		group.setBounds(21, 148, 527, 117);
		
		TBDtEv = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		TBDtEv.setLinesVisible(true);
		TBDtEv.setHeaderVisible(true);
		TBDtEv.setBounds(10, 22, 501, 85);
		
		TableColumn tableColumn_6 = new TableColumn(TBDtEv, SWT.NONE);
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("Snomed ID");
		
		TableColumn tableColumn_7 = new TableColumn(TBDtEv, SWT.NONE);
		tableColumn_7.setWidth(397);
		tableColumn_7.setText("Name");
		
		Group grpDiagnostic = new Group(grpEvaluation, SWT.NONE);
		grpDiagnostic.setText("Diagnostic");
		grpDiagnostic.setBounds(21, 271, 527, 122);
		
		table = new Table(grpDiagnostic, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 22, 476, 85);
		
		TableColumn tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(100);
		tableColumn_8.setText("Snomed ID");
		
		TableColumn tableColumn_9 = new TableColumn(table, SWT.NONE);
		tableColumn_9.setWidth(397);
		tableColumn_9.setText("Name");
		
		Button button = new Button(grpDiagnostic, SWT.NONE);
		button.setText("[+]");
		button.setEnabled(false);
		button.setBounds(492, 22, 25, 25);
		
		Button button_1 = new Button(grpDiagnostic, SWT.NONE);
		button_1.setText("[-]");
		button_1.setEnabled(false);
		button_1.setBounds(492, 53, 25, 25);
		
		Button btnr = new Button(grpDiagnostic, SWT.NONE);
		btnr.setText("[R]");
		btnr.setEnabled(false);
		btnr.setBounds(492, 84, 25, 25);
		
		Group grpResults = new Group(grpEvaluation, SWT.NONE);
		grpResults.setText("Results");
		grpResults.setBounds(21, 399, 527, 117);
		
		table_1 = new Table(grpResults, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 22, 498, 85);
		
		TableColumn tableColumn_10 = new TableColumn(table_1, SWT.NONE);
		tableColumn_10.setWidth(100);
		tableColumn_10.setText("Snomed ID");
		
		TableColumn tableColumn_11 = new TableColumn(table_1, SWT.NONE);
		tableColumn_11.setWidth(397);
		tableColumn_11.setText("Name");
		
		Button btnStartTraining = new Button(grpEvaluation, SWT.NONE);
		btnStartTraining.addSelectionListener(new SelectionAdapter() {
		    @Override
			public void widgetSelected(SelectionEvent arg0) {
		    	List<ClinicalElement> signos = new ArrayList<ClinicalElement>();
		    	OnlySigns objOs = new OnlySigns();
		    	signos = objOs.GetOnlySigns();
		    	
		    	for (int i = 0 ; i< signos.size() ; i++){
			        TableItem item = new TableItem(TBSignsEv, SWT.NONE);
			        item.setText (0, signos.get(i).getId().toString());
			        item.setText (1, signos.get(i).getNombre().toString());
			     }
			}
		});
		btnStartTraining.setBounds(575, 25, 86, 25);
		btnStartTraining.setText("Start Training");

	}
}
