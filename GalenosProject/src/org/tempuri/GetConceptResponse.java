
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfConcept;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetConceptResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfConcept" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getConceptResult"
})
@XmlRootElement(name = "GetConceptResponse")
public class GetConceptResponse {

    @XmlElementRef(name = "GetConceptResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfConcept> getConceptResult;

    /**
     * Gets the value of the getConceptResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfConcept }{@code >}
     *     
     */
    public JAXBElement<ArrayOfConcept> getGetConceptResult() {
        return getConceptResult;
    }

    /**
     * Sets the value of the getConceptResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfConcept }{@code >}
     *     
     */
    public void setGetConceptResult(JAXBElement<ArrayOfConcept> value) {
        this.getConceptResult = (value);
    }

}
