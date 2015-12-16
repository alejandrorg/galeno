
package org.datacontract.schemas._2004._07.snapiwcfservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.system_data_objects.ComplexObject;


/**
 * <p>Java class for MapSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}ComplexObject">
 *       &lt;sequence>
 *         &lt;element name="MapSetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MapSetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapSetRealmId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapSetRuleType" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="MapSetSchemeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapSetSchemeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapSetSchemeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapSetSeparator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapSetType" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapSet", propOrder = {
    "mapSetId",
    "mapSetName",
    "mapSetRealmId",
    "mapSetRuleType",
    "mapSetSchemeId",
    "mapSetSchemeName",
    "mapSetSchemeVersion",
    "mapSetSeparator",
    "mapSetType"
})
public class MapSet
    extends ComplexObject
{

    @XmlElement(name = "MapSetId")
    protected Long mapSetId;
    @XmlElementRef(name = "MapSetName", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mapSetName;
    @XmlElementRef(name = "MapSetRealmId", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mapSetRealmId;
    @XmlElementRef(name = "MapSetRuleType", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> mapSetRuleType;
    @XmlElementRef(name = "MapSetSchemeId", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mapSetSchemeId;
    @XmlElementRef(name = "MapSetSchemeName", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mapSetSchemeName;
    @XmlElementRef(name = "MapSetSchemeVersion", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mapSetSchemeVersion;
    @XmlElementRef(name = "MapSetSeparator", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mapSetSeparator;
    @XmlElementRef(name = "MapSetType", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> mapSetType;

    /**
     * Gets the value of the mapSetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMapSetId() {
        return mapSetId;
    }

    /**
     * Sets the value of the mapSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMapSetId(Long value) {
        this.mapSetId = value;
    }

    /**
     * Gets the value of the mapSetName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMapSetName() {
        return mapSetName;
    }

    /**
     * Sets the value of the mapSetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMapSetName(JAXBElement<String> value) {
        this.mapSetName = (value);
    }

    /**
     * Gets the value of the mapSetRealmId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMapSetRealmId() {
        return mapSetRealmId;
    }

    /**
     * Sets the value of the mapSetRealmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMapSetRealmId(JAXBElement<String> value) {
        this.mapSetRealmId = (value);
    }

    /**
     * Gets the value of the mapSetRuleType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getMapSetRuleType() {
        return mapSetRuleType;
    }

    /**
     * Sets the value of the mapSetRuleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setMapSetRuleType(JAXBElement<Short> value) {
        this.mapSetRuleType = (value);
    }

    /**
     * Gets the value of the mapSetSchemeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMapSetSchemeId() {
        return mapSetSchemeId;
    }

    /**
     * Sets the value of the mapSetSchemeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMapSetSchemeId(JAXBElement<String> value) {
        this.mapSetSchemeId = (value);
    }

    /**
     * Gets the value of the mapSetSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMapSetSchemeName() {
        return mapSetSchemeName;
    }

    /**
     * Sets the value of the mapSetSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMapSetSchemeName(JAXBElement<String> value) {
        this.mapSetSchemeName = (value);
    }

    /**
     * Gets the value of the mapSetSchemeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMapSetSchemeVersion() {
        return mapSetSchemeVersion;
    }

    /**
     * Sets the value of the mapSetSchemeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMapSetSchemeVersion(JAXBElement<String> value) {
        this.mapSetSchemeVersion = (value);
    }

    /**
     * Gets the value of the mapSetSeparator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMapSetSeparator() {
        return mapSetSeparator;
    }

    /**
     * Sets the value of the mapSetSeparator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMapSetSeparator(JAXBElement<String> value) {
        this.mapSetSeparator = (value);
    }

    /**
     * Gets the value of the mapSetType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getMapSetType() {
        return mapSetType;
    }

    /**
     * Sets the value of the mapSetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setMapSetType(JAXBElement<Short> value) {
        this.mapSetType = (value);
    }

}
