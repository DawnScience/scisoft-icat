
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relatedDatafiles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedDatafiles">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="relatedDatafilesPK" type="{client.icat3.uk}relatedDatafilesPK" minOccurs="0"/>
 *         &lt;element name="relation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedDatafiles", propOrder = {
    "relatedDatafilesPK",
    "relation"
})
public class RelatedDatafiles
    extends EntityBaseBean
{

    protected RelatedDatafilesPK relatedDatafilesPK;
    protected String relation;

    /**
     * Gets the value of the relatedDatafilesPK property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedDatafilesPK }
     *     
     */
    public RelatedDatafilesPK getRelatedDatafilesPK() {
        return relatedDatafilesPK;
    }

    /**
     * Sets the value of the relatedDatafilesPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedDatafilesPK }
     *     
     */
    public void setRelatedDatafilesPK(RelatedDatafilesPK value) {
        this.relatedDatafilesPK = value;
    }

    /**
     * Gets the value of the relation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelation() {
        return relation;
    }

    /**
     * Sets the value of the relation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelation(String value) {
        this.relation = value;
    }

}
