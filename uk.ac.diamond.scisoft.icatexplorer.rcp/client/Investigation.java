
package uk.icat3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for investigation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="investigation">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="bcatInvStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datasetCollection" type="{client.icat3.uk}dataset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="facility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="facilityCycle" type="{client.icat3.uk}facilityCycle" minOccurs="0"/>
 *         &lt;element name="grantId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="instrument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invAbstract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="invNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invParamName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invParamValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="invType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigatorCollection" type="{client.icat3.uk}investigator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="keywordCollection" type="{client.icat3.uk}keyword" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prevInvNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicationCollection" type="{client.icat3.uk}publication" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="sampleCollection" type="{client.icat3.uk}sample" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shiftCollection" type="{client.icat3.uk}shift" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "investigation", propOrder = {
    "bcatInvStr",
    "datasetCollection",
    "facility",
    "facilityCycle",
    "grantId",
    "id",
    "instrument",
    "invAbstract",
    "invEndDate",
    "invNumber",
    "invParamName",
    "invParamValue",
    "invStartDate",
    "invType",
    "investigatorCollection",
    "keywordCollection",
    "prevInvNumber",
    "publicationCollection",
    "releaseDate",
    "sampleCollection",
    "shiftCollection",
    "title",
    "visitId"
})
public class Investigation
    extends EntityBaseBean
{

    protected String bcatInvStr;
    protected List<Dataset> datasetCollection;
    protected String facility;
    protected FacilityCycle facilityCycle;
    protected Long grantId;
    protected Long id;
    protected String instrument;
    protected String invAbstract;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar invEndDate;
    protected String invNumber;
    protected String invParamName;
    protected String invParamValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar invStartDate;
    protected String invType;
    protected List<Investigator> investigatorCollection;
    protected List<Keyword> keywordCollection;
    protected String prevInvNumber;
    protected List<Publication> publicationCollection;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar releaseDate;
    protected List<Sample> sampleCollection;
    protected List<Shift> shiftCollection;
    protected String title;
    protected String visitId;

    /**
     * Gets the value of the bcatInvStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBcatInvStr() {
        return bcatInvStr;
    }

    /**
     * Sets the value of the bcatInvStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBcatInvStr(String value) {
        this.bcatInvStr = value;
    }

    /**
     * Gets the value of the datasetCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datasetCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatasetCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dataset }
     * 
     * 
     */
    public List<Dataset> getDatasetCollection() {
        if (datasetCollection == null) {
            datasetCollection = new ArrayList<Dataset>();
        }
        return this.datasetCollection;
    }

    /**
     * Gets the value of the facility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacility() {
        return facility;
    }

    /**
     * Sets the value of the facility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacility(String value) {
        this.facility = value;
    }

    /**
     * Gets the value of the facilityCycle property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityCycle }
     *     
     */
    public FacilityCycle getFacilityCycle() {
        return facilityCycle;
    }

    /**
     * Sets the value of the facilityCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityCycle }
     *     
     */
    public void setFacilityCycle(FacilityCycle value) {
        this.facilityCycle = value;
    }

    /**
     * Gets the value of the grantId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGrantId() {
        return grantId;
    }

    /**
     * Sets the value of the grantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGrantId(Long value) {
        this.grantId = value;
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
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrument(String value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the invAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvAbstract() {
        return invAbstract;
    }

    /**
     * Sets the value of the invAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvAbstract(String value) {
        this.invAbstract = value;
    }

    /**
     * Gets the value of the invEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvEndDate() {
        return invEndDate;
    }

    /**
     * Sets the value of the invEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvEndDate(XMLGregorianCalendar value) {
        this.invEndDate = value;
    }

    /**
     * Gets the value of the invNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvNumber() {
        return invNumber;
    }

    /**
     * Sets the value of the invNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvNumber(String value) {
        this.invNumber = value;
    }

    /**
     * Gets the value of the invParamName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvParamName() {
        return invParamName;
    }

    /**
     * Sets the value of the invParamName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvParamName(String value) {
        this.invParamName = value;
    }

    /**
     * Gets the value of the invParamValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvParamValue() {
        return invParamValue;
    }

    /**
     * Sets the value of the invParamValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvParamValue(String value) {
        this.invParamValue = value;
    }

    /**
     * Gets the value of the invStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvStartDate() {
        return invStartDate;
    }

    /**
     * Sets the value of the invStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvStartDate(XMLGregorianCalendar value) {
        this.invStartDate = value;
    }

    /**
     * Gets the value of the invType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvType() {
        return invType;
    }

    /**
     * Sets the value of the invType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvType(String value) {
        this.invType = value;
    }

    /**
     * Gets the value of the investigatorCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the investigatorCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvestigatorCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Investigator }
     * 
     * 
     */
    public List<Investigator> getInvestigatorCollection() {
        if (investigatorCollection == null) {
            investigatorCollection = new ArrayList<Investigator>();
        }
        return this.investigatorCollection;
    }

    /**
     * Gets the value of the keywordCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywordCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywordCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Keyword }
     * 
     * 
     */
    public List<Keyword> getKeywordCollection() {
        if (keywordCollection == null) {
            keywordCollection = new ArrayList<Keyword>();
        }
        return this.keywordCollection;
    }

    /**
     * Gets the value of the prevInvNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevInvNumber() {
        return prevInvNumber;
    }

    /**
     * Sets the value of the prevInvNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevInvNumber(String value) {
        this.prevInvNumber = value;
    }

    /**
     * Gets the value of the publicationCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publicationCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublicationCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Publication }
     * 
     * 
     */
    public List<Publication> getPublicationCollection() {
        if (publicationCollection == null) {
            publicationCollection = new ArrayList<Publication>();
        }
        return this.publicationCollection;
    }

    /**
     * Gets the value of the releaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the value of the releaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReleaseDate(XMLGregorianCalendar value) {
        this.releaseDate = value;
    }

    /**
     * Gets the value of the sampleCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sampleCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSampleCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sample }
     * 
     * 
     */
    public List<Sample> getSampleCollection() {
        if (sampleCollection == null) {
            sampleCollection = new ArrayList<Sample>();
        }
        return this.sampleCollection;
    }

    /**
     * Gets the value of the shiftCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shift }
     * 
     * 
     */
    public List<Shift> getShiftCollection() {
        if (shiftCollection == null) {
            shiftCollection = new ArrayList<Shift>();
        }
        return this.shiftCollection;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the visitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitId() {
        return visitId;
    }

    /**
     * Sets the value of the visitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitId(String value) {
        this.visitId = value;
    }

}
