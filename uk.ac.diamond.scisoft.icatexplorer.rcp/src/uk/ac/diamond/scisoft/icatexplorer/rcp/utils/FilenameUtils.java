package uk.ac.diamond.scisoft.icatexplorer.rcp.utils;

import java.io.File;

public class FilenameUtils {

	private String fullPath;
	private char pathSeparator, extensionSeparator;

	public FilenameUtils(String str, char sep, char ext) {
		fullPath = str;
		pathSeparator = sep;
		extensionSeparator = ext;
	}

	public String extension() {
		int dot = fullPath.lastIndexOf(extensionSeparator);
		return fullPath.substring(dot + 1);
	}

	public String filename() { 
		int dot = fullPath.lastIndexOf(extensionSeparator);
		int sep = fullPath.lastIndexOf(pathSeparator);
		// return fullPath.substring(sep + 1, dot) ;
		return fullPath.substring(sep + 1, fullPath.length());
	}

	public String path() {
		int sep = fullPath.lastIndexOf(pathSeparator);
		return fullPath.substring(0, sep);
	}

	public String windowsPath() {
		String backslash = System.getProperty("file.separator");

		return fullPath.replace("/", backslash + backslash);
	}
	
	public String localFilePath(String downloadDir){
		File file1 = new File(downloadDir);
	    File file2 = new File(file1, filename());    
	    String localFilePath = file2.getPath();	
	    
		return localFilePath;
	}
	
	// public static void main(String[] args) {
	// final String FPATH = "/home/mem/index.html";
	// Filename myHomePage = new Filename(FPATH, '/', '.');
	// System.out.println("Extension = " + myHomePage.extension());
	// System.out.println("Filename = " + myHomePage.filename());
	// System.out.println("Path = " + myHomePage.path());
	// System.out.println("Local path = " + myHomePage.localPath());
	// }
}
