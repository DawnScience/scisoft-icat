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

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.datafiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.dawnsci.analysis.api.dataset.IMetadataProvider;
import org.eclipse.dawnsci.analysis.api.metadata.IMetadata;
import org.eclipse.dawnsci.analysis.api.metadata.MetadataType;
import org.icatproject.Datafile;

import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils.UnitsConverter;


public class DatafileTreeData implements IMetadataProvider{
	
	private Datafile icatDatafile;
	private IProject parentProject;
	
	
	/**
	 * @param projectName 
	 * @param name
	 * @param datafileid
	 * @param status
	 */
	public DatafileTreeData(Datafile icatDatafile, IProject parentProject) {
		this.icatDatafile = icatDatafile;
		this.parentProject = parentProject;
	}

	public IProject getParentProject() {
		return parentProject;
	}

	public void setProjectName(IProject parentProject) {
		this.parentProject = parentProject;
	}

	/**
	 * @return Returns the icatDatafile.
	 */
	public Datafile getIcatDatafile() {
		return icatDatafile;
	}

	/**
	 * @param icatDatafile The icatDatafile to set.
	 */
	public void setIcatDatafile(Datafile icatDatafile) {
		this.icatDatafile = icatDatafile;
	}

	/* (non-Javadoc)
	 * @see uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider#getMetadata()
	 */
	@Override
	public IMetadata getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("ID", Long.toString(this.getIcatDatafile().getId()));
		pairs.put("CHECKSUM", this.getIcatDatafile().getChecksum());
		pairs.put("DESCRIPTION", this.getIcatDatafile().getDescription());
		pairs.put("LOCATION", this.getIcatDatafile().getLocation());
		pairs.put("NAME", this.getIcatDatafile().getName());
		pairs.put("CREATION_TIME",
				UnitsConverter.gregorianToString(this.getIcatDatafile().getDatafileCreateTime()));
		pairs.put("MODIFICATION_TIME",
				UnitsConverter.gregorianToString(this.getIcatDatafile().getDatafileModTime()));
		pairs.put("FILE_SIZE", Long.toString(this.getIcatDatafile().getFileSize()));

		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("NAME", "DATAFILE: " + this.getIcatDatafile().getName());

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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends MetadataType> List<T> getMetadata(Class<T> clazz) throws Exception {
		if (IMetadata.class.isAssignableFrom(clazz)) {
			List<T> result = new ArrayList<T>();
			result.add((T) getMetadata());
			return result;
		}
		throw new UnsupportedOperationException("getMetadata(clazz) does not currently support anything other than IMetadata");
		// If it should only support this, simply return null here, otherwise implement the method fully
	}
}
