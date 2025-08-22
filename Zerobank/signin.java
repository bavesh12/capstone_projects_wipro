package stepdefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signin {
    WebDriver driver;
    Pageclass pageClass;
    
    @Given("login page should be open in default browser")
    public void login_page_should_be_open_in_default_browser() {
        driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        pageClass = new Pageclass(driver);
    }

    @When("^click on login button and enter (.*) and (.*)$")
    public void click_on_login_button_and_enter_username_and_password(String username, String password) {
        pageClass.login(username, password);
    }

    @And("^click on signin button check (.*)$")
    public void click_on_signin_button_check_status(String status) {
        System.out.println("Status of Test: " + status);
    }

	@Then("login successfully and open home page")
	public void login_successfully_and_open_home_page() {
	   
	}


}
