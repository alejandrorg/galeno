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

public class AllSigns
{
  public List<ClinicalElement> GetAllSigns(Logic lg)
    throws Exception
  {
    List<ClinicalElement> signs = new ArrayList<ClinicalElement>();
    List<ClinicalElement> disorders = new ArrayList<ClinicalElement>();
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    signs = lg.getAllSigns();
    disorders = lg.getAllDisorders();
    System.out.println("En el método GetAllSigns signs = "+signs.size()+ " disorders = "+disorders.size());
    try {
      for (int i = 0; i < signs.size(); i++)
      {
        elements.add(signs.get(i));
      }
      for (int i = 0; i < disorders.size(); i++)
      {
        elements.add(disorders.get(i));
      }

       }
    catch (Exception e)
    {
      System.out.println("Error en método GetAllSigns "+e.getMessage());
    }
    elements = new Logic().ordenalista(elements, "signs/disordes");
    return elements;
  }
}