
package uk.icat3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keywordDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="keywordDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caseSensitive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="investigationInclude" type="{client.icat3.uk}investigationInclude" minOccurs="0"/>
 *         &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keywordDetails", propOrder = {
    "caseSensitive",
    "investigationInclude",
    "keywords"
})
public class KeywordDetails {

    protected boolean caseSensitive;
    protected InvestigationInclude investigationInclude;
    @XmlElement(nillable = true)
    protected List<String> keywords;

    /**
     * Gets the value of the caseSensitive property.
     * 
     */
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Sets the value of the caseSensitive property.
     * 
     */
    public void setCaseSensitive(boolean value) {
        this.caseSensitive = value;
    }

    /**
     * Gets the value of the investigationInclude property.
     * 
     * @return
     *     possible object is
     *     {@link InvestigationInclude }
     *     
     */
    public InvestigationInclude getInvestigationInclude() {
        return investigationInclude;
    }

    /**
     * Sets the value of the investigationInclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvestigationInclude }
     *     
     */
    public void setInvestigationInclude(InvestigationInclude value) {
        this.investigationInclude = value;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<String>();
        }
        return this.keywords;
    }

}
