
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfSubSet;


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
 *         &lt;element name="GetSubSetsResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfSubSet" minOccurs="0"/>
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
    "getSubSetsResult"
})
@XmlRootElement(name = "GetSubSetsResponse")
public class GetSubSetsResponse {

    @XmlElementRef(name = "GetSubSetsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSubSet> getSubSetsResult;

    /**
     * Gets the value of the getSubSetsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSubSet }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSubSet> getGetSubSetsResult() {
        return getSubSetsResult;
    }

    /**
     * Sets the value of the getSubSetsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSubSet }{@code >}
     *     
     */
    public void setGetSubSetsResult(JAXBElement<ArrayOfSubSet> value) {
        this.getSubSetsResult = (value);
    }

}
