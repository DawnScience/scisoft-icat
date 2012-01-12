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
 * Java class for investigator complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="investigator">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="facilityUser" type="{client.icat3.uk}facilityUser" minOccurs="0"/>
 *         &lt;element name="investigatorPK" type="{client.icat3.uk}investigatorPK" minOccurs="0"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "investigator", propOrder = { "facilityUser", "investigatorPK",
		"role" })
public class Investigator extends EntityBaseBean {

	protected FacilityUser facilityUser;
	protected InvestigatorPK investigatorPK;
	protected String role;

	/**
	 * Gets the value of the facilityUser property.
	 * 
	 * @return possible object is {@link FacilityUser }
	 * 
	 */
	public FacilityUser getFacilityUser() {
		return facilityUser;
	}

	/**
	 * Sets the value of the facilityUser property.
	 * 
	 * @param value
	 *            allowed object is {@link FacilityUser }
	 * 
	 */
	public void setFacilityUser(FacilityUser value) {
		this.facilityUser = value;
	}

	/**
	 * Gets the value of the investigatorPK property.
	 * 
	 * @return possible object is {@link InvestigatorPK }
	 * 
	 */
	public InvestigatorPK getInvestigatorPK() {
		return investigatorPK;
	}

	/**
	 * Sets the value of the investigatorPK property.
	 * 
	 * @param value
	 *            allowed object is {@link InvestigatorPK }
	 * 
	 */
	public void setInvestigatorPK(InvestigatorPK value) {
		this.investigatorPK = value;
	}

	/**
	 * Gets the value of the role property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the value of the role property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRole(String value) {
		this.role = value;
	}

}
