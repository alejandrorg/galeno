
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfMapSet;


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
 *         &lt;element name="GetCrossMapSetResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfMapSet" minOccurs="0"/>
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
    "getCrossMapSetResult"
})
@XmlRootElement(name = "GetCrossMapSetResponse")
public class GetCrossMapSetResponse {

    @XmlElementRef(name = "GetCrossMapSetResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMapSet> getCrossMapSetResult;

    /**
     * Gets the value of the getCrossMapSetResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMapSet }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMapSet> getGetCrossMapSetResult() {
        return getCrossMapSetResult;
    }

    /**
     * Sets the value of the getCrossMapSetResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMapSet }{@code >}
     *     
     */
    public void setGetCrossMapSetResult(JAXBElement<ArrayOfMapSet> value) {
        this.getCrossMapSetResult = (value);
    }

}
