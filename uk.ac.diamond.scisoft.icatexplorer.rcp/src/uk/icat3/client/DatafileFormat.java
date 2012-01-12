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
 * Java class for datafileFormat complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="datafileFormat">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="datafileFormatPK" type="{client.icat3.uk}datafileFormatPK" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formatType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datafileFormat", propOrder = { "datafileFormatPK",
		"description", "formatType" })
public class DatafileFormat extends EntityBaseBean {

	protected DatafileFormatPK datafileFormatPK;
	protected String description;
	protected String formatType;

	/**
	 * Gets the value of the datafileFormatPK property.
	 * 
	 * @return possible object is {@link DatafileFormatPK }
	 * 
	 */
	public DatafileFormatPK getDatafileFormatPK() {
		return datafileFormatPK;
	}

	/**
	 * Sets the value of the datafileFormatPK property.
	 * 
	 * @param value
	 *            allowed object is {@link DatafileFormatPK }
	 * 
	 */
	public void setDatafileFormatPK(DatafileFormatPK value) {
		this.datafileFormatPK = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the formatType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFormatType() {
		return formatType;
	}

	/**
	 * Sets the value of the formatType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFormatType(String value) {
		this.formatType = value;
	}

}
