package com.mapsynq.test.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mapsynq.test.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener eventListener;

	/**
	 * Perform basic initialization task read properties file
	 */
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(
					"src/test/resources/com/mapsynq/" + "test/config/config.properties");
			prop.load(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close browser
	 */
	public void cleanup() {
		if (TestBase.driver != null) {
			try {
				TestBase.driver.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Initialize browser
	 */
	public static void init(boolean mobile) {

		// Read the browser type, browser driver path
		String browserName = prop.getProperty("browser");
		String chromeDriverPath = null;
		String firefoxDriverPath = null;
		if (SystemUtils.IS_OS_WINDOWS) {
			chromeDriverPath = prop.getProperty("driver.windows.chrome.path");
			firefoxDriverPath = prop.getProperty("driver.windows.firefox.path");
		} else if (SystemUtils.IS_OS_MAC) {
			chromeDriverPath = prop.getProperty("driver.mac.chrome.path");
			firefoxDriverPath = prop.getProperty("driver.mac.firefox.path");
		} else if (SystemUtils.IS_OS_LINUX) {
			chromeDriverPath = prop.getProperty("driver.linux.chrome.path");
			firefoxDriverPath = prop.getProperty("driver.linux.firefox.path");
		}

		// Launch driver conditionally according to the browser name in property file
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			if (mobile) {
				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", "Nexus 5");
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			}
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("ChromeHeadless")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			chromeOptions.addArguments("window-size=1200x600");
			if (mobile) {
				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", "Nexus 5");
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			}
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		eventFiringWebDriver = new EventFiringWebDriver(driver);
		// Create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		eventFiringWebDriver.register(eventListener);
		driver = eventFiringWebDriver;

		// Set page load timeout, implicit wait, maximize page and delete cookies.
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("timeout.pageload")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeout.implicitwait")),
				TimeUnit.SECONDS);

		// Launch url
		driver.get(prop.getProperty("url"));

	}
}
