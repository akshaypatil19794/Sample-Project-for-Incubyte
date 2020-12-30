package com.incubyte.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.incubyte.config.Configurations;

public class BaseTestCase {
	public static WebDriver driver;

	/**
	 * Launches browser
	 * @throws Exception
	 */
	public void launchBrowser() throws Exception {
		try {
			if ((Configurations.BrowserName).equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", Configurations.chromeDriverPath);
				driver = new ChromeDriver();
			} else if ((Configurations.BrowserName).equals("IE")) {
				System.setProperty("webdriver.ie.driver", Configurations.IEDriverPath);
				driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get(Configurations.URL);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void tearDown() {
		driver.quit();
	}

}
