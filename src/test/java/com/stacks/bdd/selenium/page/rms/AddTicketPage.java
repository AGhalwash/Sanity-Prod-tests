package com.stacks.bdd.selenium.page.rms;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.rms.AddTicketLocator.*;



public class AddTicketPage extends PageObject {

    public AddTicketPage(CustomWebDriver driver) {
        super(driver, AddTicketPage.class.getName());
    }

    public void selectClientType(String type) {
       if (!Waiter.waitExpectedConditionsVisibilityOf(driver,CHECK_CLIENT_TYPE_RADIO_BUTTON.by(type),3)){
        driver.clickOnAndVerify(UNCHECK_CLIENT_TYPE_RADIO_BUTTON.by(type),CHECK_CLIENT_TYPE_RADIO_BUTTON.by(type));
       }
       Waiter.sleep(9000);
    }
}
