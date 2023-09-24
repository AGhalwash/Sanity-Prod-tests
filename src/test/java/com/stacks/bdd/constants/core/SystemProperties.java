package com.stacks.bdd.constants.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumSet;
import java.util.Properties;

import org.apache.log4j.Logger;

public class SystemProperties {

	private static final Logger logger = Logger.getLogger(SystemProperties.class.getName());

	private static final Properties SYSTEM_PROPS = loadSystemProperties();

	private SystemProperties() {
		// Private constructor to avoid instantiation
	}

	/**
	 * 
	 * @return
	 */
	public static Properties getSystemProperties() {
		return SYSTEM_PROPS;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getSystemProperty(String key) {
		return SYSTEM_PROPS.getProperty(key);
	}

	/**
	 * 
	 * @return
	 */
	public static String getServerUrl() {
		String serverUrl = SYSTEM_PROPS.getProperty("selenium.server.url");
		if (serverUrl == null) {
			throw new IllegalArgumentException("selenium.server.url configuration not found in system.properties");
		} else {
			return serverUrl;
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String getLocale() {
		String locale = SYSTEM_PROPS.getProperty("locale");
		if (locale == null) {
			throw new IllegalArgumentException("locale configuration not found in system.properties");
		} else {
			return locale;
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Browser getSeleniumBrowser() {
		String seleniumBrowser = SYSTEM_PROPS.getProperty("selenium.browser");
		if (seleniumBrowser == null) {
			throw new IllegalArgumentException("selenium.browser configuration not found in system.properties");
		} else {
			for (Browser browser : Browser.values()) {
				if (browser.getDescription().equals(seleniumBrowser)) {
					return browser;
				}
			}

			throw new IllegalArgumentException(
					"Wrong browser " + seleniumBrowser + " . Supported browsers are " + EnumSet.allOf(Browser.class));
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Boolean getSeleniumGrid() {
		String seleniumGrid = SYSTEM_PROPS.getProperty("selenium.grid");
		if (seleniumGrid == null) {
			logger.warn("selenium.grid configuration not found in system.properties");
		}
		return Boolean.parseBoolean(seleniumGrid);
	}
	
	public static Boolean getSeleniumGridDebug() {
		String seleniumGridDebug = SYSTEM_PROPS.getProperty("selenium.grid.debug");
		if (seleniumGridDebug == null) {
			logger.warn("selenium.grid.debug configuration not found in system.properties");
		}
		return Boolean.parseBoolean(seleniumGridDebug);
	}

	/**
	 * 
	 * @return
	 */
	public static URL getSeleniumGridUrl() {
		String seleniumGridUrl = SYSTEM_PROPS.getProperty("selenium.grid.url");
		if (seleniumGridUrl == null) {
			logger.warn("selenium.grid.url configuration not found in system.properties");
		}
		try {
            assert seleniumGridUrl != null;
            return new URL(seleniumGridUrl);
		} catch (MalformedURLException e) {
			logger.error(e);
			throw new IllegalArgumentException(e);
		}
	}



	public static Browser getBrowser() {
		String browser = SYSTEM_PROPS.getProperty("selenium.browser");
		if (browser == null) {
			logger.warn("browser configuration not found in system.properties");
		}
		return Browser.valueOf(browser.toUpperCase());
	}

	/**
	 * 
	 * @return
	 */
	public static String getCenterId() {
		String centerId = SYSTEM_PROPS.getProperty("center.id");
		if (centerId == null) {
			logger.warn("center.id configuration not found in system.properties");
		}
		return centerId;
	}

	/**
	 * 
	 * @return
	 */
	private static Properties loadSystemProperties() {
		Properties systemProps = new Properties();
		try {
			InputStream appConfigIn = SystemProperties.class.getClassLoader().getResourceAsStream("system.properties");
			if (appConfigIn == null) {
				throw new IllegalArgumentException("system.properties not found");
			}
			systemProps.load(appConfigIn);
			systemProps.forEach((key, value) -> logger.info(key + ": " + value));
		} catch (IOException e) {
			logger.error(e);
			throw new IllegalArgumentException(e);
		}
		return systemProps;
	}
	public static String getReportConfigPath(){
		String reportConfigPath = SYSTEM_PROPS.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return System.getProperty("user.dir")+ reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
}
