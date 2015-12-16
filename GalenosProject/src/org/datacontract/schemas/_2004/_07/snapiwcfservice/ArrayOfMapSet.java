
package org.datacontract.schemas._2004._07.snapiwcfservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMapSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapSet" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}MapSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapSet", propOrder = {
    "mapSet"
})
public class ArrayOfMapSet {

    @XmlElement(name = "MapSet", nillable = true)
    protected List<MapSet> mapSet;

    /**
     * Gets the value of the mapSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapSet }
     * 
     * 
     */
    public List<MapSet> getMapSet() {
        if (mapSet == null) {
            mapSet = new ArrayList<MapSet>();
        }
        return this.mapSet;
    }

}
