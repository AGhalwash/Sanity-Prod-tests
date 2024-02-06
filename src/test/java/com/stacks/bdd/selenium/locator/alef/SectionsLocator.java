package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum SectionsLocator implements Locator, I18nLocator {


    DELETE_SECTION_POP_UP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to delete Section')]")),
    ADD_SECTION_BUTTON(By.xpath("//button[contains(@data-qa,'add-new-section')]")),
    DISABLE_SECTION_BUTTON(By.xpath("//*[contains(@data-qa, 'table-item-disable')]")),
    ENABLE_SECTION_BUTTON(By.xpath("//*[contains(@data-qa, 'table-item-enable')]")),
    GENERATE_SECTIONS_BUTTON(By.xpath("//button[contains(@data-qa,'generate-Sections')]")),
    DELETE_SECTION_BUTTON(By.xpath("//*[contains(@data-qa, 'table-item-delete')]"))

    ;
    String resourceName = "com/stacks/bdd/selenium/locator/schools_%s.properties";

    private By locator;
    private String key;
    private String description;

    SectionsLocator(By locator) {
        this.description = description;
        this.locator = locator;
    }

    SectionsLocator(String key) {
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