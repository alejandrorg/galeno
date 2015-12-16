
package org.datacontract.schemas._2004._07.snapiwcfservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.system_data_objects.ComplexObject;


/**
 * <p>Java class for Favourite complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Favourite">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}ComplexObject">
 *       &lt;sequence>
 *         &lt;element name="FavouriteId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FavouriteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PrivateSharedFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Favourite", propOrder = {
    "favouriteId",
    "favouriteName",
    "memberCount",
    "privateSharedFlag"
})
public class Favourite
    extends ComplexObject
{

    @XmlElementRef(name = "FavouriteId", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> favouriteId;
    @XmlElementRef(name = "FavouriteName", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> favouriteName;
    @XmlElementRef(name = "MemberCount", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> memberCount;
    @XmlElementRef(name = "PrivateSharedFlag", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> privateSharedFlag;

    /**
     * Gets the value of the favouriteId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFavouriteId() {
        return favouriteId;
    }

    /**
     * Sets the value of the favouriteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFavouriteId(JAXBElement<Long> value) {
        this.favouriteId = (value);
    }

    /**
     * Gets the value of the favouriteName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFavouriteName() {
        return favouriteName;
    }

    /**
     * Sets the value of the favouriteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFavouriteName(JAXBElement<String> value) {
        this.favouriteName = (value);
    }

    /**
     * Gets the value of the memberCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMemberCount() {
        return memberCount;
    }

    /**
     * Sets the value of the memberCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMemberCount(JAXBElement<Integer> value) {
        this.memberCount = (value);
    }

    /**
     * Gets the value of the privateSharedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrivateSharedFlag() {
        return privateSharedFlag;
    }

    /**
     * Sets the value of the privateSharedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrivateSharedFlag(JAXBElement<String> value) {
        this.privateSharedFlag = (value);
    }

}
