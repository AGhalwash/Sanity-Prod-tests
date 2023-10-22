package com.stacks.bdd.selenium.page.rms;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.rms.AddTicketLocator.LOADER_ICON;
import static com.stacks.bdd.selenium.locator.rms.TicketListLocator.*;


public class TicketListPage extends PageObject {

    public TicketListPage(CustomWebDriver driver) {
        super(driver, TicketListPage.class.getName());
    }

    public void openAddTicketPage() {
        Waiter.waitExpectedConditionsVisibilityOf(driver,ADD_TICKET_TO_CALL_CENTER_BUTTON.by(), 2);
        driver.clickOnAndVerify(ADD_TICKET_TO_CALL_CENTER_BUTTON.by());
    }

    public boolean checkAddTicketButton(){
        return Waiter.waitExpectedConditionsVisibilityOf(driver,ADD_TICKET_TO_CALL_CENTER_BUTTON.by(), 2);
    }

    public boolean checkTicketSubject(String subject){
        return Waiter.waitExpectedConditionsVisibilityOf(driver, TICKET_SUBJECT.by(subject),5);
    }

    public void clickOnTicketStatusButton(String status){
        Waiter.waitExpectedConditionsVisibilityOf(driver, TICKET_STATUS_BUTTON.by(status),5);
        driver.clickOn(TICKET_STATUS_BUTTON.by(status));
        Waiter.waitForDisappearanceElements(driver,LOADER_ICON.by(),5);
    }

    public void clickOnSortByTicketNumber(){
        Waiter.waitExpectedConditionsVisibilityOf(driver, SORTING_BY_TICKET_NUMBER_BUTTON.by(),5);
        driver.clickOn(SORTING_BY_TICKET_NUMBER_BUTTON.by());
        Waiter.waitForDisappearanceElements(driver,LOADER_ICON.by(),5);
    }
}
