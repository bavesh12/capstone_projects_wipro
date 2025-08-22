package stepdefination;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class rightclick {

    WebDriver driver;
    JavascriptExecutor js;

    @When("I searched for {string}")
    public void i_searched_for(String searchItem) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        js = (JavascriptExecutor) driver;
        
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.clear();
        searchBox.sendKeys(searchItem);
        
        driver.findElement(By.id("gh-search-btn")).click();
        System.out.println("Searched for: " + searchItem);
        Thread.sleep(3000);
    }

    @When("I scroll down the page")
    public void i_scroll_down_the_page() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scrolled down page");
        Thread.sleep(1000);
    }

    @When("I click on product picture")
    public void i_click_on_product_picture() throws InterruptedException {
        Thread.sleep(2000);
        WebElement productImage = driver.findElement(By.cssSelector("#item1b29775252 > div > div.s-item__image-section > div > a > div > img"));
        productImage.click();
        System.out.println("Clicked on product picture");
        Thread.sleep(3000);
    }

    @When("I move to new browser tab")
    public void i_move_to_new_browser_tab() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
            System.out.println("Moved to new browser tab");
        }
        Thread.sleep(2000);
    }

    @Then("I close new tab and go back")
    public void i_close_new_tab_and_go_back() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1) {
            driver.close();
            driver.switchTo().window(tabs.get(0));
            System.out.println("Closed new tab and went back");
        }
        driver.quit();
    }
}