package com.stacks.bdd.selenium.page.genomi.home;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.genomi.TicketListLocator.ADD_TICKET_TO_CALL_CENTER_BUTTON;


public class TicketListPage extends PageObject {

    public TicketListPage(CustomWebDriver driver) {
        super(driver, TicketListPage.class.getName());
    }

    public void openAddTicketPage() {
        Waiter.waitExpectedConditionsVisibilityOf(driver,ADD_TICKET_TO_CALL_CENTER_BUTTON.by(), 2);
        driver.clickOnAndVerify(ADD_TICKET_TO_CALL_CENTER_BUTTON.by());
    }
}
