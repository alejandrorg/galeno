/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

/**
 *
 * @author gandhi
 */
import SnApi.SnomedTerms;
import java.util.ArrayList;
import java.util.List;

public class SnomedConcepts
{   
  public List<ClinicalElement> Concepts(String c_name)throws Exception
  {
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    try
    {
      SnomedTerms sc = new SnomedTerms();
      elements = sc.SearchConcepts(c_name);
      if (elements.isEmpty())
      {
       
        System.out.println("There are not results for this search. Please try to be more specific");
        
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return elements;
    }
    return elements;
  }
}
