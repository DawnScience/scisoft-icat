package uk.ac.diamond.scisoft.icatexplorer.rcp.data;

import java.util.List;

import uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient.ICATSessionDetails;
//import uk.ac.diamond.scisoft.icatexplorer.rcp.data.DDatafile;
import uk.icat3.client.Datafile;
import uk.icat3.client.Dataset;
import uk.icat3.client.DatasetInclude;
import uk.icat3.client.InsufficientPrivilegesException_Exception;
import uk.icat3.client.NoSuchObjectFoundException_Exception;
import uk.icat3.client.SessionException_Exception;

/**
 * DDataset element
 * @author smw81327
 * @version $Id$
 */
public class DDataset extends uk.icat3.client.Dataset
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

	public void setIDatafiles(List idatafiles) {
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

}
