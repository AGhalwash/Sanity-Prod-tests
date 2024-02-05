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
    SEARCH_ICON_BUTTON(By.xpath("//i[contains(@class,'icon icon--search')]")),
    EDIT_BUTTON(By.xpath("//*[contains(@data-testid, 'table-item-edit')]")),
    SCHOOL_SETTINGS_BUTTON(By.xpath("//*[contains(@data-testid, 'table-action-button-settings')]")),
    SCHOOL_DELETE_BUTTON(By.xpath("//*[contains(@data-testid, 'table-action-button-delete')]")),
    SCHOOL_DISABLE_BUTTON(By.xpath("//*[contains(@data-testid, 'table-action-button-disable')]")),
    DELETE_BUTTON(By.xpath("//i[contains(@data-qa, 'table-item-delete')]")),
    FIRST_ROW_BY_NAME("classes.first.row.by.name"),
    DELETE_POP_UP_TITLE(By.xpath("//h2[contains(@class,'swal2-title') and text()='Delete class']")),
    DELETE_SCHOOL_POP_UP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to delete')]")),
    DISABLE_SCHOOL_POP_UP_MESSAGE(By.xpath("//div[contains(@id, 'swal2-content') and contains(text(), 'Are you sure you want to deactivate this school?')]"))

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