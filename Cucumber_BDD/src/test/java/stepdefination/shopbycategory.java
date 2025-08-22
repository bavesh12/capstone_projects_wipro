package stepdefination;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class shopbycategory {

    WebDriver driver;
    Actions actions;

    @Given("I am on eBay homepage")
    public void i_am_on_ebay_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        actions = new Actions(driver);
        System.out.println("On eBay homepage");
    }

    @When("I move mouse over categories menu")
    public void i_move_mouse_over_categories_menu() throws InterruptedException {
        Thread.sleep(2000);
        WebElement categoryMenu = driver.findElement(By.xpath("//*[@id=\"gh\"]/section/div/div/div/button/span"));
        actions.moveToElement(categoryMenu).perform();
        System.out.println("Moved mouse over categories menu");
        Thread.sleep(1000);
    }

    @When("I choose Electronics from the list")
    public void i_choose_electronics_from_the_list() throws InterruptedException {
        Thread.sleep(2000);
        WebElement electronicsCategory = driver.findElement(By.xpath("//a[text()='Electronics']"));
        electronicsCategory.click();
        System.out.println("Chose Electronics category");
        Thread.sleep(3000);
    }

    @Then("I view Electronics category products page")
    public void i_view_electronics_category_products_page() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Viewed Electronics category page");           
    }

    @Then("I return back to main homepage")
    public void i_return_back_to_main_homepage() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Returned to main homepage");
        Thread.sleep(2000);
        driver.quit();
    }
}