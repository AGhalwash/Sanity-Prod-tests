package com.stacks.bdd.selenium.fields;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.Waiter;

public class CalendarField extends AbstractField {
	
	private final Date seed;
	
	private static final List<String> BLANK_VALUES = Arrays.asList("");
	
	private static final By DATE_PICKER_LOCATOR = By.xpath("//*[@id=\"ui-datepicker-div\"]/table//td");
	private static final By MONTH_SELECT_LOCATOR = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
	private static final By YEAR_SELECT_LOCATOR = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
	private static final String DAY_XPATH = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td[. = '%d']";
	
	
	public CalendarField(String name, CustomWebDriver driver, By locator, Date seed,  Boolean isMandatory) {
		super(name, driver, locator, isMandatory);
		this.seed = seed;
	}

	@Override
	public void fillWithDefaultValue() {
		Waiter.waitForVisibleElement(driver, locator);
		
		if (BLANK_VALUES.contains(driver.getElementAttribute(locator, Constants.VALUE))) {
			driver.clickOn(locator);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(seed);
			
			Waiter.waitForVisibleElement(driver, MONTH_SELECT_LOCATOR);
			new Select(driver.getSeleniumWebDriver().findElement(MONTH_SELECT_LOCATOR)).selectByIndex(calendar.get(Calendar.MONTH));
			
			Waiter.waitForVisibleElement(driver, YEAR_SELECT_LOCATOR);
			new Select(driver.getSeleniumWebDriver().findElement(YEAR_SELECT_LOCATOR)).selectByValue(String.valueOf(calendar.get(Calendar.YEAR)));
			
			By dayLocator = By.xpath(String.format(DAY_XPATH, calendar.get(Calendar.DAY_OF_MONTH)));
			driver.clickOn(dayLocator);
			
			Waiter.waitForInvisibleElements(driver, DATE_PICKER_LOCATOR);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			assertThat(driver.getElementAttribute(locator, Constants.VALUE), is(equalTo(formatter.format(calendar.getTime()))));
		}
	}

	@Override
	public String getValue() {
		Waiter.waitForVisibleElement(driver, locator);
		return driver.getElementAttribute(locator, Constants.VALUE);
	}

}
