package com.stacks.bdd.constants.genomi;

import com.stacks.bdd.constants.core.IUser;
import org.apache.log4j.Logger;

import java.util.EnumSet;

public enum User implements IUser {

	//COMMON USERS
	ADMIN_USER_BDD(null, "USER_BDD_ADMIN", "Cambiar_20", "BDD Admin"),


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
