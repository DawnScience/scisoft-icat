package uk.ac.diamond.actors.icat;

import java.util.Hashtable;

public class Sessions {
	
	static Hashtable<String, ICATClient> sessions = new Hashtable<String, ICATClient>();

	public static void addSession(String token, ICATClient client) {
		sessions.put(token, client);
	}

	public static void removeSession(String token) {
		sessions.remove(token);
	}
	
	public static ICATClient getSession(String token) {
		return sessions.get(token);
	}
}
