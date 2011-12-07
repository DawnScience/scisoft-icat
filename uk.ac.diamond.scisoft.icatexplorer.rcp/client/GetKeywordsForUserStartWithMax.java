
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getKeywordsForUserStartWithMax complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getKeywordsForUserStartWithMax">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startKeyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberReturned" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getKeywordsForUserStartWithMax", propOrder = {
    "sessionId",
    "startKeyword",
    "numberReturned"
})
public class GetKeywordsForUserStartWithMax {

    protected String sessionId;
    protected String startKeyword;
    protected int numberReturned;

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
     * Gets the value of the startKeyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartKeyword() {
        return startKeyword;
    }

    /**
     * Sets the value of the startKeyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartKeyword(String value) {
        this.startKeyword = value;
    }

    /**
     * Gets the value of the numberReturned property.
     * 
     */
    public int getNumberReturned() {
        return numberReturned;
    }

    /**
     * Sets the value of the numberReturned property.
     * 
     */
    public void setNumberReturned(int value) {
        this.numberReturned = value;
    }

}
