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
 * Java class for getMyInvestigationsIncludesPagination complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getMyInvestigationsIncludesPagination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigationInclude" type="{client.icat3.uk}investigationInclude" minOccurs="0"/>
 *         &lt;element name="startIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfResults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMyInvestigationsIncludesPagination", propOrder = {
		"sessionId", "investigationInclude", "startIndex", "numberOfResults" })
public class GetMyInvestigationsIncludesPagination {

	protected String sessionId;
	protected InvestigationInclude investigationInclude;
	protected int startIndex;
	protected int numberOfResults;

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
	 * Gets the value of the investigationInclude property.
	 * 
	 * @return possible object is {@link InvestigationInclude }
	 * 
	 */
	public InvestigationInclude getInvestigationInclude() {
		return investigationInclude;
	}

	/**
	 * Sets the value of the investigationInclude property.
	 * 
	 * @param value
	 *            allowed object is {@link InvestigationInclude }
	 * 
	 */
	public void setInvestigationInclude(InvestigationInclude value) {
		this.investigationInclude = value;
	}

	/**
	 * Gets the value of the startIndex property.
	 * 
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * Sets the value of the startIndex property.
	 * 
	 */
	public void setStartIndex(int value) {
		this.startIndex = value;
	}

	/**
	 * Gets the value of the numberOfResults property.
	 * 
	 */
	public int getNumberOfResults() {
		return numberOfResults;
	}

	/**
	 * Sets the value of the numberOfResults property.
	 * 
	 */
	public void setNumberOfResults(int value) {
		this.numberOfResults = value;
	}

}
