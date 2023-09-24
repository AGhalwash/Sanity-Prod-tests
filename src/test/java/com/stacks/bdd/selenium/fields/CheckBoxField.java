package com.stacks.bdd.selenium.fields;

import org.openqa.selenium.By;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;

public class CheckBoxField extends AbstractField {

	private static final String CHECKED_CLASS = "ui-state-active";
	
	public CheckBoxField(String name, CustomWebDriver driver, By locator, Boolean isMandatory) {
		super(name, driver, locator, isMandatory);
	}

	@Override
	public void fillWithDefaultValue() {
		Waiter.waitForVisibleElement(driver, locator);
			driver.clickOn(locator);
	}

	@Override
	public String getValue() {
		Waiter.waitForVisibleElement(driver, locator);
		return String.valueOf(driver.getElementAttribute(locator, "class").contains(CHECKED_CLASS));
	}

}
