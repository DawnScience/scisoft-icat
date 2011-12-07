
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keyword complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="keyword">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="keywordPK" type="{client.icat3.uk}keywordPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keyword", propOrder = {
    "keywordPK"
})
public class Keyword
    extends EntityBaseBean
{

    protected KeywordPK keywordPK;

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
