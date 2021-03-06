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

package uk.ac.diamond.scisoft.icatexplorer.rcp.icatclient;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ICATSessions {
	
	private static final Logger logger = LoggerFactory.getLogger(ICATSessions.class);
	
	public static HashMap<String, Object> icatsMap = new HashMap<String, Object>();
	
	public static void add(String sessionId, ICATClient icatClient){
		icatsMap.put(sessionId, icatClient);
		logger.info("added: " + sessionId + " - " + icatClient.projectName);
	}
	
	public static void remove(String sessionId){
		icatsMap.remove(sessionId);
		logger.info("removed: " + sessionId + " - " + ((ICATClient)icatsMap.get(sessionId)).projectName);
	}
	
	public static ICATClient get(String sessionId){	
		return (ICATClient) icatsMap.get(sessionId);
	}

	public static boolean hasSessionId(String sessionId) {
		return icatsMap.containsKey(sessionId);
	}
	
}
