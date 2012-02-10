
package uk.ac.diamond.scisoft.icatexplorer.rcp.visits;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.resources.IFolder;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;
import uk.icat3.client.Investigation;


public class VisitTreeData implements IMetadataProvider { 

	private IFolder container;
	private Investigation icatInvestigation; 
	private String parentProject;
	

	/**
	 *  
	 * @param icatInvestigation 
	 * @param aFolder The file that defines this property.
	 */
	public VisitTreeData(Investigation icatInvestigation, IFolder aFolder) { 
		this.icatInvestigation = icatInvestigation;
		container = aFolder; 
	} 
	
	public VisitTreeData(Investigation icatInvestigation, String parentProject) { 
		this.icatInvestigation = icatInvestigation;
		this.parentProject = parentProject; 
	} 
	
	public String getParentProject() { 
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
