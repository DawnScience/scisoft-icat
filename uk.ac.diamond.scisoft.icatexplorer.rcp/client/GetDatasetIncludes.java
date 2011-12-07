
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDatasetIncludes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDatasetIncludes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datasetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="datasetInclude" type="{client.icat3.uk}datasetInclude" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDatasetIncludes", propOrder = {
    "sessionId",
    "datasetId",
    "datasetInclude"
})
public class GetDatasetIncludes {

    protected String sessionId;
    protected Long datasetId;
    protected DatasetInclude datasetInclude;

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
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
     * Gets the value of the datasetInclude property.
     * 
     * @return
     *     possible object is
     *     {@link DatasetInclude }
     *     
     */
    public DatasetInclude getDatasetInclude() {
        return datasetInclude;
    }

    /**
     * Sets the value of the datasetInclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatasetInclude }
     *     
     */
    public void setDatasetInclude(DatasetInclude value) {
        this.datasetInclude = value;
    }

}
