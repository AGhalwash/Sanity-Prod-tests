package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.ClassesLocator.HEAD_TITLE_TEXT;
import static com.stacks.bdd.selenium.locator.alef.GradesLocator.*;


public class GradesPage extends PageObject {

    public GradesPage(CustomWebDriver driver) {
        super(driver, GradesPage.class.getName());
    }


    public boolean editGradesAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Edit grade information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Grade Name"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Select Grade"), 5);
        return (condition1 && condition2 && condition3);
    }

    public boolean addGradesAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Add grade information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Grade Name"), 5);
        return (condition1 && condition2);
    }

    public void clickOnAddGradeButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, ADD_STAFF_BUTTON.by(), 5);
        driver.clickOnAndVerify(ADD_STAFF_BUTTON.by());
    }

    public void clickOnDeleteButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, SETTINGS_BUTTON.by(), 5);
        driver.clickOnAndVerify(SETTINGS_BUTTON.by(), DELETE_BUTTON.by());
        driver.clickOn(DELETE_BUTTON);
    }

    public boolean deleteGradePopupMessage() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_GRADE_POPUP_MESSAGE.by(), 5);
    }

    public void clickOnEditGradeButton(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,EDIT_GRADE_BUTTON.by(),5);
        driver.clickOnAndVerify(EDIT_GRADE_BUTTON.by());
    }

    public boolean findSearchedGrade(String value){
        return Waiter.waitExpectedConditionsVisibilityOf(driver,GRADE_ROW.by(value),5);
    }
}


