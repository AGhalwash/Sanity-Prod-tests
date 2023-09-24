package com.stacks.bdd.selenium.driver.core;

import com.google.common.io.Files;
import com.stacks.bdd.constants.core.SystemProperties;
import com.stacks.bdd.selenium.locator.core.Locator;
import com.stacks.bdd.selenium.pdfUtils.ReadPDF;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;



import static com.stacks.bdd.selenium.locator.rms.LoaderLocator.LOADING;
import static com.stacks.bdd.selenium.locator.rms.LoaderLocator.LOADING_DIV;
import static com.stacks.bdd.selenium.locator.rms.PDFLocator.*;


public final class CustomWebDriver {

	private static final Logger logger = Logger.getLogger(CustomWebDriver.class.getName());

	private final WebDriver driver;
	private static final Integer NUM_RETRYS = 3;
	private static final String DOCUMENT_GETELEMENTBYID = "document.getElementById('";
	private byte[] screenshot;

	protected CustomWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void maximizeCurrentPage(){
		driver.manage().window().maximize();
	}

	public void openPage(String pageUrl) {
		driver.get(pageUrl);
	}

	/**
	 * Calls the custom clickOn(By,retrys) function
	 *
	 * @param by
	 *            From the element we want to click
	 */
	public void clickOn(By by) {
		clickOn(by, NUM_RETRYS);
	}

	/**
	 * Calls the custom clickOn(By,retrys) function

	 * @param locator
	 *            From the element we want to click
	 */
	public void clickOn(Locator locator) {
		clickOn(locator.by(), NUM_RETRYS);
	}

	/**
	 * Calls the custom clickOnAndVerify(By) function
	 *
	 */
	public void clickOnAndVerify(By elementToClickOn) {
		Supplier<Boolean> condition = () -> !Waiter.waitForDisappearanceElements(this, elementToClickOn, 10);
		clickOnAndVerify(elementToClickOn, condition);
	}

	public void clickOnAndVerify(By elementToClickOn, By elementToVerify) {
		Supplier<Boolean> condition = () -> !Waiter.waitExpectedConditionElementVisibleIfExists(this,elementToVerify, 10);
		clickOnAndVerify(elementToClickOn, condition);
	}

	public void clickOnAndVerify(By elementToClickOn, Supplier<Boolean> condition) {
		int retries = NUM_RETRYS;
		do {
			clickOn(elementToClickOn);
			retries--;
		} while(condition.get() && retries > 0);
	}

	// This function is specifically for MSD because the normal click is not working..
	public void clickOnSpecificElementFromListWithIndex(By elementToClickOn, int index, Supplier<Boolean> condition){
		int retries = NUM_RETRYS;
		do {
			Waiter.waitForElementToNotBeStale(this,elementToClickOn,5);
			driver.findElements(elementToClickOn).get(index).click();
			retries--;
		} while(condition.get() && retries > 0);
	}

	public void movePointerToAndVerify(By elementToMovePointerTo, By elementToVerify) {
		Supplier<Boolean> condition = () -> !Waiter.waitExpectedConditionElementVisibleIfExists(this, elementToVerify, 10);
		movePointerToAndVerify(elementToMovePointerTo, condition);
	}

	public void movePointerToAndVerify(By elementToMovePointerTo, Supplier<Boolean> condition)
	{
		int retries = NUM_RETRYS;
		do {
			movePointerTo(elementToMovePointerTo);
			retries--;
		} while(condition.get() && retries > 0);
	}
	/**
	 * this functions writes on the focused element
	 *
	 * @param text
	 */
	public void sendKeysToFocusedElement(String text) {
		WebElement active = this.driver.switchTo().activeElement();
		active.sendKeys(text);
	}

	public void sendKeysToFocusedElement(Keys text) {
		WebElement active = this.driver.switchTo().activeElement();
		active.sendKeys(text);
	}

	/**
	 * Clicks on a position given by coordenates X and Y
	 *
	 * @param x
	 *            coordinate X from a 2D position
	 * @param y
	 *            coordinate Y from a 2D position
	 */
	public void clickOnPosition(int x, int y) {
		new Actions(driver).moveByOffset(x, y).click().build().perform();
	}

