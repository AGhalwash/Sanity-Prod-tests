package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.ClassesLocator.*;
import static com.stacks.bdd.selenium.locator.alef.SchoolsLocator.*;


public class SchoolsPage extends PageObject {

    public SchoolsPage(CustomWebDriver driver) {
        super(driver, SchoolsPage.class.getName());
    }

    public void chooseOrganization(String organization) {
        Waiter.waitExpectedConditionsVisibilityOf(driver, ORGANIZATION_DROP_DOWN.by(), 5);
        driver.clickOn(ORGANIZATION_DROP_DOWN.by());
        Waiter.waitExpectedConditionsVisibilityOf(driver, ORGANIZATION_DROP_DOWN_OPTION.by(organization), 5);
        driver.clickOnAndVerify(ORGANIZATION_DROP_DOWN_OPTION.by(organization));
    }

    public void clickOnFirstSchool() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, SCHOOLS_FIRST_ROW.by(), 5);
        driver.clickOnAndVerify(SCHOOLS_FIRST_ROW.by());
    }

    public void clickOnSection(String section) {
        Waiter.waitExpectedConditionsVisibilityOf(driver, CLASSES_SECTION.by(section), 5);
        driver.clickOn(CLASSES_SECTION.by(section));
    }

    public void searchFor(String value) {
        Waiter.sleep(80000);
        Waiter.waitExpectedConditionsVisibilityOf(driver, SEARCH_TEXT_FIELD.by(), 5);
        driver.sendKeysTo(value, SEARCH_TEXT_FIELD.by(),5);
        driver.clickOn(SEARCH_ICON_BUTTON);
        Waiter.sleep(3000);
    }

    public boolean findSearched(String value) {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, FIRST_ROW_BY_NAME.by(value), 5);
    }

    public void clickOnRowByName(String value) {
        Waiter.waitExpectedConditionsVisibilityOf(driver, FIRST_ROW_BY_NAME.by(value), 10);
        driver.clickOnAndVerify(FIRST_ROW_BY_NAME.by(value));
    }

    public void clickOnEditButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, EDIT_BUTTON.by(), 5);
        driver.clickOnAndVerify(EDIT_BUTTON.by());
    }

    public void clickOnDeleteButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_BUTTON.by(), 5);
        driver.clickOnAndVerify(DELETE_BUTTON.by(), DELETE_POP_UP_TITLE.by());
    }

    public boolean checkDeletePopupTitle() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_POP_UP_TITLE.by(), 5);
    }

    public boolean classPageAppeared(String value) {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by(value), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Basic Information"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Contact Information"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class schedule"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by(" Edit class"), 5);
        boolean condition6 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("+ Add Student"), 5);
        boolean condition7 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("+ Add Schedule"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7);
    }

    public boolean schoolDetailsPageAppeared(String value) {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by(value), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Basic Information"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Contact Information"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("School Overview"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Active Students"), 5);
        boolean condition6 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Active Teachers"), 5);
        boolean condition7 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Sections"), 5);
        boolean condition8 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Grades"), 5);
        boolean condition9 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Active Admins"), 5);
        boolean condition10 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Active Leaders"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7 && condition8 && condition9 && condition10);
    }

    public boolean editSchoolPageAppeared(String value) {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Basic Information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Edit school information"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Contact Information"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Academic Year"), 5);
        boolean condition6 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Settings"), 5);
        boolean condition9 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Allow Student self enrollment"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition6 && condition9);
    }

    public void clickOnDeleteSchoolButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, SCHOOL_SETTINGS_BUTTON.by(), 5);
        driver.clickOnAndVerify(SCHOOL_SETTINGS_BUTTON.by(), SCHOOL_DELETE_BUTTON.by());
        driver.clickOn(SCHOOL_DELETE_BUTTON);
    }

    public void clickOnDisableSchoolButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, SCHOOL_SETTINGS_BUTTON.by(), 5);
        driver.clickOnAndVerify(SCHOOL_SETTINGS_BUTTON.by(), SCHOOL_DISABLE_BUTTON.by());
        driver.clickOn(SCHOOL_DISABLE_BUTTON);
    }

    public boolean deleteSchoolPopupMessage() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_SCHOOL_POP_UP_MESSAGE.by(), 5);
    }

    public boolean disableSchoolPopupMessage() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, DISABLE_SCHOOL_POP_UP_MESSAGE.by(), 5);
    }
}


