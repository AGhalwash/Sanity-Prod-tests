package com.stacks.bdd.cucumber.runner;

import java.util.HashMap;
import java.util.Map;

import com.stacks.bdd.constants.core.*;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;


public class CucumberTestState {

	// The shared selenium web driver
	private CustomWebDriver driver;

	// The last opened form


	// A map to exchange information
	private final Map<String, Map<String, String>> dataTransferMap = new HashMap<>();

	private IUser user;



	public Browser getBrowser() {
		return SystemProperties.getBrowser();
	}
	
	/**
	 * Returns the value to which the specified keys are mapped.
	 * <p>Should replace all get access to the map {@code dataTransferMap}</p>
	 * 
	 * @param stepDefKey the key of the parent map whose associated son map is to be treated.
	 * @param elementId the key of the son map whose associated value is to be returned.
	 * @return the value to which the specified keys are mapped.
	 */
	public String getDataTransferById(String stepDefKey, String elementId) {
		return dataTransferMap.get(stepDefKey).get(elementId);
	}
	
	/**
	 * Associates the specified value with the specified key in this map.
	 * <p>If {@code dataTransferMap} does not have the stepDefKey, it is created.</p>
	 * <p>If the map previously contained a mapping for the elementKey, the old value is replaced by the specified value.</p>
	 * <p>Should replace all put access to the map {@code dataTransferMap}</p>
	 * 
	 * @param stepDefKey the key of the parent map whose associated son map is to be treated.
	 * @param elementKey the key of the son map whose associated value is to be returned.
	 * @param value the value to be associated with the specified stepDefKey and elementKey.
	 */
	public void addElementToDataTransfer(String stepDefKey, String elementKey, String value) {
		boolean hasKey = dataTransferMap.containsKey(stepDefKey);
		if (!hasKey) {
			dataTransferMap.put(stepDefKey, new HashMap<String, String>());
		}
		dataTransferMap.get(stepDefKey).put(elementKey, value);
	}	
	
	// Getters & Setters
	public CustomWebDriver getDriver() {
		return driver;
	}

	public void setDriver(CustomWebDriver driver) {
		driver.resetScreenshot();
		this.driver = driver;
	}



	public Map<String, Map<String, String>> getDataTransferMap() {
		return dataTransferMap;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

}
