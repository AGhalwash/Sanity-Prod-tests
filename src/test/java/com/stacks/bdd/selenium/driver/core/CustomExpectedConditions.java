package com.stacks.bdd.selenium.driver.core;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions {
    private CustomExpectedConditions(){
        // Utility class
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is
     * greater than 0.
     *
     * @param webElement used to find the element
     * @return the WebElement once it is located and visible
     */
    @SuppressWarnings("squid:S1166")
    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final WebElement webElement) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    return elementIfVisible(webElement);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "visibility of element located by " + webElement.toString();
            }
        };
    }

    /**
     * @return the given element if it is visible and has non-zero size, otherwise null.
     */
    private static WebElement elementIfVisible(WebElement element) {
        return element.isDisplayed() ? element : null;
    }
}
