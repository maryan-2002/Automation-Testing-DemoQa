package QABootcamo_Maven.AxsosAcademy;
 
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
import java.util.Set;
 
public class BrowserWindowsPage extends BasePage {
 
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
 
    By browserWindowsMenu = By.xpath("//span[text()='Browser Windows']");
    By newTabBtn = By.id("tabButton");
    By newWindowBtn = By.id("windowButton");
    By messageWindowBtn = By.id("messageWindowButton");
// to click on the browser window button
    public void openMenu() {
        jsClick(driver.findElement(browserWindowsMenu));
    }
 
    public void clickNewTab() {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(newTabBtn));
 
        jsClick(element);
    }
 
    public void clickNewWindow() {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(newWindowBtn));
 
        jsClick(element);
    }
 
    public void clickMessageWindow() {
        driver.findElement(messageWindowBtn).click();
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(messageWindowBtn));
 
        jsClick(element);
    }
 
    public void switchToNewWindow() {
        String parent = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
 
        for (String h : handles) {
            if (!h.equals(parent)) {
                driver.switchTo().window(h);
                break;
            }
        }
    }
}