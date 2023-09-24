package com.stacks.bdd.selenium.fields;

import org.openqa.selenium.By;

public interface IField {
	void fillWithDefaultValue();
	String getValue();
    String getName();
	Boolean isMandatory();
	By locator();
}
