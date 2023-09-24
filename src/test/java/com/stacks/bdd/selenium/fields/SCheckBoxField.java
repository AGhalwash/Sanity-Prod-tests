package com.stacks.bdd.selenium.fields;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;

public class SCheckBoxField extends AbstractField {
	
	private final Boolean seed;
	
	private static final String CHECKED_CLASS = "ui-state-active";
	
	public SCheckBoxField(String name, CustomWebDriver driver, By locator, Boolean seed,  Boolean isMandatory) {
		super(name, driver, locator, isMandatory);
		this.seed = seed;
	}

	@Override
	public void fillWithDefaultValue() {
		Waiter.waitForVisibleElement(driver, locator);
		if (driver.getElementAttribute(locator, Constants.CLASS).contains(CHECKED_CLASS) != seed)
			driver.clickOn(locator);
		
		Waiter.waitForScript(driver, locator);
		
		if (seed) {
			assertThat(driver.getElementAttribute(locator, Constants.CLASS), containsString(CHECKED_CLASS));
		} else {
			assertThat(driver.getElementAttribute(locator, Constants.CLASS), not(containsString(CHECKED_CLASS)));
		}
	}

	@Override
	public String getValue() {
		Waiter.waitForVisibleElement(driver, locator);
		
		return String.valueOf(driver.getElementAttribute(new ByChained(locator, By.xpath("./..")), Constants.CLASS).contains(CHECKED_CLASS));
	}

}
