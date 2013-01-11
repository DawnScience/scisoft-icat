/*
 * Copyright © 2011 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datasets;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import org.icatproject.Dataset;


public class DatasetTreeData  implements IMetadataProvider {
	
	private Dataset icatDataset;
	private IProject parentProject;
	
	
	/**
	 * @param projectName 
	 * @param dataset 
	 */
	public DatasetTreeData(Dataset icatDataset, IProject parentProject){
		this.icatDataset = icatDataset;
		this.parentProject  = parentProject;
	}
	
	public IProject getParentProject() { 
		return parentProject;
	}
	
	/**
	 * @return Returns the icatDataset.
	 */
	public Dataset getIcatDataset() {
		return icatDataset;
	}

	/**
	 * @param icatDataset The icatDataset to set.
	 */
	public void setIcatDataset(Dataset icatDataset) {
		this.icatDataset = icatDataset;
	}


	/* (non-Javadoc)
	 * @see uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider#getMetadata()
	 */
	@Override
	public IMetaData getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("ID", Long.toString(this.icatDataset.getId()));
		pairs.put("INVESTIGATION_ID", Long.toString(this.icatDataset.getId()));
		pairs.put("NAME", this.icatDataset.getName());
		pairs.put("LOCATION", this.icatDataset.getLocation());
		pairs.put("DESCRIPTION", this.icatDataset.getDescription());
		
		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("NAME", "DATASET: " + this.icatDataset.getName());

		return new MetaDataAdapter() {
			private static final long serialVersionUID = MetaDataAdapter.serialVersionUID;

			@Override
			public Serializable getMetaValue(String key) throws Exception {
				return pairs.get(key);
			}

			@Override
			public Collection<String> getMetaNames() throws Exception {

				return Collections.unmodifiableCollection(pairs.keySet());
			}

			@Override
			public Collection<String> getDataNames() {

				return Collections.unmodifiableCollection(name.values());
			}

		};
	}

}
