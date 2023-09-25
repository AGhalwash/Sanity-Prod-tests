package com.stacks.bdd.selenium.page.rms;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.rms.AuthorizationEditLocator.*;
import static com.stacks.bdd.selenium.locator.rms.HomeLocator.PASSWORD_TEXT;
import static com.stacks.bdd.selenium.locator.rms.HomeLocator.USER_TEXT;


public class AuthorizationEditPage extends PageObject {

    public AuthorizationEditPage(CustomWebDriver driver) {
        super(driver, AuthorizationEditPage.class.getName());
    }


    public void openPowerArrow(String power){
        Waiter.waitExpectedConditionsVisibilityOf(driver,ROLE_POWER_ARROW_BUTTON_CLOSED.by(power),3);
        driver.clickOnAndVerify(ROLE_POWER_ARROW_BUTTON_CLOSED.by(power), ROLE_POWER_ARROW_BUTTON_OPENED.by(power));
    }

    public void checkPowerCheckbox(String status,String power){
        switch (status) {
            case "check":
             if( Waiter.waitExpectedConditionsVisibilityOf(driver,ROLE_POWER_CHECKBOX_UNCHECKED.by(power),2)) {
                driver.clickOnAndVerify(ROLE_POWER_CHECKBOX_UNCHECKED.by(power), ROLE_POWER_CHECKBOX_CHECKED.by(power));
            }
                break;
            case "uncheck":
                if(Waiter.waitExpectedConditionsVisibilityOf(driver,ROLE_POWER_CHECKBOX_CHECKED.by(power),2)) {
                    driver.clickOnAndVerify(ROLE_POWER_CHECKBOX_CHECKED.by(power), ROLE_POWER_CHECKBOX_UNCHECKED.by(power));
                }
                break;
            default:
                throw new IllegalArgumentException(power + Constants.NOT_FOUND);
        }
    }

    public void clickOnSaveButton(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,SAVE_BUTTON.by(),2);
        driver.clickOnAndVerify(SAVE_BUTTON.by());
    }
}
