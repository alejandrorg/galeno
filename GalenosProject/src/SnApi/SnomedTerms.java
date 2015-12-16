/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SnApi;

import Galenos.classes.ClinicalElement;
import java.util.ArrayList;
import java.util.List;
import org.datacontract.schemas._2004._07.snapiwcfservice.*;



/**
 *
 * @author gandhi
 */
public class SnomedTerms {
    String guid = "85904027-DF2D-40B6-9242-F2E13CE12DA3";
    List<ClinicalElement> elements = new ArrayList();
    ClinicalElement ce;
    public List<ClinicalElement> SearchConcepts(String name){
        try{
            System.out.println("buscando terminos relacionados con " + name);
      ArrayOfConcept ac = getConcept(name, "", this.guid);
      List lc = ac.getConcept();
      System.out.println("The concepts are ");

      int cont = 0;
      for (int i = 0; i < lc.size(); i++)
      {
        long num_concept = ((Concept)lc.get(i)).getConceptId().longValue();

        cont++;
        ArrayOfDescription ad = getDescription(Long.valueOf(num_concept), this.guid);
        for (int j = 0; j < 1; j++)
        {
          this.ce = new ClinicalElement();
          this.ce.setId("I" + num_concept);
          this.ce.setNombre((ad.getDescription().get(j)).getTerm().getValue());
          this.ce.setTipo("finding");
          this.elements.add(this.ce);
            System.out.println((ad.getDescription().get(j)).getTerm().getValue());
        }
      }
      System.out.println("Se encontraron " + cont + " items");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return this.elements;
    }

    private static ArrayOfConcept getConcept(java.lang.String conceptId, java.lang.String nameSpace, java.lang.String guid) {
        org.tempuri.SnApiService service = new org.tempuri.SnApiService();
        org.tempuri.ISnApiService port = service.getBasicHttpBindingISnApiService();
        return port.getConcept(conceptId, nameSpace, guid);
    }

    private static ArrayOfDescription getDescription(java.lang.Long conceptId, java.lang.String guid) {
        org.tempuri.SnApiService service = new org.tempuri.SnApiService();
        org.tempuri.ISnApiService port = service.getBasicHttpBindingISnApiService();
        return port.getDescription(conceptId, guid);
    }
    
}
