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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import uk.icat3.client.SessionException;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the uk.icat3.client.admin package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _LoginAdmin_QNAME = new QName(
			"admin.client.icat3.uk", "loginAdmin");
	private final static QName _SessionException_QNAME = new QName(
			"admin.client.icat3.uk", "SessionException");
	private final static QName _LoginAdminResponse_QNAME = new QName(
			"admin.client.icat3.uk", "loginAdminResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: uk.icat3.client.admin
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link LoginAdmin }
	 * 
	 */
	public LoginAdmin createLoginAdmin() {
		return new LoginAdmin();
	}

	/**
	 * Create an instance of {@link LoginAdminResponse }
	 * 
	 */
	public LoginAdminResponse createLoginAdminResponse() {
		return new LoginAdminResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LoginAdmin }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "admin.client.icat3.uk", name = "loginAdmin")
	public JAXBElement<LoginAdmin> createLoginAdmin(LoginAdmin value) {
		return new JAXBElement<LoginAdmin>(_LoginAdmin_QNAME, LoginAdmin.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SessionException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "admin.client.icat3.uk", name = "SessionException")
	public JAXBElement<SessionException> createSessionException(
			SessionException value) {
		return new JAXBElement<SessionException>(_SessionException_QNAME,
				SessionException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link LoginAdminResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "admin.client.icat3.uk", name = "loginAdminResponse")
	public JAXBElement<LoginAdminResponse> createLoginAdminResponse(
			LoginAdminResponse value) {
		return new JAXBElement<LoginAdminResponse>(_LoginAdminResponse_QNAME,
				LoginAdminResponse.class, null, value);
	}

}
