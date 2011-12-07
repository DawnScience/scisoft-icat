
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteDataFileParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteDataFileParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datafileParameterPK" type="{client.icat3.uk}datafileParameterPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteDataFileParameter", propOrder = {
    "sessionId",
    "datafileParameterPK"
})
public class DeleteDataFileParameter {

    protected String sessionId;
    protected DatafileParameterPK datafileParameterPK;

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
     * Gets the value of the datafileParameterPK property.
     * 
     * @return
     *     possible object is
     *     {@link DatafileParameterPK }
     *     
     */
    public DatafileParameterPK getDatafileParameterPK() {
        return datafileParameterPK;
    }

    /**
     * Sets the value of the datafileParameterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatafileParameterPK }
     *     
     */
    public void setDatafileParameterPK(DatafileParameterPK value) {
        this.datafileParameterPK = value;
    }

}
