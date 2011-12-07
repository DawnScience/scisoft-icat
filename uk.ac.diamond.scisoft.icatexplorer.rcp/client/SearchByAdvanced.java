
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchByAdvanced complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchByAdvanced">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advancedSearchDetails" type="{client.icat3.uk}advancedSearchDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchByAdvanced", propOrder = {
    "sessionId",
    "advancedSearchDetails"
})
public class SearchByAdvanced {

    protected String sessionId;
    protected AdvancedSearchDetails advancedSearchDetails;

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
     * Gets the value of the advancedSearchDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancedSearchDetails }
     *     
     */
    public AdvancedSearchDetails getAdvancedSearchDetails() {
        return advancedSearchDetails;
    }

    /**
     * Sets the value of the advancedSearchDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancedSearchDetails }
     *     
     */
    public void setAdvancedSearchDetails(AdvancedSearchDetails value) {
        this.advancedSearchDetails = value;
    }

}
