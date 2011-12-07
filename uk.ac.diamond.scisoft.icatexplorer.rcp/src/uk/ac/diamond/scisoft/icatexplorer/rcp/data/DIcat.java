package uk.ac.diamond.scisoft.icatexplorer.rcp.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DIcat {

	private DInvestigation[] children = new DInvestigation[0];
    private Object rootElement;
    
    private String host;
    private String fedid;
	private int nbInvestigations;
    
    private static final Logger logger = LoggerFactory.getLogger(DIcat.class); 

    
	/**
     * Constructor 
	 * @param string 
     */
    public DIcat(String fedid, String host)
    {
        logger.debug("creating dicat object");
    	//super(name);
        this.fedid = fedid;
        this.host = host;

    }

    public void setChildren(DInvestigation[] children)
    {
        if (children != null)
        {
            setChildrensParent(null, this.children);
        }
        this.children = children;
        setChildrensParent(this, this.children);
    }

    /**
     * Sets children's parent
     * @param dInvestigation parent to be set
     * @param children children to set the parent
     */
    private static void setChildrensParent(DIcat dIcat, DInvestigation[] children)
    {
        for (int i = 0; i < children.length; i++)
        {
            children[i].setParent(dIcat);
        }
    }

    // getter and setter
    public DInvestigation[] getChildren()
    {
        return children;
    }

    public void setRoot(Object parentElement)
    {
        this.rootElement = parentElement;
    }

    public Object getRoot()
    {
        return rootElement;
    }
    
    
   //
    public String getHost() {
		return host;
	}


	public String getFedid() {
		return fedid;
	}

	public void setNbInvestigations(int nbInv) {

		nbInvestigations = nbInv;
		
	}
	public int getNbInvestigations() {

		return nbInvestigations;		
	}


}

