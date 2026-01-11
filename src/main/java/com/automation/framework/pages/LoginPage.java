package com.automation.framework.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By username = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By dashboardText = By.xpath("//h6[text()='Dashboard']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void goTo(String url) {
		driver.get(url);
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
	}

	public void enterUsername(String user) {
		wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
		driver.findElement(username).sendKeys(user);
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
	}
}
