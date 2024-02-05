package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum ClassesLocator implements Locator, I18nLocator {


    ADD_CLASS_BUTTON(By.xpath("//button[contains(@class,'button button--primary')]")),
    CLASS_MATERIAL_DROP_DOWN_MENU(By.xpath("//div[contains(@class, 'custom-select') and @data-qa='form-class-material' and @data-testid='form-class-material']")),
    CLASS_MATERIAL_SEARCH_TEXT(By.xpath("//div[contains(@class, 'css-d7wsyz')]//input[contains(@id, 'react-select-20-input')]")),
    PATHWAY_OPTION(By.xpath("//div[contains(@class,'material-badge material-type') and text()='PATHWAY']")),
    SEARCH_TEXT_FIELD(By.id("table-search-input")),
    HEAD_TITLE_TEXT("head.title.text"),

    ;
    String resourceName = "com/stacks/bdd/selenium/locator/schools_%s.properties";

    private By locator;
    private String key;
    private String description;

    ClassesLocator(By locator) {
        this.description = description;
        this.locator = locator;
    }

    ClassesLocator(String key) {
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