package com.stacks.bdd.selenium.page.rms;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void openDropdownList(String list){
        Waiter.waitExpectedConditionsVisibilityOf(driver,DROP_DOWN_LIST.by(list),5);
        driver.clickOn(DROP_DOWN_LIST.by(list));
    }

    public boolean checkBranchName(String branch){
        return Waiter.waitExpectedConditionsVisibilityOf(driver,DROP_DOWN_LIST_ITEM.by(branch),5);
    }

    public boolean unwantedValues(){
        String[] unwantedValues = { "نمار", "المعيزلية", "سكن الرياض 3", "جازان", "الإدارة العامة","الطائف","سكن خميس مشيط 1","الاحساء","وادي الدواسر ","سكن الرياض 1"};


        // Define the locator for the list of elements (modify as needed)
        By elementLocator = By.cssSelector("div span.ng-option-label");

        // Call the assertListDoesNotContainValues function
        return assertListDoesNotContainValues( elementLocator, unwantedValues);
    }
    public boolean assertListDoesNotContainValues(By elementLocator, String[] unwantedValues) {
        // Find the list of elements
        List<WebElement> elements = driver.findElements(elementLocator);

        for (WebElement element : elements) {
            // Get the text of the element
            String elementText = element.getText().trim();
            for (String unwantedValue : unwantedValues) {
                // Check if the element text contains unwanted value
                if (elementText.contains(unwantedValue)) {
                    // Assertion failed, the list contains an unwanted value
                    return false;
                }
            }
        }
        // Assertion passed, the list does not contain any unwanted values
        return true;
    }
}
