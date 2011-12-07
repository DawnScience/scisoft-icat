
package uk.icat3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataset complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataset">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="datafileCollection" type="{client.icat3.uk}datafile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datasetParameterCollection" type="{client.icat3.uk}datasetParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datasetStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datasetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="investigationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sampleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataset", propOrder = {
    "datafileCollection",
    "datasetParameterCollection",
    "datasetStatus",
    "datasetType",
    "description",
    "id",
    "investigationId",
    "location",
    "name",
    "sampleId"
})
public class Dataset
    extends EntityBaseBean
{

    protected List<Datafile> datafileCollection;
    protected List<DatasetParameter> datasetParameterCollection;
    protected String datasetStatus;
    protected String datasetType;
    protected String description;
    protected Long id;
    protected Long investigationId;
    protected String location;
    protected String name;
    protected Long sampleId;

    /**
     * Gets the value of the datafileCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datafileCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatafileCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Datafile }
     * 
     * 
     */
    public List<Datafile> getDatafileCollection() {
        if (datafileCollection == null) {
            datafileCollection = new ArrayList<Datafile>();
        }
        return this.datafileCollection;
    }

    /**
     * Gets the value of the datasetParameterCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datasetParameterCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatasetParameterCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatasetParameter }
     * 
     * 
     */
    public List<DatasetParameter> getDatasetParameterCollection() {
        if (datasetParameterCollection == null) {
            datasetParameterCollection = new ArrayList<DatasetParameter>();
        }
        return this.datasetParameterCollection;
    }

    /**
     * Gets the value of the datasetStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetStatus() {
        return datasetStatus;
    }

    /**
     * Sets the value of the datasetStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetStatus(String value) {
        this.datasetStatus = value;
    }

    /**
     * Gets the value of the datasetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetType() {
        return datasetType;
    }

    /**
     * Sets the value of the datasetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetType(String value) {
        this.datasetType = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the investigationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestigationId() {
        return investigationId;
    }

    /**
     * Sets the value of the investigationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestigationId(Long value) {
        this.investigationId = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sampleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSampleId() {
        return sampleId;
    }

    /**
     * Sets the value of the sampleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSampleId(Long value) {
        this.sampleId = value;
    }

}
