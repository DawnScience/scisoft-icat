
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getKeywordsForUserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getKeywordsForUserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keywordType" type="{client.icat3.uk}keywordType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getKeywordsForUserType", propOrder = {
    "sessionId",
    "keywordType"
})
public class GetKeywordsForUserType {

    protected String sessionId;
    protected KeywordType keywordType;

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
     * Gets the value of the keywordType property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordType }
     *     
     */
    public KeywordType getKeywordType() {
        return keywordType;
    }

    /**
     * Sets the value of the keywordType property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordType }
     *     
     */
    public void setKeywordType(KeywordType value) {
        this.keywordType = value;
    }

}
