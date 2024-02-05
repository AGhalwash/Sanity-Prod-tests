package com.stacks.bdd.selenium.locator.rms;

import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum LoaderLocator implements Locator {

    LOADING(By.cssSelector(".ext-el-mask")),
    LOADING_DIV(By.cssSelector(".loadingDiv")),
    OVERLAY(By.cssSelector(".ui-widget-overlay")),
    INFO_MESSAGE(By.xpath("//div[@role='dialog']//div[@id='infoMessage']")),
    CONFIRM_MESSAGE(By.xpath("//div[@role='dialog']//div[@id='confirmMessage']")),
    ALERT_MESSAGE(By.xpath("//div[@role='dialog']//div[@id='alertMessage']")),
    ACCEPT_POPUP(By.id("dialogButtonId_1"));

    private By locator;

    LoaderLocator(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }
}
