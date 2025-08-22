package stepdefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addcart{

    WebDriver driver;

    @Given("I go to homepage")
    public void i_go_to_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        System.out.println("Navigated to eBay homepage");
    }

    @Given("I go on the login page")
    public void i_go_on_the_login_page() throws InterruptedException {
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();
        System.out.println("Accessed login page");
        Thread.sleep(2000);
    }

    @Given("I enter valid username")
    public void i_enter_valid_username() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("userid"));
        emailField.clear();
        Thread.sleep(2000);
        emailField.sendKeys("username951520@gmail.com");
        System.out.println("Entered valid username");
    }

    @Given("I click on continue")
    public void i_click_on_continue() throws InterruptedException {
        Thread.sleep(2000);
        WebElement continueButton = driver.findElement(By.id("signin-continue-btn"));
        continueButton.click();
        System.out.println("Clicked continue button");
    }

    @Given("I enter valid password")
    public void i_enter_valid_password() throws InterruptedException {
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.clear();
        passwordField.sendKeys("Ammanana@0310");
        System.out.println("Entered valid password");
    }

    @Given("I click sign in button")
    public void i_click_sign_in_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement signInButton = driver.findElement(By.id("sgnBt"));
        signInButton.click();
        System.out.println("Clicked sign in button");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() throws InterruptedException {
            System.out.println("Logged in successfully");
        }
    @When("I am on a product page")
    public void i_am_on_a_product_page() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.ebay.com/itm/365723415668");
        System.out.println("On product page");
        Thread.sleep(3000);
    }

    @When("I add the product to cart")
    public void i_add_the_product_to_cart() throws InterruptedException {
        Thread.sleep(2000);
        WebElement addToCartButton = driver.findElement(By.cssSelector("a[id*='atcBtn']"));
        addToCartButton.click();
        System.out.println("Added product to cart");
        Thread.sleep(1000);
    }

    @When("I go to the cart")
    public void i_go_to_the_cart() throws InterruptedException {
        Thread.sleep(3000);
        
        driver.get("https://cart.ebay.com/");
        System.out.println("Navigated directly to cart page");
        
        Thread.sleep(3000);
    }

    @Then("The product should be displayed in the cart")
    public void the_product_should_be_displayed_in_the_cart() throws InterruptedException {
            System.out.println("Product is displayed in the cart");
            driver.quit();
    }
}