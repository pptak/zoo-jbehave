package net.zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class ZOOSystem {

	public enum SYSTEM_RESPONSE {
		OK, ERROR, TRY_AGAIN
	};

	public static final String PUBLIC_ACCESS_ROLE_NAME = "PUBLIC";

	private static final List<String> BROWSERS = new ArrayList<>();
	private static final List<String> USERS = new ArrayList<>();
	private static final Map<String, String> USER_CORRECT_PASS = new HashedMap<>();
	private static final Map<String, String> GORILLA_PINS = new HashedMap<>();
	private static final String START_URL = "zoo.system.org";
	private static final List<String> USER_LOGED = new ArrayList<>();
	private static final Map<String, List<String>> USERS_ROLES = new HashedMap<>();

	static {
		USERS.add("Marc");
		USERS.add("Bill");
		USERS.add("Sussan");
		USERS.add("Anna");

		USER_CORRECT_PASS.put("Marc", "dksnskadnka");
		USER_CORRECT_PASS.put("Sussan", "Hmal-02oo20");
		USER_CORRECT_PASS.put("Anna", "XyB)()_--");
		USER_CORRECT_PASS.put("Bill", "%^GHkKKąśćęłóź+_>><<<");

		BROWSERS.add("Chrome");
		BROWSERS.add("Edge");
		BROWSERS.add("IE");
		BROWSERS.add("Opera");
		BROWSERS.add("Firefox");

		GORILLA_PINS.put("Marc", "123456");
		GORILLA_PINS.put("Bill", "654321");
		GORILLA_PINS.put("Sussan", "121212");
		GORILLA_PINS.put("Anna", "32345");

		USERS_ROLES.put("Marc", Arrays.asList(PUBLIC_ACCESS_ROLE_NAME, "MANAGER"));
		USERS_ROLES.put("Bill", Arrays.asList(PUBLIC_ACCESS_ROLE_NAME));
		USERS_ROLES.put("Sussan", Arrays.asList(PUBLIC_ACCESS_ROLE_NAME, "GORILLA_GUARDIAN"));
		USERS_ROLES.put("Anna", Arrays.asList(PUBLIC_ACCESS_ROLE_NAME, "LION_GUARDIAN", "DEPUTY_MANAGER"));

	}

	public boolean userExists(String user) {
		return USERS.contains(user);
	}

	public boolean login(String user, String password) {
		boolean ok = false;
		String pass = USER_CORRECT_PASS.get(user);
		if (pass != null) {
			ok = USER_CORRECT_PASS.get(user).equals(password);
			if (ok)
				USER_LOGED.add(user);
		}
		return ok;
	}

	/**
	 * Test id browser is supported by application
	 * 
	 * @param browser
	 *            name
	 * @return if is supported
	 */
	public boolean supportedBrowser(String browser) {
		return BROWSERS.contains(browser);
	}

	public boolean checkStartUrl(String url) {
		return START_URL.equals(url);
	}

	public boolean checkGorillaPIN(String user, String pin) {
		return GORILLA_PINS.get(user).contains(pin);
	}

	public boolean isUserLoged(String user) {
		return USER_LOGED.contains(user);
	}

	public List<String> userRoles(String user) {
		return USERS_ROLES.get(user);
	}
}
