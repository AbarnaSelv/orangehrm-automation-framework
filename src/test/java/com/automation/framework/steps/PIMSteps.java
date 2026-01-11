package com.automation.framework.steps;

import com.automation.framework.drivers.DriverFactory;
import com.automation.framework.pages.LoginPage;
import com.automation.framework.pages.PIMPage;
import com.automation.framework.utils.ConfigReader;
import com.automation.framework.utils.ExcelUtils;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PIMSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	private PIMPage pim = new PIMPage(driver);
	private WebDriverWait wait =
			new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait", 15)));


	@Given("user is logged in as {string} and {string}")
	public void user_is_logged_in_as_and(String username, String password) {
		loginPage.goTo(ConfigReader.get("base.url"));
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}


	@When("user navigates to PIM add employee")
	public void user_navigates_to_pim_add_employee() {
		pim.openPIM();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[normalize-space()='Add']")));
		pim.clickAdd();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
	}

	@When("user adds employee with {string} {string}")
	public void user_adds_employee_with(String fname, String lname) {
		pim.enterFirstName(fname);
		pim.enterLastName(lname);
		pim.setUniqueEmployeeId("EmpI");
		pim.clickSave();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h6[text()='Personal Details']")));
	}

	@When("user adds employees from excel {string}")
	public void user_adds_employees_from_excel(String path) {
		List<String[]> rows = ExcelUtils.readSheet(path, "employees");
		for (String[] r : rows) {
			pim.openPIM();
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//button[normalize-space()='Add']")));
			pim.clickAdd();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
			pim.enterFirstName(r[0]);
			pim.enterLastName(r[1]);
			pim.setUniqueEmployeeId("EmpI");
			pim.clickSave();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//h6[text()='Personal Details']")));
		}
	}

	@Then("employee should be added")
	public void employee_should_be_added() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h6[text()='Personal Details']")));
	}

	@Then("all employees from excel should be added")
	public void all_employees_from_excel_should_be_added() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h6[text()='Personal Details']")));
	}

}
