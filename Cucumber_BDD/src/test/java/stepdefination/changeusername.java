package stepdefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class changeusername {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I log into eBay with valid credentials")
    public void i_log_into_ebay_with_valid_credentials() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.ebay.com/");

        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        signInLink.click();

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        emailField.clear();
        emailField.sendKeys("username951520@gmail.com");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin-continue-btn")));
        continueButton.click();

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        passwordField.clear();
        passwordField.sendKeys("Ammanana@0310");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sgnBt")));
        signInButton.click();

        System.out.println("Logged into eBay account successfully");
    }

    @When("I hover over the profile icon")
    public void i_hover_over_the_profile_icon() {
        WebElement profileMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#gh > nav > div.gh-nav__left-wrap > span.gh-identity"))); 
        profileMenu.click();
        System.out.println("Hovered/clicked profile menu");
    }

    @And("I navigate to account preferences")
    public void i_navigate_to_account_preferences() {
        WebElement accountSettings = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account settings")));
        accountSettings.click();
        System.out.println("Navigated to account preferences");
    }

    @And("I click on personal information")
    public void i_click_on_personal_information() {
        WebElement personalInfo = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personal Information")));
        personalInfo.click();
        System.out.println("Opened personal information section");
    }

    @And("I select edit username option")
    public void i_select_edit_username_option() {
        WebElement editUsername = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Edit username")));
        editUsername.click();
        System.out.println("Clicked edit username");
    }

    @And("I update the username to {string}")
    public void i_update_the_username_to(String newUsername) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameField")));
        usernameField.clear();
        usernameField.sendKeys(newUsername);

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveButton")));
        saveButton.click();

        System.out.println("Updated username to: " + newUsername);
    }

    @And("I re-login after username change")
    public void i_re_login_after_username_change() {
        driver.get("https://signin.ebay.com/");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        emailField.clear();
        emailField.sendKeys("username951520@gmail.com");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin-continue-btn")));
        continueButton.click();

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        passwordField.clear();
        passwordField.sendKeys("Ammanana@0310");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sgnBt")));
        signInButton.click();

        System.out.println("Re-logged in after username change");
    }

    @Then("the username should be updated on my account")
    public void the_username_should_be_updated_on_my_account() {
        WebElement profileMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ug")));
        String updatedUsername = profileMenu.getText();

        System.out.println("Verified username after update: " + updatedUsername);

        driver.quit();
    }
}
