
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for entityBaseBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entityBaseBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="facilityAcquiredData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="icatRole" type="{client.icat3.uk}icatRole" minOccurs="0"/>
 *         &lt;element name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="uniqueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entityBaseBean", propOrder = {
    "facilityAcquiredData",
    "icatRole",
    "selected",
    "uniqueId"
})
@XmlSeeAlso({
    FacilityUser.class,
    Investigator.class,
    Investigation.class,
    Datafile.class,
    DatafileParameter.class,
    Dataset.class,
    RelatedDatafiles.class,
    IcatAuthorisation.class,
    Sample.class,
    FacilityCycle.class,
    DatafileFormat.class,
    Shift.class,
    DatasetParameter.class,
    IcatRole.class,
    SampleParameter.class,
    Parameter.class,
    Keyword.class,
    Publication.class
})
public abstract class EntityBaseBean {

    protected boolean facilityAcquiredData;
    protected IcatRole icatRole;
    protected boolean selected;
    protected String uniqueId;

    /**
     * Gets the value of the facilityAcquiredData property.
     * 
     */
    public boolean isFacilityAcquiredData() {
        return facilityAcquiredData;
    }

    /**
     * Sets the value of the facilityAcquiredData property.
     * 
     */
    public void setFacilityAcquiredData(boolean value) {
        this.facilityAcquiredData = value;
    }

    /**
     * Gets the value of the icatRole property.
     * 
     * @return
     *     possible object is
     *     {@link IcatRole }
     *     
     */
    public IcatRole getIcatRole() {
        return icatRole;
    }

    /**
     * Sets the value of the icatRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcatRole }
     *     
     */
    public void setIcatRole(IcatRole value) {
        this.icatRole = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets the value of the selected property.
     * 
     */
    public void setSelected(boolean value) {
        this.selected = value;
    }

    /**
     * Gets the value of the uniqueId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Sets the value of the uniqueId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueId(String value) {
        this.uniqueId = value;
    }

}
