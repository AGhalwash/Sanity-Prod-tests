package com.stacks.bdd.selenium.fields;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JSTextInputField extends AbstractField {

    private final String seed;

    private static final List<String> BLANK_VALUES = Arrays.asList("");

    public JSTextInputField(String name, CustomWebDriver driver, By locator, String seed,  Boolean isMandatory) {
        super(name, driver, locator, isMandatory);
        this.seed = seed;
    }

    @Override
    public void fillWithDefaultValue() {
        if(seed.contains("/"))
            driver.fillDateValue(locator, seed);
        else {
            Waiter.waitForVisibleElement(driver, locator);

            if (!driver.getElementAttribute(locator, "class").contains(DISABLED_CLASS)) {
                if (BLANK_VALUES.contains(driver.getElementAttribute(locator, Constants.VALUE))) {
                    driver.fillDate(locator, seed);
                    assertThat(driver.getElementAttribute(locator, Constants.VALUE), is(equalTo(seed)));
                }
            }
        }
    }

    @Override
    public String getValue() {
        return null;
    }
}
