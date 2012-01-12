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
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;

/**
 * @author smw81327
 * @version $Id$
 */
public class DInvestigation extends uk.icat3.client.Investigation implements
		IMetadataProvider {

	private static final Logger logger = LoggerFactory
			.getLogger(DInvestigation.class);

	private DDataset[] children = new DDataset[0];

	private long id;
	private String inv_number;
	private String visit_id;
	private String instrument;
	private String title;
	private int nbDatasets;
	private DIcat dIcat;

	/**
	 * Constructor
	 */
	public DInvestigation(long id, String visit_id) {
		// super(name);
		this.id = id;
		this.visit_id = visit_id;
	}

	//
	@Override
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInv_number() {
		return inv_number;
	}

	public void setInv_number(String inv_number) {
		this.inv_number = inv_number;
	}

	@Override
	public String getVisitId() {
		return visit_id;
	}

	@Override
	public void setVisitId(String visit_id) {
		this.visit_id = visit_id;
	}

	@Override
	public String getInstrument() {
		return instrument;
	}

	@Override
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	public int getNbdatasets() {
		return nbDatasets;
	}

	public void setNbdatasets(int nbDatasets) {
		this.nbDatasets = nbDatasets;
	}

	/**
	 * @param dIcat
	 */
	public void setParent(DIcat dIcat) {
		this.dIcat = dIcat;
	}

	public DIcat getParent() {
		return dIcat;
	}

	// getter and setter
	public DDataset[] getChildren() {
		logger.debug("DInvestigation nb children: " + children.length);
		return children;
	}

	public void setChildren(DDataset[] children) {
		if (children != null) {
			setChildrensParent(null, this.children);
		}
		this.children = children;
		setChildrensParent(this, this.children);
	}

	private static void setChildrensParent(DInvestigation dInv,
			DDataset[] children) {
		for (int i = 0; i < children.length; i++) {
			children[i].setParent(dInv);
		}
	}

	@Override
	public IMetaData getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("ID", Long.toString(this.getId()));
		pairs.put("INSTRUMENT", this.getInstrument());
		pairs.put("INV_NUMBER", this.getInv_number());
		pairs.put("VISIT_ID", this.getVisitId());
		pairs.put("START_DATE",
				UnitsConverter.gregorianToString(this.getInvStartDate()));
		pairs.put("END_DATE",
				UnitsConverter.gregorianToString(this.getInvEndDate()));

		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("INV_ID", "INVESTIGATION: " + this.getVisitId());

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
