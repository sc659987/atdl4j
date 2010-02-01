//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.30 at 11:18:20 PM JST 
//


package org.atdl4j.atdl.validation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Construct used to build a boolean expression.
 * 
 * <p>Java class for Edit_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Edit_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.fixprotocol.org/ATDL-1-1/Core}Description" minOccurs="0"/>
 *         &lt;element name="Edit" type="{http://www.fixprotocol.org/ATDL-1-1/Validation}Edit_t" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EditRef" type="{http://www.fixprotocol.org/ATDL-1-1/Validation}EditRef_t" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="field" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="field2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operator" type="{http://www.fixprotocol.org/ATDL-1-1/Validation}operator_t" />
 *       &lt;attribute name="logicOperator" type="{http://www.fixprotocol.org/ATDL-1-1/Validation}logicOperator_t" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Edit_t", propOrder = {
    "description",
    "edit",
    "editRef"
})
public class EditT {

    @XmlElement(name = "Description", namespace = "http://www.fixprotocol.org/ATDL-1-1/Core")
    protected String description;
    @XmlElement(name = "Edit")
    protected List<EditT> edit;
    @XmlElement(name = "EditRef")
    protected List<EditRefT> editRef;
    @XmlAttribute
    protected String field;
    @XmlAttribute
    protected String field2;
    @XmlAttribute
    protected String value;
    @XmlAttribute
    protected OperatorT operator;
    @XmlAttribute
    protected LogicOperatorT logicOperator;
    @XmlAttribute
    protected String id;

    /**
     * Description of the Edit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the edit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EditT }
     * 
     * 
     */
    public List<EditT> getEdit() {
        if (edit == null) {
            edit = new ArrayList<EditT>();
        }
        return this.edit;
    }

    /**
     * Gets the value of the editRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the editRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEditRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EditRefT }
     * 
     * 
     */
    public List<EditRefT> getEditRef() {
        if (editRef == null) {
            editRef = new ArrayList<EditRefT>();
        }
        return this.editRef;
    }

    /**
     * Gets the value of the field property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField(String value) {
        this.field = value;
    }

    /**
     * Gets the value of the field2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField2() {
        return field2;
    }

    /**
     * Sets the value of the field2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField2(String value) {
        this.field2 = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorT }
     *     
     */
    public OperatorT getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorT }
     *     
     */
    public void setOperator(OperatorT value) {
        this.operator = value;
    }

    /**
     * Gets the value of the logicOperator property.
     * 
     * @return
     *     possible object is
     *     {@link LogicOperatorT }
     *     
     */
    public LogicOperatorT getLogicOperator() {
        return logicOperator;
    }

    /**
     * Sets the value of the logicOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicOperatorT }
     *     
     */
    public void setLogicOperator(LogicOperatorT value) {
        this.logicOperator = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}