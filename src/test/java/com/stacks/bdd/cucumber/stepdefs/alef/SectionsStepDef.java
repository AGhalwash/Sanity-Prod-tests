package com.stacks.bdd.cucumber.stepdefs.alef;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.alef.SectionsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class SectionsStepDef {
    private static Logger logger = Logger.getLogger(SectionsStepDef.class.getName());
    private final CucumberTestState state;

    public SectionsStepDef(CucumberTestState state) {
        logger.trace("HomeStepDef");
        this.state = state;

    }

    @Then("^Edit section page appeared$")
    public void editSectionPageAppeared() {
        logger.trace("Edit section page appeared");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        Assert.assertTrue("Edit section page did not appear", sectionsPage.editSectionPageAppeared());
    }

    @Then("^Delete section pop up message appear$")
    public void deleteSectionPopUpMessageAppear() {
        logger.trace("Delete section pop up message appear");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        Assert.assertTrue("Delete section pop up did not appear", sectionsPage.deleteSectionPopupAppear());
    }

    @When("^I click on add section button$")
    public void iClickOnAddSectionButton() {
        logger.trace("Delete section pop up message appear");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        sectionsPage.clickOnAddSectionButton();
    }

    @Then("^Add section page appeared$")
    public void addSectionPageAppeared() {
        logger.trace("Add section page appeared");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        Assert.assertTrue("Add section page did not appear", sectionsPage.addSectionPageAppeared());
    }


    @Then("^I find section \"([^\"]*)\" is disabled$")
    public void iFindSectionIsDisabled(String value) {
        logger.trace("I find section " + value + "is disabled");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        Assert.assertTrue("Add section page did not appear", sectionsPage.checkSectionIsDisabled(value));
    }

    @When("^I click on (disable|enable) section button$")
    public void iClickOnDisableSectionButton(String status) {
        logger.trace("I click on disable section button");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        switch (status){
            case "disable":
                sectionsPage.clickOnDisableSectionButton();
                break;
            case "enable":
                sectionsPage.clickOnEnableSectionButton();
                break;
            default:
                throw new IllegalArgumentException(status + Constants.NOT_FOUND);
        }
    }

    @When("^I click on generate sections button$")
    public void iClickOnGenerateSectionsButton() {
        logger.trace("I click on disable section button");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        sectionsPage.clickOnGenerateSectionsButton();
    }

    @Then("^Generate sections page appears$")
    public void generateSectionsPageAppears() {
        logger.trace("Generate sections page appears");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        Assert.assertTrue("Generate sections page did not appear", sectionsPage.generateSectionsPageAppeared());
    }

    @When("^I click on delete section button$")
    public void iClickOnDeleteSectionButton() {
        logger.trace("I click on delete section button");
        SectionsPage sectionsPage = new SectionsPage(state.getDriver());
        sectionsPage.clickOnDeleteSectionButton();
    }
}