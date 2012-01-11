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

package uk.ac.diamond.scisoft.icatexplorer.rcp.utils;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NetworkUtils {
	
	private static Logger logger = LoggerFactory.getLogger(NetworkUtils.class);

	public static boolean insideDLS(InetAddress addr) {

		String hostname = addr.getCanonicalHostName();
		
		if (hostname.contains("diamond.ac.uk")) {
			logger.debug("Connected from INSIDE Diamond: " + hostname);
			return true;
		} else {
			logger.debug("Connected from OUTSIDE Diamond: " + hostname);
			return false;
		}
	}

}
