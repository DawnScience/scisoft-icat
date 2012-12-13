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

package uk.ac.diamond.scisoft.icatexplorer.rcp.visits;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;
import uk.icat3.client.Investigation;


public class VisitTreeData implements IMetadataProvider { 

	private IFolder container;
	private Investigation icatInvestigation; 
	private IProject parentProject;
	

	/**
	 *  
	 * @param icatInvestigation 
	 * @param aFolder The file that defines this property.
	 */
	public VisitTreeData(Investigation icatInvestigation, IFolder aFolder) { 
		this.icatInvestigation = icatInvestigation;
		container = aFolder; 
	} 
	
	public VisitTreeData(Investigation icatInvestigation, IProject parentProject) { 
		this.icatInvestigation = icatInvestigation;
		this.parentProject = parentProject; 
	} 
	
	public IProject getParentProject() { 
		return parentProject;
	}
	
	/**
	 * The IFolder that defines this property.  
	 * @return The IFolder that defines this property.
	 */
	public IFolder getFolder() { 
		return container;
	}

	/**
	 * @return Returns the icatInvestigation.
	 */
	public Investigation getIcatInvestigation() {
		return icatInvestigation;
	}

	/**
	 * @param icatInvestigation The icatInvestigation to set.
	 */
	public void setIcatInvestigation(Investigation icatInvestigation) {
		this.icatInvestigation = icatInvestigation;
	}

	/* (non-Javadoc)
	 * @see uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider#getMetadata()
	 */
	@Override
	public IMetaData getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("ID", Long.toString(this.icatInvestigation.getId()));
		//pairs.put("SAMPLE_ID", Long.toString(this.icatDataset.getSampleId()));
		pairs.put("INSTRUMENT", this.icatInvestigation.getInstrument());
		pairs.put("START_DATE", UnitsConverter.gregorianToString(this.icatInvestigation.getInvStartDate()));
		pairs.put("END_DATE", UnitsConverter.gregorianToString(this.icatInvestigation.getInvEndDate()));
		pairs.put("FACILITY", this.icatInvestigation.getFacility());
		pairs.put("INV_NUMBER", this.icatInvestigation.getInvNumber());
		
		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("NUMBER", "INVESTIGATION: " + this.icatInvestigation.getVisitId());

		return new MetaDataAdapter(icatInvestigation.getVisitId()) {
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
