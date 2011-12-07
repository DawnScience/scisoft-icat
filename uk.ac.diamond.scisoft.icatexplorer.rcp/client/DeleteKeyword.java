
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteKeyword complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteKeyword">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keywordPK" type="{client.icat3.uk}keywordPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteKeyword", propOrder = {
    "sessionId",
    "keywordPK"
})
public class DeleteKeyword {

    protected String sessionId;
    protected KeywordPK keywordPK;

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
     * Gets the value of the keywordPK property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordPK }
     *     
     */
    public KeywordPK getKeywordPK() {
        return keywordPK;
    }

    /**
     * Sets the value of the keywordPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordPK }
     *     
     */
    public void setKeywordPK(KeywordPK value) {
        this.keywordPK = value;
    }

}
