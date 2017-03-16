//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//


package org.atdl4j.fixatdl.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Derived parameter type corresponding to the FIX "Data" type defined in the FIX specification.
 * <p>
 * <p>Java class for Data_t complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Data_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Parameter_t">
 *       &lt;attribute name="minLength" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Length" />
 *       &lt;attribute name="maxLength" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Length" />
 *       &lt;attribute name="constValue" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}data" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data_t")
public class DataT
        extends ParameterT {

    @XmlAttribute
    protected BigInteger minLength;
    @XmlAttribute
    protected BigInteger maxLength;
    @XmlAttribute
    protected String constValue;

    /**
     * Gets the value of the minLength property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the constValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getConstValue() {
        return constValue;
    }

    /**
     * Sets the value of the constValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setConstValue(String value) {
        this.constValue = value;
    }

}
