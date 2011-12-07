
package uk.icat3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for datafile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datafile">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="checksum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="command" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datafileCreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datafileFormat" type="{client.icat3.uk}datafileFormat" minOccurs="0"/>
 *         &lt;element name="datafileInclude" type="{client.icat3.uk}datafileInclude" minOccurs="0"/>
 *         &lt;element name="datafileModifyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datafileParameterCollection" type="{client.icat3.uk}datafileParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datafileVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datafileVersionComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datasetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedDatafilesCollection1" type="{client.icat3.uk}relatedDatafiles" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="relatedDatafilesCollection" type="{client.icat3.uk}relatedDatafiles" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datafile", propOrder = {
    "checksum",
    "command",
    "datafileCreateTime",
    "datafileFormat",
    "datafileInclude",
    "datafileModifyTime",
    "datafileParameterCollection",
    "datafileVersion",
    "datafileVersionComment",
    "datasetId",
    "description",
    "fileSize",
    "id",
    "location",
    "name",
    "relatedDatafilesCollection1",
    "relatedDatafilesCollection",
    "signature"
})
public class Datafile
    extends EntityBaseBean
{

    protected String checksum;
    protected String command;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datafileCreateTime;
    protected DatafileFormat datafileFormat;
    protected DatafileInclude datafileInclude;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datafileModifyTime;
    protected List<DatafileParameter> datafileParameterCollection;
    protected String datafileVersion;
    protected String datafileVersionComment;
    protected Long datasetId;
    protected String description;
    protected Integer fileSize;
    protected Long id;
    protected String location;
    protected String name;
    @XmlElement(nillable = true)
    protected List<RelatedDatafiles> relatedDatafilesCollection1;
    protected List<RelatedDatafiles> relatedDatafilesCollection;
    protected String signature;

    /**
     * Gets the value of the checksum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Sets the value of the checksum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChecksum(String value) {
        this.checksum = value;
    }

    /**
     * Gets the value of the command property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the value of the command property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommand(String value) {
        this.command = value;
    }

    /**
     * Gets the value of the datafileCreateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatafileCreateTime() {
        return datafileCreateTime;
    }

    /**
     * Sets the value of the datafileCreateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatafileCreateTime(XMLGregorianCalendar value) {
        this.datafileCreateTime = value;
    }

    /**
     * Gets the value of the datafileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link DatafileFormat }
     *     
     */
    public DatafileFormat getDatafileFormat() {
        return datafileFormat;
    }

    /**
     * Sets the value of the datafileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatafileFormat }
     *     
     */
    public void setDatafileFormat(DatafileFormat value) {
        this.datafileFormat = value;
    }

    /**
     * Gets the value of the datafileInclude property.
     * 
     * @return
     *     possible object is
     *     {@link DatafileInclude }
     *     
     */
    public DatafileInclude getDatafileInclude() {
        return datafileInclude;
    }

    /**
     * Sets the value of the datafileInclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatafileInclude }
     *     
     */
    public void setDatafileInclude(DatafileInclude value) {
        this.datafileInclude = value;
    }

    /**
     * Gets the value of the datafileModifyTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatafileModifyTime() {
        return datafileModifyTime;
    }

    /**
     * Sets the value of the datafileModifyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatafileModifyTime(XMLGregorianCalendar value) {
        this.datafileModifyTime = value;
    }

    /**
     * Gets the value of the datafileParameterCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datafileParameterCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatafileParameterCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatafileParameter }
     * 
     * 
     */
    public List<DatafileParameter> getDatafileParameterCollection() {
        if (datafileParameterCollection == null) {
            datafileParameterCollection = new ArrayList<DatafileParameter>();
        }
        return this.datafileParameterCollection;
    }

    /**
     * Gets the value of the datafileVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatafileVersion() {
        return datafileVersion;
    }

    /**
     * Sets the value of the datafileVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatafileVersion(String value) {
        this.datafileVersion = value;
    }

    /**
     * Gets the value of the datafileVersionComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatafileVersionComment() {
        return datafileVersionComment;
    }

    /**
     * Sets the value of the datafileVersionComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatafileVersionComment(String value) {
        this.datafileVersionComment = value;
    }

    /**
     * Gets the value of the datasetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDatasetId() {
        return datasetId;
    }

    /**
     * Sets the value of the datasetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDatasetId(Long value) {
        this.datasetId = value;
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
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFileSize(Integer value) {
        this.fileSize = value;
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
     * Gets the value of the relatedDatafilesCollection1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedDatafilesCollection1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedDatafilesCollection1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedDatafiles }
     * 
     * 
     */
    public List<RelatedDatafiles> getRelatedDatafilesCollection1() {
        if (relatedDatafilesCollection1 == null) {
            relatedDatafilesCollection1 = new ArrayList<RelatedDatafiles>();
        }
        return this.relatedDatafilesCollection1;
    }

    /**
     * Gets the value of the relatedDatafilesCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedDatafilesCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedDatafilesCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedDatafiles }
     * 
     * 
     */
    public List<RelatedDatafiles> getRelatedDatafilesCollection() {
        if (relatedDatafilesCollection == null) {
            relatedDatafilesCollection = new ArrayList<RelatedDatafiles>();
        }
        return this.relatedDatafilesCollection;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

}
