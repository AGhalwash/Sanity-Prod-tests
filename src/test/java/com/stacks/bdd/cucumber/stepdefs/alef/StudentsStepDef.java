package com.stacks.bdd.cucumber.stepdefs.alef;

import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.page.alef.ClassesPage;
import com.stacks.bdd.selenium.page.alef.StudentsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class StudentsStepDef {
    private static Logger logger = Logger.getLogger(StudentsStepDef.class.getName());
    private final CucumberTestState state;

    public StudentsStepDef(CucumberTestState state) {
        logger.trace("HomeStepDef");
        this.state = state;

    }

    @Then("^Edit student page appeared$")
    public void editStudentPageAppeared() {
        logger.trace("Edit student page appeared");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        Assert.assertTrue("Edit student page is not opened successfully", studentsPage.editStudentPageAppeared());
    }

    @Then("^Delete student pop up message appear$")
    public void deleteStudentPopUpMessageAppear() {
        logger.trace("Edit student page appeared");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        Assert.assertTrue("Delete student pop up did not appear", studentsPage.checkDeleteStudentPopupTitle());
    }

    @When("^I click on add student button$")
    public void iClickOnAddStudentButton() {
        logger.trace("Edit student page appeared");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        studentsPage.clickOnAddStudentButton();
    }

    @Then("^Add student page appeared$")
    public void addStudentPageAppeared() {
        logger.trace("Add student page appeared");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        Assert.assertTrue("Edit student page is not opened successfully", studentsPage.addStudentPageAppeared());
    }

    @When("^I click on Set QR Code button$")
    public void iClickOnSetQRCodeButton() {
        logger.trace("Add student page appeared");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        studentsPage.clickOnSetQRCodeButton();
    }

    @Then("^Set QR code count pop up appears$")
    public void setQRCodeCountPopUpAppears() {
        logger.trace("Set QR code count pop up appears");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        Assert.assertTrue("Set QR code count pop up did not appear", studentsPage.checkSetQRCODEPopup());
    }

    @Then("^Disable student pop up appear$")
    public void disableStudentPopUpAppear() {
        logger.trace("Disable student pop up appear");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        Assert.assertTrue("Disable student pop up did not appear", studentsPage.disableStudentPageAppeared());
    }

    @When("^I click on disable student button$")
    public void iClickOnDisableStudentButton() {
        logger.trace("Disable student pop up appear");
        StudentsPage studentsPage = new StudentsPage(state.getDriver());
        studentsPage.clickOnDisableStudentButton();
    }
}