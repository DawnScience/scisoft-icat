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
 * Java class for NoSuchObjectFoundException complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="NoSuchObjectFoundException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stackTraceAsString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uniqueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoSuchObjectFoundException", propOrder = { "message",
		"stackTraceAsString", "uniqueId" })
public class NoSuchObjectFoundException {

	protected String message;
	protected String stackTraceAsString;
	protected String uniqueId;

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Gets the value of the stackTraceAsString property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStackTraceAsString() {
		return stackTraceAsString;
	}

	/**
	 * Sets the value of the stackTraceAsString property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStackTraceAsString(String value) {
		this.stackTraceAsString = value;
	}

	/**
	 * Gets the value of the uniqueId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Sets the value of the uniqueId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUniqueId(String value) {
		this.uniqueId = value;
	}

}
