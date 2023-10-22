package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.rms.TicketListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class TicketListStepDef {
	private static Logger logger = Logger.getLogger(TicketListStepDef.class.getName());

	private final CucumberTestState state;
	private static final String STEPDEF = "HomeStepDef";
	private static final String SUBJECT = "subject";


	public TicketListStepDef(CucumberTestState state) {
		logger.trace("TicketListStepDef");
		this.state = state;

	}

	@And("^I open add ticket to call center page$")
	public void iOpenAddTicketToCallCenterPage() {
		logger.trace("I open add ticket to call center page");
		TicketListPage ticketListPage = new TicketListPage(state.getDriver());
		ticketListPage.openAddTicketPage();
	}

	@Then("^I don't find add ticket button$")
	public void iDonTFindAddTicketButton() {
		logger.trace("I don't find add ticket button");
		TicketListPage ticketListPage = new TicketListPage(state.getDriver());
		Assert.assertFalse("Add ticket button appeared", ticketListPage.checkAddTicketButton());
	}

	@Then("^I (find|don't find) the created ticket$")
	public void iFindTheCreatedTicket(String status) {
		logger.trace("I (find|don't find) the created ticket");
		TicketListPage ticketListPage = new TicketListPage(state.getDriver());
		String subject = state.getDataTransferById(STEPDEF,SUBJECT);
		switch (status) {
			case "find":
				Assert.assertTrue("ticket is not found", ticketListPage.checkTicketSubject(subject));
				break;
			case "don't find":
				Assert.assertFalse("ticket is found", ticketListPage.checkTicketSubject(subject));
				break;
			default:
				throw new IllegalArgumentException(status + Constants.NOT_FOUND);
		}
	}

	@When("^I click on \"([^\"]*)\" ticket status button$")
	public void iClickOnTicketStatusButton(String status) {
		logger.trace("I click on \"([^\"]*)\" ticket status button");
		TicketListPage ticketListPage = new TicketListPage(state.getDriver());
		ticketListPage.clickOnTicketStatusButton(status);
	}

	@And("^I click on sort by ticket number$")
	public void iClickOnSortByTicketNumber() {
		logger.trace("I click on sort by ticket number");
		TicketListPage ticketListPage = new TicketListPage(state.getDriver());
		ticketListPage.clickOnSortByTicketNumber();
	}
}