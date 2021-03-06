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
import java.math.BigDecimal;


/**
 * Derived parameter type corresponding to the FIX "Float" type defined in the FIX specification.
 * <p>
 * <p>Java class for Float_t complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Float_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Numeric_t">
 *       &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="constValue" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Float_t")
public class FloatT
        extends NumericT {

    @XmlAttribute
    protected BigDecimal minValue;
    @XmlAttribute
    protected BigDecimal maxValue;
    @XmlAttribute
    protected BigDecimal constValue;

    /**
     * Gets the value of the minValue property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setMinValue(BigDecimal value) {
        this.minValue = value;
    }

    /**
     * Gets the value of the maxValue property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setMaxValue(BigDecimal value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the constValue property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getConstValue() {
        return constValue;
    }

    /**
     * Sets the value of the constValue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setConstValue(BigDecimal value) {
        this.constValue = value;
    }

}
