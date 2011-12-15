package uk.ac.diamond.scisoft.icatexplorer.rcp.data;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;
import uk.icat3.client.Datafile;

/**
 * DDataset element
 * @author smw81327
 * @version $Id$
 */
public class DDataset extends uk.icat3.client.Dataset implements IMetadataProvider
{
   	private String name;
    private long id;

    private int nbDatafiles;
    private List datafiles;
	private List<uk.icat3.client.Datafile> idatafiles;
	private DInvestigation dInvestigation;


	/**
     * Constructor
     */
    public DDataset(long id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

    // getters and setter
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public int getNbDatafiles() {
		return nbDatafiles;
	}

	public void setNbDatafiles(int nbDatafiles) {
		this.nbDatafiles = nbDatafiles;
	}
	
	public List getDDatafiles() {
		return datafiles;
	}

	public void setDDatafiles(List datafiles) {
		this.datafiles = datafiles;
	}
	
	public Long getId() {
			return this.id;
		}
	 
	public void setId(long id) {
		this.id = id;
	}

	public List getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(List datafiles) {
		this.datafiles = datafiles;
	}
	public List<uk.icat3.client.Datafile> getIDatafiles() {
		return idatafiles;
	}

	public void setIDatafiles(List<Datafile> idatafiles) {
		this.idatafiles = idatafiles;
	}
	
	
    /**
     * @param dInvestigation
     */
    public void setParent(DInvestigation dInvestigation)
    {
        this.dInvestigation = dInvestigation;
    }

    public DInvestigation getParent()
    {
        return dInvestigation;
    }

	@Override
	public IMetaData getMetadata() throws Exception {
		final HashMap <String, String> pairs = new HashMap<String, String>();	
		pairs.put("ID", Long.toString(this.getId()));
		pairs.put("NAME",this.getName());
		pairs.put("STATUS",this.getDatasetStatus());
		pairs.put("TYPE",this.getDatasetType());
		pairs.put("DESCRIPTION",this.getDescription());
		pairs.put("LOCATION",this.getLocation());
		//pairs.put("INVESTIGATION_ID", Long.toString(super.getInvestigationId()));
		//pairs.put("SAMPLE_ID", Long.toString(this.getSampleId()));
		//pairs.put("SAMPLE_ID", Long.toString(this.getUniqueId()));
		
		final HashMap <String, String> name = new HashMap<String, String>();
		name.put("NAME", "DATASET: "+this.getName());
		
		return new MetaDataAdapter(){

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
