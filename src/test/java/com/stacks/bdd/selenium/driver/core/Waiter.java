package com.stacks.bdd.selenium.driver.core;

import com.stacks.bdd.constants.core.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Set;

public final class Waiter {

	private static Logger logger = Logger.getLogger(Waiter.class);
	
	private static final int SMALL_WAIT = 200; //0.2 seconds
	private static final int MEDIUM_WAIT = 2000; //2 seconds
	private static final int WAIT_TIME_OUT = 20; //20 seconds
	private static final int WAIT_TIME_OUT_INVISIBILE = 60; //60 seconds
	private static final int WAIT_TIME_OUT_SECONDS = 20; ; //20 seconds

	private Waiter() {
		// private constructor
	}

	/**
	 * 
	 * @param driver
	 * @param urlFragment
	 */
	public static void waitForPage(CustomWebDriver driver, String urlFragment) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(new ExpectedCondition<Boolean>() {

			private String urlFragment;

			private ExpectedCondition<Boolean> init(String urlFragment) {
				this.urlFragment = urlFragment;
				return this;
			}

			@Override
			public Boolean apply(WebDriver driver) {
				String currentURL = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.location.href");
				return currentURL.contains(urlFragment);
			}

		}.init(urlFragment));

		waitForOverlayClearing(driver);
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 */
	public static void waitForVisibleElement(CustomWebDriver driver, By by) {
		waitForVisibleElement(driver, by, WAIT_TIME_OUT);
	}

	public static void waitForVisibleElement(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(),Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		waitForOverlayClearing(driver);
	}

	public static void waitForVisibleElement(CustomWebDriver driver, WebElement webElement) {
		waitForVisibleElement(driver, webElement, WAIT_TIME_OUT);
	}

	public static void waitForVisibleElement(CustomWebDriver driver, WebElement webElement, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(CustomExpectedConditions.visibilityOfElementLocated(webElement));
		waitForOverlayClearing(driver);
	}

	@SuppressWarnings("squid:S1166")
	public static boolean waitExpectedConditionsVisibilityOf(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch(TimeoutException e){
			return false;
		}
	}

	public static void waitForPresenceOfElement(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		waitForOverlayClearing(driver);
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 */
	public static void waitForVisibleElements(CustomWebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		waitForOverlayClearing(driver);
	}

	/**
	 *
	 * @param driver
	 * @param by
	 * @param text
	 */
	public static void waitForTextNotToBePresentInElementValue(CustomWebDriver driver, By by, String text) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
	}

