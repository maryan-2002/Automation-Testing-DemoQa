package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ButtonsPage {

	 WebDriver driver;
	    WebDriverWait wait;
	    Actions actions;

	    public ButtonsPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        actions = new Actions(driver);
	    }

	    // Locators
	    By elementsCard = By.xpath("//h5[text()='Elements']");
	    By buttonsMenu = By.xpath("//span[text()='Buttons']");

	    By doubleClickBtn = By.id("doubleClickBtn");
	    By rightClickBtn = By.id("rightClickBtn");
	    By dynamicClickBtn = By.xpath("//button[text()='Click Me']"); // unique dynamic button

	    By doubleClickMessage = By.id("doubleClickMessage");
	    By rightClickMessage = By.id("rightClickMessage");
	    By dynamicClickMessage = By.id("dynamicClickMessage");

	    // --------------------------
	    // Navigation
	    // --------------------------
	    public void navigateToButtons() {
	        // 1. Click Elements card
	        WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(elementsCard));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elements);

	        // 2. Click Buttons menu
	        WebElement menuItem = wait.until(ExpectedConditions.elementToBeClickable(buttonsMenu));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuItem);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuItem);
	        closeDemoQAAds();
	        // Wait for page loaded
	        wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickBtn));
	        System.out.println("Navigated to Buttons page ✅ Current URL: " + driver.getCurrentUrl());
	    }

	    // --------------------------
	    // Actions
	    // --------------------------
	    public void doubleClickButton() {
	        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);

	        Actions actions = new Actions(driver);
	        actions.moveToElement(btn).doubleClick().perform();
	    }

	    public void rightClickButton() {
	        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickBtn));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
	        wait.until(ExpectedConditions.elementToBeClickable(btn));
	        actions.moveToElement(btn).contextClick().perform(); 
	    }
	    
	    public void dynamicClickButton() {
	        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicClickBtn));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
	        wait.until(ExpectedConditions.elementToBeClickable(btn));
	        btn.click();
	    }

	    // --------------------------
	    // Validations
	    // --------------------------
	    public boolean isDoubleClickMessageDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickMessage))
	                .isDisplayed();
	    }

	    public boolean isRightClickMessageDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickMessage))
	                .isDisplayed();
	    }

	    public boolean isDynamicClickMessageDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicClickMessage))
	                .isDisplayed();
	    }
	    
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
}
