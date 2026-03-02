package base;
 
 
import java.time.Duration;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BasePage {
 
    private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    protected WebDriverWait wait;
    protected WebDriver getDriver() {
        return driver.get();
    }
    public BasePage(WebDriver driver) {
    	BasePage.driver.set(driver);;
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }
    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) getDriver())
            .executeScript("arguments[0].click();", element);
    }
 
}
