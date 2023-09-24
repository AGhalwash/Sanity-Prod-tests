package com.stacks.bdd.cucumber.hooks;

import com.stacks.bdd.cucumber.runner.CucumberTestState;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TaggedHooks {

	private final CucumberTestState state;
	
	public TaggedHooks(CucumberTestState state) {
		this.state = state;
	}
	
	@Before(value = { "@tag" }, order = 1)
	public void beforeTag() { }
	
	@After(value = { "@tag" }, order = 1)
	public void afterTag() { }
}
