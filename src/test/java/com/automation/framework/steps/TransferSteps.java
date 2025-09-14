package com.automation.framework.steps;

import com.automation.framework.drivers.DriverFactory;
import com.automation.framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import java.time.Duration;

public class TransferSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait",15)));

    @Given("user is logged in with {string} and {string}")
    public void user_is_logged_in_with_and(String username, String password) {
        driver.get(ConfigReader.get("base.url"));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
    }

    @When("user navigates to transfer funds page")
    public void user_navigates_to_transfer_funds_page() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Funds"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Transfer Funds']")));
    }

    @When("user transfers {int} from account {string} to account {string}")
    public void user_transfers_from_account_to_account(Integer amount, String fromAcc, String toAcc) {
        driver.findElement(By.id("amount")).sendKeys(amount.toString());
        driver.findElement(By.id("fromAccountId")).sendKeys(fromAcc);
        driver.findElement(By.id("toAccountId")).sendKeys(toAcc);
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();
    }

    @Then("transfer confirmation should be displayed")
    public void transfer_confirmation_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Transfer Complete!']")));
    }
}
