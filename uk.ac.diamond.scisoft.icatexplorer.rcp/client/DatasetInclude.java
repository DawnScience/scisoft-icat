
package uk.icat3.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for datasetInclude.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="datasetInclude">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DATASET_AND_DATAFILES_ONLY"/>
 *     &lt;enumeration value="DATASET_PARAMETERS_ONLY"/>
 *     &lt;enumeration value="DATASET_DATAFILES_AND_PARAMETERS"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "datasetInclude")
@XmlEnum
public enum DatasetInclude {

    DATASET_AND_DATAFILES_ONLY,
    DATASET_PARAMETERS_ONLY,
    DATASET_DATAFILES_AND_PARAMETERS,
    NONE;

    public String value() {
        return name();
    }

    public static DatasetInclude fromValue(String v) {
        return valueOf(v);
    }

}
