
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchByKeywordsAll complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchByKeywordsAll">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keywordDetails" type="{client.icat3.uk}keywordDetails" minOccurs="0"/>
 *         &lt;element name="startIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfResults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchByKeywordsAll", propOrder = {
    "sessionId",
    "keywordDetails",
    "startIndex",
    "numberOfResults"
})
public class SearchByKeywordsAll {

    protected String sessionId;
    protected KeywordDetails keywordDetails;
    protected int startIndex;
    protected int numberOfResults;

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
     * Gets the value of the keywordDetails property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordDetails }
     *     
     */
    public KeywordDetails getKeywordDetails() {
        return keywordDetails;
    }

    /**
     * Sets the value of the keywordDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordDetails }
     *     
     */
    public void setKeywordDetails(KeywordDetails value) {
        this.keywordDetails = value;
    }

    /**
     * Gets the value of the startIndex property.
     * 
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the value of the startIndex property.
     * 
     */
    public void setStartIndex(int value) {
        this.startIndex = value;
    }

    /**
     * Gets the value of the numberOfResults property.
     * 
     */
    public int getNumberOfResults() {
        return numberOfResults;
    }

    /**
     * Sets the value of the numberOfResults property.
     * 
     */
    public void setNumberOfResults(int value) {
        this.numberOfResults = value;
    }

}
