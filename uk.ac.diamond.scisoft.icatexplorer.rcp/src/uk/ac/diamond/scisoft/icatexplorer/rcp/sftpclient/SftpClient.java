package uk.ac.diamond.scisoft.icatexplorer.rcp.sftpclient;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.diamond.scisoft.icatexplorer.rcp.utils.FilenameUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;

public class SftpClient {
	
	private static Logger logger = LoggerFactory.getLogger(SftpClient.class);
	
	public SftpClient(){
		
	}
	
	public String downloadFile(String fedid, String password, String remoteHost, String remoteFile, String downloadDir){
		
		JSch jsch = new JSch();
		
		
		String knownHostsFilename = "/home/username/.ssh/known_hosts";
		try {
			jsch.setKnownHosts( knownHostsFilename );
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = null;
		try {
			session = jsch.getSession( fedid, remoteHost );
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		{
		  // "interactive" version
		  // can selectively update specified known_hosts file 
		  // need to implement UserInfo interface
		  // MyUserInfo is a swing implementation provided in 
		  //  examples/Sftp.java in the JSch dist
		  UserInfo ui = new Sftp.MyUserInfo();
		  session.setUserInfo(ui);

		  // OR non-interactive version. Relies in host key being in known-hosts file
		  session.setPassword( password );
		}

		
		Channel channel;
		ChannelSftp sftpChannel = null;
		try {
			session.connect();
			channel = session.openChannel( "sftp" );
			channel.connect();
			sftpChannel = (ChannelSftp) channel;
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FilenameUtils fileUtils = new FilenameUtils(remoteFile, '/', '.');
		
		File file1 = new File(downloadDir);
	    File file2 = new File(file1,fileUtils.filename());
	    
	    String localFilePath = file2.getPath();//"C:\\gotFile";

	    logger.debug("localFilePath: " + localFilePath);

		try {
			sftpChannel.get(remoteFile, localFilePath );
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// OR
		//InputStream in = sftpChannel.get( remoteFile );		
		// process inputstream as needed
		
		sftpChannel.exit();
		session.disconnect();
		
		return localFilePath;
	} 
	

}