	/**
	 * Wait for a element to be visible and then try to click it numRetrys times, if
	 * it fails retunrs an exemption
	 *
	 * @param by
	 *            From the element we want to click
	 * @param numRetrys
	 *            number of try to click, defined in header
	 */
	private void clickOn(By by, Integer numRetrys) {
		try {
			Waiter.waitForClickableElement(this, by);
			driver.findElement(by).click();
		} catch (ElementClickInterceptedException exception) {
			if (numRetrys >= 0) {
				Waiter.waitForDisappearanceElements(this, LOADING_DIV.by(), 3);
				Waiter.waitForDisappearanceElements(this, LOADING.by(), 3);
				Waiter.waitForVisibleElement(this, by);
				scrollPageBy(200);
				clickOn(by, numRetrys - 1);
			} else {
				throw exception;
			}
		} catch (Exception e) {
			if (numRetrys >= 0) {
				Waiter.waitForVisibleElement(this, by);
				clickOn(by, numRetrys - 1);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Get a string representing the current URL that the browser is looking at.
	 *
	 * @return The URL of the page currently loaded in the browser
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	/**
	 * Call the custom getElementText(By,numRetrys)
	 *
	 * @param by
	 *            From the element we want to operate
	 * @return The innerText of the by element.
	 */
	public String getElementText(By by) {
		return getElementText(by, NUM_RETRYS);
	}

	/**
	 * Call the custom getElementText(By,numRetrys)
	 *
	 * @param locator
	 *            The element we want to operate
	 * @return The innerText of the by element.
	 */
	public String getElementText(Locator locator) {
		return getElementText(locator.by(), NUM_RETRYS);
	}

	/**
	 * Get the visible (i.e. not hidden by CSS) innerText of this element, including
	 * sub-elements, without any leading or trailing whitespace. Customized to Wait
	 * for the element and try it numRetrys times.
	 *
	 * @param by
	 *            The element we want to operate
	 * @param numRetrys
	 *            Number of try to do the action (default:3, set in header)
	 * @return The innerText of the by element.
	 */
	private String getElementText(By by, Integer numRetrys) {
		try {
			Waiter.waitForVisibleElement(this, by);
			return driver.findElement(by).getText();
		} catch (Exception e) {
			if (numRetrys > 0) {
				return getElementText(by, numRetrys - 1);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Call the custom getElementAttribute(By,attribte,numRetrys)
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired attribute from the element
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getElementAttribute(By by, String attribute) {
		return getElementAttribute(by, attribute, NUM_RETRYS);
	}

	/**
	 * Call the custom getElementAttribute(WebElement,attribte,numRetrys)
	 *
	 * @param webElement
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired attribute from the element
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getElementAttribute(WebElement webElement, String attribute) {
		return getElementAttribute(webElement, attribute, NUM_RETRYS);
	}

	/**
	 * Call the custom getElementAttribute(By,attribte,numRetrys)
	 *
	 * @param locator
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired attribute from the element
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getElementAttribute(Locator locator, String attribute) {
		return getElementAttribute(locator.by(), attribute, NUM_RETRYS);
	}

	/**
	 * This method will return the value of the property with the given name, if it
	 * exists. If it does not, then the value of the attribute with the given name
	 * is returned. If neither exists, null is returned.
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired attribute from the element
	 * @param numRetrys
	 *            Number of try to do the action (default:3, set in header)
	 * @return
	 */
	private String getElementAttribute(By by, String attribute, Integer numRetrys) {
		try {
			return driver.findElement(by).getAttribute(attribute);
		} catch (Exception e) {
			if (numRetrys >= 0) {
				return getElementAttribute(by, attribute, numRetrys - 1);
			} else {
				throw e;
			}
		}
	}

	/**
	 * This method will return the value of the property with the given name, if it
	 * exists. If it does not, then the value of the attribute with the given name
	 * is returned. If neither exists, null is returned.
	 *
	 * @param webElement
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired attribute from the element
	 * @param numRetrys
	 *            Number of try to do the action (default:3, set in header)
	 * @return
	 */
	public String getElementAttribute(WebElement webElement, String attribute, Integer numRetrys) {
		try {
			return webElement.getAttribute(attribute);
		} catch (Exception e) {
			if (numRetrys >= 0) {
				return getElementAttribute(webElement, attribute, numRetrys - 1);
			} else {
				throw e;
			}
		}
	}

	public boolean checkIfElementHasAttribute(By by, String attribute){
		try {
			if (driver.findElement(by).getAttribute(attribute) != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Call the custom setElementAttribute
	 *
	 * @param by -> From the element we want to operate
	 * @param attribute -> Desired attribute from the element
	 * @param value -> Desired value that wants to set
	 */
	public void setElementAttribute(By by, String attribute, String value) {
		setElementAttribute(by, attribute, value, NUM_RETRYS);
	}

	/**
	 * Call the custom setElementAttribute
	 *
	 * @param locator -> From the element we want to operate
	 * @param attribute -> Desired attribute from the element
	 * @param value -> Desired value that wants to set
	 */
	public void setElementAttribute(Locator locator, String attribute, String value) {
		setElementAttribute(locator.by(), attribute, value, NUM_RETRYS);
	}
	/**
	 * This method will set the value of the property with the given name, if it
	 * exists.
	 *
	 * @param by -> From the element we want to operate
	 * @param attribute -> Desired attribute from the element
	 * @param value -> Desired value that wants to set
	 * @param numRetries -> Number of try to do the action (default:3, set in header)
	 */
	private void setElementAttribute(By by, String attribute, String value, Integer numRetries) {
		try {
			WebElement element = driver.findElement(by);
			((JavascriptExecutor) driver)
					.executeScript(DOCUMENT_GETELEMENTBYID + element.getAttribute("id") + "')."+ attribute + "='" + value + "';");

		} catch (Exception e) {
			if (numRetries >= 0) {
				setElementAttribute(by, attribute, value, numRetries - 1);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Call the custom getElementCSS(By,attribte,numRetrys)
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired css property from the element
	 * @return The current, computed value of the property
	 */
	public String getElementCss(By by, String attribute) {
		return getElementCss(by, attribute, NUM_RETRYS);
	}

	/**
	 * Call the custom getElementCSS(By,attribte,numRetrys)
	 *
	 * @param locator
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired css property from the element
	 * @return The current, computed value of the property
	 */
	public String getElementCss(Locator locator, String attribute) {
		return getElementCss(locator.by(), attribute, NUM_RETRYS);
	}

	/**
	 * Get the value of a given CSS property. Color values should be returned as
	 * rgba strings, so, for example if the "background-color" property is set as
	 * "green" in the HTML source, the returned value will be "rgba(0, 255, 0, 1)".
	 * Note that shorthand CSS properties (e.g. background, font, border,
	 * border-top, margin, margin-top, padding, padding-top, list-style, outline,
	 * pause, cue) are not returned, in accordance with the DOM CSS2 specification -
	 * you should directly access the longhand properties (e.g. background-color) to
	 * access the desired values.
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param attribute
	 *            Desired css property from the element
	 * @param numRetrys
	 *            Number of try to do the action (default:3, set in header)
	 * @return The current, computed value of the property
	 */
	private String getElementCss(By by, String attribute, Integer numRetrys) {
		try {
			Waiter.waitForVisibleElement(this, by);
			return driver.findElement(by).getCssValue(attribute);
		} catch (Exception e) {
			if (numRetrys >= 0) {
				return getElementCss(by, attribute, numRetrys - 1);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Use this method to simulate typing into an element, which may set its value.
	 * Waits until element is visible and send the sequence, without clear it
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 */
	public void sendKeysWithoutClear(String keys, By locator) {
		Waiter.waitExpectedConditionsVisibilityOf(this, locator);
		driver.findElement(locator).sendKeys(keys);
	}

	/**
	 * Call the custom sendKeysTo(keys,locator,NUM_RETRYS)
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 */
	public void sendKeysTo(String keys, By locator) {
		sendKeysTo(keys, locator, NUM_RETRYS);
	}

	/**
	 * Call the custom sendKeysTo(keys,locator,NUM_RETRYS)
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 */
	public void sendKeysTo(String keys, Locator locator) {
		sendKeysTo(keys, locator.by(), NUM_RETRYS);
	}

	/**
	 * Call the custom sendKeysToReadonly(keys, locator)
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 */
	public void sendKeysToReadonly(String keys, Locator locator) {
		sendKeysToReadonly(keys, locator.by());
	}

	/**
	 * Use this method to simulate typing into an element with readonly attribute,
	 * which may set its value.
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param by
	 *            From the element we want to operate
	 */
	public void sendKeysToReadonly(String keys, By by) {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript(
				DOCUMENT_GETELEMENTBYID + element.getAttribute("id") + "').removeAttribute('readonly',0);");
		element.clear();
		element.sendKeys(keys);
	}

	/**
	 * Use this method to simulate typing into an element, which may set its value.
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 */
	public void sendKeysToHidden(String keys, Locator locator) {
		sendKeysToHidden(keys, locator.by());
	}

	/**
	 * Use this method to simulate typing into an element with hidden attribute,
	 * which may set its value.
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param by
	 *            From the element we want to operate
	 */
	public void sendKeysToHidden(String keys, By by) {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver)
				.executeScript(DOCUMENT_GETELEMENTBYID + element.getAttribute("id") + "').value='" + keys + "';");
	}

	/**
	 * Use this method to simulate typing into an element, which may set its value.
	 * Waits for the element, clear the data inside element and send the new key
	 * sequence.
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 * @param numRetrys
	 *            Number of try to do the action (default:3, set in header)
	 */
	public void sendKeysTo(String keys, By locator, Integer numRetrys) {
		try {
			Waiter.waitForVisibleElement(this, locator);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(keys);
		} catch (Exception e) {
			if (numRetrys >= 0) {
				Waiter.waitForClickableElement(this, locator);
				sendKeysTo(keys, locator, numRetrys - 1);
			} else {
				throw e;
			}
		}
	}

	public void sendKeysToWebElement(String keys, WebElement webElement) {
		webElement.clear();
		webElement.sendKeys(keys);
	}

	// Clear function alone is not working, it must be a backspace
	public void sendBackSpaceKeyTo(By locator) {
		Waiter.waitForVisibleElement(this, locator);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
	}

	public String getTitle(){
		return driver.getTitle();
	}

	/**
	 * Use this method to simulate typing into an element, which may set its value.
	 * Waits for the element, clear the data inside element and send the new key
	 * sequence.
	 *
	 * @param keys
	 *            character sequence to send to the element
	 * @param locator
	 *            From the element we want to operate
	 * @param numRetrys
	 *            Number of try to do the action (default:3, set in header)
	 */
	public void sendKeysToAndVerify(String keys, By locator, Integer numRetrys) {
		sendKeysToAndVerify(keys, locator, numRetrys, true);
	}

	public void sendKeysToAndVerify(String keys, By locator, Integer numRetrys, boolean clear) {
		int numRetries = numRetrys;
		String elementText, elementValue;
		Waiter.waitForVisibleElement(this, locator);
		WebElement element = driver.findElement(locator);
		boolean keysSend;
		do {
			try {
				Waiter.waitForVisibleElement(this, locator);
				if(clear){
					element.clear();
				}
				element.sendKeys(keys);
			} catch (Exception e) {
				if(numRetries <= 1){
					throw e;
				}
			}
			elementText = element.getText();
			elementValue = element.getAttribute("value");
			keysSend = keys.equals(elementText) || keys.equals(elementValue);
			numRetries--;
		} while(!keysSend && numRetries > 0);
	}

	public void sendKeysToAndVerify(String keys, By locator, By elementToVerify, Integer numRetrys) {
		Supplier<Boolean> condition = () -> !Waiter.waitExpectedConditionsVisibilityOf(this,elementToVerify, 3);
		Waiter.waitForVisibleElement(this, locator);
		WebElement element = driver.findElement(locator);
		int retries = numRetrys;
		do {
			element.clear();
			element.sendKeys(keys);
			retries--;
		} while(condition.get() && retries > 0);
	}

	public void sendKeysToFocusedElementAndVerify(String keys, By locator, Integer numRetrys) {
		int numRetries = numRetrys;
		String elementText;
		String elementValue;
		Waiter.waitForVisibleElement(this, locator);
		WebElement element;
		boolean keysSend;
		do {
			try {
				Waiter.waitForVisibleElement(this, locator);
				clickOn(locator);
				WebElement active = this.driver.switchTo().activeElement();
				active.sendKeys(keys);
				Waiter.sleep(1000);
			} catch (Exception e) {
				if(numRetries <= 1){
					throw e;
				}
			}
			element = driver.findElement(locator);
			elementText = element.getText();
			elementValue = element.getAttribute("value");
			keysSend = keys.equals(elementText) || keys.equals(elementValue);
			numRetries--;
		} while(!keysSend && numRetries > 0);
	}

	/**
	 * Changes the active frame/window to the desired in iFrameLocator
	 *
	 * @param iFrameLocator
	 *            The iframe locator we wanna switch
	 */
	public void switchToIframe(Locator iFrameLocator) {
		Waiter.waitForVisibleElement(this, iFrameLocator.by());
		driver.switchTo().frame(driver.findElement(iFrameLocator.by()));
	}

	public void switchToIframe(By iFrameLocator) {
		Waiter.waitForVisibleElement(this, iFrameLocator);
		driver.switchTo().frame(driver.findElement(iFrameLocator));
	}

	/**
	 * Returns to the default frame/window after use switchToIframe(locator)
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Choose a position by index from a select
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param index
	 *            Element from select to choose by index
	 */
	public void selectByIndex(By by, int index) {
		final Select combo = new Select(driver.findElement(by));
		combo.selectByIndex(index);
	}

	/**
	 * Choose a position by value from a select
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param value
	 *            Element from select to choose by value
	 */
	public void selectByValue(By by, String value) {
		final Select combo = new Select(driver.findElement(by));
		combo.selectByValue(value);
	}

	/**
	 * Choose an option by text from a select
	 *
	 * @param by
	 *            From the element we want to operate
	 * @param value
	 *            Element from select to choose by text
	 */
	public void selectByText(By by, String value) {
		scrollToElement(by);
		final Select combo = new Select(driver.findElement(by));
		combo.selectByVisibleText(value);
	}

	/**
	 * If an alert is present (exist), switch to it and accept it
	 */
	public void acceptAlert() {
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	/**
	 * Read an alert containing text
	 *
	 * @return innerText of the alert element.
	 */
	public String readAlert() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * Waits until the element intrudiced is visible, and move the pointer to the
	 * location of this element.
	 *
	 * @param locator
	 *            From the element we want to operate
	 */
	public void movePointerTo(Locator locator) {
		Waiter.waitForClickableElement(this, locator.by());
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator.by());
		action.moveToElement(we).build().perform();
	}

	public void clickAndDrag(Locator a, Locator b){
		Waiter.waitForClickableElement(this, a.by());
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(a.by()));
		action.clickAndHold();

		action.moveToElement(driver.findElement(b.by()));
		action.release().perform();
	}


	public void movePointerTo(By by) {
		Waiter.waitForVisibleElement(this, by);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(by);
		action.moveToElement(we).build().perform();
	}


	public void movePointerTo(WebElement we) {
		Waiter.waitForClickableElement(this, we);
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform();
	}



	/**
	 * Scrolls the page until the given element is visible
	 *
	 * @param by
	 *            From the element we want to operate
	 */
	public void scrollToElement(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	}

	public void fillDate(By by, String value) {
		((JavascriptExecutor) driver).executeScript("$("+"arguments[0]"+").val('"+value+"');", driver.findElement(by));
	}

	public boolean checkElementInViewPort(By by) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("function detectIsVisible(el) { var id = '';var position = el.offset().top;if ( position > 80 ) { return true; }return false; };return detectIsVisible($("+"arguments[0]"+"));", driver.findElement(by));
	}

	public void fillDateValue(By by, String value) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('paciente.nacimiento').setAttribute('value','"+value+"');", driver.findElement(by));
	}

	public void scrollToElementWithOffset(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);  var elementPosition = arguments[0].getBoundingClientRect().bottom;var offsetPosition = elementPosition + 500;window.scrollTo({bottom: offsetPosition,behavior: \"smooth\"});", driver.findElement(by));
	}

	public void scrollToElementWithBackwardOffset(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);  var elementPosition = arguments[0].getBoundingClientRect().bottom;var offsetPosition = elementPosition - 500;window.scrollTo({bottom: offsetPosition,behavior: \"smooth\"});", driver.findElement(by));
	}

	public void scrollToElementIfExists(By by, int timeout) {
		if(Waiter.waitExpectedConditionsVisibilityOf(this,by,timeout)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
		}
	}

	public void scrollToBeginningOfPage(){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
	}

	public void scrollToEndOfPage(){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * Wait for destiny element to be present then click on actual position and move
	 * to desired element position
	 *
	 * @param locator
	 *            From the element we want to operate
	 */
	public void clickAndMovePointerTo(Locator locator) {
		Waiter.waitForClickableElement(this, locator.by());
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator.by());
		action.click();
		action.moveToElement(we).build().perform();
	}

	public void clickAndMovePointerToAndVerify(Locator locator, Locator expectedLocator) {
		Waiter.waitForDisappearanceElements(this, LOADING_DIV.by());
		Waiter.waitForClickableElement(this, locator.by());
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator.by());
		action.moveToElement(we).build().perform();
		clickOnAndVerify(locator.by(), expectedLocator.by());
	}

	public void clickAndMovePointerToAndVerify(By byLocator, By expectedByLocator) {
		Waiter.waitForDisappearanceElements(this, LOADING_DIV.by());
		Waiter.waitForClickableElement(this, byLocator);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(byLocator);
		action.moveToElement(we).build().perform();
		clickOnAndVerify(byLocator, expectedByLocator);

	}

	/**
	 * Delete all cookies from actual browser
	 */
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * Capture the screenshot and store it in the specified location.
	 *
	 * @return Object in which is stored information about the screenshot
	 */
	public byte[] getScreenshot() {
		if(screenshot == null){
			screenshot = takeScreenshot();
		}
		return screenshot;
	}

	public byte[] takeScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void takeExtendReportScreenshot(Scenario sc) throws IOException {
		File sourcePath= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-parallel/" + sc.getName());
		Files.copy(sourcePath, destinationPath);
		Reporter.addScreenCaptureFromPath(destinationPath.toString());

	}


	public void resetScreenshot(){
		this.screenshot = null;
	}

	/**
	 * Waits 5s and then close the browser
	 */
	public void quit() {
		Waiter.sleep(5000);
		driver.quit();
	}

	/**
	 * Get the Selenium driver linked to the project never modified
	 *
	 * @return Selenium driver never modified
	 */
	public WebDriver getSeleniumWebDriver() {
		return driver;
	}

	/**
	 * Look for if a element is present or not in the frame/window and return a
	 * true/false answer
	 *
	 * @param by
	 *            Element to look for
	 * @return true if the element is located, false if the element
	 */
	public boolean elementExists(By by) {
		return driver.findElements(by).size() > 0;
	}

	/**
	 * Look for if a element is present or not in the frame/window and return a
	 * true/false answer
	 *
	 * @param locator
	 *            Element to look for
	 * @return true if the element is located, false if the element
	 */
	public boolean elementExists(Locator locator) {
		return driver.findElements(locator.by()).size() > 0;
	}

	/**
	 * Perform an action to double click an element
	 *
	 * @param element
	 *            Where we want to click
	 */
	public void doubleclickWebElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	/**
	 * Perform an action to oduble click an element
	 *
	 * @param by
	 */
	public void doubleclickBy(By by) {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(by)).build().perform();
	}

	public void doubleClick(By elementToClickOn, Supplier<Boolean> condition) {
		int retries = NUM_RETRYS;
		Actions action = new Actions(driver);
		do {
			action.doubleClick(driver.findElement(elementToClickOn)).build().perform();
			retries--;
		} while(condition.get() && retries > 0);
	}

	public void doubleClickOnAndVerify(By elementToClickOn) {
		Supplier<Boolean> condition = () -> !Waiter.waitForDisappearanceElements(this, elementToClickOn, 10);
		doubleClick(elementToClickOn, condition);
	}

	public void doubleClickOnAndVerify(By elementToClickOn, By elementToVerify) {
		Supplier<Boolean> condition = () -> !Waiter.waitExpectedConditionElementVisibleIfExists(this,elementToVerify, 10);
		doubleClick(elementToClickOn,condition);
	}

	public void doubleClickJS(By by){
		((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
				"evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);",driver.findElement(by));
	}

	/**
	 * A function to jump over all the window and stays on the last one
	 *
	 * @return A String identifier of the original Window
	 */
	public String switchToNewWindow() {
		String winHandleBefore = driver.getWindowHandle();
		driver.getWindowHandles().stream()
				.filter(winHandle -> !winHandle.equals(winHandleBefore))
				.findFirst()
				.ifPresent(this::switchToHandle);
		if(winHandleBefore.equals(driver.getWindowHandle())) {
			throw new NoSuchWindowException("There is no other window present");
		}
		return winHandleBefore;
	}

	/**
	 * A function to jump over all the window and executes method on the last one
	 */
	public void doInsideNewWindow(Runnable code){
		Waiter.waitForNewWindow(this,5);
		String windowBefore = switchToNewWindow();
		try{
			code.run();
		} catch (Exception exception){
			getScreenshot();
			throw exception;
		} finally {
			switchToBefore(windowBefore);
		}
	}

	/**
	 * A function to jump over all the window and executes method on the last one
	 * @return The value of the supplier
	 */
	public <T>T getInsideNewWindow(Supplier<T> code){
		T returnValue;
		Waiter.waitForNewWindow(this,5);
		String windowBefore = switchToNewWindow();
		try{
			returnValue = code.get();
		} catch (Exception exception){
			getScreenshot();
			throw exception;
		} finally {
			switchToBefore(windowBefore);
		}
		return returnValue;
	}

	public void closeAllWindowsOtherThanLogin(){
		int windowsNumber = numberOfWindows();
		for (int i = 1; i< windowsNumber; i++){
			switchToWindow(1);
			logger.trace(String.format("Number of windows: %s and this handle is: %s", windowsNumber,getHandle()));
			closeWindow();
			switchToWindow(0);
			logger.trace(String.format("Number of windows: %s and this handle is: %s", numberOfWindows(),getHandle()));
		}
	}

	/**
	 * A function to jump over all the window and stays on the last one
	 *
	 */
	public void closeOtherWindowsIfAny() {
		String winHandleBefore = driver.getWindowHandle();
		driver.getWindowHandles().stream()
				.filter(winHandle -> !winHandle.equals(winHandleBefore))
				.forEach(winHandle -> {
					switchToHandle(winHandle);
					closeWindow();
				});
		switchToHandle(winHandleBefore);
	}

	/**
	 * Switch current window to the one determined by winHandle
	 *
	 * @param winHandle
	 *            Identifier of a window
	 */
	public void switchToHandle(String winHandle) {
		driver.switchTo().window(winHandle);
	}

	/**
	 * Switch current window to the one determined by index
	 *
	 * @param index
	 *            Identifier of a window
	 */
	public void switchToWindow(int index) {
		List<String> availableWindows = new ArrayList<>(driver.getWindowHandles());
		if (!availableWindows.isEmpty()) {
			driver.switchTo().window(availableWindows.get(index));
		}
	}

	/**
	 * Returns the current window identifier
	 *
	 * @return String containing the current window identifier
	 */
	public String getHandle() {
		return driver.getWindowHandle();
	}

	/**
	 * Returns all active windows identifiers
	 *
	 * @return A set of string containing all window identifiers
	 */
	public Set<String> getHandles() {
		return driver.getWindowHandles();
	}

	/**
	 * Change current window to the one whose identified with before windowhandle
	 *
	 * @param before
	 *            String containing a windowHandle of a window
	 */
	public void switchToBefore(String before) {
		driver.switchTo().window(before);
	}

	/**
	 * Test the state of visibility of an element and return a boolean, true if
	 * visible, false if not
	 *
	 * @param by
	 *            from the desired element
	 * @return return true if visible, false if not
	 */
	public boolean isVisible(By by) {
		if (elementExists(by)) {
			WebElement we = driver.findElement(by);
			return we.isDisplayed();
		}else{
			return false;
		}
	}

	/**
	 * Wait for the desired element to be visible and search for an element with the
	 * by/locator provided an return an objet of class webelement.
	 *
	 * @param by from the desired element
	 * @return WebElement containing the desired element
	 */
	public WebElement findElement(By by, boolean wait) {
		if(wait){
			Waiter.waitForVisibleElement(this, by, 3);
		}
		return driver.findElement(by);
	}

	public WebElement findElement(By by) {
		return findElement(by, true);
	}
	public WebElement findPresentElement(By by) {
		Waiter.waitForPresenceOfElement(this, by, 3);
		return driver.findElement(by);
	}

	/**
	 * Wait for the desired elements to be visible and search for all the elements
	 * with the by/locator provided an return a list of objects of class webelement.
	 *
	 * @param by
	 *            from the desired element
	 * @return WebElement containing the desired element
	 */
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	/**
	 * Test the state of visibility of an element and return a boolean, true if
	 * visible, false if not
	 *
	 * @param locator
	 *            from the desired element
	 * @return return true if visible, false if not
	 */
	public boolean isVisible(Locator locator) {
		return isVisible(locator.by());
	}

	/**
	 * Check if a popUp is visible and return boolean with true if visible, false if
	 * not
	 *
	 * @param locator
	 *            from the desired element
	 * @return boolean with true if visible, false if not
	 */
	public boolean popUpIsVisible(Locator locator) {
		return driver.findElement(locator.by()).isDisplayed();
	}

	/**
	 * Combine swithToIframe, isVisible and switchTodefault in one class Returns a
	 * boolean if the element is visible inside an iframe, true if it's visible,
	 * false if not
	 *
	 * @param locator
	 *            from the element we want to check visibility
	 * @param iframe
	 *            from the iframe we want to look inside
	 * @return boolean with true if visible, false if not
	 */
	public boolean isVisibleIntoIframe(Locator locator, Locator iframe) {
		switchToIframe(iframe);
		boolean result = driver.findElement(locator.by()).isDisplayed();
		switchToDefaultContent();
		return result;
	}

	/**
	 * Check from a list getted from the locator if each one of the elements
	 * contains a certain text/feature/property. Returns true if it does, false if
	 * not
	 *
	 * @param locator
	 *            from the list of items we want to check
	 * @param element
	 *            element we want to check if it's inside in every item
	 * @return return true if the element exisit in every item from the list, false
	 *         if not
	 */
	public boolean searchElementInEveryRow(Locator locator, String element) {
		List<WebElement> elements = driver.findElements(locator.by());
		for (WebElement e : elements) {
			if (!e.getText().toUpperCase().contains(element.toUpperCase())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Press the key enter inside a element located by locator
	 *
	 * @param locator
	 *            from the element to use
	 */
	public void pressIntro(Locator locator) {
		WebElement we = driver.findElement(locator.by());
		we.sendKeys(Keys.ENTER);
	}

	/**
	 * Press the key tab inside a element located by locator
	 *
	 * @param locator
	 *            from the element to use
	 */
	public void pressTab(Locator locator) {
		WebElement we = driver.findElement(locator.by());
		we.sendKeys(Keys.TAB);
	}

	/**
	 * Find the first five elements to acomplish the locator specification
	 *
	 * @param locator
	 *            from the element to use
	 */
	public List<WebElement> findFiveElements(Locator locator) {
		List<WebElement> elements = null;
		for (int i = 0; i < 5; i++) {
			elements = driver.findElements(locator.by());
		}
		return elements;
	}

	/**
	 * Find all the elements to acomplish the locator specification
	 *
	 * @param locator
	 *            from the elements to find
	 */
	public List<WebElement> findElements(Locator locator) {
		return driver.findElements(locator.by());
	}

	/**
	 * Move to the element located by the by and then press the right click button
	 * inside this element
	 *
	 * @param by
	 *            from the element to use
	 */
	public void rightClick(By by) {
		WebElement we = driver.findElement(by);
		scrollToElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(we);
		action.contextClick(we).build().perform();
	}

	/**
	 * Click on any element that is visible from the list that acomplish by
	 * specfication.
	 *
	 * @param by
	 *            that specifies an element characteristic
	 */
	public void clickOnVisibleFromList(By by) {
		List<WebElement> list = driver.findElements(by);
		for (WebElement e : list) {
			if (e.isDisplayed()) {
				e.click();
			}
		}
	}

	/**
	 * Returns the quantity of elements that are specified by the locator supplied
	 *
	 * @param locator
	 *            that specifies or not some elements
	 * @return number of elements located bt locator
	 */
	public int getElementsSize(Locator locator) {
		return driver.findElements(locator.by()).size();
	}

	public int getElementsSize(By by) {
		return driver.findElements(by).size();
	}

	/**
	 * Close the actual window
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * Return the text from the element specified by the by
	 *
	 * @param by
	 *            By that specified an element
	 * @return String that contains the specified text element
	 */
	public String getText(By by) {
		return findElement(by).getText();
	}

	/**
	 * Return the text from the element specified by a Locator
	 *
	 * @param locator
	 *            Locacator that specified an element
	 * @return String that contains the specified text element
	 */
	public String getText(Locator locator) {
		return findElement(locator.by()).getText();
	}

	/**
	 * Return the text from the element specified by the input
	 *
	 * @param we
	 *            An object from class element
	 * @return String that contains the specified text element
	 */
	public String getText(WebElement we) {
		return we.getText();
	}

	/**
	 * Return the text from all the element specified by the by
	 *
	 * @param by
	 *            By that specified a list of elements
	 * @return List of string that contains all the specified element text
	 */
	public List<String> getTextFromAllChildElements(By by) {
		List<WebElement> elements = findElements(by);
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText().toUpperCase());
		}
		return texts;
	}

	public List<String> getTextFromAllChildElementsWithoutUpperCase(By by) {
		List<WebElement> elements = findElements(by);
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	/**
	 * Return the attribute from all the element specified by the by
	 *
	 * @param by
	 *            By that specified a list of elements
	 * @return List of string that contains all the specified element attribute
	 */
	public List<String> getAttributeFromAllChildElements(By by, String attribute) {
		Waiter.waitForElementToNotBeStale(this,by,2);
		List<WebElement> elements = findElements(by);
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getAttribute(attribute).toUpperCase());
		}
		return texts;
	}

	/**
	 *
	 */
	public void waitElementToBeClickableAndClick(By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	/**
	 *
	 */
	@SuppressWarnings({"squid:S1166", "squid:S00108"})
	public void clickOnElementIfExists(By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		} catch(TimeoutException ignored) {}
	}

	public void clickOnElementIfExists(Locator locator, int timeOutInSeconds) {
		clickOnElementIfExists(locator.by(), timeOutInSeconds);
	}

	/**
	 *
	 */
	public void waitElementToBeVisibleAndClick(By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
	}

	/**
	 * Function that try to click an element if fail return an exception
	 *
	 * @param by
	 *            that specifies some element
	 * @return boolean with true if the element is clickable, false if not
	 */
	public boolean tryToClick(By by) {
		try{
			clickOn(by);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void waitseconds(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			logger.error(e);
		}
	}

	/**
	 * TO REFACTOR ALREADY DEFINED
	 *
	 * @param locator
	 *            w
	 */
	public void doEnter(Locator locator) {
		driver.findElement(locator.by()).sendKeys(Keys.ENTER);
	}

	/**
	 * Check if an alert is present in the windowhandles and return a boolean if it
	 * exist and not if not
	 *
	 * @return Boolean with tru if alert exist, false if not
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	/** positive pixels means scrolling down, negative means up
	 *
	 * @param pixels -> number of pixels to scroll
	 */
	public void scrollPage(int pixels) {
		JavascriptExecutor js = ((JavascriptExecutor) getSeleniumWebDriver());
		js.executeScript("scroll(0, " + pixels + ");");
	}

	public void scrollPageBy(int pixels) {
		JavascriptExecutor js = ((JavascriptExecutor) getSeleniumWebDriver());
		js.executeScript("window.scrollBy(0, " + pixels + ");");
	}

	/**
	 * Change the focus to the new window, search the url of the pdf, retrieve the
	 * session and read the content of the PDF.
	 *
	 * This method doesn't work. To refine.
	 *
	 * @return Object String with The content of the pdf
	 */
	public String getContentPdf() {
		Waiter.waitNumberOfWindowsToBe(this,2);
		String result;
		try {
			result = getInsideNewWindow(this::getPdfAsString);
		} finally {
			closeAllWindowsOtherThanLogin();
		}
		return result;
	}

	public boolean waitForPDFToLoad(List<String> includedList, List<String> excludedList){
		boolean returnValue;
		Waiter.waitForNewWindow(this,5);
		String windowBefore = switchToNewWindow();
		try{
			returnValue = waitForPdf(includedList, excludedList);
		} catch (Exception exception){
			getScreenshot();
			throw exception;
		} finally {
			switchToBefore(windowBefore);
		}
		return returnValue;
	}

	public String getContentPdfWithoutSwitchingToNewWindow() {
		String result;
		try {
			result = getPdfAsString();
		} finally {
			closeAllWindowsOtherThanLogin();
		}
		return result;
	}

	private String getPdfAsString(){
		String pdfStr = "";
		switch (SystemProperties.getSeleniumBrowser()) {
			case FIREFOX:
				pdfStr = getPdfAsStringFromFirefox();
				break;
			case CHROME:
				pdfStr = getPdfAsStringFromChrome();
				break;
			default:
				logger.trace("Browser does not match:" + SystemProperties.getSeleniumBrowser());
		}
		return pdfStr;
	}

	private String generateXPATH(WebElement childElement, String current) {
		String childTag = childElement.getTagName();
		if(childTag.equals("html")) {
			return "/html[1]"+current;
		}
		WebElement parentElement = childElement.findElement(By.xpath(".."));
		List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
		int count = 0;
		for(int i=0;i<childrenElements.size(); i++) {
			WebElement childrenElement = childrenElements.get(i);
			String childrenElementTag = childrenElement.getTagName();
			if(childTag.equals(childrenElementTag)) {
				count++;
			}
			if(childElement.equals(childrenElement)) {
				return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
			}
		}
		return null;
	}

	private String getPdfAsStringFromChrome(){
		String innerPdfStr;
		if(elementExists(PDF_OBJECT_CHROME.by())) {
			WebElement wE = driver.findElement(PDF_OBJECT_CHROME.by());
			String urlPdf = wE.getAttribute("src");
			Cookie cookie = getSeleniumWebDriver().manage().getCookieNamed("JSESSIONID");
			String cookieStr = cookie.toString();
			innerPdfStr = ReadPDF.getContentPdf(urlPdf, cookieStr);
			return innerPdfStr;

		} else {
			return getPdfAsStringFromChromeExtension();
		}
	}

	public String getPdfAsStringFromChromeExtension(){
		String innerPdfStr = "";
		switchToIframe(By.xpath("//iframe"));

		driver.findElement(PDF_OBJECT_CHROME.by());
		Waiter.sleep(3000);
		byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		ByteArrayInputStream bis = new ByteArrayInputStream(image);
		try {
			BufferedImage bImage2 = ImageIO.read(bis);
			ImageIO.write(bImage2, "jpg", new File("output.jpg"));
			driver.get("https://www.onlineocr.net/");
			driver.findElement(By.cssSelector("#fileupload")).sendKeys("output.jpg");
			Waiter.sleep(3000);
			driver.findElement(By.cssSelector("#MainContent_btnOCRConvert")).click();
			waitElementToBeClickableAndClick(By.cssSelector("#MainContent_txtOCRResultText"), 60);
			Waiter.sleep(1000);
			innerPdfStr = driver.findElement(By.cssSelector("#MainContent_txtOCRResultText")).getText();
		}catch( IOException exception) {
			logger.error(exception.getMessage(), exception);
		}
		return innerPdfStr;
	}

	private void switchToPdfIframe(){
		Waiter.sleep(1000); //To be removed when we check if really necessary
		acceptAlert();
		if (Waiter.waitExpectedConditionsVisibilityOf(this , PDF_IFRAME_FIREFOX.by())) {
			switchToIframe(PDF_IFRAME_FIREFOX);
		}
		Waiter.waitForVisibleElement(this, PDF_OBJECT_FIREFOX.by());
	}

	private String getPdfAsStringFromFirefox() {
		String innerPdfStr;
		switchToPdfIframe();
		int retry = 3;
		do {
			Waiter.sleep(1000);
			WebElement wE = driver.findElement(PDF_OBJECT_FIREFOX.by());
			String pdfInnerHTML = wE.getAttribute("innerHTML");
			innerPdfStr = String.join(" ", pdfInnerHTML.split("</span><.*?>")).replaceAll("<.*?>", "");
			retry--;
		} while ("".equals(innerPdfStr) && retry > 0);
		return innerPdfStr;
	}

	public String getPixelsFromTopOfPdf() {
		Waiter.waitNumberOfWindowsToBe(this,2,5);
		switchToWindow(1);
		String innerPdfStr;
		switchToPdfIframe();
		int retry = 3;
		do {
			Waiter.sleep(1000);
			WebElement wE = driver.findElement(PDF_OBJECT_FIREFOX.by());
			innerPdfStr = wE.getAttribute("innerHTML");
			retry--;
		} while ("".equals(innerPdfStr) && retry > 0);
		innerPdfStr =  innerPdfStr.split("top: ")[1].split("px;")[0];
		switchToWindow(0);
		return innerPdfStr;
	}

	public boolean waitForPdf(List<String> includedList, List<String> excludedList){
		if (Waiter.waitExpectedConditionsVisibilityOf(this , PDF_IFRAME_FIREFOX.by())) {
			switchToIframe(PDF_IFRAME_FIREFOX);
		}
		Waiter.waitForVisibleElement(this, PDF_OBJECT_FIREFOX.by());
		return Waiter.waitExpectedPDFContainsListOfText(this, PDF_OBJECT_FIREFOX.by(),includedList, excludedList, 10);
	}

	public int numberOfPagesInPdfFromFirefox(){
		int numberOfPages;
		if (Waiter.waitExpectedConditionsVisibilityOf(this , PDF_IFRAME_FIREFOX.by())) {
			switchToIframe(PDF_IFRAME_FIREFOX);
		}
		Waiter.waitForVisibleElement(this, PDF_OBJECT_FIREFOX.by());
		int retry = 2;
		do {
			Waiter.sleep(1000);
			numberOfPages = driver.findElements(PDF_OBJECT_FIREFOX_PAGES.by()).size();
			retry--;
		} while (numberOfPages==0 && retry > 0);
		return numberOfPages;
	}

	/**
	 * Check if there is a PopUp and close all the PopUps with the
	 * POP_UP_ACCEPT_BUTTON
	 */


	/**
	 * navigate to specified URL
	 *
	 * @param URL to navigate
	 */
	public void goToURL(String URL) {
		driver.navigate().to(URL);
	}

	/**
	 * Use this method to simulate a click into an element.
	 *
	 * @param by
	 *            From the element we want to operate
	 */
	public void forceClick(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(by));
	}

	public void forceClickByXpath(String xpath) {
		((JavascriptExecutor) driver)
				.executeScript("var element = document.evaluate(\"" + xpath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; element.click();");
	}

	public void uploadFileFromDocuments(Locator fileInputElement, String folder, String fileName) throws IOException {
		String path = "./src/main/resources/Documents/" + folder + "/" + fileName;
		File file = new File(path);
		if (this.isVisible(fileInputElement)) {
			sendKeysTo(file.getCanonicalPath(), fileInputElement);
		}else{
			this.setElementAttribute(fileInputElement,"style", "display:yes");
			this.sendKeysTo(file.getCanonicalPath(), fileInputElement);
		}
	}

	public void dragElementOverElement(WebElement firstElement, WebElement targetElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(firstElement, targetElement).perform();
	}

	public void clickOnElementWithOffSetAction(By locator, int xOffset, int yOffset) {
		scrollToElement(locator);
		WebElement webElement = driver.findElement(locator);
		Actions clickAction = new Actions(driver);
		clickAction.moveToElement(webElement, xOffset, yOffset).click().build().perform();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void rightClickAndVerify(By targetElement, By verificationElement) {
		scrollToElement(targetElement);
		int retries = NUM_RETRYS;
		do {
			rightClick(targetElement);
			retries--;
		} while(!isVisible(verificationElement) && retries > 0);
	}

	public void clickAndMovePointerTo(By elementBylocator) {
		Waiter.waitForClickableElement(this, elementBylocator);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(elementBylocator);
		action.click();
		action.moveToElement(we).build().perform();
	}

	public WebElement switchToActiveElement(){
		return driver.switchTo().activeElement();
	}

	public void rightClickElementAtElementOffsetAndVerify(By targetElement, int xOffset, int yOffset , By elementToVerify) {
		Waiter.waitExpectedConditionsElementToBeClickable(this, targetElement, 5);
		WebElement target = driver.findElement(targetElement);
		Supplier<Boolean> condition = () -> !Waiter.waitExpectedConditionsVisibilityOf(this, elementToVerify, 10);
		Actions clickAction = new Actions(driver);
		int retries = NUM_RETRYS;
		do {
			clickAction.moveToElement(target, xOffset, yOffset).contextClick().build().perform();
			retries--;
		} while(condition.get() && retries > 0);
	}

	public void rightClickElementAtElementOffset(By targetElement, int xOffset, int yOffset) {
		Waiter.waitExpectedConditionsElementToBeClickable(this, targetElement, 5);
		WebElement target = driver.findElement(targetElement);
		Actions clickAction = new Actions(driver);
		clickAction.moveToElement(target, xOffset, yOffset).contextClick().build().perform();
	}

	public void clearField(By by){
		driver.findElement(by).clear();
	}

	public int numberOfWindows(){
		return driver.getWindowHandles().size();
	}

	public String getItemFromSessionStorage(String key) {
		return (String) ((JavascriptExecutor) driver).executeScript(String.format("return window.sessionStorage.getItem('%s');", key));
	}

	public boolean isInputItemChecked(By by) {
		try {
			return getElementAttribute(by, "checked").equals("true");
		} catch (NullPointerException e) {
			return false;
		}
	}
}
