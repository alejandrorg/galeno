/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;
import java.util.ArrayList;
import java.util.List;

public class OriginalDiseases
{
  public List<ClinicalElement> GetOriginalDiseases()
    throws Exception
  {
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    ClinicalElement ce = new ClinicalElement();
    Logic lg = new Logic();
    try {
      elements = lg.getOriginalDiseases();
    } catch (Exception e) {
      ce = new ClinicalElement();
      ce.setMensaje("ERROR Ontology Not Found " + e.getMessage());
      elements.clear();
      elements.add(ce);
    }
    return elements;
  }
}
