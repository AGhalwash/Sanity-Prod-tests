package com.stacks.bdd.selenium.fields;

import org.openqa.selenium.By;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;

public class HiddenInputField extends AbstractField {
    private final String seed;

    public HiddenInputField(String name, CustomWebDriver driver, By locator, String seed, Boolean isMandatory) {
        super(name, driver, locator, isMandatory);
        this.seed = seed;
    }

    @Override
    public String getValue() {
        return driver.getElementAttribute(locator, "value");
    }

    @Override
    public void fillWithDefaultValue() {
        driver.sendKeysToHidden(seed, locator);
    }
}
