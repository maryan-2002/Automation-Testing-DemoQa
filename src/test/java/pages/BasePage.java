package pages;
 
 
import java.time.Duration;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BasePage {
 
    protected WebDriver driver;
    protected WebDriverWait wait;
 
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", element);
    }
 
}
