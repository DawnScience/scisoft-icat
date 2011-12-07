
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shift complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shift">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="shiftComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shiftPK" type="{client.icat3.uk}shiftPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shift", propOrder = {
    "shiftComment",
    "shiftPK"
})
public class Shift
    extends EntityBaseBean
{

    protected String shiftComment;
    protected ShiftPK shiftPK;

    /**
     * Gets the value of the shiftComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftComment() {
        return shiftComment;
    }

    /**
     * Sets the value of the shiftComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftComment(String value) {
        this.shiftComment = value;
    }

    /**
     * Gets the value of the shiftPK property.
     * 
     * @return
     *     possible object is
     *     {@link ShiftPK }
     *     
     */
    public ShiftPK getShiftPK() {
        return shiftPK;
    }

    /**
     * Sets the value of the shiftPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShiftPK }
     *     
     */
    public void setShiftPK(ShiftPK value) {
        this.shiftPK = value;
    }

}
