package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.rms.TicketListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class TicketListStepDef {
	private static Logger logger = Logger.getLogger(TicketListStepDef.class.getName());

	private final CucumberTestState state;


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
}