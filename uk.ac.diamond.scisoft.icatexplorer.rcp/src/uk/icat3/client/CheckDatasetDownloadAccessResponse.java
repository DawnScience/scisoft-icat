
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkDatasetDownloadAccessResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkDatasetDownloadAccessResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="downloadInfo" type="{client.icat3.uk}downloadInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkDatasetDownloadAccessResponse", propOrder = {
    "downloadInfo"
})
public class CheckDatasetDownloadAccessResponse {

    protected DownloadInfo downloadInfo;

    /**
     * Gets the value of the downloadInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadInfo }
     *     
     */
    public DownloadInfo getDownloadInfo() {
        return downloadInfo;
    }

    /**
     * Sets the value of the downloadInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadInfo }
     *     
     */
    public void setDownloadInfo(DownloadInfo value) {
        this.downloadInfo = value;
    }

}
