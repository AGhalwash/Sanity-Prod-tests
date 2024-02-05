package com.stacks.bdd.constants.genomi;

import com.stacks.bdd.constants.core.IUser;
import org.apache.log4j.Logger;

import java.util.EnumSet;

public enum User implements IUser {

	//COMMON USERS
	ADMIN_USER_DEMO(null, "demoadmin@alef.ae", "4cb3e8fa7bc539de18e902c835d1df8625516d8b", "ADMIN_USER_DEMO"),
	ADMIN_USER_US(null, "zaghamussuperadmin@alef.ae", "zaghamussuperadmin", "ADMIN_USER_US"),
	ADMIN_USER_IDN(null, "zagham-indo@alefeducation.com", "Alef@7HgD&ZV", "ADMIN_USER_IDN"),
	ADMIN_USER_MOE(null, "ishar@alefeducation.com", "ishar12345", "ADMIN_USER_MOE"),
	ADMIN_USER_SCHOOLS(null, "ahmed.schools@alef.ae", "4cb3e8fa7bc539de18e902c83", "ADMIN_USER_SCHOOLS")


	;

	static Logger logger = Logger.getLogger(User.class.getName());
	
	private final String name;
	private final String username;
	private final String password;
	private final String role;
	
	User(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public static User getUserByRole(String role) {
		logger.trace("getUserByRole :: " + role);
		EnumSet<User> allUsers = EnumSet.allOf(User.class);
		for (User user : allUsers) {
			if (role.equals(user.role)) {
				return user;
			}
		}

		throw new IllegalArgumentException("User with role \"" + role + "\" not found.");
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

}
