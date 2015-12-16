package SnApi;
import org.datacontract.schemas._2004._07.snapiwcfservice.*;
import org.tempuri.*;
import java.util.*;
public class Concepto {
    
	public java.util.List<Concept> lc;

	public ArrayOfDescription result2;
	public ArrayOfConcept result;
	public SnApiService service;
	public ISnApiService port;
	public String text = "";
	public String subsets = "";
	public String favorites = "";
	public String suffix = "";
	public String namespaces = "";
	public Integer maxResults = Integer.valueOf(100);
	public Integer matchType = Integer.valueOf(0);
	public String guid = "85904027-DF2D-40B6-9242-F2E13CE12DA3";
	public String Concepto; 
	public ArrayList lista = new ArrayList();
	public int dimension;


	public Concepto(){
	    
	service = new SnApiService();
	port = service.getBasicHttpBindingISnApiService();
	//result = port.searchConcepts(text, subsets, favorites, suffix, namespaces, maxResults, matchType, guid);
	//lc = result.getConcept();
	}
	public void setTermino(String term)
	{  text = term;
	 
	   //result = port.searchConcepts(text, subsets, favorites, suffix, namespaces, maxResults, matchType, guid);
	result = port.searchConcepts(term, "", "", "", "", "", "", "", "", "", "", maxResults, matchType, "", guid);
	lc = result.getConcept();
	      
	}
	public String getTermino()
	{
	  return text;
	}
	public void setTermino2(String term)
	{
	  text = term;
	}
	public void setConcepto()
	{
	 lc = result.getConcept(); 
	}
	public void setDimension()
	{
	 dimension = lc.size();
	}
	public int getDimension()
	{
	  return dimension;
	}
	public String getConcepto(int i)
	{
	   Concepto = lc.get(i).getFullySpecifiedName().getValue();
	    return Concepto;
	    
	}
	 
	public static void main(String[] args){
	     Concepto c = new Concepto();
	     c.setTermino("Head pain");
	     System.out.println(c.getConcepto(0));
	    }
	}

