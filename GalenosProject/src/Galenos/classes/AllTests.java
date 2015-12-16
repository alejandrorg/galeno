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

public class AllTests
{
  public List<ClinicalElement> GetAllTest(Logic lg)
    throws Exception
  {
    List<ClinicalElement> test = new ArrayList<ClinicalElement>();
    try
    {
      test = lg.getAllTest();
//      for(int i=0; i<test.size(); i++){
//    	  System.out.println(test.get(i).getId()+"-"+test.get(i).getNombre());
//      }
    }
    catch (Exception e) {
     e.printStackTrace();  
    }
    test = new Logic().ordenalista(test, "signs/disordes");
    return test;
  }
}
