
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addDataSetParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addDataSetParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataSetParameter" type="{client.icat3.uk}datasetParameter" minOccurs="0"/>
 *         &lt;element name="datasetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDataSetParameter", propOrder = {
    "sessionId",
    "dataSetParameter",
    "datasetId"
})
public class AddDataSetParameter {

    protected String sessionId;
    protected DatasetParameter dataSetParameter;
    protected Long datasetId;

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
     * Gets the value of the dataSetParameter property.
     * 
     * @return
     *     possible object is
     *     {@link DatasetParameter }
     *     
     */
    public DatasetParameter getDataSetParameter() {
        return dataSetParameter;
    }

    /**
     * Sets the value of the dataSetParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatasetParameter }
     *     
     */
    public void setDataSetParameter(DatasetParameter value) {
        this.dataSetParameter = value;
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

}
