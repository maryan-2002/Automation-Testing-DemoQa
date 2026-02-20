package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TextBoxPage {

	 WebDriver driver;
	 WebDriverWait wait;

	    public TextBoxPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Locators
	    By elementsCard = By.xpath("//h5[text()='Elements']");
	    By textBoxMenu = By.xpath("//span[text()='Text Box']");


	    By fullName = By.id("userName");
	    By email = By.id("userEmail");
	    By currentAddress = By.id("currentAddress");
	    By permanentAddress = By.id("permanentAddress");
	    By submitBtn = By.id("submit");

	    By outputSection = By.id("output");

	 // Navigation
	    public void navigateToTextBox() {
	        // Remove any interfering ads/iframes
	        closeDemoQAAds();

	        // 1. Click Elements card
	        WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(elementsCard));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elements);

	        // 2. Click Text Box menu (click the span)
	        clickSidebarMenuItem(textBoxMenu);

	        // 3. Wait until Full Name input appears to confirm page loaded
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
	        System.out.println("Navigated to Text Box page ✅ Current URL: " + driver.getCurrentUrl());
	    }






	    // Actions
	    public void fillForm(String name, String mail, String current, String permanent) {
	        driver.findElement(fullName).sendKeys(name);
	        driver.findElement(email).sendKeys(mail);
	        driver.findElement(currentAddress).sendKeys(current);
	        driver.findElement(permanentAddress).sendKeys(permanent);
	    }

	    public void enterEmailOnly(String mail) {
	        driver.findElement(email).sendKeys(mail);
	    }

	    public void clickSubmit() {
	        WebElement button = driver.findElement(submitBtn);

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", button);

	        wait.until(ExpectedConditions.elementToBeClickable(button));

	        // Use JS click (more stable on DemoQA)
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", button);
	    }

	    // Validations
	    public boolean isOutputDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(outputSection))
	                .isDisplayed();
	    }

	    public boolean isEmailFieldInvalid() {
	        WebElement emailField = driver.findElement(email);
	        // Returns true if the field is invalid
	        return !(Boolean) ((JavascriptExecutor) driver)
	                .executeScript("return arguments[0].validity.valid;", emailField);
	    }
	    
	    //Remove Ads
	    public void closeDemoQAAds() {
	        try {
	            // Wait a short moment for iframe ads to appear
	            Thread.sleep(1000); // small wait for ad iframe to load
	            // Find all iframes
	            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	            for (WebElement frame : iframes) {
	                // Remove the iframe from DOM
	                ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", frame);
	            }
	            System.out.println("All iframes (ads) removed ✅");
	        } catch (Exception e) {
	            System.out.println("No iframes detected");
	        }
	    }

	    //Side Bar
	    public void clickSidebarMenuItem(By menuItem) {
	        // Wait until menu item is clickable
	        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(menuItem));

	        // Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

	        // Slight delay to let animations finish
	        wait.until(ExpectedConditions.elementToBeClickable(item));

	        // Click using JS
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	    }

}
