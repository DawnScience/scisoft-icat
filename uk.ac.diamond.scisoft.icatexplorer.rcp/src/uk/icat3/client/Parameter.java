
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parameter">
 *   &lt;complexContent>
 *     &lt;extension base="{client.icat3.uk}entityBaseBean">
 *       &lt;sequence>
 *         &lt;element name="datafileParameter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nonNumericValueFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeric" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="numericValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameterPK" type="{client.icat3.uk}parameterPK" minOccurs="0"/>
 *         &lt;element name="sampleParameter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="searchable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitsLongVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parameter", propOrder = {
    "datafileParameter",
    "description",
    "nonNumericValueFormat",
    "numeric",
    "numericValue",
    "parameterPK",
    "sampleParameter",
    "searchable",
    "unitsLongVersion",
    "verified"
})
public class Parameter
    extends EntityBaseBean
{

    protected boolean datafileParameter;
    protected String description;
    protected String nonNumericValueFormat;
    protected boolean numeric;
    protected String numericValue;
    protected ParameterPK parameterPK;
    protected boolean sampleParameter;
    protected String searchable;
    protected String unitsLongVersion;
    protected boolean verified;

    /**
     * Gets the value of the datafileParameter property.
     * 
     */
    public boolean isDatafileParameter() {
        return datafileParameter;
    }

    /**
     * Sets the value of the datafileParameter property.
     * 
     */
    public void setDatafileParameter(boolean value) {
        this.datafileParameter = value;
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
     * Gets the value of the nonNumericValueFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonNumericValueFormat() {
        return nonNumericValueFormat;
    }

    /**
     * Sets the value of the nonNumericValueFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonNumericValueFormat(String value) {
        this.nonNumericValueFormat = value;
    }

    /**
     * Gets the value of the numeric property.
     * 
     */
    public boolean isNumeric() {
        return numeric;
    }

    /**
     * Sets the value of the numeric property.
     * 
     */
    public void setNumeric(boolean value) {
        this.numeric = value;
    }

    /**
     * Gets the value of the numericValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumericValue() {
        return numericValue;
    }

    /**
     * Sets the value of the numericValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumericValue(String value) {
        this.numericValue = value;
    }

    /**
     * Gets the value of the parameterPK property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterPK }
     *     
     */
    public ParameterPK getParameterPK() {
        return parameterPK;
    }

    /**
     * Sets the value of the parameterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterPK }
     *     
     */
    public void setParameterPK(ParameterPK value) {
        this.parameterPK = value;
    }

    /**
     * Gets the value of the sampleParameter property.
     * 
     */
    public boolean isSampleParameter() {
        return sampleParameter;
    }

    /**
     * Sets the value of the sampleParameter property.
     * 
     */
    public void setSampleParameter(boolean value) {
        this.sampleParameter = value;
    }

    /**
     * Gets the value of the searchable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchable() {
        return searchable;
    }

    /**
     * Sets the value of the searchable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchable(String value) {
        this.searchable = value;
    }

    /**
     * Gets the value of the unitsLongVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitsLongVersion() {
        return unitsLongVersion;
    }

    /**
     * Sets the value of the unitsLongVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitsLongVersion(String value) {
        this.unitsLongVersion = value;
    }

    /**
     * Gets the value of the verified property.
     * 
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * Sets the value of the verified property.
     * 
     */
    public void setVerified(boolean value) {
        this.verified = value;
    }

}
