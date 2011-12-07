
package uk.icat3.client.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loginAdmin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loginAdmin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="runAsUserFedId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginAdmin", propOrder = {
    "runAsUserFedId"
})
public class LoginAdmin {

    protected String runAsUserFedId;

    /**
     * Gets the value of the runAsUserFedId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunAsUserFedId() {
        return runAsUserFedId;
    }

    /**
     * Sets the value of the runAsUserFedId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunAsUserFedId(String value) {
        this.runAsUserFedId = value;
    }

}
