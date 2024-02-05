package com.stacks.bdd.cucumber.stepdefs.alef;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.alef.GradesPage;
import com.stacks.bdd.selenium.page.alef.SchoolsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class GradesStepDef {
    private static Logger logger = Logger.getLogger(GradesStepDef.class.getName());
    private final CucumberTestState state;

    public GradesStepDef(CucumberTestState state) {
        logger.trace("HomeStepDef");
        this.state = state;

    }

    @Then("^Edit Grades staff page appear$")
    public void editGradesStaffPageAppear() {
        logger.trace("Edit Grades staff page appear");
        GradesPage gradesPage = new GradesPage(state.getDriver());
        Assert.assertTrue("Edit grades staff page did not appear", gradesPage.editGradesAppeared());
    }

    @When("^I click on add grades button$")
    public void iClickOnAddGradesButton() {
        logger.trace("I click on add grades button");
        GradesPage gradesPage = new GradesPage(state.getDriver());
        gradesPage.clickOnAddGradeButton();
    }

    @Then("^Add grades page appear$")
    public void addGradesPageAppear() {
        logger.trace("Add grades page appear");
        GradesPage gradesPage = new GradesPage(state.getDriver());
        Assert.assertTrue("Add school staff page did not appear", gradesPage.addGradesAppeared());
    }

    @When("^I click on delete button in grades page$")
    public void iClickOnDeleteButtonInGradesPage() {
        logger.trace("I click on delete button in grades page");
        GradesPage gradesPage = new GradesPage(state.getDriver());
        gradesPage.clickOnDeleteButton();
    }

    @Then("^Delete grade pop up message appear$")
    public void deleteGradePopUpMessageAppear() {
        logger.trace("Delete grade pop up message appear");
        GradesPage gradesPage = new GradesPage(state.getDriver());
        Assert.assertTrue("Delete grades pop up message did not appear", gradesPage.deleteGradePopupMessage());
    }

    @When("^I click on edit grade button$")
    public void iClickOnEditGradeButton() {
        logger.trace("Delete grade pop up message appear");
        GradesPage gradesPage = new GradesPage(state.getDriver());
        gradesPage.clickOnEditGradeButton();
    }

    @Then("^I find \"([^\"]*)\" grade$")
    public void iFindGrade(String value) {
        logger.trace("I find " + value);
        GradesPage gradesPage = new GradesPage(state.getDriver());
        Assert.assertTrue("searched is not found", gradesPage.findSearchedGrade(value));
    }
}