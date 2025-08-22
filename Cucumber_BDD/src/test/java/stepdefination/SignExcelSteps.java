package stepdefination;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SignExcelSteps {

    WebDriver driver;

    @Given("user logs in with all usernames and passwords from excel")
    public void user_logs_in_with_all_usernames_and_passwords_from_excel() {
        String filePath = "src/test/resources/testdata/LoginData.xlsx"; // make sure path is correct

        List<List<String>> sheetData = ExcelReader.getSheetData(filePath, "Sheet1");

        // Loop through all rows (your Excel has no header, so start from 0)
        for (int i = 0; i < sheetData.size(); i++) {
            String username = sheetData.get(i).get(0);
            String password = sheetData.get(i).get(1);

            System.out.println("Login attempt " + (i + 1) + ": " + username + " / " + password);

            // Launch browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("http://zero.webappsecurity.com/login.html");

            // Enter credentials
            driver.findElement(By.id("user_login")).sendKeys(username);
            driver.findElement(By.id("user_password")).sendKeys(password);
            driver.findElement(By.name("submit")).click();

            // Add a short pause so you can see login attempt (optional)
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Close browser before next iteration
            driver.quit();
        }
    }
}
