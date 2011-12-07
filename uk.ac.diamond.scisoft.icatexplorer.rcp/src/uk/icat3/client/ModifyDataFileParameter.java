
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for modifyDataFileParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="modifyDataFileParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFileParameter" type="{client.icat3.uk}datafileParameter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyDataFileParameter", propOrder = {
    "sessionId",
    "dataFileParameter"
})
public class ModifyDataFileParameter {

    protected String sessionId;
    protected DatafileParameter dataFileParameter;

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the dataFileParameter property.
     * 
     * @return
     *     possible object is
     *     {@link DatafileParameter }
     *     
     */
    public DatafileParameter getDataFileParameter() {
        return dataFileParameter;
    }

    /**
     * Sets the value of the dataFileParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatafileParameter }
     *     
     */
    public void setDataFileParameter(DatafileParameter value) {
        this.dataFileParameter = value;
    }

}
