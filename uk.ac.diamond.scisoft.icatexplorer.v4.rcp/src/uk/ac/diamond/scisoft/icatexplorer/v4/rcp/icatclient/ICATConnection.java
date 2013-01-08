package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.icatclient;

public class ICATConnection {
	
	private String id;
	private String siteName;
	private String wsdlLocation;
	private String sftpServer;

	
	
	public ICATConnection(String id, String siteName, String sftpServer, String wsdlLocation) {
		
		this.id = id;
		this.siteName = siteName;
		this.sftpServer = sftpServer;
		this.wsdlLocation = wsdlLocation;
	}
	
	public ICATConnection(String wsdlLocation) {
		
		this.id = "testID";
		this.siteName = "testSite";
		this.wsdlLocation = wsdlLocation;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getWsdlLocation() {
		return wsdlLocation;
	}
	public void setWsdlLocation(String wsdlLocation) {
		this.wsdlLocation = wsdlLocation;
	}

	public String getSftpServer() {
		return sftpServer;
	}

	public void setSftpServer(String sftpServer) {
		this.sftpServer = sftpServer;
	}
	
}
