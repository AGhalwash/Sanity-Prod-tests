package com.stacks.bdd.cucumber.hooks;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.driver.core.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import java.io.IOException;

public class ScenarioHooks {

	private static final Logger logger = Logger.getLogger(ScenarioHooks.class.getName());

	private final CucumberTestState state;

	public ScenarioHooks(CucumberTestState state) {
		this.state = state;
	}

	@Before(order = 2)
	public void deleteCookiesBeforeScenario() {
		logger.info("Set driver for scenario");
		state.setDriver(BrowserFactory.getBrowser());
		logger.info("delete cookies before");
		if (state.getDriver() != null) {
			state.getDriver().deleteAllCookies();
		}
	}

	@Before(order = 3)
	public void goToDefaultContent(Scenario scenario) {
		logger.info("go to default content");
		state.getDriver().switchToDefaultContent();
		state.getDriver().getSeleniumWebDriver().manage().window().maximize();
	}

	@Before(order = 4)
	public void logBeforeScenario(Scenario scenario) {
		String msg = "Entering scenario " + scenario.getId();
		logger.info(msg);
	}

	@After(order = 2)
	public void closeOtherWindowsAfterScenario(Scenario scenario) {
		logger.info("close other windows after");
		if (state.getDriver() != null) {
			state.getDriver().closeAllWindowsOtherThanLogin();
		}
		logger.info("stop browser");
		if (state.getDriver() != null || !state.getDriver().getSeleniumWebDriver().toString().contains("(null)")) {
			state.getDriver().quit();
		}
	}

	@After(order = 3)
	public void deleteCookiesAfterScenario() {
		logger.info("delete cookies after");
		if (state.getDriver() != null) {
			state.getDriver().deleteAllCookies();
		}
	}

	@After(order = 4)
	public void embedScreenshotOnFailure(Scenario scenario) throws IOException {
		logger.info("screenshot");
		if (state.getDriver() != null && scenario.isFailed()) {
			if(state.getDriver().numberOfWindows()>1){
				state.getDriver().switchToWindow(1);
				scenario.embed(state.getDriver().getScreenshot(), "image/png");
				state.getDriver().takeExtendReportScreenshot(scenario);
				state.getDriver().switchToWindow(0);
			}
			else {
				scenario.embed(state.getDriver().getScreenshot(), "image/png");
				state.getDriver().takeExtendReportScreenshot(scenario);
			}
		}
	}

	@After(order = 5)
	public void logAfterScenario(Scenario scenario) {
		String msg = "Exiting scenario " + scenario.getId() + " with status " + scenario.getStatus();
		logger.info(msg);
	}
}
