
package org.datacontract.schemas._2004._07.snapiwcfservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfICD10Children complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfICD10Children">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ICD10Children" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ICD10Children" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfICD10Children", propOrder = {
    "icd10Children"
})
public class ArrayOfICD10Children {

    @XmlElement(name = "ICD10Children", nillable = true)
    protected List<ICD10Children> icd10Children;

    /**
     * Gets the value of the icd10Children property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icd10Children property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getICD10Children().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ICD10Children }
     * 
     * 
     */
    public List<ICD10Children> getICD10Children() {
        if (icd10Children == null) {
            icd10Children = new ArrayList<ICD10Children>();
        }
        return this.icd10Children;
    }

}
