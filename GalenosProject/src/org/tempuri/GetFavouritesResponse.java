
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.snapiwcfservice.ArrayOfFavourite;


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
 *         &lt;element name="GetFavouritesResult" type="{http://schemas.datacontract.org/2004/07/SnApiWcfService}ArrayOfFavourite" minOccurs="0"/>
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
    "getFavouritesResult"
})
@XmlRootElement(name = "GetFavouritesResponse")
public class GetFavouritesResponse {

    @XmlElementRef(name = "GetFavouritesResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFavourite> getFavouritesResult;

    /**
     * Gets the value of the getFavouritesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFavourite }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFavourite> getGetFavouritesResult() {
        return getFavouritesResult;
    }

    /**
     * Sets the value of the getFavouritesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFavourite }{@code >}
     *     
     */
    public void setGetFavouritesResult(JAXBElement<ArrayOfFavourite> value) {
        this.getFavouritesResult = (value);
    }

}
