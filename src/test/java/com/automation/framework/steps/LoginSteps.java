package com.automation.framework.steps;

import com.automation.framework.drivers.DriverFactory;
import com.automation.framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import java.time.Duration;

public class LoginSteps {
    private WebDriver driver = DriverFactory.getDriver();

    @Given("user opens login page")
    public void user_opens_login_page() {
        driver.get(ConfigReader.get("base.url"));
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait", 15)));
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        user.clear();
        user.sendKeys(username);
        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        dismissGooglePasswordPopup();
    }

    @Then("dashboard should be visible")
    public void dashboard_should_be_visible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait", 15)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
    }

    private void dismissGooglePasswordPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
            ok.click();
        } catch (Exception e) {
        }
    }
}
