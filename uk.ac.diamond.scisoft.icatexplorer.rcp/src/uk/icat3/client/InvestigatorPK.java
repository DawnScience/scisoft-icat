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
 * Java class for investigatorPK complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="investigatorPK">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityPrimaryKeyBaseBean">
 *       &lt;sequence>
 *         &lt;element name="facilityUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "investigatorPK", propOrder = { "facilityUserId",
		"investigationId" })
public class InvestigatorPK extends EntityPrimaryKeyBaseBean {

	protected String facilityUserId;
	protected Long investigationId;

	/**
	 * Gets the value of the facilityUserId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFacilityUserId() {
		return facilityUserId;
	}

	/**
	 * Sets the value of the facilityUserId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFacilityUserId(String value) {
		this.facilityUserId = value;
	}

	/**
	 * Gets the value of the investigationId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getInvestigationId() {
		return investigationId;
	}

	/**
	 * Sets the value of the investigationId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setInvestigationId(Long value) {
		this.investigationId = value;
	}

}
