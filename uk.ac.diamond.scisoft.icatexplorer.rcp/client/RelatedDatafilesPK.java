
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relatedDatafilesPK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedDatafilesPK">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityPrimaryKeyBaseBean">
 *       &lt;sequence>
 *         &lt;element name="destDatafileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sourceDatafileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedDatafilesPK", propOrder = {
    "destDatafileId",
    "sourceDatafileId"
})
public class RelatedDatafilesPK
    extends EntityPrimaryKeyBaseBean
{

    protected Long destDatafileId;
    protected Long sourceDatafileId;

    /**
     * Gets the value of the destDatafileId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDestDatafileId() {
        return destDatafileId;
    }

    /**
     * Sets the value of the destDatafileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDestDatafileId(Long value) {
        this.destDatafileId = value;
    }

    /**
     * Gets the value of the sourceDatafileId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSourceDatafileId() {
        return sourceDatafileId;
    }

    /**
     * Sets the value of the sourceDatafileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSourceDatafileId(Long value) {
        this.sourceDatafileId = value;
    }

}
