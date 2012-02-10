
package uk.ac.diamond.scisoft.icatexplorer.rcp.datasets;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.icat3.client.Dataset;


public class DatasetTreeData  implements IMetadataProvider {
	
	private Dataset icatDataset;
	private String parentProject;
	
	
	/**
	 * @param projectName 
	 * @param dataset 
	 */
	public DatasetTreeData(Dataset icatDataset, String parentProject){
		this.icatDataset = icatDataset;
		this.parentProject  = parentProject;
	}
	
	public String getParentProject() { 
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
		//pairs.put("SAMPLE_ID", Long.toString(this.icatDataset.getSampleId()));
		pairs.put("INVESTIGATION_ID", Long.toString(this.icatDataset.getInvestigationId()));
		pairs.put("NAME", this.icatDataset.getName());
		pairs.put("DATASET_TYPE", this.icatDataset.getDatasetType());
		pairs.put("DATASET_STATUS", this.icatDataset.getDatasetStatus());
		pairs.put("LOCATION", this.icatDataset.getLocation());
		pairs.put("DESCRIPTION", this.icatDataset.getDescription());
		
		final HashMap<String, String> name = new HashMap<String, String>();
		name.put("NAME", "DATASET: " + this.icatDataset.getName());

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
