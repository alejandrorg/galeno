/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

/**
 *
 * @author gandhi
 */
import java.util.ArrayList;
import java.util.List;

public class OriginalSigns
{
  public List<ClinicalElement> OriginalSignsFromDisease(String Id_Disease)
    throws Exception
  {
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    ClinicalElement ce = new ClinicalElement();
    try {
      elements = ce.getOriginalSigns(Id_Disease);
      if (elements.isEmpty())
      {
        System.out.println("ERROR Disease not found ");
        elements.clear();
        return elements;
      }
    } catch (Exception e) {
      
      System.out.println("ERROR Disease not found " + e.getMessage());
      elements.clear();
      return elements;
    }
    return elements;
  }
}
