package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.HomeLocator.*;


public class HomePage extends PageObject {

    public HomePage(CustomWebDriver driver) {
        super(driver, HomePage.class.getName());
    }

    public void chooseOrganization(String organization) {
        driver.clickOn(ORGANIZATION_DROP_DOWN.by());
        Waiter.waitExpectedConditionsVisibilityOf(driver, ORGANIZATION_DROP_DOWN_OPTION.by(organization), 5);
        driver.clickOnAndVerify(ORGANIZATION_DROP_DOWN_OPTION.by(organization));
    }
}


