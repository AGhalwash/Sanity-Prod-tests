package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.rms.AddTicketPage;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class AddTicketStepDef {
	private static Logger logger = Logger.getLogger(AddTicketStepDef.class.getName());

	private final CucumberTestState state;


	public AddTicketStepDef(CucumberTestState state) {
		logger.trace("AddTicketStepDef");
		this.state = state;
	}


	@When("^I click on \"([^\"]*)\" radio button$")
	public void iClickOnRadioButton(String type) {
		logger.trace("I click on " + type + "radio button");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		addTicketPage.selectClientType(type);
	}
}