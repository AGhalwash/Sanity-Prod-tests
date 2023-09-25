package com.stacks.bdd.selenium.locator.rms;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum AuthorizationViewLocator implements Locator, I18nLocator {

	ROLE_EDIT_BUTTON("role.edit.button")

	;

	String resourceName = "com/stacks/bdd/selenium/locator/home_%s.properties";

	private By locator;
	private String key;
	private String description;

	AuthorizationViewLocator(By locator) {
		this.description = description;
		this.locator = locator;
	}

	AuthorizationViewLocator(String key) {
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