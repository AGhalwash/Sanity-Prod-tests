package com.stacks.bdd.selenium.locator.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.stacks.bdd.constants.core.SystemProperties;

/**
 * i18nPropertiesMap structure
 * 
 * <pre>
 * {
 * es={
 * 	nurse.linkText=Sanitario, 
 * 	general.medecine.xpathExpression=//*[contains(text(), 'MEDICINA GENERAL')]},
 * en={
 * 	nurse.linkText=Nurse, 
 * 	general.medecine.xpathExpression=//*[contains(text(), 'GENERAL MEDICINE')]}
 * }
 * </pre>
 *
 */
public interface I18nLocator {

	Logger logger = Logger.getLogger(I18nLocator.class.getName());

	Map<String, Map<String, String>> i18nPropertiesMap = new ConcurrentHashMap<>();
	Map<String, String> propertyMap = new ConcurrentHashMap<>();

	String getKey();

	String getResourceName();

	/**
	 * create enum from i18nPropertiesMap file. freaky.
	 * 
	 * @param key
	 *            nurse.linkText
	 * @param resourceName
	 * @return
	 */
	default String getSelector() {

		String locale = SystemProperties.getLocale();

        if (i18nPropertiesMap.get(locale) == null || i18nPropertiesMap.get(locale).get(getKey()) == null) {
			try (final InputStream is = I18nLocator.class.getClassLoader()
					.getResourceAsStream(String.format(getResourceName(), locale))) {
				Properties properties = new Properties();
                assert is != null;
                properties.load(new InputStreamReader(is, StandardCharsets.UTF_8));
				propertyMap.put(getKey(), properties.getProperty(getKey()));
				i18nPropertiesMap.put(locale, propertyMap);
			} catch (IOException e) {
				logger.error(getResourceName(), e);
			}
		}

		return i18nPropertiesMap.get(locale).get(getKey());
	}
}
