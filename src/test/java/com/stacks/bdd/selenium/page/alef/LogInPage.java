package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.constants.core.Browser;
import com.stacks.bdd.constants.core.SystemProperties;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.EnumSet;

import static com.stacks.bdd.selenium.locator.alef.SchoolsLocator.*;


public class LogInPage {

	static Logger logger = Logger.getLogger(LogInPage.class.getName());
	private final CustomWebDriver driver;

	private static final String SUBMITLOGININ = "submitLogIn";

	private static final String LOGIN = "Login - ALEF";
	public LogInPage(CustomWebDriver driver) {
		this.driver = driver;
	}


	public void openPage(String url)
	{   logger.trace("openPage");
		driver.openPage(SystemProperties.getServerUrl(url));
		Waiter.waitForLoad(driver);
		WebDriverWait wait = new WebDriverWait(driver.getSeleniumWebDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(LOGIN));
	}

	public LogInPage writeName(String userName) {
		logger.trace("writeName");
		Waiter.waitExpectedConditionsVisibilityOf(driver,USER_TEXT.by(),2);
		driver.sendKeysToAndVerify(userName, USER_TEXT.by(),3);
		return this;
	}

	public void writePassword(String userPassword) {
		logger.trace("writePassword");
		Waiter.waitExpectedConditionsVisibilityOf(driver,PASSWORD_TEXT.by(),2);
		driver.sendKeysToAndVerify(userPassword, PASSWORD_TEXT.by(),3);
	}

	public void login(String userName, String userPassword)
	{
		logger.trace(SUBMITLOGININ);
		writeName(userName).writePassword(userPassword);
		driver.clickOn(SUBMIT_BUTTON);
	}

}
