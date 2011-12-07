
package uk.icat3.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keywordType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="keywordType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="ALPHA_NUMERIC"/>
 *     &lt;enumeration value="ALPHA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "keywordType")
@XmlEnum
public enum KeywordType {

    ALL,
    ALPHA_NUMERIC,
    ALPHA;

    public String value() {
        return name();
    }

    public static KeywordType fromValue(String v) {
        return valueOf(v);
    }

}
