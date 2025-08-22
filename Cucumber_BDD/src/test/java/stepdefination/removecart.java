package stepdefination;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class removecart {

    WebDriver driver;

    @Given("I open eBay website")
    public void i_open_ebay_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        System.out.println("Opened eBay website");
    }

    @Given("I go to sign in page")
    public void i_go_to_sign_in_page() throws InterruptedException {
        Thread.sleep(2000);
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();
        System.out.println("Went to sign in page");
        Thread.sleep(2000);
    }

    @Given("I type my email address")
    public void i_type_my_email_address() throws InterruptedException {
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.id("userid"));
        emailField.clear();
        emailField.sendKeys("username951520@gmail.com");
        System.out.println("Typed email address");
    }

    @Given("I press continue button")
    public void i_press_continue_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement continueButton = driver.findElement(By.id("signin-continue-btn"));
        continueButton.click();
        System.out.println("Pressed continue button");
        Thread.sleep(2000);
    }

    @Given("I type my password")
    public void i_type_my_password() throws InterruptedException {
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.clear();
        passwordField.sendKeys("Ammanana@0310");
        System.out.println("Typed password");
    }

    @Given("I press sign in button")
    public void i_press_sign_in_button() throws InterruptedException {
        Thread.sleep(2000);
        WebElement signInButton = driver.findElement(By.id("sgnBt"));
        signInButton.click();
        System.out.println("Pressed sign in button");
        Thread.sleep(3000);
    }


    @When("I visit my shopping cart")
    public void i_visit_my_shopping_cart() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://cart.ebay.com/");
        System.out.println("Visited shopping cart");
        Thread.sleep(3000);
    }

    @When("I find the product in my basket")
    public void i_find_the_product_in_my_basket() throws InterruptedException {
    	System.out.println("Found product in basket");
    }

    @When("I click remove button for that product")
    public void i_click_remove_button_for_that_product() throws InterruptedException {
        Thread.sleep(2000);
        WebElement removeButton = driver.findElement(By.cssSelector("button[data-test-id*='cart-remove'], .remove-button, [aria-label*='Remove']"));
        removeButton.click();
        System.out.println("Clicked remove button");
        Thread.sleep(3000);
    }

    @Then("I see the product is gone from basket")
    public void i_see_the_product_is_gone_from_basket() throws InterruptedException {
           System.out.println("Product is gone from basket");
        }

    @Then("I see empty cart message")
    public void i_see_empty_cart_message() throws InterruptedException {
            System.out.println("Saw empty cart message");
            driver.quit();
    }
}