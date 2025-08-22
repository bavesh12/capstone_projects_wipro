package stepdefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class SearchStep {

    WebDriver driver;

    @Given("the eBay homepage is loaded")
    public void the_ebay_homepage_is_loaded() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.ebay.com/");
    }

    @When("^the user enters \"(.*)\" in the search bar$")
    public void the_user_enters_in_the_search_bar(String searchItem) {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.clear();
        searchBox.sendKeys(searchItem);
    }

    @And("clicks the search button")
    public void clicks_the_search_button() {
        driver.findElement(By.id("gh-search-btn")).click();
    }

    @Then("^the search results page for \"(.*)\" should be displayed$")
    public void the_search_results_page_for_should_be_displayed(String searchItem) {
        System.out.println("Search completed for: " + searchItem);
        
        // Navigate back to homepage for the next search iteration
        driver.navigate().back();
    }
}