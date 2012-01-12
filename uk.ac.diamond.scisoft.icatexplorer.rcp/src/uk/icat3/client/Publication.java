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
 * Java class for publication complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="publication">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="fullReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="repository" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repositoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publication", propOrder = { "fullReference", "id",
		"repository", "repositoryId", "url" })
public class Publication extends EntityBaseBean {

	protected String fullReference;
	protected Long id;
	protected String repository;
	protected String repositoryId;
	protected String url;

	/**
	 * Gets the value of the fullReference property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFullReference() {
		return fullReference;
	}

	/**
	 * Sets the value of the fullReference property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFullReference(String value) {
		this.fullReference = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setId(Long value) {
		this.id = value;
	}

	/**
	 * Gets the value of the repository property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepository() {
		return repository;
	}

	/**
	 * Sets the value of the repository property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepository(String value) {
		this.repository = value;
	}

	/**
	 * Gets the value of the repositoryId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepositoryId() {
		return repositoryId;
	}

	/**
	 * Sets the value of the repositoryId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepositoryId(String value) {
		this.repositoryId = value;
	}

	/**
	 * Gets the value of the url property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the value of the url property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUrl(String value) {
		this.url = value;
	}

}
