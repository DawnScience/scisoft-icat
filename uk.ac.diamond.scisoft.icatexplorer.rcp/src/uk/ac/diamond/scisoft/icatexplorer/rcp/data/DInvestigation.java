package uk.ac.diamond.scisoft.icatexplorer.rcp.data;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.analysis.dataset.IMetadataProvider;
import uk.ac.diamond.scisoft.analysis.io.IMetaData;
import uk.ac.diamond.scisoft.analysis.io.MetaDataAdapter;


/**
 * @author smw81327
 * @version $Id$
 */
public class DInvestigation extends uk.icat3.client.Investigation implements IMetadataProvider
{
	
    private static final Logger logger = LoggerFactory.getLogger(DInvestigation.class); 

	
    private DDataset[] children = new DDataset[0];
    
    private long id ;
    private String inv_number;
    private String visit_id; 
    private String instrument;
    private String title;
    private int nbDatasets;
	private DIcat dIcat;

    
	/**
     * Constructor 
     */
    public DInvestigation(long id, String visit_id)
    {
        //super(name);
        this.id = id;
        this.visit_id = visit_id;
    }

   //
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

	public String getVisitId() {
		return visit_id;
	}

	public void setVisitId(String visit_id) {
		this.visit_id = visit_id;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getTitle() {
		return title;
	}

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
    public void setParent(DIcat dIcat)
    {
        this.dIcat = dIcat;
    }

    public DIcat getParent()
    {
        return dIcat;
    }

	// getter and setter
    public DDataset[] getChildren()
    {
        logger.debug("DInvestigation nb children: " + children.length);
    	return children;
    }
    
    public void setChildren(DDataset[] children)
    {
        if (children != null)
        {
            setChildrensParent(null, this.children);
        }
        this.children = children;
        setChildrensParent(this, this.children);
    }
    
    private static void setChildrensParent(DInvestigation dInv, DDataset[] children)
    {
        for (int i = 0; i < children.length; i++)
        {
            children[i].setParent(dInv);
        }
    }

	@Override
	public IMetaData getMetadata() throws Exception {
		TreeMap <String, String> pairs = new TreeMap<String, String>();	
		pairs.put("INVESTIGATION ID", "123");
		pairs.put("INVESTIGATION NAME","some name");
		
		
		return new MetaDataAdapter((Collection<String>)pairs, null);
	}


}
