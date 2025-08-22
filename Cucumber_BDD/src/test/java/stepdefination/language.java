package stepdefination;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class language {

    WebDriver driver;
    Actions actions;

    @Given("I make browser window full size")
    public void i_make_browser_window_full_size() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Made browser window full size");
    }

    @And("I go to main homepage")
    public void i_go_to_main_homepage() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        actions = new Actions(driver);
        System.out.println("Went to main homepage");
        Thread.sleep(2000);
    }

    @When("I hover mouse on language selector")
    public void i_hover_mouse_on_language_selector() throws InterruptedException {
        Thread.sleep(2000);
        WebElement languageDropdown = driver.findElement(By.cssSelector("button[aria-label*='eBay Sites'], #gh-eb, .gh-eb"));
        actions.moveToElement(languageDropdown).perform();
        System.out.println("Hovered mouse on language selector");
        Thread.sleep(1000);
    }

    @And("I pick German language option")
    public void i_pick_german_language_option() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Germany")).click();
        System.out.println("Picked German language option");
        Thread.sleep(4000);
    }

    @Then("the website language changes to German")
    public void the_website_language_changes_to_german() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}