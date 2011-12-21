/*
 * Copyright 2012 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
