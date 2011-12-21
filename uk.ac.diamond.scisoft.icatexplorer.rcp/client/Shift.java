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
 * <p>Java class for shift complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shift">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="shiftComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shiftPK" type="{client.icat3.uk}shiftPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shift", propOrder = {
    "shiftComment",
    "shiftPK"
})
public class Shift
    extends EntityBaseBean
{

    protected String shiftComment;
    protected ShiftPK shiftPK;

    /**
     * Gets the value of the shiftComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftComment() {
        return shiftComment;
    }

    /**
     * Sets the value of the shiftComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftComment(String value) {
        this.shiftComment = value;
    }

    /**
     * Gets the value of the shiftPK property.
     * 
     * @return
     *     possible object is
     *     {@link ShiftPK }
     *     
     */
    public ShiftPK getShiftPK() {
        return shiftPK;
    }

    /**
     * Sets the value of the shiftPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShiftPK }
     *     
     */
    public void setShiftPK(ShiftPK value) {
        this.shiftPK = value;
    }

}
