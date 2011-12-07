
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteSampleParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteSampleParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sampleParameterPK" type="{client.icat3.uk}sampleParameterPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteSampleParameter", propOrder = {
    "sessionId",
    "sampleParameterPK"
})
public class DeleteSampleParameter {

    protected String sessionId;
    protected SampleParameterPK sampleParameterPK;

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
     * Gets the value of the sampleParameterPK property.
     * 
     * @return
     *     possible object is
     *     {@link SampleParameterPK }
     *     
     */
    public SampleParameterPK getSampleParameterPK() {
        return sampleParameterPK;
    }

    /**
     * Sets the value of the sampleParameterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link SampleParameterPK }
     *     
     */
    public void setSampleParameterPK(SampleParameterPK value) {
        this.sampleParameterPK = value;
    }

}
