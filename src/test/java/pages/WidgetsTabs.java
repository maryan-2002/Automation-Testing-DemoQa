package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;
public class WidgetsTabs extends BaseSetup {
    public void openTabsPage(){
        startBrowser();
        NavigateWidgets();
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        WebElement Tabs=getDriver().findElement(By.xpath("//span[text()='Tabs']"));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",Tabs);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Tabs']")));
        }

    public void clickWhatTab(){
    	WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("demo-tab-what"))).click();

    }

    public void clickOriginTab() {
    	WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("demo-tab-origin"))).click();
        
    }

    public void clickUseTab() {
    	WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("demo-tab-use"))).click();
    }

    public boolean isWhatContentDisplayed() {
        return getDriver().findElement(By.id("demo-tab-what")).isDisplayed();
    }

    public boolean isOriginContentDisplayed() {
        return getDriver().findElement(By.id("demo-tab-origin")).isDisplayed();
    }

    public boolean isUseContentDisplayed() {
        return getDriver().findElement(By.id("demo-tab-use")).isDisplayed();
    }
}

