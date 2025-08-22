package stepdefination;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Pageclass {
    WebDriver driver;
    By user=By.id("user_login");
    By pass=By.id("user_password");
    By signin=By.name("submit");
    By search=By.id("searchTerm");

    public Pageclass(WebDriver driver)
    {
        this.driver=driver;
    }
    public void login(String Username,String Password)
    {
        driver.findElement(user).click();
        driver.findElement(user).sendKeys(Username);  
        driver.findElement(pass).click();
        driver.findElement(pass).sendKeys(Password);
        driver.findElement(signin).click();
    }
    
    public void search(String item)
    {
        driver.findElement(search).click();
        driver.findElement(search).sendKeys(item);
        driver.findElement(search).sendKeys(Keys.ENTER);
    }
}