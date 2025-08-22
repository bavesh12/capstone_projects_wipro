package stepdefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class login {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I access the eBay login page")
    public void i_access_the_ebay_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        signInLink.click();
        System.out.println("Accessed eBay login page");
    }

    @When("I enter my registered email address")
    public void i_enter_my_registered_email_address() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        emailField.clear();
        emailField.sendKeys("username951520@gmail.com");
        System.out.println("Entered registered email address");
    }

    @When("I proceed to the next step")
    public void i_proceed_to_the_next_step() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin-continue-btn")));
        continueButton.click();
        System.out.println("Proceeded to next step");
    }

    @When("I provide my account password")
    public void i_provide_my_account_password() {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        passwordField.clear();
        passwordField.sendKeys("Ammanana@0310");
        System.out.println("Provided account password");
    }

    @When("I complete the authentication process")
    public void i_complete_the_authentication_process() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sgnBt")));
        signInButton.click();
        System.out.println("Completed authentication process");
    }

    @Then("I should be successfully logged into my eBay account")
    public void i_should_be_successfully_logged_into_my_ebay_account() {
        System.out.println("Successfully logged into eBay account");
        driver.quit();
    }
}