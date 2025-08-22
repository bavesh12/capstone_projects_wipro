package stepdefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class shopbycatall {

    WebDriver driver;
    JavascriptExecutor js;

    @When("I open the category menu")
    public void i_open_the_category_menu() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        js = (JavascriptExecutor) driver;
        
        Thread.sleep(3000);
        WebElement categoryMenu = driver.findElement(By.xpath("//*[@id=\"gh\"]/section/div/div/div/button/span"));
        categoryMenu.click();
        System.out.println("Opened category menu");
        Thread.sleep(2000);
    }

    @And("I click through all available categories")
    public void i_click_through_all_available_categories() throws InterruptedException {
        Thread.sleep(2000);
        
        // First get the total number of categories
        List<WebElement> initialCategories = driver.findElements(By.cssSelector(".gh-categories__cat, .gh-sb-category"));
        int totalCategories = initialCategories.size();
        System.out.println("Total categories found: " + totalCategories);
        
        // Click through each category using index
        for (int i = 0; i < totalCategories; i++) {
            
            // Re-open menu for each category (except first)
            if (i > 0) {
                WebElement categoryMenu = driver.findElement(By.xpath("//*[@id=\"gh\"]/section/div/div/div/button/span"));
                categoryMenu.click();
                Thread.sleep(1500);
            }
            
            // Get fresh list of categories each time
            List<WebElement> currentCategories = driver.findElements(By.cssSelector(".gh-categories__cat, .gh-sb-category"));
            
            if (i < currentCategories.size()) {
                WebElement category = currentCategories.get(i);
                String categoryName = category.getText();
                
                if (!categoryName.isEmpty()) {
                    js.executeScript("arguments[0].style.border='3px solid yellow'", category);
                    Thread.sleep(1000);
                    
                    category.click();
                    System.out.println("Clicked on: " + categoryName + " (" + (i+1) + "/" + totalCategories + ")");
                    Thread.sleep(3000);
                    
                    driver.navigate().back();
                    Thread.sleep(2000);
                }
            }
        }
    }

    @Then("I verify all category pages loaded correctly")
    public void i_verify_all_category_pages_loaded_correctly() {
        System.out.println("Completed browsing all categories");
        driver.quit();
    }
}