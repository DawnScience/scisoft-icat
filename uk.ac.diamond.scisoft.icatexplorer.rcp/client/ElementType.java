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
