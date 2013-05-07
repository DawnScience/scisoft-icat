/*
 * Copyright 2013 Diamond Light Source Ltd.
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

package uk.ac.diamond.actors.icat;

import java.util.List;
import java.util.Map;

import org.dawb.passerelle.common.actors.AbstractDataMessageTransformer;
import org.dawb.passerelle.common.message.DataMessageComponent;
import org.dawb.passerelle.common.message.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

import com.isencia.passerelle.actor.ProcessingException;
import com.isencia.passerelle.actor.TerminationException;

public class VersionTransformer extends AbstractDataMessageTransformer {

	private static final long serialVersionUID = 1312885325541751197L;

	private String version = "unknown";

	public VersionTransformer(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super(container, name);
		
		//set-up constructor
	}

	@Override
	protected String getOperationName() {
		return "Creates a login ICAT actor";
	}

	public void attributeChanged(Attribute attribute) throws IllegalActionException {

		super.attributeChanged(attribute);
	}

	@Override
	protected DataMessageComponent getTransformedMessage(List<DataMessageComponent> cache) throws ProcessingException {

		final DataMessageComponent comp = new DataMessageComponent();

		try {
					
			final Map<String,String> scalar = MessageUtils.getScalar(cache);
			final String token    = scalar!=null ? scalar.get("token") : null;
														
			final ICATClient client = Sessions.getSession(token);
							
			version = client.getICATVersion();
			
			comp.addScalar(scalar);
			comp.putScalar("version", "ICAT Version: "+ version);
						
		} catch (Exception ne) {
			
			comp.putScalar("error_text", "Error connecting to ICAT");
			//throw ne;
		}
		return comp; 
	}

	
	public void doWrapUp() throws TerminationException {
		super.doWrapUp();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionTransformer.class);
		
}
