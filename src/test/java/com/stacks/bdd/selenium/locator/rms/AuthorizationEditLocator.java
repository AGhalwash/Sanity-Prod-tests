package com.stacks.bdd.selenium.locator.rms;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum AuthorizationEditLocator implements Locator, I18nLocator {

	ROLE_POWER_ARROW_BUTTON_CLOSED("role.power.arrow.button.closed"),
	ROLE_POWER_ARROW_BUTTON_OPENED("role.power.arrow.button.opened"),
	ROLE_POWER_CHECKBOX_CHECKED("role.power.checkbox.checked"),
	ROLE_POWER_CHECKBOX_UNCHECKED("role.power.checkbox.unchecked"),
	SAVE_BUTTON(By.xpath("//button[contains(@type, 'submit')]"))
	;

	String resourceName = "com/stacks/bdd/selenium/locator/home_%s.properties";

	private By locator;
	private String key;
	private String description;

	AuthorizationEditLocator(By locator) {
		this.description = description;
		this.locator = locator;
	}

	AuthorizationEditLocator(String key) {
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