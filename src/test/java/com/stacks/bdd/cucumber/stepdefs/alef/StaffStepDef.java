package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.alef.ClassesPage;
import com.stacks.bdd.selenium.page.alef.SchoolsPage;
import com.stacks.bdd.selenium.page.alef.StaffPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class StaffStepDef {
    private static Logger logger = Logger.getLogger(StaffStepDef.class.getName());
    private final CucumberTestState state;

    public StaffStepDef(CucumberTestState state) {
        logger.trace("HomeStepDef");
        this.state = state;

    }

    @Then("^Edit school staff page appear$")
    public void editSchoolStaffPageAppear() {
        logger.trace("Edit school staff page appear");
        StaffPage staffPage = new StaffPage(state.getDriver());
        Assert.assertTrue("Edit school staff page did not appear",staffPage.editStaffAppeared());
    }

    @When("^I click on disable button$")
    public void iClickOnDisableButton() {
        logger.trace("I click on disable button");
        StaffPage staffPage = new StaffPage(state.getDriver());
        staffPage.clickOnDisableButton();
    }

    @Then("^Disable staff pop up appear$")
    public void disableStaffPopUpAppear() {
        logger.trace("Disable staff pop up appear");
        StaffPage staffPage = new StaffPage(state.getDriver());
        Assert.assertTrue("Disable staff pop up did not appear",staffPage.checkDisableStaffPopupMessage());
    }

    @When("^I click on add staff button$")
    public void iClickOnAddStaffButton() {
        logger.trace("I click on add staff button");
        StaffPage staffPage = new StaffPage(state.getDriver());
        staffPage.clickOnAddStaffButton();
    }

    @Then("^Add school staff page appear$")
    public void addSchoolStaffPageAppear() {
        logger.trace("Add school staff page appear");
        StaffPage staffPage = new StaffPage(state.getDriver());
        Assert.assertTrue("Add school staff page did not appear",staffPage.addStaffAppeared());
    }
}