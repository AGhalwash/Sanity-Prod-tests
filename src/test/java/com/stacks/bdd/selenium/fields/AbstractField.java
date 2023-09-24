package com.stacks.bdd.selenium.fields;

import org.openqa.selenium.By;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;

public abstract class AbstractField implements IField {
	protected static final String DISABLED_CLASS = "ui-state-disabled";
	
	protected final CustomWebDriver driver;
	protected final String name;
	protected final Boolean isMandatory;
	protected final By locator;
	
	public AbstractField(String name, CustomWebDriver driver, By locator, Boolean isMandatory) {
		super();
		this.driver = driver;
		this.name = name;
		this.isMandatory = isMandatory;
		this.locator = locator;
	}
	
	public Boolean isMandatory() {
		return isMandatory;
	}
	
	public By locator() {
		return locator;
	}

	public String getName() {
		return name;
	}
	
	public abstract void fillWithDefaultValue();
	
}