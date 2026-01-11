package com.automation.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	private WebDriver driver;
	private By pimMenu = By.xpath("//a[contains(@href,'/pim/viewPimModule')]");
	private By addButton = By.xpath("//button[normalize-space()='Add']");
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By saveBtn = By.xpath("//button[normalize-space()='Save']");
	private By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPIM() {
		driver.findElement(pimMenu).click();
	}

	public void clickAdd() {
		driver.findElement(addButton).click();
	}

	public void enterFirstName(String f) {
		driver.findElement(firstName).sendKeys(f);
	}

	public void enterLastName(String l) {
		driver.findElement(lastName).sendKeys(l);
	}

	public void clickSave() {
		driver.findElement(saveBtn).click();
	}

	public boolean isSaved() {
		return driver.findElements(personalDetailsHeader).size() > 0;
	}

	public void setUniqueEmployeeId(String empId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector("div.oxd-form-loader")));
		WebElement empIdInput = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='Employee Id']/following::input[1]")));

		empIdInput.clear();


		String finalId = empId.length() > 10 ? empId.substring(0, 10) : empId;

		empIdInput.sendKeys(finalId);
	}

}
