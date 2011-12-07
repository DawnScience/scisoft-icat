
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeInvestigator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeInvestigator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigatorPK" type="{client.icat3.uk}investigatorPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeInvestigator", propOrder = {
    "sessionId",
    "investigatorPK"
})
public class RemoveInvestigator {

    protected String sessionId;
    protected InvestigatorPK investigatorPK;

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
     * Gets the value of the investigatorPK property.
     * 
     * @return
     *     possible object is
     *     {@link InvestigatorPK }
     *     
     */
    public InvestigatorPK getInvestigatorPK() {
        return investigatorPK;
    }

    /**
     * Sets the value of the investigatorPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvestigatorPK }
     *     
     */
    public void setInvestigatorPK(InvestigatorPK value) {
        this.investigatorPK = value;
    }

}
