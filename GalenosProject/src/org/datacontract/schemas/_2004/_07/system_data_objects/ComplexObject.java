
package org.datacontract.schemas._2004._07.system_data_objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.Concept;
import org.datacontract.schemas._2004._07.snapiwcfservice.Description;
import org.datacontract.schemas._2004._07.snapiwcfservice.Favourite;
import org.datacontract.schemas._2004._07.snapiwcfservice.ICD10Children;
import org.datacontract.schemas._2004._07.snapiwcfservice.ICD10Code;
import org.datacontract.schemas._2004._07.snapiwcfservice.ICD10Description;
import org.datacontract.schemas._2004._07.snapiwcfservice.MapSet;
import org.datacontract.schemas._2004._07.snapiwcfservice.Neighbour;
import org.datacontract.schemas._2004._07.snapiwcfservice.NeighbourCountResult;
import org.datacontract.schemas._2004._07.snapiwcfservice.RelType;
import org.datacontract.schemas._2004._07.snapiwcfservice.Status;
import org.datacontract.schemas._2004._07.snapiwcfservice.SubSet;
import org.datacontract.schemas._2004._07.snapiwcfservice.Suffix;


/**
 * <p>Java class for ComplexObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexObject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}StructuralObject">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexObject")
@XmlSeeAlso({
    Neighbour.class,
    SubSet.class,
    MapSet.class,
    Description.class,
    Suffix.class,
    ICD10Code.class,
    Concept.class,
    ICD10Description.class,
    NeighbourCountResult.class,
    Status.class,
    Favourite.class,
    RelType.class,
    ICD10Children.class
})
public class ComplexObject
    extends StructuralObject
{


}
