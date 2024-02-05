package com.stacks.bdd.cucumber.stepdefs.genomi;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.constants.genomi.User;
import com.stacks.bdd.cucumber.runner.CucumberTestState;
import com.stacks.bdd.selenium.driver.core.Waiter;
import com.stacks.bdd.selenium.page.alef.ClassesPage;
import com.stacks.bdd.selenium.page.alef.LogInPage;
import com.stacks.bdd.selenium.page.alef.SchoolsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class SchoolsStepDef {
    private static Logger logger = Logger.getLogger(SchoolsStepDef.class.getName());
    private final CucumberTestState state;
    public static final String STEPDEF = "SchoolsStepDef";
    private static final String SECCION = "SECCION";

    public SchoolsStepDef(CucumberTestState state) {
        logger.trace("HomeStepDef");
        this.state = state;

    }


    @Given("^I Login to ALEF With \"([^\"]*)\" in environment \"([^\"]*)\"$")
    public void iLoginToALEFWithInEnvironment(String userToLogIn, String environment) {
        logger.trace("i_log_in_as " + userToLogIn);
        User user = User.getUserByRole(userToLogIn);
        state.setUser(user);
        LogInPage page = new LogInPage(state.getDriver());
        page.openPage(environment);
        page.login(user.getUsername(), user.getPassword());
    }

    @And("^I choose organization \"([^\"]*)\"$")
    public void iChooseOrganization(String organization) {
        logger.trace("I choose organization" + organization);
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.chooseOrganization(organization);
    }

    @And("^I click on \"([^\"]*)\" section$")
    public void iClickOnSection(String section) {
        logger.trace("I click on" + section + "section");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.clickOnSection(section);
    }

    @And("^I click on first school$")
    public void iClickOnFirstSchool() {
        logger.trace("I click on first school");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.clickOnFirstSchool();
    }


    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String value) {
        logger.trace("I search for " + value);
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.searchFor(value);
        state.addElementToDataTransfer(STEPDEF, SECCION, value);
    }

    @Then("^I find \"([^\"]*)\"$")
    public void iFind(String value) {
        logger.trace("I find " + value);
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        Assert.assertTrue("searched is not found", schoolsPage.findSearched(value));
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String value) {
        logger.trace("I select " + value);
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.clickOnRowByName(value);
        state.addElementToDataTransfer(STEPDEF, SECCION, value);
    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() {
        logger.trace("I click on edit button");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.clickOnEditButton();
    }

    @Then("^Class page appeared$")
    public void classPageAppeared() {
        logger.trace("Class page appeared");
        ClassesPage classesPage = new ClassesPage(state.getDriver());
        state.getDataTransferById(STEPDEF, SECCION);
        Assert.assertTrue("Class page did not appear",classesPage.classPageAppeared(state.getDataTransferById(STEPDEF, SECCION)));
    }

    @When("^I click on delete button$")
    public void iClickOnDeleteButton() {
        logger.trace("I click on delete button");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        schoolsPage.clickOnDeleteButton();
    }

    @Then("^Delete pop up message appear$")
    public void deletePopUpMessageAppear() {
        logger.trace("Delete pop up message appear");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        Assert.assertTrue("Delete pop up message appear",schoolsPage.checkDeletePopupTitle());
    }

    @Then("^School details page appears$")
    public void schoolDetailsPageAppears() {
        logger.trace("School details page appears");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        state.getDataTransferById(STEPDEF, SECCION);
        Assert.assertTrue("Schools page did not appear",schoolsPage.schoolDetailsPageAppeared(state.getDataTransferById(STEPDEF, SECCION)));
    }

    @Then("^Edit school page appears$")
    public void editSchoolPageAppears() {
        logger.trace("Edit school page appears");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        state.getDataTransferById(STEPDEF, SECCION);
        Assert.assertTrue("Schools page did not appear",schoolsPage.editSchoolPageAppeared(state.getDataTransferById(STEPDEF, SECCION)));
    }

    @When("^I click on (delete|disable) button for schools$")
    public void iClickOnDeleteButtonForSchools(String status) {
        logger.trace("I click on delete button for schools");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        switch (status){
            case "delete":
                schoolsPage.clickOnDeleteSchoolButton();
                break;
            case "disable":
                schoolsPage.clickOnDisableSchoolButton();
                break;
            default:
                throw new IllegalArgumentException(status + Constants.NOT_FOUND);
        }
    }

    @Then("^(Delete|Disable) school pop up message appear$")
    public void deleteSchoolPopUpMessageAppear(String status) {
        logger.trace("Delete school pop up message appear");
        SchoolsPage schoolsPage = new SchoolsPage(state.getDriver());
        switch (status){
            case "Delete":
               Assert.assertTrue("Delete school pop up message did not appear",schoolsPage.deleteSchoolPopupMessage());
                break;
            case "Disable":
                Assert.assertTrue("Disable school pop up message did not appear",schoolsPage.disableSchoolPopupMessage());
                break;
            default:
                throw new IllegalArgumentException(status + Constants.NOT_FOUND);
        }
    }
}
