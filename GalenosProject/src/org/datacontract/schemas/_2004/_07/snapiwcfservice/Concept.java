
package org.datacontract.schemas._2004._07.snapiwcfservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.system_data_objects.ComplexObject;


/**
 * <p>Java class for Concept complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Concept">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}ComplexObject">
 *       &lt;sequence>
 *         &lt;element name="CTV3ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ConceptStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="FullySpecifiedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsPrimitive" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="LenStr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RootConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SNOMEDID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Concept", propOrder = {
    "ctv3ID",
    "conceptId",
    "conceptStatus",
    "fullySpecifiedName",
    "isPrimitive",
    "lenStr",
    "rootConceptId",
    "snomedid",
    "r",
    "weight"
})
public class Concept
    extends ComplexObject
{

    @XmlElementRef(name = "CTV3ID", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ctv3ID;
    @XmlElement(name = "ConceptId")
    protected Long conceptId;
    @XmlElement(name = "ConceptStatus")
    @XmlSchemaType(name = "unsignedByte")
    protected Short conceptStatus;
    @XmlElementRef(name = "FullySpecifiedName", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fullySpecifiedName;
    @XmlElementRef(name = "IsPrimitive", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> isPrimitive;
    @XmlElementRef(name = "LenStr", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> lenStr;
    @XmlElementRef(name = "RootConceptId", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> rootConceptId;
    @XmlElementRef(name = "SNOMEDID", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> snomedid;
    @XmlElementRef(name = "r", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> r;
    @XmlElementRef(name = "weight", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> weight;

    /**
     * Gets the value of the ctv3ID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCTV3ID() {
        return ctv3ID;
    }

    /**
     * Sets the value of the ctv3ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCTV3ID(JAXBElement<String> value) {
        this.ctv3ID = (value);
    }

    /**
     * Gets the value of the conceptId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConceptId() {
        return conceptId;
    }

    /**
     * Sets the value of the conceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConceptId(Long value) {
        this.conceptId = value;
    }

    /**
     * Gets the value of the conceptStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getConceptStatus() {
        return conceptStatus;
    }

    /**
     * Sets the value of the conceptStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setConceptStatus(Short value) {
        this.conceptStatus = value;
    }

    /**
     * Gets the value of the fullySpecifiedName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFullySpecifiedName() {
        return fullySpecifiedName;
    }

    /**
     * Sets the value of the fullySpecifiedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFullySpecifiedName(JAXBElement<String> value) {
        this.fullySpecifiedName = (value);
    }

    /**
     * Gets the value of the isPrimitive property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getIsPrimitive() {
        return isPrimitive;
    }

    /**
     * Sets the value of the isPrimitive property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setIsPrimitive(JAXBElement<Short> value) {
        this.isPrimitive = (value);
    }

    /**
     * Gets the value of the lenStr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getLenStr() {
        return lenStr;
    }

    /**
     * Sets the value of the lenStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setLenStr(JAXBElement<Integer> value) {
        this.lenStr = (value);
    }

    /**
     * Gets the value of the rootConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRootConceptId() {
        return rootConceptId;
    }

    /**
     * Sets the value of the rootConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRootConceptId(JAXBElement<Long> value) {
        this.rootConceptId = (value);
    }

    /**
     * Gets the value of the snomedid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSNOMEDID() {
        return snomedid;
    }

    /**
     * Sets the value of the snomedid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSNOMEDID(JAXBElement<String> value) {
        this.snomedid = (value);
    }

    /**
     * Gets the value of the r property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setR(JAXBElement<String> value) {
        this.r = (value);
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setWeight(JAXBElement<BigDecimal> value) {
        this.weight = (value);
    }

}
