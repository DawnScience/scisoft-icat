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
