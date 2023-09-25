package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.rms.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

public class HomeStepDef {
	private static Logger logger = Logger.getLogger(HomeStepDef.class.getName());

	private final CucumberTestState state;


	public HomeStepDef(CucumberTestState state) {
		logger.trace("HomeStepDef");
		this.state = state;

	}


	@Given("^I Login to RMS With \"([^\"]*)\"$")
	public void iLoginToRMSWith(String user) {
		logger.trace("I Login to RMS With" + user);
		HomePage homePage = new HomePage(state.getDriver());
		homePage.loginToRMS(user);
	}

	@And("^I change language to Arabic$")
	public void iChangeLanguageToArabic() {
		logger.trace("I change language to Arabic");
		HomePage homePage = new HomePage(state.getDriver());
		homePage.changeLanguageToArabic();
	}

	@And("^I open View reports page$")
	public void iOpenViewReportsPage() {
		logger.trace("I open View reports page");
		HomePage homePage = new HomePage(state.getDriver());
		homePage.openViewReportsPage();
	}

	@And("^I open Authorization View Page page$")
	public void iOpenAuthorizationViewPagePage() {
		logger.trace("I open Authorization View Page page");
		HomePage homePage = new HomePage(state.getDriver());
		homePage.openAuthorizationViewPage();
	}
}