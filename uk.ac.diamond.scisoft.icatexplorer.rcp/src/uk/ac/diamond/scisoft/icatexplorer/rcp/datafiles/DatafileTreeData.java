
package uk.ac.diamond.scisoft.icatexplorer.rcp.datafiles;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.UnitsConverter;
import uk.icat3.client.Datafile;


public class DatafileTreeData implements IMetadataProvider{
	
	private Datafile icatDatafile;
	private String parentProject;
	
	private static Logger logger = LoggerFactory.getLogger(DatafileTreeData.class);
	
	/**
	 * @param projectName 
	 * @param name
	 * @param datafileid
	 * @param status
	 */
	public DatafileTreeData(Datafile icatDatafile, String parentProject) {
		this.setIcatDatafile(icatDatafile);
		this.parentProject = parentProject;
		
		logger.debug("DatafileTree data created: " + icatDatafile.getName());
	}

	public String getParentProject() {
		return parentProject;
	}

	public void setProjectName(String parentProject) {
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
	public IMetaData getMetadata() throws Exception {
		final HashMap<String, String> pairs = new HashMap<String, String>();
		pairs.put("ID", Long.toString(this.getIcatDatafile().getId()));
		pairs.put("CHECKSUM", this.getIcatDatafile().getChecksum());
		pairs.put("COMMAND", this.getIcatDatafile().getCommand());
		pairs.put("VERSION", this.getIcatDatafile().getDatafileVersion());
		pairs.put("DESCRIPTION", this.getIcatDatafile().getDescription());
		pairs.put("LOCATION", this.getIcatDatafile().getLocation());
		pairs.put("NAME", this.getIcatDatafile().getName());
		pairs.put("SIGNATURE", this.getIcatDatafile().getSignature());
		pairs.put("UNIQUE_ID", this.getIcatDatafile().getUniqueId());
		pairs.put("CREATION_TIME",
				UnitsConverter.gregorianToString(this.getIcatDatafile().getDatafileCreateTime()));
		pairs.put("MODIFICATION_TIME",
				UnitsConverter.gregorianToString(this.getIcatDatafile().getDatafileModifyTime()));
		pairs.put("DATASET_ID", Long.toString(this.getIcatDatafile().getDatasetId()));
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


}
