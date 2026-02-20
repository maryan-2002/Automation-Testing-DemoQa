package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By bookStoreCard = By.xpath("//h5[text()='Book Store Application']"); // Book Store card
    By loginMenu = By.xpath("//span[text()='Login']");  // Login menu inside Book Store
    By usernameField = By.id("userName");
    By passwordField = By.id("password");
    By loginButton = By.id("login");
    By logoutButton = By.id("submit");
    By errorMessage = By.id("name");   // DemoQA error message for login
    By profilePage = By.xpath("//div[@class='main-header' and text()='Profile']");
    // --------------------------
    // Navigation
    // --------------------------
    public void navigateToLogin() {
        // 1. Click Book Store Application card
        WebElement bookStore = wait.until(ExpectedConditions.elementToBeClickable(bookStoreCard));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookStore);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookStore);

        // Optional: remove ads/iframes if present
        closeDemoQAAds();

        // 2. Click Login menu inside Book Store
        WebElement menuItem = wait.until(ExpectedConditions.elementToBeClickable(loginMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuItem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuItem);

        // 3. Wait until username field appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        System.out.println("Navigated to Login page ✅ Current URL: " + driver.getCurrentUrl());
    }

    // --------------------------
    // Actions
    // --------------------------
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        WebElement btn = driver.findElement(loginButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void clickLogout() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    // --------------------------
    // Validations
    // --------------------------
    public boolean isProfilePageDisplayed() {
        try {
            // Wait until the username field on the Profile page is visible
            By profileUsername = By.id("userName-value");  // This element exists only after successful login
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileUsername));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(errorMessage,
                    "Invalid username or password!"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isFieldMarkedAsRequired(By field) {
        WebElement input = driver.findElement(field);
        // Returns true if the field is invalid (HTML5 required)
        return !(Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validity.valid;", input);
    }

    // --------------------------
    // Remove DemoQA Ads
    // --------------------------
    public void closeDemoQAAds() {
        try {
            Thread.sleep(1000); // wait for ads/iframes
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            for (WebElement frame : iframes) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", frame);
            }
            System.out.println("All iframes (ads) removed ✅");
        } catch (Exception e) {
            System.out.println("No iframes detected");
        }
    }
}