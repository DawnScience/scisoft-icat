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

package uk.ac.diamond.scisoft.icatexplorer.rcp.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;

public class DIcat implements IMetadataProvider {

	private DInvestigation[] children = new DInvestigation[0];
	private Object rootElement;

	private String host;
	private String fedid;
	private int nbInvestigations;

	private static final Logger logger = LoggerFactory.getLogger(DIcat.class);

	/**
	 * Constructor
	 * 
	 * @param string
	 */
	public DIcat(String fedid, String host) {

		this.fedid = fedid;
		this.host = host;

	}

	public void setChildren(DInvestigation[] children) {
		if (children != null) {
			setChildrensParent(null, this.children);
		}
		this.children = children;
		setChildrensParent(this, this.children);
	}

	/**
	 * Sets children's parent
	 * 
	 * @param dInvestigation
	 *            parent to be set
	 * @param children
	 *            children to set the parent
	 */
	private static void setChildrensParent(DIcat dIcat,
			DInvestigation[] children) {
		for (int i = 0; i < children.length; i++) {
			children[i].setParent(dIcat);
		}
	}

	// getter and setter
	public DInvestigation[] getChildren() {
		return children;
	}

	public void setRoot(Object parentElement) {
		this.rootElement = parentElement;
	}

	public Object getRoot() {
		return rootElement;
	}

	//
	public String getHost() {
		return host;
	}

	public String getFedid() {
		return fedid;
	}

	public void setNbInvestigations(int nbInv) {

		nbInvestigations = nbInv;

	}

	public int getNbInvestigations() {

		return nbInvestigations;
	}

	@Override
	public IMetaData getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("FACILITY", "DLS");
		pairs.put("ICAT_HOSTED_AT", this.getHost());
		pairs.put("SESSION_ID", ICATSessionDetails.icatClient.getSessionId());
		pairs.put("FED_ID", ICATSessionDetails.icatClient.getFedId());

		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("NAME", "ICAT CONNECTION DETAILS");

		return new MetaDataAdapter() {

			@Override
			public Serializable getMetaValue(String key) throws Exception {
				return pairs.get(key);
			}

			@Override
			public Collection<String> getMetaNames() throws Exception {

				return pairs.keySet();
			}

			@Override
			public Collection<String> getDataNames() {

				return name.values();
			}

		};
	}

}
