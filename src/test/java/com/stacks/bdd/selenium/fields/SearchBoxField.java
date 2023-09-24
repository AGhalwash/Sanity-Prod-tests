package com.stacks.bdd.selenium.fields;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;

public class SearchBoxField extends AbstractField {

	private final String seed;
	
	private static final List<String> BLANK_VALUES = Arrays.asList("");
	
	public SearchBoxField(String name, CustomWebDriver driver, By locator, String seed,  Boolean isMandatory) {
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
		
		if (BLANK_VALUES.contains(driver.getElementAttribute(locator, Constants.VALUE))) {
			String idPrefix = driver.getElementAttribute(locator, "id");
			idPrefix = idPrefix.substring(0, idPrefix.length()-6);
		
			By inputSelector = By.id(idPrefix + "_input");
			driver.sendKeysTo(seed, inputSelector);
			
			By firstResultSelector = By.xpath("//*[@id='" + idPrefix + "_panel']/ul/li[1]");
	        String firstResultText = driver.getElementText(firstResultSelector);
	        driver.clickOn(firstResultSelector);
	        
			assertThat(driver.getElementAttribute(locator, Constants.VALUE), is(equalTo(firstResultText)));
		}
	}
	
}
