package stepdefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class search {

    WebDriver driver;
    PageClass1 page;

    @Given("I am in to eBay Homepage")
    public void i_am_in_to_e_bay_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PageClass1.EBAY_URL);   
        page = new PageClass1(driver);     
        System.out.println("Opened eBay Homepage");
    }

    @When("I search for {string}")
    public void i_search_for(String searchItem) {
        page.searchItem(searchItem);  
        System.out.println("Entered search item: " + searchItem);
    }

    @When("I click the search button")
    public void i_click_the_search_button() throws InterruptedException {
        page.clickSearchButton();
        System.out.println("Clicked Search button");
        Thread.sleep(2000);  
    }

    @Then("I navigate back to home page")
    public void i_navigate_back_to_home_page() throws InterruptedException {
        page.navigateToHome();
        System.out.println("Navigated back to Homepage");
        Thread.sleep(2000);
        driver.quit();  
    }
}
