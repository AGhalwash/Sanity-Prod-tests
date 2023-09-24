package com.stacks.bdd.constants.core;

public interface IUser {
	String getRole();

	String getName();

	String getUsername();

	String getPassword();

	default String getCenterId() {
		return SystemProperties.getCenterId();
	}
}
