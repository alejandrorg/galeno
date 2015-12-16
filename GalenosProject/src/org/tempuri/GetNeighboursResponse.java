
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfNeighbour;


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
 *         &lt;element name="GetNeighboursResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfNeighbour" minOccurs="0"/>
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
    "getNeighboursResult"
})
@XmlRootElement(name = "GetNeighboursResponse")
public class GetNeighboursResponse {

    @XmlElementRef(name = "GetNeighboursResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfNeighbour> getNeighboursResult;

    /**
     * Gets the value of the getNeighboursResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNeighbour }{@code >}
     *     
     */
    public JAXBElement<ArrayOfNeighbour> getGetNeighboursResult() {
        return getNeighboursResult;
    }

    /**
     * Sets the value of the getNeighboursResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNeighbour }{@code >}
     *     
     */
    public void setGetNeighboursResult(JAXBElement<ArrayOfNeighbour> value) {
        this.getNeighboursResult = (value);
    }

}