	/**
	 *
	 * @param driver
	 * @param by
	 * @param text
	 */
	public static void waitForTextToBePresentInElementText(CustomWebDriver driver, By by, String text) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}

	/**
	 *
	 * @param driver
	 * @param by
	 * @param text
	 * @param timeOutInSeconds
	 */
	public static void waitForTextToBePresentInElementValue(CustomWebDriver driver, By by, String text, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 */
	public static void waitForInvisibleElement(CustomWebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		waitForOverlayClearing(driver);
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 */
	public static void waitForInvisibleElements(CustomWebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.getSeleniumWebDriver().findElements(by)));
		waitForOverlayClearing(driver);
	}

	/**
	 *
	 * @param driver
	 * @param by
	 */
	public static boolean waitForDisappearanceElements(CustomWebDriver driver, By by) {
		return waitForDisappearanceElements(driver, by, WAIT_TIME_OUT_SECONDS);
	}

	/**
	 *
	 * @param driver
	 * @param by
	 */
    @SuppressWarnings({"squid:S1166"})
	public static boolean waitForDisappearanceElements(CustomWebDriver driver, By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOut));
		boolean disappeared = false;
		try{
		    disappeared = wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch(TimeoutException exception) {
			if(exception.getCause() instanceof NoSuchWindowException){
				disappeared = true;
			}
		}
		catch(WebDriverException ignored) {
				disappeared = true;
		}
		return disappeared;
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 */
	public static void waitForClickableElement(CustomWebDriver driver, By by) {
		waitForClickableElement(driver, by, WAIT_TIME_OUT);
	}

	/**
	 *
	 * @param driver
	 * @param webElement
	 */
	public static void waitForClickableElement(CustomWebDriver driver, WebElement webElement) {
		waitForClickableElement(driver, webElement, WAIT_TIME_OUT);
	}

	/**
	 *
	 * @param driver
	 * @param by
	 */
	public static void waitForClickableElement(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		waitForOverlayClearing(driver);
	}

	/**
	 *
	 * @param driver
	 * @param webElement
	 */
	public static void waitForClickableElement(CustomWebDriver driver, WebElement webElement,int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		waitForOverlayClearing(driver);
	}
	
	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			logger.trace(Constants.INTERRUPTION_EXCEPTION,e);
		}
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 */
	public static void waitForScript(CustomWebDriver driver, By by) {
		try {
			Thread.sleep(MEDIUM_WAIT);
		} catch (InterruptedException e) {
			logger.trace(Constants.INTERRUPTION_EXCEPTION,e);
		}
		Waiter.waitForVisibleElement(driver, by);
	}

	/**
	 * 
	 * @param driver
	 */
	private static void waitForOverlayClearing(CustomWebDriver driver) {
		List<WebElement> allOverlays = driver.getSeleniumWebDriver()
				.findElements(By.cssSelector("div[class='blockUI blockOverlay ui-widget-overlay']"));
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(allOverlays));

		if (!allOverlays.isEmpty()) {
			try {
				Thread.sleep(SMALL_WAIT);
			} catch (InterruptedException e) {
				logger.trace(Constants.INTERRUPTION_EXCEPTION,e);
			}
		}
	}

	/**
	 *
	 * @param driver
	 * @param timeout
	 * @return
	 */
	public static boolean waitForNewWindow(CustomWebDriver driver, int timeout){
		boolean flag = false;
		int counter = 0;
		while(!flag){
			try {
				Set<String> winId = driver.getSeleniumWebDriver().getWindowHandles();
				if(winId.size() > 1){
					flag = true;
					return flag;
				}
				Thread.sleep(1000);
				counter++;
				if(counter > timeout){
					return flag;
				}
			} catch (Exception e) {
				logger.trace(e.getMessage());
				return false;
			}
		}
		return flag;
	}

	@SuppressWarnings("squid:S1166")
	public static boolean waitNumberOfWindowsToBe(CustomWebDriver driver, int nWindows, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(nWindows));
			return true;
		} catch (TimeoutException ignored){
			return false;
		}
	}

	public static void waitForReloadedElement(CustomWebDriver driver, By locatorBy, int timeOutInSeconds) {
		waitForDisappearanceElements(driver, locatorBy, timeOutInSeconds);
		waitForVisibleElement(driver, locatorBy, timeOutInSeconds);
	}

	public static void waitForReloadedElement(CustomWebDriver driver, By locatorBy) {
		waitForReloadedElement(driver, locatorBy, WAIT_TIME_OUT);
	}

	/**
	 * @param by
	 *            w
	 * @return boolean
	 */
	public static boolean waitExpectedConditionsVisibilityOf(CustomWebDriver driver, By by) {
		return waitExpectedConditionsVisibilityOf(driver, by, WAIT_TIME_OUT);
	}

	/**
	 *
	 * @param by
	 *            w
	 */
	public static boolean waitExpectedConditionsElementToBeClickable(CustomWebDriver driver, By by) {
		 return waitExpectedConditionsElementToBeClickable(driver, by, WAIT_TIME_OUT_SECONDS);
	}

	public static boolean waitExpectedConditionsElementToBeClickable(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;
		} catch(TimeoutException e){
			return false;
		}
	}

	/**
	 *
	 * @param by
	 *            w
	 * @param by2
	 *            w
	 */
	public static void waitExpectedConditionsVisibilityOfTwoElements(CustomWebDriver driver, By by, By by2) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT_SECONDS) /* seconds */);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(by),
				ExpectedConditions.visibilityOfElementLocated(by2)));
	}

	/**
	 *
	 * @param by
	 *            w
	 */
	public static void waitExpectedConditionsInvisibilityOf(CustomWebDriver driver, By by) {
		waitExpectedConditionsInvisibilityOf(driver, by, WAIT_TIME_OUT_INVISIBILE);
	}

	public static void waitExpectedConditionsInvisibilityOf(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * wait until page contains the given title
	 *
	 * @param expectedPageTitle
	 * @param timeOutInSeconds
	 * @return
	 */
	public static boolean waitUntilPageTitleContains(CustomWebDriver driver, String expectedPageTitle, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.titleContains(expectedPageTitle));
		return true;
	}

	/**
	 * THIS SHOULD NOT BE HERE, SHOULD BE IN WAITER
	 */
	public static void waitForLoad(CustomWebDriver driver) {
		new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(60)).until((ExpectedCondition<Boolean>) wd ->
				"complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState")));
	}

	/**
	 *
	 * @param nWindows
	 *            s
	 * @return s
	 */
	public static boolean waitNumberOfWindowsToBe(CustomWebDriver driver, int nWindows) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT_SECONDS) /* seconds */);
		wait.until(ExpectedConditions.numberOfWindowsToBe(nWindows));
		return true;
	}

	/**
	 *
	 * @param by
	 *            w
	 * @return w
	 */
	public static boolean waitExpectedConditionsPresenceOf(CustomWebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(WAIT_TIME_OUT_SECONDS)  /* seconds */);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return true;
	}

	public static boolean waitExpectedConditionsPresenceOf(CustomWebDriver driver, By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeout) /* seconds */);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return true;
	}

	public static void waitExpectedConditionsElementSizeMoreThan(CustomWebDriver driver, int beforeClickNumber, By locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (driver.findElements(locator).size() > beforeClickNumber){
					return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
		});
	}

    public static boolean waitForFocusedElementToBe(CustomWebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeout));
		return wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
					return driver.findElement(locator).equals(driver.switchTo().activeElement());
			}
		});
    }

	public static boolean waitExpectedConditionsElementSizeEqual(CustomWebDriver driver, int sizeWanted, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeout));
		try {
			return wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					if (driver.findElements(locator).size() == sizeWanted) {
						return Boolean.TRUE;
					}
					return Boolean.FALSE;
				}
			});
		}
		catch (TimeoutException e){
			return false;
		}
	}

	public static boolean waitExpectedConditionsElementAttributeToContain(CustomWebDriver driver, By by, String attribute, String expected, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.attributeContains(by, attribute, expected));
			return true;
		} catch(TimeoutException e){
			return false;
		}
	}

	public static boolean waitExpectedConditionElementVisibleIfExists(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(new WaitForVisibleElement(driver, by));
			return true;
		} catch(TimeoutException e){
			logger.trace(Constants.TIMEOUT_EXCEPTION,e);
			return false;
		}
	}

	public static boolean waitExpectedPDFContainsListOfText(CustomWebDriver driver, By by,List<String > listOfText,List<String> excludedListOfText, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(new WaitForPDFToContainText(driver, by, listOfText, excludedListOfText));
			return true;
		} catch(TimeoutException e){
			logger.trace(Constants.TIMEOUT_EXCEPTION,e);
			return false;
		}
	}

	public static Integer waitExpectedConditionElementDoesntContainAttribute(CustomWebDriver driver, By by ,String att, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			return wait.until(new WaitForElementNotContainingAttribute(driver, by, att));
		} catch(TimeoutException e){
			logger.trace(Constants.TIMEOUT_EXCEPTION,e);
			return 0;
		}
	}


	public static boolean waitExpectedConditionOptionExists(CustomWebDriver driver, By option, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(new WaitForOptionExists(driver, option));
			return true;
		} catch(TimeoutException e){
			logger.trace(Constants.TIMEOUT_EXCEPTION,e);
			return false;
		}
	}


	public static boolean waitExpectedConditionElementHasText(CustomWebDriver driver, By by, String text, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(new WaitForVisibleElementThatHasText(driver, by, text));
			return true;
		} catch(TimeoutException e){
			logger.trace(Constants.TIMEOUT_EXCEPTION,e);
			return false;
		}
	}

	public static class WaitForOptionExists implements ExpectedCondition<Boolean>{
		private CustomWebDriver driver;
		private By option;
		public WaitForOptionExists(CustomWebDriver driver, By option){
			this.driver=driver;
			this.option=option;
		}

		@Override
		public Boolean apply( WebDriver webDriver) {
			try {
				return driver.elementExists(option);
			}catch (Exception e){
				return false;
			}
		}

	}

	public static class WaitForPDFToContainText implements ExpectedCondition<Boolean>{
		private CustomWebDriver driver;
		private By locator;
		private List<String> listOfStrings;
		private List<String> excludedListOfStrings;
		public WaitForPDFToContainText(CustomWebDriver driver, By locator, List<String> listOfStrings, List<String> excludedListOfStrings ){
			this.driver=driver;
			this.locator=locator;
			this.listOfStrings=listOfStrings;
			this.excludedListOfStrings = excludedListOfStrings;
		}

		@Override
		public Boolean apply(WebDriver webDriver) {
			WebElement wE = driver.findElement(locator);
			String pdfInnerHTML = wE.getAttribute("innerHTML");
			String innerPdfStr = String.join(" ", pdfInnerHTML.split("</span><.*?>")).replaceAll("<.*?>", "");
			// added for debugging reason should be removed latter on
			logger.trace("value of PDF text   "+innerPdfStr);
			for(String st: listOfStrings) {
				if (!innerPdfStr.contains(st))
					return false;
			}
			for(String st: excludedListOfStrings) {
				if (innerPdfStr.contains(st))
					return false;
			}
			return true;
		}
	}

	public static class WaitForElementNotContainingAttribute implements ExpectedCondition<Integer>{
		private CustomWebDriver driver;
		private By locator;
		private String attr;
		private Integer count=0;
		public WaitForElementNotContainingAttribute(CustomWebDriver driver, By locator, String attr){
			this.driver=driver;
			this.locator=locator;
			this.attr=attr;
		}

		@Override
		public Integer apply( WebDriver webDriver) {
			try {
				List<WebElement> ele=driver.findElements(locator);
				for(WebElement e: ele){
					if(e.isEnabled() && e.isDisplayed() && e.getAttribute(attr).equals("")){
						break;
					}
					count++;
				}
			}catch (Exception e){
				return null;
			}
			return count;
		}


	}

	public static class WaitForVisibleElement implements ExpectedCondition<Boolean>{
		private CustomWebDriver driver;
		private By locator;
		public WaitForVisibleElement(CustomWebDriver driver, By locator){
			this.driver=driver;
			this.locator=locator;
		}

		@Override
		public Boolean apply( WebDriver webDriver) {
			try {
				return driver.findElement(locator).isEnabled() && driver.findElement(locator).isDisplayed();
			}catch (Exception e){
				return false;
			}
		}

	}

	public static class WaitForVisibleElementThatHasText implements ExpectedCondition<Boolean>{
		private CustomWebDriver driver;
		private By locator;
		private String text;
		public WaitForVisibleElementThatHasText(CustomWebDriver driver, By locator, String text){
			this.driver=driver;
			this.locator=locator;
			this.text=text;
		}

		@Override
		public Boolean apply( WebDriver webDriver) {
			try {
				return driver.findElement(locator).isEnabled() && driver.findElement(locator).isDisplayed() && driver.getText(locator).contains(text);
			}catch (Exception e){
				return false;
			}
		}

	}

	public static boolean waitForElementToNotBeStale(CustomWebDriver driver, By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(by))));
			return true;
		} catch(TimeoutException e){
			logger.trace(Constants.TIMEOUT_EXCEPTION,e);
			return false;
		}
	}
}
