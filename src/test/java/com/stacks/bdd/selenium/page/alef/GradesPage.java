package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.ClassesLocator.*;
import static com.stacks.bdd.selenium.locator.alef.StaffLocator.*;


public class StaffPage extends PageObject {

    public StaffPage(CustomWebDriver driver) {
        super(driver, StaffPage.class.getName());
    }


    public boolean editStaffAppeared(){
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Edit school staff information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("School Staff’s First Name"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Role"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Exclude From Report"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Force Change Password"), 5);
        boolean condition6 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("School Staff’s Middle Name"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5 && condition6);
    }

    public boolean addStaffAppeared(){
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Add school staff information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("School Staff’s First Name"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Role"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Exclude From Report"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("School Staff’s Middle Name"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5);
    }

    public void clickOnDisableButton(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,DISABLE_BUTTON.by(),5);
        driver.clickOn(DISABLE_BUTTON.by());
    }

    public boolean checkDisableStaffPopupMessage(){
        return Waiter.waitExpectedConditionsVisibilityOf(driver,DISABLE_STAFF_POP_UP_MESSAGE.by(),5);
    }

    public void clickOnAddStaffButton(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,ADD_STAFF_BUTTON.by(),5);
        driver.clickOnAndVerify(ADD_STAFF_BUTTON.by());
    }
}


