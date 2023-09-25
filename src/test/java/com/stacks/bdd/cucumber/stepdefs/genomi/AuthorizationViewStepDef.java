package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.rms.AuthorizationViewPage;
import com.stacks.bdd.selenium.page.rms.TicketListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

public class AuthorizationViewStepDef {
    private static Logger logger = Logger.getLogger(AuthorizationViewStepDef.class.getName());

    private final CucumberTestState state;


    public AuthorizationViewStepDef(CucumberTestState state) {
        logger.trace("AuthorizationViewStepDef");
        this.state = state;
    }


    @And("^I edit role with name \"([^\"]*)\"$")
    public void iEditRoleWithName(String role) {
        logger.trace("I edit role with name " + role);
        AuthorizationViewPage authorizationViewPage = new AuthorizationViewPage(state.getDriver());
        authorizationViewPage.clickOnRoleEditButton(role);
    }

}