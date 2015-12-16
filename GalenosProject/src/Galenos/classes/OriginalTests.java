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

public class OriginalTests
{
  public List<ClinicalElement> OriginalTestFromDisease(String Id_Disease)
    throws Exception
  {
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    ClinicalElement ce = new ClinicalElement();
    try {
      elements = ce.getOriginalDiagnosticTest(Id_Disease);
      if (elements.isEmpty())
      {
        System.out.println("There are no results for this query");
        elements.clear();
        return elements;
      }
    }
    catch (Exception e)
    {
      elements.clear();
      System.out.println("ERROR Disease not found " + e.getMessage());
      return elements;
    }

    return elements;
  }
}