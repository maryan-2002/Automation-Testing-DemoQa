package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WidgetsToolTip extends BaseSetup {
    public void openToolTipPage() {
        startBrowser();
        NavigateWidgets();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement ToolTips=driver.findElement(By.xpath("//span[text()='Tool Tips']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",ToolTips);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Tool Tips']")));
    }

    public void hoverOverButton() {
        WebElement button=driver.findElement(By.id("toolTipButton"));
        Actions actions=new Actions(driver);
        actions.moveToElement(button).perform();
    }

    public void hoverOverTextField(){
        WebElement textField=driver.findElement(By.id("toolTipTextField"));
        Actions actions=new Actions(driver);
        actions.moveToElement(textField).perform();
    }

    public boolean isToolTipDisplayed(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner"))).isDisplayed();
    }

    public boolean isToolTipHidden() {
        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("tooltip-inner")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void moveMouseAway(){
        Actions actions=new Actions(driver);
        actions.moveByOffset(200,0).perform();
    }
}

