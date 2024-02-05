package com.stacks.bdd.selenium.locator.alef;

import com.stacks.bdd.selenium.locator.core.I18nLocator;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum GradesLocator implements Locator, I18nLocator {


    DISABLE_BUTTON(By.xpath("//*[contains(@data-qa, 'table-item-disable')]")),
    DISABLE_STAFF_POP_UP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to disable?')]")),
    ADD_STAFF_BUTTON(By.xpath("//button[contains(@data-qa,'add-new-grade')]")),
    SETTINGS_BUTTON(By.xpath("//*[contains(@data-testid, 'table-action-button-settings')]")),
    DELETE_BUTTON(By.xpath("//*[contains(@data-testid, 'table-action-button-delete')]")),
    DELETE_GRADE_POPUP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to delete')]")),
    EDIT_GRADE_BUTTON(By.xpath("//*[contains(@data-testid, 'table-action-button-edit')]")),
    GRADE_ROW("grade.row")

    ;
    String resourceName = "com/stacks/bdd/selenium/locator/schools_%s.properties";

    private By locator;
    private String key;
    private String description;

    GradesLocator(By locator) {
        this.description = description;
        this.locator = locator;
    }

    GradesLocator(String key) {
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