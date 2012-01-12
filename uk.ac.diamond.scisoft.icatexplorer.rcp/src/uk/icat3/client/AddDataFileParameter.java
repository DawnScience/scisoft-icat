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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for addDataFileParameter complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="addDataFileParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFileParameter" type="{client.icat3.uk}datafileParameter" minOccurs="0"/>
 *         &lt;element name="datafileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDataFileParameter", propOrder = { "sessionId",
		"dataFileParameter", "datafileId" })
public class AddDataFileParameter {

	protected String sessionId;
	protected DatafileParameter dataFileParameter;
	protected Long datafileId;

	/**
	 * Gets the value of the sessionId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the value of the sessionId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSessionId(String value) {
		this.sessionId = value;
	}

	/**
	 * Gets the value of the dataFileParameter property.
	 * 
	 * @return possible object is {@link DatafileParameter }
	 * 
	 */
	public DatafileParameter getDataFileParameter() {
		return dataFileParameter;
	}

	/**
	 * Sets the value of the dataFileParameter property.
	 * 
	 * @param value
	 *            allowed object is {@link DatafileParameter }
	 * 
	 */
	public void setDataFileParameter(DatafileParameter value) {
		this.dataFileParameter = value;
	}

	/**
	 * Gets the value of the datafileId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getDatafileId() {
		return datafileId;
	}

	/**
	 * Sets the value of the datafileId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setDatafileId(Long value) {
		this.datafileId = value;
	}

}
