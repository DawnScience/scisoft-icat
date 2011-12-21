/*
 * Copyright 2012 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
