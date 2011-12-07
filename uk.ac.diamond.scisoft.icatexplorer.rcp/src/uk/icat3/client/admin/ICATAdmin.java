
package uk.icat3.client.admin;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.4-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ICATAdmin", targetNamespace = "admin.client.icat3.uk")
@XmlSeeAlso({
    uk.icat3.client.admin.ObjectFactory.class,
    uk.icat3.client.ObjectFactory.class
})
public interface ICATAdmin {


    /**
     * 
     * @param runAsUserFedId
     * @return
     *     returns java.lang.String
     * @throws SessionException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loginAdmin", targetNamespace = "admin.client.icat3.uk", className = "uk.icat3.client.admin.LoginAdmin")
    @ResponseWrapper(localName = "loginAdminResponse", targetNamespace = "admin.client.icat3.uk", className = "uk.icat3.client.admin.LoginAdminResponse")
    public String loginAdmin(
        @WebParam(name = "runAsUserFedId", targetNamespace = "")
        String runAsUserFedId)
        throws SessionException
    ;

}
