
package com.stacks.bdd.selenium.driver.core;

import com.stacks.bdd.constants.core.Browser;
import com.stacks.bdd.constants.core.SystemProperties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BrowserFactory {

	private static final Logger logger = Logger.getLogger(BrowserFactory.class.getName());

	private static final String DRIVERS_PATH = "src//test//resources//com//stacks//bdd//selenium//driver//";
	private static final String DEBUG = "debug_OMI360";
	private static final String DEBUG_FIREFOX = "debug";
	private static final String NO_DEBUG = "no_debug";
	private static final Browser BROWSER = SystemProperties.getSeleniumBrowser();
	private static final Boolean SELENIUM_GRID = SystemProperties.getSeleniumGrid();
	private static final URL SELENIUM_GRID_URL = SystemProperties.getSeleniumGridUrl();
	private static final Boolean SELENIUM_GRID_DEBUG = SystemProperties.getSeleniumGridDebug();
	private static final String LOCALE = SystemProperties.getLocale();
	private static final Boolean IS_WINDOWS = System.getProperty("os.name").startsWith("Windows");

	private static Map<String, WebDriver> drivers = new HashMap<>();

	private BrowserFactory() {
	}

	public static CustomWebDriver getBrowser() {
		WebDriver driver;
		logger.info("Creating driver.");
		switch (BROWSER) {
			case CHROME:
				driver = getChromeDriver();
				break;
			case FIREFOX:
				driver = getFirefoxDriver();
				break;
			case IE:
				driver = getInternetExplorerDriver();
				break;
			case EDGE:
				driver = getEdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Supported browsers are " + EnumSet.allOf(Browser.class));
		}
		drivers.put(BROWSER.toString(), driver);
		return new CustomWebDriver(driver);
	}

	private static WebDriver getEdgeDriver() {
		System.setProperty("webdriver.edge.driver", DRIVERS_PATH + "MicrosoftWebDriver.exe");
		return new EdgeDriver();
	}

	private static WebDriver getInternetExplorerDriver() {
		System.setProperty("webdriver.ie.driver", DRIVERS_PATH + "IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

	private static WebDriver getFirefoxDriver() {
		if (SELENIUM_GRID) {
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("intl.accept_languages", LOCALE);
			fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
			fp.setPreference("network.proxy.type", 1);
			fp.setPreference("network.proxy.http", "proxy-eb-chs.cegedim.cloud");
			fp.setPreference("network.proxy.ssl", "proxy-eb-chs.cegedim.cloud");
			fp.setPreference("network.proxy.ftp", "proxy-eb-chs.cegedim.cloud");
			fp.setPreference("network.proxy.http_port", 3128);
			fp.setPreference("network.proxy.ssl_port", 3128);
			fp.setPreference("network.proxy.ftp_port", 3128);
			fp.setPreference("print.always_print_silent", true);
			fp.setPreference("network.proxy.share_proxy_settings", true);
			fp.setPreference("network.proxy.no_proxies_on", "localhost,127.0.0.1,*.cegedim.com,*.cegedim.cloud,*.cegedim.grp,*.cegedim.hds,*.cegedim.clt,*.monlogicielmedical.com,.bcbdexther.fr");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(fp);
			// https://confluencechs.cegedim.com/pages/viewpage.action?pageId=44045964#SWFDO-PortainerforBDD(pswfbdd01.hosting.cegedim.cloud)-ConnecttoSelenium'snodedesktopbyVNC:
			//if(SELENIUM_GRID_DEBUG) {
			//	options.setCapability("applicationName", DEBUG_FIREFOX);
			//} else {
			//	options.setCapability("applicationName", NO_DEBUG);
			// }
		/*	RemoteWebDriver driver = new RemoteWebDriver(SELENIUM_GRID_URL, options);
			driver.setFileDetector(new LocalFileDetector());
			if(SELENIUM_GRID_DEBUG) {
				// Bear in mind that in non-debug images, the maximize window command won't
				// work. You can use the resize window command instead. Also, some browser
				// drivers allow specifying window size in capabilities.
				driver.manage().window().maximize();
                logger.info("driver maximized");
			}*/
			/*	return driver;*/
		} else {
			WebDriver webDriver;
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("intl.accept_languages", LOCALE);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
			options.addPreference("print.always_print_silent", true);
			options.addPreference("print.show_print_progress", false);
			webDriver = new FirefoxDriver(options);
			webDriver.manage().window().maximize();
			return webDriver;
		}
		return null;
	}

	private static WebDriver getChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=" + LOCALE);
		options.addArguments("--lang=" + LOCALE);
		options.addArguments("--remote-allow-origins=*");
		if (SELENIUM_GRID) {
			options.setCapability(ChromeOptions.CAPABILITY, options);
			// https://confluencechs.cegedim.com/pages/viewpage.action?pageId=44045964#SWFDO-PortainerforBDD(pswfbdd01.emea.cegedim.grp)-ConnecttoSelenium'snodedesktopbyVNC:
		/*	if(SELENIUM_GRID_DEBUG) {
				options.setCapability("applicationName", DEBUG);
			} else {
				options.setCapability("applicationName", NO_DEBUG);
			}*/
			RemoteWebDriver driver = new RemoteWebDriver(SELENIUM_GRID_URL, options);
			driver.setFileDetector(new LocalFileDetector());
			if(SELENIUM_GRID_DEBUG) {
				// Bear in mind that in non-debug images, the maximize window command won't
				// work. You can use the resize window command instead. Also, some browser
				// drivers allow specifying window size in capabilities.
				Waiter.sleep(1500);
				driver.manage().window().maximize();
			}
			else {
				Waiter.sleep(1500);
				driver.manage().window().setSize(new Dimension(1920,1080));
			}
			return driver;
		} else {
			System.setProperty("webdriver.chrome.driver",
					DRIVERS_PATH + (IS_WINDOWS ? "chromedriver.exe" : "chromedriver"));
			options.addArguments("disable-infobars", "--start-maximized");
			return new ChromeDriver(options);
		}
	}

}



