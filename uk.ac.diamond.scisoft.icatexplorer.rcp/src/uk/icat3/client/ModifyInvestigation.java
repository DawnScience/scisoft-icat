
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for modifyInvestigation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="modifyInvestigation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigaion" type="{client.icat3.uk}investigation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyInvestigation", propOrder = {
    "sessionId",
    "investigaion"
})
public class ModifyInvestigation {

    protected String sessionId;
    protected Investigation investigaion;

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
     * Gets the value of the investigaion property.
     * 
     * @return
     *     possible object is
     *     {@link Investigation }
     *     
     */
    public Investigation getInvestigaion() {
        return investigaion;
    }

    /**
     * Sets the value of the investigaion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Investigation }
     *     
     */
    public void setInvestigaion(Investigation value) {
        this.investigaion = value;
    }

}
