package com.stacks.bdd.selenium.locator.rms;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum AddTicketLocator implements Locator, I18nLocator {

	CHECK_CLIENT_TYPE_RADIO_BUTTON("checked.client.type.radio.button"),
	UNCHECK_CLIENT_TYPE_RADIO_BUTTON("unchecked.client.type.radio.button"),
	TICKET_TYPE_RADIO_BUTTON("ticket.type.radio.button"),
	LOADER_ICON(By.xpath("//img[@class='loader-img']")),
	DROP_DOWN_LIST("drop.down.list"),
	DROP_DOWN_LIST_ITEM("drop.down.list.item"),


	;

	String resourceName = "com/stacks/bdd/selenium/locator/home_%s.properties";

	private By locator;
	private String key;
	private String description;

	AddTicketLocator(By locator) {
		this.description = description;
		this.locator = locator;
	}

	AddTicketLocator(String key) {
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