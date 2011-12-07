
package uk.icat3.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for datafileInclude.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="datafileInclude">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DATAFILE_PARAMETERS"/>
 *     &lt;enumeration value="RELATED_DATAFILES"/>
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "datafileInclude")
@XmlEnum
public enum DatafileInclude {

    DATAFILE_PARAMETERS,
    RELATED_DATAFILES,
    ALL,
    NONE;

    public String value() {
        return name();
    }

    public static DatafileInclude fromValue(String v) {
        return valueOf(v);
    }

}
