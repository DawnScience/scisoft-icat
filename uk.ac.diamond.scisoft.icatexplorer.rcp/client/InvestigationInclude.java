
package uk.icat3.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for investigationInclude.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="investigationInclude">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INVESTIGATORS_ONLY"/>
 *     &lt;enumeration value="KEYWORDS_ONLY"/>
 *     &lt;enumeration value="PUBLICATIONS_ONLY"/>
 *     &lt;enumeration value="INVESTIGATORS_AND_KEYWORDS"/>
 *     &lt;enumeration value="INVESTIGATORS_AND_SHIFTS"/>
 *     &lt;enumeration value="INVESTIGATORS_SHIFTS_AND_SAMPLES"/>
 *     &lt;enumeration value="INVESTIGATORS_SHIFTS_SAMPLES_AND_PUBLICATIONS"/>
 *     &lt;enumeration value="DATASETS_ONLY"/>
 *     &lt;enumeration value="DATASETS_AND_DATASET_PARAMETERS_ONLY"/>
 *     &lt;enumeration value="DATASETS_AND_DATAFILES"/>
 *     &lt;enumeration value="DATASETS_DATAFILES_AND_PARAMETERS"/>
 *     &lt;enumeration value="SAMPLES_ONLY"/>
 *     &lt;enumeration value="ROLE_ONLY"/>
 *     &lt;enumeration value="SHIFT_ONLY"/>
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="ALL_EXCEPT_DATASETS_AND_DATAFILES"/>
 *     &lt;enumeration value="ALL_EXCEPT_DATASETS_DATAFILES_AND_ROLES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "investigationInclude")
@XmlEnum
public enum InvestigationInclude {

    INVESTIGATORS_ONLY,
    KEYWORDS_ONLY,
    PUBLICATIONS_ONLY,
    INVESTIGATORS_AND_KEYWORDS,
    INVESTIGATORS_AND_SHIFTS,
    INVESTIGATORS_SHIFTS_AND_SAMPLES,
    INVESTIGATORS_SHIFTS_SAMPLES_AND_PUBLICATIONS,
    DATASETS_ONLY,
    DATASETS_AND_DATASET_PARAMETERS_ONLY,
    DATASETS_AND_DATAFILES,
    DATASETS_DATAFILES_AND_PARAMETERS,
    SAMPLES_ONLY,
    ROLE_ONLY,
    SHIFT_ONLY,
    ALL,
    NONE,
    ALL_EXCEPT_DATASETS_AND_DATAFILES,
    ALL_EXCEPT_DATASETS_DATAFILES_AND_ROLES;

    public String value() {
        return name();
    }

    public static InvestigationInclude fromValue(String v) {
        return valueOf(v);
    }

}
