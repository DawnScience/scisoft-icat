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

/**
 * DDataset element
 * 
 * @author smw81327
 * @version $Id$
 */
public class DDataset extends uk.icat3.client.Dataset implements
		IMetadataProvider {

	private static final Logger logger = LoggerFactory
			.getLogger(DDataset.class);

	private String name;
	private long id;
	private long sample_id;
	private long investigation_id;
	private String dataset_type;
	private String dataset_status;
	private String location;
	private String description;
	private String mod_time;
	private String mod_id;
	private String create_time;
	private String create_id;
	private String facility_acquired;
	private String deleted;

	private DInvestigation dInvestigation;

	public long getSample_id() {
		return sample_id;
	}

	public long getInvestigation_id() {
		return investigation_id;
	}

	public String getDataset_type() {
		return dataset_type;
	}

	public String getDataset_status() {
		return dataset_status;
	}

	@Override
	public String getLocation() {
		return super.location;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public String getMod_time() {
		return mod_time;
	}

	public String getMod_id() {
		return mod_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public String getCreate_id() {
		return create_id;
	}

	public String getFacility_acquired() {
		return facility_acquired;
	}

	public String getDeleted() {
		return deleted;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Constructor
	 */
	public DDataset(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DDataset(Long id, String name, String datasetStatus,
			String datasetType, String description, Long investigationId,
			String location, Long sampleId, String uniqueId) {

		this.id = id;
		this.name = name;
		this.dataset_status = datasetStatus;
		this.dataset_type = datasetType;
		this.description = description;
		this.investigation_id = investigationId;
		this.location = location;
		// this.sample_id = sampleId;

	}

	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * @param dInvestigation
	 */
	public void setParent(DInvestigation dInvestigation) {
		this.dInvestigation = dInvestigation;
	}

	public DInvestigation getParent() {
		return dInvestigation;
	}

	@Override
	public IMetaData getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("ID", Long.toString(this.getId()));
		pairs.put("SAMPLE_ID", Long.toString(this.getSample_id()));
		pairs.put("INVESTIGATION_ID", Long.toString(this.getInvestigation_id()));
		pairs.put("NAME", this.getName());
		pairs.put("DATASET_TYPE", this.getDataset_type());
		pairs.put("DATASET_STATUS", this.getDataset_status());
		pairs.put("LOCATION", this.getLocation());
		pairs.put("DESCRIPTION", this.getDescription());
		// pairs.put("MOD_TIME", UnitsConverter.gregorianToString(this.get
		// .get.getMod_time()));
		// pairs.put("MOD_ID", Long.toString(this.getMod_id()));
		// pairs.put("CREATE_TIME",
		// UnitsConverter.gregorianToString(this.getCreate_time()));
		// pairs.put("CREATE_ID", Long.toString(this.getMod_id()));
		// pairs.put("FACILITY_ACQUIRED", this.getFacility_acquired());
		// pairs.put("DELETED", this.getDeleted());

		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("NAME", "DATASET: " + this.getName());

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
