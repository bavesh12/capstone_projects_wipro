package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageClass1 {
    WebDriver driver;
    private WebDriverWait wait;
    By email = By.id("userid");
    By pass = By.cssSelector("#pass");
    By cont = By.id("signin-continue-btn");
    By search = By.id("gh-ac");
    By Submit = By.id("sgnBt");
    By searchButton = By.id("gh-search-btn"); 
    By addToCartBtn = By.cssSelector("a[id*='atcBtn']");
    By goToCartBtn = By.cssSelector("a[href*='cart.ebay.com']");
    By removeFromCartBtn = By.cssSelector("button[data-test-id*='cart-remove']");
    By emptyCartMessage = By.xpath("//div[contains(text(),'Your cart is empty')]");
    
    By categoryMenu = By.xpath("//*[@id=\"gh\"]/section/div/div/div/button/span");
    By electronicsCategory = By.xpath("//a[text()='Electronics']");
    
    By ProductImage = By.cssSelector("#item1b29775252 > div > div.s-item__image-section > div > a > div > img");
    By productDescription = By.xpath("//div[@id='vi-desc-maincntr'] | //div[contains(@class,'item-desc')]");
    
    By languageDropdown = By.cssSelector("button[aria-label*='eBay Sites']");
    By germanLanguageOption = By.linkText("Germany");
    
    By categoriesall = By.className("gh-categories__cat");
    By categoryMenu1 = By.cssSelector("#gh > section > div > div");
    
    By userProfileDropdown = By.cssSelector("#gh > nav > div.gh-nav__left-wrap > span.gh-identity");
    By accountSettingsLink = By.xpath("//*[@id=\"account-settings-link-PI\"]");
    By editUsernameButton = By.id("individual_username_edit_button");
    By usernameInput = By.id("user_name");
    By usernameSubmitButton = By.id("username_submit_edit_btn");
    
    By editAddressButton = By.id("individual_personal_info_address_edit_button");
    By addressLine1Input = By.id("addressLine1");
    By cityInput = By.id("city");
    By stateDropdown = By.cssSelector("select>option[value=\"TS\"]");
    By postalCodeInput = By.id("postalCode");
    By addressSubmitButton = By.id("address_edit_submit_button");

    
    
    //By categories = By.className("gh-categories__cat");

    public static final String EBAY_URL = "https://www.ebay.com/";
    public static final String PRODUCT_PAGE = "https://www.ebay.com/itm/365723415668";
    public static final String CART_PAGE = "https://cart.ebay.com/";
    
    public static final String ACCOUNT_SETTINGS_URL = "https://accountsettings.ebay.com/uas";
    public static final String NEW_USERNAME = "saibavesh"; // Define this constant
    
    public PageClass1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void email_in() {
        driver.findElement(email).click();
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("username951520@gmail.com");
    }

    public void pass_in() {
        driver.findElement(pass).click();
        driver.findElement(pass).sendKeys("Ammanana@0310");
    }

    public void con_in() {
        driver.findElement(cont).click();
    }

    public void submit_in() {
        driver.findElement(Submit).click();
    }

    public void searchItem(String item) {
        WebElement searchBox = driver.findElement(search);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(item);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void navigateToHome() {
        driver.get(EBAY_URL);
    }
    
    public void navigateToProductPage() {
        driver.get(PRODUCT_PAGE);
    }
    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(goToCartBtn).click();
    }

      public void removeItemFromCart() {
        driver.findElement(removeFromCartBtn).click();
    }

    public boolean isCartEmpty() {
        return driver.findElement(emptyCartMessage).isDisplayed();
    }
    
    public void hoverOverCategoryMenu() {
        WebElement menu = driver.findElement(categoryMenu);
        new Actions(driver).moveToElement(menu).perform();
    }
    
    public void selectElectronicsCategory() {
        driver.findElement(electronicsCategory).click();
    }
    
    public void navigateToHomePage() {
        driver.get(EBAY_URL);
    }
    
    //rightclick
    public void searchForProduct(String productName) {
        driver.findElement(search).clear();
        driver.findElement(search).sendKeys(productName);
        driver.findElement(searchButton).click();
    }
    
    public void scrollDown(int pixels) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0," + pixels + ")");
    }
    
    public void clickProductImage() {
        driver.findElement(ProductImage).click();
    }
    
    public void switchToNewWindow() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        }
    }
    
    public String getProductDescription() {
        return driver.findElement(productDescription).getText();
    }
    
    public void closeNewWindowAndSwitchBack() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1) {
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }
    
    // language
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    
    public void hoverOverLanguageDropdown() {
        WebElement dropdown = driver.findElement(languageDropdown);
        new Actions(driver).moveToElement(dropdown).perform();
    }
    
    public void selectGermanLanguage() {
        driver.findElement(germanLanguageOption).click();
    }
    
    //allcategories
    public void openCategoryMenu() throws InterruptedException {
        WebElement menu = driver.findElement(categoryMenu1);
        menu.click();
        Thread.sleep(1500);
    }

    public List<WebElement> getAllCategories() {
        return driver.findElements(categoriesall);
    }

    public void highlightElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript(
            "arguments[0].style.border='3px solid yellow'", element);
        Thread.sleep(1000);
    }

    public void clickCategory(WebElement category) throws InterruptedException {
        category.click();
        Thread.sleep(3000);
    }

    public void navigateBack() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
    }
    
    
    //username change
    
    public void hoverOverUserProfile() throws InterruptedException {
        WebElement profile = driver.findElement(userProfileDropdown);
        new Actions(driver).moveToElement(profile).build().perform();
        Thread.sleep(3000);
    }

    public void navigateToAccountSettings() throws InterruptedException {
        driver.get(ACCOUNT_SETTINGS_URL);
        Thread.sleep(3000);
    }

    public void clickAccountSettingsLink() throws InterruptedException {
        driver.findElement(accountSettingsLink).click();
        Thread.sleep(3000);
    }

    public void clickEditUsername() throws InterruptedException {
        driver.findElement(editUsernameButton).click();
        Thread.sleep(3000);
    }

    public void updateUsername(String newUsername) throws InterruptedException {
        WebElement input = driver.findElement(usernameInput);
        input.clear();
        input.sendKeys(newUsername);
        driver.findElement(usernameSubmitButton).click();
        Thread.sleep(5000);
    }

    public void loginAfterUsernameChange(String email, String password) throws InterruptedException {
        WebElement emailInput = driver.findElement(this.email);
        emailInput.clear();
        emailInput.sendKeys(email);
        driver.findElement(cont).click();
        Thread.sleep(3000);
        
        WebElement passwordInput = driver.findElement(pass);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(Submit).click();
        Thread.sleep(4000);
    }

    //address change 
    
    public void hoverOverUserProfile1() throws InterruptedException {
        WebElement profile = driver.findElement(userProfileDropdown);
        new Actions(driver).moveToElement(profile).build().perform();
        Thread.sleep(3000);
    }

    public void navigateToAccountSettings1() throws InterruptedException {
        driver.get(ACCOUNT_SETTINGS_URL);
        Thread.sleep(3000);
    }

    public void clickAccountSettings1() throws InterruptedException {
        driver.findElement(accountSettingsLink).click();
        Thread.sleep(3000);
    }

    public void scrollDown1(int pixels) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0," + pixels + ")");
    }

    public void clickEditAddress() throws InterruptedException {
        driver.findElement(editAddressButton).click();
        Thread.sleep(3000);
    }

    public void updateAddress(String newAddress, String city, String postalCode) throws InterruptedException {
        // Update address line 1
        WebElement addressInput = driver.findElement(addressLine1Input);
        addressInput.clear();
        addressInput.sendKeys(newAddress);
        
        // Update city
        WebElement cityInput = driver.findElement(this.cityInput);
        cityInput.clear();
        cityInput.sendKeys(city);
        
        // Select state
        driver.findElement(stateDropdown).click();
        
        // Update postal code
        WebElement postalCodeInput = driver.findElement(this.postalCodeInput);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
        
        // Submit changes
        driver.findElement(addressSubmitButton).click();
        Thread.sleep(5000);
    }


    
}

