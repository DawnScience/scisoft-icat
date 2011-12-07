
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for icatAuthorisation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="icatAuthorisation">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="elementId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elementType" type="{client.icat3.uk}elementType" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="role" type="{client.icat3.uk}icatRole" minOccurs="0"/>
 *         &lt;element name="userChildRecord" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "icatAuthorisation", propOrder = {
    "elementId",
    "elementType",
    "id",
    "role",
    "userChildRecord",
    "userId"
})
public class IcatAuthorisation
    extends EntityBaseBean
{

    protected Long elementId;
    protected ElementType elementType;
    protected Long id;
    protected IcatRole role;
    protected Long userChildRecord;
    protected String userId;

    /**
     * Gets the value of the elementId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElementId() {
        return elementId;
    }

    /**
     * Sets the value of the elementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElementId(Long value) {
        this.elementId = value;
    }

    /**
     * Gets the value of the elementType property.
     * 
     * @return
     *     possible object is
     *     {@link ElementType }
     *     
     */
    public ElementType getElementType() {
        return elementType;
    }

    /**
     * Sets the value of the elementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementType }
     *     
     */
    public void setElementType(ElementType value) {
        this.elementType = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link IcatRole }
     *     
     */
    public IcatRole getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcatRole }
     *     
     */
    public void setRole(IcatRole value) {
        this.role = value;
    }

    /**
     * Gets the value of the userChildRecord property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserChildRecord() {
        return userChildRecord;
    }

    /**
     * Sets the value of the userChildRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserChildRecord(Long value) {
        this.userChildRecord = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
