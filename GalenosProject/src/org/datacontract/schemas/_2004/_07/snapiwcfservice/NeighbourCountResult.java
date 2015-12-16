
package org.datacontract.schemas._2004._07.snapiwcfservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.system_data_objects.ComplexObject;


/**
 * <p>Java class for NeighbourCountResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NeighbourCountResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}ComplexObject">
 *       &lt;sequence>
 *         &lt;element name="ConceptFullySpecifiedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="NeighbourCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PorCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="RelTypeFullySpecifiedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NeighbourCountResult", propOrder = {
    "conceptFullySpecifiedName",
    "conceptId",
    "neighbourCount",
    "porCH",
    "relType",
    "relTypeFullySpecifiedName"
})
public class NeighbourCountResult
    extends ComplexObject
{

    @XmlElementRef(name = "ConceptFullySpecifiedName", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> conceptFullySpecifiedName;
    @XmlElementRef(name = "ConceptId", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> conceptId;
    @XmlElementRef(name = "NeighbourCount", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> neighbourCount;
    @XmlElementRef(name = "PorCH", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> porCH;
    @XmlElementRef(name = "RelType", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> relType;
    @XmlElementRef(name = "RelTypeFullySpecifiedName", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relTypeFullySpecifiedName;

    /**
     * Gets the value of the conceptFullySpecifiedName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConceptFullySpecifiedName() {
        return conceptFullySpecifiedName;
    }

    /**
     * Sets the value of the conceptFullySpecifiedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConceptFullySpecifiedName(JAXBElement<String> value) {
        this.conceptFullySpecifiedName = (value);
    }

    /**
     * Gets the value of the conceptId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getConceptId() {
        return conceptId;
    }

    /**
     * Sets the value of the conceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setConceptId(JAXBElement<Long> value) {
        this.conceptId = (value);
    }

    /**
     * Gets the value of the neighbourCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNeighbourCount() {
        return neighbourCount;
    }

    /**
     * Sets the value of the neighbourCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNeighbourCount(JAXBElement<Integer> value) {
        this.neighbourCount = (value);
    }

    /**
     * Gets the value of the porCH property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPorCH() {
        return porCH;
    }

    /**
     * Sets the value of the porCH property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPorCH(JAXBElement<String> value) {
        this.porCH = (value);
    }

    /**
     * Gets the value of the relType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRelType() {
        return relType;
    }

    /**
     * Sets the value of the relType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRelType(JAXBElement<Long> value) {
        this.relType = (value);
    }

    /**
     * Gets the value of the relTypeFullySpecifiedName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelTypeFullySpecifiedName() {
        return relTypeFullySpecifiedName;
    }

    /**
     * Sets the value of the relTypeFullySpecifiedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelTypeFullySpecifiedName(JAXBElement<String> value) {
        this.relTypeFullySpecifiedName = (value);
    }

}
