package com.stacks.bdd.selenium.page.rms;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.constants.core.SystemProperties;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.rms.HomeLocator.*;


public class HomePage extends PageObject {

    public HomePage(CustomWebDriver driver) {
        super(driver, HomePage.class.getName());
    }

    public void openPageWithoutAcceptCookies() {
        driver.openPage(SystemProperties.getServerUrl());
        Waiter.waitForLoad(driver);
    }

    public void loginToRMS(String user) {
        openPageWithoutAcceptCookies();
        Waiter.waitExpectedConditionsVisibilityOf(driver, USER_TEXT.by(), 5);
        switch (user) {
            case "Normal user":
                driver.sendKeysTo("aghalwash@arabdt.com", USER_TEXT);
                driver.sendKeysTo("Arabdt1234", PASSWORD_TEXT);
                break;
            case "Admin":
                driver.sendKeysTo("Super@super.com", USER_TEXT);
                driver.sendKeysTo("P@ssw0rd", PASSWORD_TEXT);
                break;
            default:
                throw new IllegalArgumentException(user + Constants.NOT_FOUND);
        }
        driver.clickOnAndVerify(SUBMIT_BUTTON.by());
    }

    public void logOut(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,LOG_OUT_ARROW_BUTTON.by(),2);
        driver.clickOn(LOG_OUT_ARROW_BUTTON.by());
        Waiter.waitExpectedConditionsVisibilityOf(driver,LOG_OUT_BUTTON.by(),2);
        driver.clickOnAndVerify(LOG_OUT_BUTTON.by(),USER_TEXT.by());
    }

    public void changeLanguageToArabic(){
       if( Waiter.waitExpectedConditionsVisibilityOf(driver, ENGLISH_LANGUAGE_BUTTON.by(), 2)) {
           driver.clickOnAndVerify(ENGLISH_LANGUAGE_BUTTON.by(), ARABIC_LANGUAGE_BUTTON.by());
           driver.clickOnAndVerify(ARABIC_LANGUAGE_BUTTON.by());
       }
    }
    public void openViewReportsPage(){
        Waiter.waitExpectedConditionsVisibilityOf(driver, REPORTS_BUTTON.by(), 5);
        driver.clickOnAndVerify(REPORTS_BUTTON.by(),VIEW_REPORTS_BUTTON.by());
        driver.clickOnAndVerify(VIEW_REPORTS_BUTTON.by());
    }

    public void openAuthorizationViewPage(){
        Waiter.waitExpectedConditionsVisibilityOf(driver, SETTINGS_BUTTON.by(), 5);
        driver.clickOnAndVerify(SETTINGS_BUTTON.by(),VIEW_AUTHORIZATION_VIEW_BUTTON.by());
        driver.clickOnAndVerify(VIEW_AUTHORIZATION_VIEW_BUTTON.by());
    }
}
