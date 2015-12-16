
package org.datacontract.schemas._2004._07.snapiwcfservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.system_data_objects.ComplexObject;


/**
 * <p>Java class for Description complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Description">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}ComplexObject">
 *       &lt;sequence>
 *         &lt;element name="ConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DescriptionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DescriptionStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="DescriptionType" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IbitialCapitalStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="LanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Term" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Description", propOrder = {
    "conceptId",
    "descriptionId",
    "descriptionStatus",
    "descriptionType",
    "ibitialCapitalStatus",
    "languageCode",
    "term"
})
public class Description
    extends ComplexObject
{

    @XmlElement(name = "ConceptId")
    protected Long conceptId;
    @XmlElement(name = "DescriptionId")
    protected Long descriptionId;
    @XmlElement(name = "DescriptionStatus")
    @XmlSchemaType(name = "unsignedByte")
    protected Short descriptionStatus;
    @XmlElement(name = "DescriptionType")
    @XmlSchemaType(name = "unsignedByte")
    protected Short descriptionType;
    @XmlElementRef(name = "IbitialCapitalStatus", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> ibitialCapitalStatus;
    @XmlElementRef(name = "LanguageCode", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> languageCode;
    @XmlElementRef(name = "Term", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> term;

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
     * Gets the value of the descriptionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDescriptionId() {
        return descriptionId;
    }

    /**
     * Sets the value of the descriptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDescriptionId(Long value) {
        this.descriptionId = value;
    }

    /**
     * Gets the value of the descriptionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDescriptionStatus() {
        return descriptionStatus;
    }

    /**
     * Sets the value of the descriptionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDescriptionStatus(Short value) {
        this.descriptionStatus = value;
    }

    /**
     * Gets the value of the descriptionType property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDescriptionType() {
        return descriptionType;
    }

    /**
     * Sets the value of the descriptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDescriptionType(Short value) {
        this.descriptionType = value;
    }

    /**
     * Gets the value of the ibitialCapitalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getIbitialCapitalStatus() {
        return ibitialCapitalStatus;
    }

    /**
     * Sets the value of the ibitialCapitalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setIbitialCapitalStatus(JAXBElement<Short> value) {
        this.ibitialCapitalStatus = (value);
    }

    /**
     * Gets the value of the languageCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguageCode() {
        return languageCode;
    }

    /**
     * Sets the value of the languageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguageCode(JAXBElement<String> value) {
        this.languageCode = (value);
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTerm(JAXBElement<String> value) {
        this.term = (value);
    }

}
