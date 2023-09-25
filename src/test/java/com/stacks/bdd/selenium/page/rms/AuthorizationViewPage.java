package com.stacks.bdd.selenium.page.rms;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.rms.AuthorizationViewLocator.*;


public class AuthorizationViewPage extends PageObject {

    public AuthorizationViewPage(CustomWebDriver driver) {
        super(driver, AuthorizationViewPage.class.getName());
    }

    public void clickOnRoleEditButton(String role){
        Waiter.waitExpectedConditionsVisibilityOf(driver,ROLE_EDIT_BUTTON.by(role),3);
        driver.clickOnAndVerify(ROLE_EDIT_BUTTON.by(role));
    }
}
