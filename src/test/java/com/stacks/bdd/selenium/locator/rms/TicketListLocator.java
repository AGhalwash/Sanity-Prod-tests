package com.stacks.bdd.selenium.locator.rms;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum TicketListLocator implements Locator, I18nLocator {

	ADD_TICKET_TO_CALL_CENTER_BUTTON(By.xpath("//button[span[text()='إضافة بلاغ']]")),
	TICKET_SUBJECT("ticket.subject"),
	TICKET_STATUS_BUTTON("ticket.status.button")
	;

	String resourceName = "com/stacks/bdd/selenium/locator/home_%s.properties";

	private By locator;
	private String key;
	private String description;

	TicketListLocator(By locator) {
		this.description = description;
		this.locator = locator;
	}

	TicketListLocator(String key) {
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