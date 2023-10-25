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

public class AddTicketStepDef {
	private static Logger logger = Logger.getLogger(AddTicketStepDef.class.getName());

	private final CucumberTestState state;
	private static final String STEPDEF = "HomeStepDef";
	private static final String SUBJECT = "subject";

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

	@Then("^I find \"([^\"]*)\" branch name$")
	public void iFindBranchName(String branch) {
		logger.trace("I find " + branch + "branch name");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		Assert.assertTrue("Branch name is not displayed",addTicketPage.checkBranchName(branch));
		Assert.assertTrue("I find all branches names",addTicketPage.unwantedValues());

	}

	@And("^I (do|don't) find all branches$")
	public void iDoFindAllBranches(String status) {
		logger.trace("I "+ status + "find all branches");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		switch (status) {
			case "do":
				Assert.assertFalse("I find all branches names",addTicketPage.unwantedValues());
				break;
			case "don't":
				Assert.assertTrue("I did not find all branches names",addTicketPage.unwantedValues());
				break;
			default:
				throw new IllegalArgumentException(status + Constants.NOT_FOUND);
		}
	}

	@And("^I enter mandatory fields$")
	public void iEnterMandatoryFields() {
		logger.trace("I enter mandatory fields");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		addTicketPage.fillClientPhoneNumber();
		addTicketPage.fillClientName();
		state.addElementToDataTransfer(STEPDEF,SUBJECT,addTicketPage.fillRequestAddress());
		addTicketPage.fillDescription();
	}

	@And("^I open \"([^\"]*)\" list in (ticket source|appointment of official) section$")
	public void iOpenListInTicketSourceSection(String list, String section) {
		logger.trace("I open " +  list);
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		switch (section) {
			case "ticket source":
				addTicketPage.openTicketSourceDropdownList(list);
				break;
			case "appointment of official":
				addTicketPage.openAppointmentOfOfficialDropdownList(list);
				break;
			default:
				throw new IllegalArgumentException(section + Constants.NOT_FOUND);
		}
	}

	@And("^I choose \"([^\"]*)\" branch$")
	public void iChooseBranch(String branch)  {
		logger.trace("I choose " + branch + "branch");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		addTicketPage.clickOnBranchName(branch);
	}

	@And("^I click on \"([^\"]*)\" radio button in appointment of official section$")
	public void iClickOnRadioButtonInAppointmentOfOfficialSection(String button)  {
		logger.trace("I click on \"([^\"]*)\" radio button in appointment of official section");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		addTicketPage.clickOnAppointmentOfOfficialRadioButton(button);
	}

	@And("^I enter mandatory fields without client name$")
	public void iEnterMandatoryFieldsWithoutClientName() {
		logger.trace("I enter mandatory fields");
		AddTicketPage addTicketPage = new AddTicketPage(state.getDriver());
		addTicketPage.fillClientPhoneNumber();
		state.addElementToDataTransfer(STEPDEF,SUBJECT,addTicketPage.fillRequestAddress());
		addTicketPage.fillDescription();
	}
}