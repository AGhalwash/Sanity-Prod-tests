package com.stacks.bdd.selenium.fields;

import com.stacks.bdd.selenium.driver.core.Waiter;
import org.openqa.selenium.By;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;

public class AddPopUpField extends AbstractField {

    private final By locator2;

    public AddPopUpField(String name, CustomWebDriver driver, By locator, By locator2, Boolean isMandatory) {
        super(name, driver, locator, isMandatory);
        this.locator2 = locator2;
    }

    @Override
    public String getValue() {
        return driver.getElementAttribute(locator, "value");
    }

    @Override
    public void fillWithDefaultValue() {
        driver.clickOn(locator);
        driver.doInsideNewWindow(() -> driver.clickOnAndVerify(locator2));
        Waiter.waitExpectedConditionsVisibilityOf(driver,locator);
    }
}
