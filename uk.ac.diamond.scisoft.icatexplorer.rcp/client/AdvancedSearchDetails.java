
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
 * <p>Java class for advancedSearchDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="advancedSearchDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="backCatalogueInvestigatorString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseSensitive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="datafileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRangeEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateRangeStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="experimentNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grantId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="instruments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="investigationAbstract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigationInclude" type="{client.icat3.uk}investigationInclude" minOccurs="0"/>
 *         &lt;element name="investigationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigators" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="runEnd" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="runStart" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="sampleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "advancedSearchDetails", propOrder = {
    "backCatalogueInvestigatorString",
    "caseSensitive",
    "datafileName",
    "dateRangeEnd",
    "dateRangeStart",
    "experimentNumber",
    "grantId",
    "instruments",
    "investigationAbstract",
    "investigationInclude",
    "investigationName",
    "investigationType",
    "investigators",
    "keywords",
    "runEnd",
    "runStart",
    "sampleName",
    "visitId"
})
public class AdvancedSearchDetails {

    protected String backCatalogueInvestigatorString;
    protected boolean caseSensitive;
    protected String datafileName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateRangeEnd;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateRangeStart;
    protected String experimentNumber;
    protected Long grantId;
    @XmlElement(nillable = true)
    protected List<String> instruments;
    protected String investigationAbstract;
    protected InvestigationInclude investigationInclude;
    protected String investigationName;
    protected String investigationType;
    @XmlElement(nillable = true)
    protected List<String> investigators;
    @XmlElement(nillable = true)
    protected List<String> keywords;
    protected Double runEnd;
    protected Double runStart;
    protected String sampleName;
    protected String visitId;

    /**
     * Gets the value of the backCatalogueInvestigatorString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackCatalogueInvestigatorString() {
        return backCatalogueInvestigatorString;
    }

    /**
     * Sets the value of the backCatalogueInvestigatorString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackCatalogueInvestigatorString(String value) {
        this.backCatalogueInvestigatorString = value;
    }

    /**
     * Gets the value of the caseSensitive property.
     * 
     */
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Sets the value of the caseSensitive property.
     * 
     */
    public void setCaseSensitive(boolean value) {
        this.caseSensitive = value;
    }

    /**
     * Gets the value of the datafileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatafileName() {
        return datafileName;
    }

    /**
     * Sets the value of the datafileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatafileName(String value) {
        this.datafileName = value;
    }

    /**
     * Gets the value of the dateRangeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateRangeEnd() {
        return dateRangeEnd;
    }

    /**
     * Sets the value of the dateRangeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateRangeEnd(XMLGregorianCalendar value) {
        this.dateRangeEnd = value;
    }

    /**
     * Gets the value of the dateRangeStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateRangeStart() {
        return dateRangeStart;
    }

    /**
     * Sets the value of the dateRangeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateRangeStart(XMLGregorianCalendar value) {
        this.dateRangeStart = value;
    }

    /**
     * Gets the value of the experimentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExperimentNumber() {
        return experimentNumber;
    }

    /**
     * Sets the value of the experimentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExperimentNumber(String value) {
        this.experimentNumber = value;
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
     * Gets the value of the instruments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instruments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstruments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInstruments() {
        if (instruments == null) {
            instruments = new ArrayList<String>();
        }
        return this.instruments;
    }

    /**
     * Gets the value of the investigationAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvestigationAbstract() {
        return investigationAbstract;
    }

    /**
     * Sets the value of the investigationAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvestigationAbstract(String value) {
        this.investigationAbstract = value;
    }

    /**
     * Gets the value of the investigationInclude property.
     * 
     * @return
     *     possible object is
     *     {@link InvestigationInclude }
     *     
     */
    public InvestigationInclude getInvestigationInclude() {
        return investigationInclude;
    }

    /**
     * Sets the value of the investigationInclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvestigationInclude }
     *     
     */
    public void setInvestigationInclude(InvestigationInclude value) {
        this.investigationInclude = value;
    }

    /**
     * Gets the value of the investigationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvestigationName() {
        return investigationName;
    }

    /**
     * Sets the value of the investigationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvestigationName(String value) {
        this.investigationName = value;
    }

    /**
     * Gets the value of the investigationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvestigationType() {
        return investigationType;
    }

    /**
     * Sets the value of the investigationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvestigationType(String value) {
        this.investigationType = value;
    }

    /**
     * Gets the value of the investigators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the investigators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvestigators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInvestigators() {
        if (investigators == null) {
            investigators = new ArrayList<String>();
        }
        return this.investigators;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<String>();
        }
        return this.keywords;
    }

    /**
     * Gets the value of the runEnd property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRunEnd() {
        return runEnd;
    }

    /**
     * Sets the value of the runEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRunEnd(Double value) {
        this.runEnd = value;
    }

    /**
     * Gets the value of the runStart property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRunStart() {
        return runStart;
    }

    /**
     * Sets the value of the runStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRunStart(Double value) {
        this.runStart = value;
    }

    /**
     * Gets the value of the sampleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSampleName() {
        return sampleName;
    }

    /**
     * Sets the value of the sampleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSampleName(String value) {
        this.sampleName = value;
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
