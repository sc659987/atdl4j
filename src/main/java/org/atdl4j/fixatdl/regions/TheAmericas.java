//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//


package org.atdl4j.fixatdl.regions;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for null.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType>
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AI"/>
 *     &lt;enumeration value="AG"/>
 *     &lt;enumeration value="AR"/>
 *     &lt;enumeration value="AW"/>
 *     &lt;enumeration value="BS"/>
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="BZ"/>
 *     &lt;enumeration value="BM"/>
 *     &lt;enumeration value="BO"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="KY"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CO"/>
 *     &lt;enumeration value="CR"/>
 *     &lt;enumeration value="CU"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="DO"/>
 *     &lt;enumeration value="EC"/>
 *     &lt;enumeration value="SV"/>
 *     &lt;enumeration value="FK"/>
 *     &lt;enumeration value="GD"/>
 *     &lt;enumeration value="GP"/>
 *     &lt;enumeration value="GT"/>
 *     &lt;enumeration value="GY"/>
 *     &lt;enumeration value="HT"/>
 *     &lt;enumeration value="HN"/>
 *     &lt;enumeration value="JM"/>
 *     &lt;enumeration value="MQ"/>
 *     &lt;enumeration value="MX"/>
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="AN"/>
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="PA"/>
 *     &lt;enumeration value="PY"/>
 *     &lt;enumeration value="PE"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="BL"/>
 *     &lt;enumeration value="KN"/>
 *     &lt;enumeration value="LC"/>
 *     &lt;enumeration value="MF"/>
 *     &lt;enumeration value="PM"/>
 *     &lt;enumeration value="VC"/>
 *     &lt;enumeration value="TT"/>
 *     &lt;enumeration value="TC"/>
 *     &lt;enumeration value="US"/>
 *     &lt;enumeration value="UY"/>
 *     &lt;enumeration value="VG"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="VE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "")
@XmlEnum
public enum TheAmericas {

    AI,
    AG,
    AR,
    AW,
    BS,
    BB,
    BZ,
    BM,
    BO,
    BR,
    CA,
    KY,
    CL,
    CO,
    CR,
    CU,
    DM,
    DO,
    EC,
    SV,
    FK,
    GD,
    GP,
    GT,
    GY,
    HT,
    HN,
    JM,
    MQ,
    MX,
    MS,
    AN,
    NI,
    PA,
    PY,
    PE,
    PR,
    BL,
    KN,
    LC,
    MF,
    PM,
    VC,
    TT,
    TC,
    US,
    UY,
    VG,
    VI,
    VE;

    public String value() {
        return name();
    }

    public static TheAmericas fromValue(String v) {
        return valueOf(v);
    }

}
