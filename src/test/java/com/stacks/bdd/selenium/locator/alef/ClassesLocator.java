package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum SchoolsLocator implements Locator, I18nLocator {

    //LOGIN PAGE
	USER_TEXT(By.xpath("//input[@type='text']")),
	PASSWORD_TEXT(By.xpath("//input[@type='password']")),
	SUBMIT_BUTTON(By.xpath("//*[@type='submit']")),

	// HOME PAGE

	ORGANIZATION_DROP_DOWN(By.xpath("//div[contains(@class,'value-container org-dropdown')]")),
	ORGANIZATION_DROP_DOWN_OPTION("organization.drop.down.option"),
	SCHOOLS_FIRST_ROW(By.xpath("//td[contains(@class,'ant-table-column-sort')]")),
	CLASSES_SECTION("section.nav.bar"),
	ADD_CLASS_BUTTON(By.xpath("//button[contains(@class,'button button--primary')]")),
	CLASS_MATERIAL_DROP_DOWN_MENU(By.xpath("//div[contains(@class, 'custom-select') and @data-qa='form-class-material' and @data-testid='form-class-material']")),
	CLASS_MATERIAL_SEARCH_TEXT(By.xpath("//div[contains(@class, 'value-container-control')]")),
	PATHWAY_OPTION(By.xpath("//div[contains(@class,'material-badge material-type') and text()='PATHWAY']"))


	;

	String resourceName = "com/stacks/bdd/selenium/locator/schools_%s.properties";

	private By locator;
	private String key;
	private String description;

	SchoolsLocator(By locator) {
		this.description = description;
		this.locator = locator;
	}

	SchoolsLocator(String key) {
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