package com.automation.framework.drivers;

import java.time.Duration;

import com.automation.framework.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver initDriver(String browser) {

		if (browser == null || browser.isEmpty()) {
			browser = ConfigReader.get("browser");
		}
		if (browser == null) {
			browser = "chrome";
		}

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			tlDriver.set(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");

			tlDriver.set(new FirefoxDriver(options));

		} else {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");

			tlDriver.set(new ChromeDriver(options));
		}

		int implicit = ConfigReader.getInt("implicit.wait", 5);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));

		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitDriver() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}
}
