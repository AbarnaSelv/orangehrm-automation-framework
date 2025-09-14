package com.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By dashboardText = By.xpath("//h6[text()='Dashboard']");
    private By loginError = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public boolean isDashboardVisible() {
        return driver.findElements(dashboardText).size() > 0;
    }

    public String getLoginError() {
        if (driver.findElements(loginError).size() > 0) {
            return driver.findElement(loginError).getText();
        }
        return "";
    }
}
