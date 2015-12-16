
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfDescription;


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
 *         &lt;element name="GetDescriptionResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfDescription" minOccurs="0"/>
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
    "getDescriptionResult"
})
@XmlRootElement(name = "GetDescriptionResponse")
public class GetDescriptionResponse {

    @XmlElementRef(name = "GetDescriptionResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDescription> getDescriptionResult;

    /**
     * Gets the value of the getDescriptionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDescription }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDescription> getGetDescriptionResult() {
        return getDescriptionResult;
    }

    /**
     * Sets the value of the getDescriptionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDescription }{@code >}
     *     
     */
    public void setGetDescriptionResult(JAXBElement<ArrayOfDescription> value) {
        this.getDescriptionResult = (value);
    }

}
