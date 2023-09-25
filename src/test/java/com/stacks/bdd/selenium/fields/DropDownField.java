package com.stacks.bdd.selenium.fields;

import org.openqa.selenium.By;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.rms.LoaderLocator.LOADING;

public class DropDownField extends AbstractField {
	

	private final String seed;
	
	public DropDownField(String name, CustomWebDriver driver, By locator, String seed,  Boolean isMandatory) {
		super(name, driver, locator, isMandatory);
		this.seed = seed;
	}

	@Override
	public void fillWithDefaultValue() {
		Waiter.waitForVisibleElement(driver, locator);
		driver.scrollToElement(locator);
		Waiter.waitForDisappearanceElements(driver, LOADING.by());
		driver.selectByValue(locator, seed);
	}

	@Override
	public String getValue() {
		String idPrefix = driver.getElementAttribute(locator, "id");
		By labelSelector = By.xpath("//*[@id='" +idPrefix +"']//preceding-sibling::label");
		return driver.getElementText(labelSelector);
	}

}
