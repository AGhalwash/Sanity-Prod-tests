package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.ClassesLocator.HEAD_TITLE_TEXT;
import static com.stacks.bdd.selenium.locator.alef.SectionsLocator.DISABLE_SECTION_BUTTON;
import static com.stacks.bdd.selenium.locator.alef.StudentsLocator.*;


public class StudentsPage extends PageObject {

    public StudentsPage(CustomWebDriver driver) {
        super(driver, StudentsPage.class.getName());
    }


    public boolean editStudentPageAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Edit Student"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Student Info"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Guardian Information"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Interface"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Kid-friendly Interface"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5);
    }

    public boolean addStudentPageAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Add New Student"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Student Info"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Interface"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Kid-friendly Interface"), 5);
        return (condition1 && condition2 && condition3 && condition4);
    }

    public boolean disableStudentPageAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Are you sure you want to continue?"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("You are disabling a student. This student will not be able to login to Alef anymore nor will the student show up in any of the teacher and principal analytics pages."), 5);
        return (condition1 && condition2);
    }

    public boolean checkDeleteStudentPopupTitle() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_STUDENT_POP_UP_MESSAGE.by(), 5);
    }

    public void clickOnAddStudentButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, ADD_STUDENT_BUTTON.by(), 5);
        driver.clickOnAndVerify(ADD_STUDENT_BUTTON.by());
    }

    public void clickOnSetQRCodeButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, SET_QR_CODE_BUTTON.by(), 5);
        driver.clickOn(SET_QR_CODE_BUTTON.by());
    }

    public boolean checkSetQRCODEPopup() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Set QR Code Count"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Please set the number of times the QR code can be used"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("QR Code Count"), 5);
        return (condition1 && condition2 && condition3);
    }

    public void clickOnDisableStudentButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, DISABLE_SECTION_BUTTON.by(), 5);
        driver.clickOn(DISABLE_SECTION_BUTTON.by());
    }
}


