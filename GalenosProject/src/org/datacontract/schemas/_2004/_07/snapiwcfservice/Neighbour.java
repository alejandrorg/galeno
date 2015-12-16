
package org.datacontract.schemas._2004._07.snapiwcfservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.system_data_objects.ComplexObject;


/**
 * <p>Java class for Neighbour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Neighbour">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses}ComplexObject">
 *       &lt;sequence>
 *         &lt;element name="NameSpaceID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="NeighbourConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="NeighbourFSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PorCHorS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Neighbour", propOrder = {
    "nameSpaceID",
    "neighbourConceptId",
    "neighbourFSN",
    "porCHorS"
})
public class Neighbour
    extends ComplexObject
{

    @XmlElementRef(name = "NameSpaceID", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> nameSpaceID;
    @XmlElement(name = "NeighbourConceptId")
    protected Long neighbourConceptId;
    @XmlElementRef(name = "NeighbourFSN", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> neighbourFSN;
    @XmlElementRef(name = "PorCHorS", namespace = "http://schemas.datacontract.org/2004/07/SnApiWcfService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> porCHorS;

    /**
     * Gets the value of the nameSpaceID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getNameSpaceID() {
        return nameSpaceID;
    }

    /**
     * Sets the value of the nameSpaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setNameSpaceID(JAXBElement<Long> value) {
        this.nameSpaceID = (value);
    }

    /**
     * Gets the value of the neighbourConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNeighbourConceptId() {
        return neighbourConceptId;
    }

    /**
     * Sets the value of the neighbourConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNeighbourConceptId(Long value) {
        this.neighbourConceptId = value;
    }

    /**
     * Gets the value of the neighbourFSN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNeighbourFSN() {
        return neighbourFSN;
    }

    /**
     * Sets the value of the neighbourFSN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNeighbourFSN(JAXBElement<String> value) {
        this.neighbourFSN = (value);
    }

    /**
     * Gets the value of the porCHorS property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPorCHorS() {
        return porCHorS;
    }

    /**
     * Sets the value of the porCHorS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPorCHorS(JAXBElement<String> value) {
        this.porCHorS = (value);
    }

}
