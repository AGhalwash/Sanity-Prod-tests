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
        Waiter.waitForDisappearanceElements(driver,LOADER_ICON.by(),5);
       }
    }

    public boolean checkFourRadioButtons(String button1, String button2, String button3, String button4){
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver,TICKET_TYPE_RADIO_BUTTON.by(button1),2);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver,TICKET_TYPE_RADIO_BUTTON.by(button2),2);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver,TICKET_TYPE_RADIO_BUTTON.by(button3),2);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver,TICKET_TYPE_RADIO_BUTTON.by(button4),2);
        return (condition1 && condition2 && condition3 && condition4);
    }

    public boolean checkOneRadioButton(String button){
        return  Waiter.waitExpectedConditionsVisibilityOf(driver,TICKET_TYPE_RADIO_BUTTON.by(button),2);
    }
}
