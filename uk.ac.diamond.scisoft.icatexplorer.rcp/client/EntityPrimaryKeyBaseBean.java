
package uk.icat3.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for entityPrimaryKeyBaseBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entityPrimaryKeyBaseBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entityPrimaryKeyBaseBean")
@XmlSeeAlso({
    ParameterPK.class,
    DatafileParameterPK.class,
    DatafileFormatPK.class,
    KeywordPK.class,
    DatasetParameterPK.class,
    ShiftPK.class,
    RelatedDatafilesPK.class,
    SampleParameterPK.class,
    InvestigatorPK.class
})
public abstract class EntityPrimaryKeyBaseBean {


}
