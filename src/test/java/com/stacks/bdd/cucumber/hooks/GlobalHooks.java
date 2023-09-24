package com.stacks.bdd.cucumber.hooks;

import cucumber.api.java.After;
import org.apache.log4j.Logger;

import com.stacks.bdd.cucumber.runner.CucumberTestState;

import cucumber.api.java.Before;

public class GlobalHooks {

	private static final Logger logger = Logger.getLogger(GlobalHooks.class.getName());

	private static boolean executed = false;
	private final CucumberTestState localState;

	public GlobalHooks(CucumberTestState localState) {
		this.localState = localState;
	}

	@Before(order = 0)
	public void startBrowser() {
		if (!executed) {
			logger.info("start browser");

			// Register the aferAll() method
			Runtime.getRuntime().addShutdownHook(new Thread(this::stopBrowser));

			executed = true;
		}
	}

    @After(order = 0)
	private void stopBrowser() {
	}
}
