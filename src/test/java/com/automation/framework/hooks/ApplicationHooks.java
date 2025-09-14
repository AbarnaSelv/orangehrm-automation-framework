package com.automation.framework.hooks;

import com.automation.framework.drivers.DriverFactory;
import com.automation.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
    private WebDriver driver;
    @Before
    public void beforeScenario() {
        String browser = ConfigReader.get("browser");
        driver = DriverFactory.initDriver(browser);
    }
    @After
    public void afterScenario() {
        DriverFactory.quitDriver();
    }
}
