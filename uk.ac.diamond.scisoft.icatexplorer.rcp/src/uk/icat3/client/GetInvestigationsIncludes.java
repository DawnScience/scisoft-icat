
package uk.icat3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInvestigationsIncludes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInvestigationsIncludes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="investigationIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="investigationInclude" type="{client.icat3.uk}investigationInclude" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInvestigationsIncludes", propOrder = {
    "userId",
    "investigationIds",
    "investigationInclude"
})
public class GetInvestigationsIncludes {

    protected String userId;
    @XmlElement(type = Long.class)
    protected List<Long> investigationIds;
    protected InvestigationInclude investigationInclude;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the investigationIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the investigationIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvestigationIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getInvestigationIds() {
        if (investigationIds == null) {
            investigationIds = new ArrayList<Long>();
        }
        return this.investigationIds;
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

}
