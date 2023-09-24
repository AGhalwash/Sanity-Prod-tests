package com.stacks.bdd.selenium.page.genomi.home;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;
import com.stacks.bdd.selenium.locator.core.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.stacks.bdd.selenium.locator.genomi.LoaderLocator.*;

public class LoggedPage extends PageObject {
    protected boolean newLF;



    private static String returnFormat(Calendar c, String format){
        Date dt = c.getTime();
        SimpleDateFormat formatter;
        formatter= new SimpleDateFormat(format);
        return formatter.format(dt);
    }
    public static String getDayFormatted(int add, String format) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, add);
        return returnFormat(c,format);
    }

    public static String getDayFormattedType(String type, int add, String format) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        switch (type){
            case "month":
                c.add(Calendar.MONTH, add);
                break;
            case "year":
                c.add(Calendar.YEAR, add);
                break;
            default:
                c.add(Calendar.DATE, add);
                break;
        }
        return returnFormat(c,format);
    }

    public String getTimeFormatted(int add) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MINUTE, add);
        dt = c.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(dt);
    }


    public LoggedPage(CustomWebDriver driver, String pageClassName, List<Locator> mandatoryPageElements) {
        super(driver, pageClassName);
    }

    public LoggedPage(CustomWebDriver driver, String pageClassName) {
        this(driver, pageClassName, new ArrayList<Locator>());
    }

    public LoggedPage(CustomWebDriver driver) {
        this(driver, LoggedPage.class.getName());
    }



    protected void waitUntilPageIsLoaded(String pageName, List<Locator> locators) {
        pageName = pageName.substring(pageName.lastIndexOf(".") + 1).trim();
        String locatorName = "";
        try {
            for (Locator locator : locators) {
                locatorName = locator.toString();
                Waiter.waitExpectedConditionElementVisibleIfExists(driver,locator.by(), 2);
            }
        } catch (TimeoutException ex) {
            String messageException = String.format("%s is not loaded because expected element %s can't be found", pageName, locatorName);
            logger.trace(messageException);
            throw new TimeoutException(messageException, ex);
        }
        logger.trace(pageName + " is loaded");
    }







    public void closeAnyAlertMessage() {
        if (Waiter.waitExpectedConditionsVisibilityOf(driver,CONFIRM_MESSAGE.by(), 5)){
            driver.clickOnAndVerify(ACCEPT_POPUP.by());
        }
        Waiter.waitForInvisibleElement(driver, OVERLAY.by());
    }

    public void closeIfInfoMessage(String[] messages) {
        if (driver.elementExists(INFO_MESSAGE)){
            String actualMessage = driver.getText(INFO_MESSAGE);
            if(Arrays.stream(messages).anyMatch(actualMessage::contains)) {
                driver.clickOn(ACCEPT_POPUP);
            }
        }
    }

    public void closeIfAlertMessageAndAction(String[] messages, Locator locator) {
        if (driver.elementExists(ALERT_MESSAGE)){
            String actualMessage = driver.getText(ALERT_MESSAGE);
            if(Arrays.stream(messages).anyMatch(actualMessage::contains)) {
                driver.clickOn(ACCEPT_POPUP);
                driver.scrollPage(10000);
                driver.clickOn(locator);
            }
        }
    }


    /**
     * Description: This method count the number of elements with same locator.
     *
     * @param by -> name of the locator.
     * @return -> return the number of rows with same element that will by found.
     */
    public int countRows(By by) {
        Waiter.waitForDisappearanceElements(driver, by, 3);
        Waiter.waitExpectedConditionsVisibilityOf(driver, by, 3);
        return driver.findElements(by).size();
    }

    public void reload() {
        driver.refreshPage();
        Waiter.waitForLoad(driver);
    }

    /**
     * Description: A methot that close an Alert.
     */

}
