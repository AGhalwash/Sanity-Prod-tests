package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum StudentsLocator implements Locator, I18nLocator {


    DELETE_STUDENT_POP_UP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to delete these students?')]")),
    ADD_STUDENT_BUTTON(By.xpath("//button[contains(@data-qa,'add-new-student')]")),
    SET_QR_CODE_BUTTON(By.xpath("//div[contains(@data-tip,'Get Guardian QR Code')]")),

    ;
    String resourceName = "com/stacks/bdd/selenium/locator/schools_%s.properties";

    private By locator;
    private String key;
    private String description;

    StudentsLocator(By locator) {
        this.description = description;
        this.locator = locator;
    }

    StudentsLocator(String key) {
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