package com.stacks.bdd.selenium.fields;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;

public class STextInputField extends AbstractField {
	
	private final String seed;
	
	private static final List<String> BLANK_VALUES = Arrays.asList("");
	
	public STextInputField(String name, CustomWebDriver driver, By locator, String seed,  Boolean isMandatory) {
		super(name, driver, locator, isMandatory);
		this.seed = seed;
	}

	@Override
	public String getValue() {
		return driver.getElementAttribute(locator, Constants.VALUE);
	}
	
	@Override
	public void fillWithDefaultValue() {
		Waiter.waitForVisibleElement(driver, locator);
		
		if (!driver.getElementAttribute(locator, "class").contains(DISABLED_CLASS)) {
			if (BLANK_VALUES.contains(driver.getElementAttribute(locator, Constants.VALUE))) {
				driver.clickOn(locator);
				Waiter.waitForScript(driver, locator);
				driver.sendKeysTo(seed, locator);
				driver.getSeleniumWebDriver().findElement(locator).sendKeys(Keys.TAB);
				Waiter.waitForScript(driver, locator);
				assertThat(driver.getElementAttribute(locator, Constants.VALUE), is(equalTo(seed)));
			}
		}
	}
	
}
