
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfICD10Description;


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
 *         &lt;element name="GetICD10DescriptionResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfICD10Description" minOccurs="0"/>
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
    "getICD10DescriptionResult"
})
@XmlRootElement(name = "GetICD10DescriptionResponse")
public class GetICD10DescriptionResponse {

    @XmlElementRef(name = "GetICD10DescriptionResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfICD10Description> getICD10DescriptionResult;

    /**
     * Gets the value of the getICD10DescriptionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfICD10Description }{@code >}
     *     
     */
    public JAXBElement<ArrayOfICD10Description> getGetICD10DescriptionResult() {
        return getICD10DescriptionResult;
    }

    /**
     * Sets the value of the getICD10DescriptionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfICD10Description }{@code >}
     *     
     */
    public void setGetICD10DescriptionResult(JAXBElement<ArrayOfICD10Description> value) {
        this.getICD10DescriptionResult = (value);
    }

}
