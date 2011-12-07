
package uk.icat3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sample complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sample">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="chemicalFormula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="instance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proposalSampleId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="safetyInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sampleParameterCollection" type="{client.icat3.uk}sampleParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sample", propOrder = {
    "chemicalFormula",
    "id",
    "instance",
    "name",
    "proposalSampleId",
    "safetyInformation",
    "sampleParameterCollection"
})
public class Sample
    extends EntityBaseBean
{

    protected String chemicalFormula;
    protected Long id;
    protected String instance;
    protected String name;
    protected Integer proposalSampleId;
    protected String safetyInformation;
    @XmlElement(nillable = true)
    protected List<SampleParameter> sampleParameterCollection;

    /**
     * Gets the value of the chemicalFormula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChemicalFormula() {
        return chemicalFormula;
    }

    /**
     * Sets the value of the chemicalFormula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChemicalFormula(String value) {
        this.chemicalFormula = value;
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
     * Gets the value of the instance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstance() {
        return instance;
    }

    /**
     * Sets the value of the instance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstance(String value) {
        this.instance = value;
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
     * Gets the value of the proposalSampleId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProposalSampleId() {
        return proposalSampleId;
    }

    /**
     * Sets the value of the proposalSampleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProposalSampleId(Integer value) {
        this.proposalSampleId = value;
    }

    /**
     * Gets the value of the safetyInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSafetyInformation() {
        return safetyInformation;
    }

    /**
     * Sets the value of the safetyInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSafetyInformation(String value) {
        this.safetyInformation = value;
    }

    /**
     * Gets the value of the sampleParameterCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sampleParameterCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSampleParameterCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SampleParameter }
     * 
     * 
     */
    public List<SampleParameter> getSampleParameterCollection() {
        if (sampleParameterCollection == null) {
            sampleParameterCollection = new ArrayList<SampleParameter>();
        }
        return this.sampleParameterCollection;
    }

}
