package com.stacks.bdd.cucumber.stepdefs.alef;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.alef.ClassesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class ClassesStepDef {
    private static Logger logger = Logger.getLogger(ClassesStepDef.class.getName());
    private final CucumberTestState state;

    public ClassesStepDef(CucumberTestState state) {
        logger.trace("HomeStepDef");
        this.state = state;

    }

    @And("^I click on add class button$")
    public void iClickOnAddClassButton() {
        logger.trace("I click on add class button");
        ClassesPage classesPage = new ClassesPage(state.getDriver());
        classesPage.clickOnAddClassButton();
    }

    @And("^I search by \"([^\"]*)\" in class material dropdown menu$")
    public void iSearchByInClassMaterialDropdownMenu(String value) {
        logger.trace("I search by" + value + "in class material dropdown menu");
        ClassesPage classesPage = new ClassesPage(state.getDriver());
        classesPage.clickOnClassMaterialDropDownMenu();
        classesPage.searchClassMaterialDropDownMenu(value);
    }

    @Then("^I find pathway options$")
    public void iFindPathwayOptions() {
        logger.trace("I find pathway options");
        ClassesPage classesPage = new ClassesPage(state.getDriver());
        Assert.assertTrue("Pathway option is not found", classesPage.findPathwayOption());
    }

    @Then("^Edit class page appeared$")
    public void editClassPageAppeared() {
        logger.trace("Edit class page appeared");
        ClassesPage classesPage = new ClassesPage(state.getDriver());
        Assert.assertTrue("Edit class page is not opened successfully", classesPage.editClassPageAppeared());
    }

    @Then("^Add class page appears$")
    public void addClassPageAppears() {
        logger.trace("Add class page appears");
        ClassesPage classesPage = new ClassesPage(state.getDriver());
        Assert.assertTrue("Add class page is not opened successfully", classesPage.addClassPageAppeared());
    }
}