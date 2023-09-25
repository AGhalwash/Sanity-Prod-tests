package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.driver.core.Waiter;
import com.stacks.bdd.selenium.page.rms.AddTicketPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static com.stacks.bdd.selenium.locator.rms.HomeLocator.PASSWORD_TEXT;
import static com.stacks.bdd.selenium.locator.rms.HomeLocator.USER_TEXT;

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
		Waiter.sleep(9000);
	}

	@Then("^I find \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" radio buttons$")
	public void iFindRadioButtons(String button1, String button2, String button3, String button4) {
		logger.trace("I find " + button1 +  button2 + button3 + button4 + "radio buttons");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		Assert.assertTrue("Radio button did not appear correctly",addTicketPage.checkFourRadioButtons(button1,button2,button3,button4));
	}

	@And("^I (don't|do) find \"([^\"]*)\" radio button$")
	public void iDonTFindRadioButton(String status, String button) {
		logger.trace("I don't find " + button + "radio button");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		switch (status) {
			case "do":
		    Assert.assertTrue("Radio button did not appear correctly", addTicketPage.checkOneRadioButton(button));
				break;
			case "don't":
				Assert.assertFalse("Radio button did not appear correctly", addTicketPage.checkOneRadioButton(button));
				break;
			default:
				throw new IllegalArgumentException(button + Constants.NOT_FOUND);
		}
	}
}