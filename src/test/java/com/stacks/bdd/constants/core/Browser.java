package com.stacks.bdd.constants.core;

public enum Browser {

	CHROME("Chrome"), FIREFOX("Firefox"), IE("IE"), EDGE("Edge");

	private String description;

	Browser(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return getDescription();
	}

}
