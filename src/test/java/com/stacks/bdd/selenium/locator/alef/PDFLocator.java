package com.stacks.bdd.selenium.locator.rms;

import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum PDFLocator implements Locator {

    PDF_OBJECT_FIREFOX(By.id("viewer")),
    PDF_OBJECT_FIREFOX_PAGES(By.xpath("//a[contains(@title,'Page')]")),
    PDF_IFRAME_FIREFOX(By.xpath("//iframe")),
    PDF_OBJECT_CHROME(By.id("plugin"));
//    PDF_OBJECT_CHROME(By.xpath("(//*[@id=\"plugin\"])[1]"));
//    PDF_OBJECT_CHROME(By.id("plugin"));

    private By locator;

    PDFLocator(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }
}
