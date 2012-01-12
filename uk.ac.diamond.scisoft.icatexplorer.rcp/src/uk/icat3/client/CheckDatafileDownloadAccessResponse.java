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
 * Java class for checkDatafileDownloadAccessResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="checkDatafileDownloadAccessResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="downloadInfo" type="{client.icat3.uk}downloadInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkDatafileDownloadAccessResponse", propOrder = { "downloadInfo" })
public class CheckDatafileDownloadAccessResponse {

	protected DownloadInfo downloadInfo;

	/**
	 * Gets the value of the downloadInfo property.
	 * 
	 * @return possible object is {@link DownloadInfo }
	 * 
	 */
	public DownloadInfo getDownloadInfo() {
		return downloadInfo;
	}

	/**
	 * Sets the value of the downloadInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DownloadInfo }
	 * 
	 */
	public void setDownloadInfo(DownloadInfo value) {
		this.downloadInfo = value;
	}

}
