
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfRelType;


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
 *         &lt;element name="GetRelTypesResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfRelType" minOccurs="0"/>
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
    "getRelTypesResult"
})
@XmlRootElement(name = "GetRelTypesResponse")
public class GetRelTypesResponse {

    @XmlElementRef(name = "GetRelTypesResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRelType> getRelTypesResult;

    /**
     * Gets the value of the getRelTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRelType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRelType> getGetRelTypesResult() {
        return getRelTypesResult;
    }

    /**
     * Sets the value of the getRelTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRelType }{@code >}
     *     
     */
    public void setGetRelTypesResult(JAXBElement<ArrayOfRelType> value) {
        this.getRelTypesResult = (value);
    }

}
