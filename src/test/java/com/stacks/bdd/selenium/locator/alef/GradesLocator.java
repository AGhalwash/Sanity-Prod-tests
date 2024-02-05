package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum StaffLocator implements Locator, I18nLocator {


    DISABLE_BUTTON(By.xpath("//*[contains(@data-qa, 'table-item-disable')]")),
    DISABLE_STAFF_POP_UP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to disable?')]")),
    ADD_STAFF_BUTTON(By.xpath("//button[contains(@data-qa,'add-new-staff')]"))

    ;
    String resourceName = "com/stacks/bdd/selenium/locator/schools_%s.properties";

    private By locator;
    private String key;
    private String description;

    StaffLocator(By locator) {
        this.description = description;
        this.locator = locator;
    }

    StaffLocator(String key) {
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