/*
 * Copyright 2012 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
				
		String knownHostsFilename = System.getProperty("user.home") + "/.ssh/known_hosts";
		try {
			jsch.setKnownHosts( knownHostsFilename );
		} catch (JSchException e) {
			logger.error("Error setting known hosts file for sftp", e);
		}

		Session session = null;
		try {
			session = jsch.getSession( fedid, remoteHost );
		} catch (JSchException e) {
			logger.error("Error getting sftp session with given fedid and remote host, fedid= " + fedid + "  - remote host= " + remoteHost, e);
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
			logger.error("Error connecting using sftp", e);
		}

		FilenameUtils fileUtils = new FilenameUtils(remoteFile, '/', '.');
		
		File file1 = new File(downloadDir);
	    File file2 = new File(file1,fileUtils.filename());
	    
	    String localFilePath = file2.getPath();//"C:\\gotFile";

	    //logger.debug("localFilePath: " + localFilePath);

		try {
			sftpChannel.get(remoteFile, localFilePath);//, monitor);
		} catch (SftpException e) {
			logger.error("Error getting file from remote host", e);
		}
		// OR
		//InputStream in = sftpChannel.get( remoteFile );		
		// process inputstream as needed
		
		sftpChannel.exit();
		session.disconnect();
		
		return localFilePath;
	} 
	

}
