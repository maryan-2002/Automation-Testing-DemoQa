package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CheckBoxPage {
	WebDriver driver;
    WebDriverWait wait;
 
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
 
    // Locators
    By elementsCard = By.xpath("//h5[text()='Elements']");
    By checkBoxMenu = By.xpath("//span[text()='Check Box']");
    By expandAllBtn = By.className("rc-tree-checkbox");
    By checkboxList = By.cssSelector("span.rct-title");
    By resultText = By.id("result");
 
    
    public void navigateToCheckbox() {
 
        WebElement elements = wait.until(
                ExpectedConditions.elementToBeClickable(elementsCard));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", elements);
 
        WebElement menuItem = wait.until(
                ExpectedConditions.elementToBeClickable(checkBoxMenu));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", menuItem);
    }
 
 
    public void clickExpandAll() {
    	driver.findElement(expandAllBtn).click();
    }
 
 
}