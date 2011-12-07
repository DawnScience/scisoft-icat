
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for icatRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="icatRole">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="actionDelete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionDownload" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionFacilityAcquired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionInsert" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionManageUsers" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionRemove" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionRootInsert" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionRootRemove" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionSelect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="actionUpdate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "icatRole", propOrder = {
    "actionDelete",
    "actionDownload",
    "actionFacilityAcquired",
    "actionInsert",
    "actionManageUsers",
    "actionRemove",
    "actionRootInsert",
    "actionRootRemove",
    "actionSelect",
    "actionUpdate",
    "role"
})
public class IcatRole
    extends EntityBaseBean
{

    protected boolean actionDelete;
    protected boolean actionDownload;
    protected boolean actionFacilityAcquired;
    protected boolean actionInsert;
    protected boolean actionManageUsers;
    protected boolean actionRemove;
    protected boolean actionRootInsert;
    protected boolean actionRootRemove;
    protected boolean actionSelect;
    protected boolean actionUpdate;
    protected String role;

    /**
     * Gets the value of the actionDelete property.
     * 
     */
    public boolean isActionDelete() {
        return actionDelete;
    }

    /**
     * Sets the value of the actionDelete property.
     * 
     */
    public void setActionDelete(boolean value) {
        this.actionDelete = value;
    }

    /**
     * Gets the value of the actionDownload property.
     * 
     */
    public boolean isActionDownload() {
        return actionDownload;
    }

    /**
     * Sets the value of the actionDownload property.
     * 
     */
    public void setActionDownload(boolean value) {
        this.actionDownload = value;
    }

    /**
     * Gets the value of the actionFacilityAcquired property.
     * 
     */
    public boolean isActionFacilityAcquired() {
        return actionFacilityAcquired;
    }

    /**
     * Sets the value of the actionFacilityAcquired property.
     * 
     */
    public void setActionFacilityAcquired(boolean value) {
        this.actionFacilityAcquired = value;
    }

    /**
     * Gets the value of the actionInsert property.
     * 
     */
    public boolean isActionInsert() {
        return actionInsert;
    }

    /**
     * Sets the value of the actionInsert property.
     * 
     */
    public void setActionInsert(boolean value) {
        this.actionInsert = value;
    }

    /**
     * Gets the value of the actionManageUsers property.
     * 
     */
    public boolean isActionManageUsers() {
        return actionManageUsers;
    }

    /**
     * Sets the value of the actionManageUsers property.
     * 
     */
    public void setActionManageUsers(boolean value) {
        this.actionManageUsers = value;
    }

    /**
     * Gets the value of the actionRemove property.
     * 
     */
    public boolean isActionRemove() {
        return actionRemove;
    }

    /**
     * Sets the value of the actionRemove property.
     * 
     */
    public void setActionRemove(boolean value) {
        this.actionRemove = value;
    }

    /**
     * Gets the value of the actionRootInsert property.
     * 
     */
    public boolean isActionRootInsert() {
        return actionRootInsert;
    }

    /**
     * Sets the value of the actionRootInsert property.
     * 
     */
    public void setActionRootInsert(boolean value) {
        this.actionRootInsert = value;
    }

    /**
     * Gets the value of the actionRootRemove property.
     * 
     */
    public boolean isActionRootRemove() {
        return actionRootRemove;
    }

    /**
     * Sets the value of the actionRootRemove property.
     * 
     */
    public void setActionRootRemove(boolean value) {
        this.actionRootRemove = value;
    }

    /**
     * Gets the value of the actionSelect property.
     * 
     */
    public boolean isActionSelect() {
        return actionSelect;
    }

    /**
     * Sets the value of the actionSelect property.
     * 
     */
    public void setActionSelect(boolean value) {
        this.actionSelect = value;
    }

    /**
     * Gets the value of the actionUpdate property.
     * 
     */
    public boolean isActionUpdate() {
        return actionUpdate;
    }

    /**
     * Sets the value of the actionUpdate property.
     * 
     */
    public void setActionUpdate(boolean value) {
        this.actionUpdate = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

}
