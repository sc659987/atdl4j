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


/**
 * <p>Java class for Market_t complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Market_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="MICCode" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[A-Z0-9]{4}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="inclusion" use="required" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Inclusion_t" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Market_t")
public class MarketT {

    @XmlAttribute(name = "MICCode", required = true)
    protected String micCode;
    @XmlAttribute(required = true)
    protected InclusionT inclusion;

    /**
     * Gets the value of the micCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMICCode() {
        return micCode;
    }

    /**
     * Sets the value of the micCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMICCode(String value) {
        this.micCode = value;
    }

    /**
     * Gets the value of the inclusion property.
     *
     * @return possible object is
     * {@link InclusionT }
     */
    public InclusionT getInclusion() {
        return inclusion;
    }

    /**
     * Sets the value of the inclusion property.
     *
     * @param value allowed object is
     *              {@link InclusionT }
     */
    public void setInclusion(InclusionT value) {
        this.inclusion = value;
    }

}
