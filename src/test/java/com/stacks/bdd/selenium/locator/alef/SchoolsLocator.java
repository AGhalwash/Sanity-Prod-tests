package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum HomeLocator implements Locator, I18nLocator {

    //LOGIN PAGE
	USER_TEXT(By.xpath("//input[@type='text']")),
	PASSWORD_TEXT(By.xpath("//input[@type='password']")),
	SUBMIT_BUTTON(By.xpath("//*[@type='submit']")),

	// HOME PAGE

	ORGANIZATION_DROP_DOWN(By.xpath("//div[contains(@class,'value-container org-dropdown')]")),
	ORGANIZATION_DROP_DOWN_OPTION("organization.drop.down.option")


	;

	String resourceName = "com/stacks/bdd/selenium/locator/home_%s.properties";

	private By locator;
	private String key;
	private String description;

	HomeLocator(By locator) {
		this.description = description;
		this.locator = locator;
	}

	HomeLocator(String key) {
		this.key = key;
		this.locator = By.xpath(this.getSelector());
	}

	@Override
	public By by() {
		return locator;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getResourceName() {
		return resourceName;
	}

	@Override
	public String toString() {
		return description;
	}

	public By by(Object... vars) {
		return By.xpath(String.format(this.getSelector(), vars));
	}
}