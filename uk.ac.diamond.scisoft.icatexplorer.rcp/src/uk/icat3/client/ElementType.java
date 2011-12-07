
package uk.icat3.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for elementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="elementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STUDY"/>
 *     &lt;enumeration value="INVESTIGATION"/>
 *     &lt;enumeration value="INVESTIGATOR"/>
 *     &lt;enumeration value="KEYWORD"/>
 *     &lt;enumeration value="SAMPLE"/>
 *     &lt;enumeration value="SAMPLE_PARAMETER"/>
 *     &lt;enumeration value="PUBLICATION"/>
 *     &lt;enumeration value="DATASET"/>
 *     &lt;enumeration value="DATASET_PARAMETER"/>
 *     &lt;enumeration value="DATAFILE"/>
 *     &lt;enumeration value="DATAFILE_PARAMETER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "elementType")
@XmlEnum
public enum ElementType {

    STUDY,
    INVESTIGATION,
    INVESTIGATOR,
    KEYWORD,
    SAMPLE,
    SAMPLE_PARAMETER,
    PUBLICATION,
    DATASET,
    DATASET_PARAMETER,
    DATAFILE,
    DATAFILE_PARAMETER;

    public String value() {
        return name();
    }

    public static ElementType fromValue(String v) {
        return valueOf(v);
    }

}
