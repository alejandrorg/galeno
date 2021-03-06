
package org.datacontract.schemas._2004._07.system_data_objects;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.system_data_objects package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ComplexObject_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", "ComplexObject");
    private final static QName _StructuralObject_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", "StructuralObject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.system_data_objects
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StructuralObject }
     * 
     */
    public StructuralObject createStructuralObject() {
        return new StructuralObject();
    }

    /**
     * Create an instance of {@link ComplexObject }
     * 
     */
    public ComplexObject createComplexObject() {
        return new ComplexObject();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComplexObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", name = "ComplexObject")
    public JAXBElement<ComplexObject> createComplexObject(ComplexObject value) {
        return new JAXBElement<ComplexObject>(_ComplexObject_QNAME, ComplexObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuralObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", name = "StructuralObject")
    public JAXBElement<StructuralObject> createStructuralObject(StructuralObject value) {
        return new JAXBElement<StructuralObject>(_StructuralObject_QNAME, StructuralObject.class, null, value);
    }

}
