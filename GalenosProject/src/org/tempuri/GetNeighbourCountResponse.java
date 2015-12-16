
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfNeighbourCountResult;


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
 *         &lt;element name="GetNeighbourCountResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfNeighbourCountResult" minOccurs="0"/>
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
    "getNeighbourCountResult"
})
@XmlRootElement(name = "GetNeighbourCountResponse")
public class GetNeighbourCountResponse {

    @XmlElementRef(name = "GetNeighbourCountResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfNeighbourCountResult> getNeighbourCountResult;

    /**
     * Gets the value of the getNeighbourCountResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNeighbourCountResult }{@code >}
     *     
     */
    public JAXBElement<ArrayOfNeighbourCountResult> getGetNeighbourCountResult() {
        return getNeighbourCountResult;
    }

    /**
     * Sets the value of the getNeighbourCountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNeighbourCountResult }{@code >}
     *     
     */
    public void setGetNeighbourCountResult(JAXBElement<ArrayOfNeighbourCountResult> value) {
        this.getNeighbourCountResult = (value);
    }

}
