package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;
public class WidgetsMenu extends BaseSetup{
    public void openMenuPage() {
        startBrowser();
        NavigateWidgets();
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement menu=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Menu']")));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", menu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Main Item 2']")));
    }

    public void hoverMainItem2(){
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        WebElement item2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Main Item 2']")));
        new Actions(getDriver()).moveToElement(item2).perform();
    }

    public boolean isSubMenuDisplayed(){
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='SUB SUB LIST »']"))).isDisplayed();
    }

    public void openSubSubMenu(){
        WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        Actions actions=new Actions(getDriver());
        WebElement item2=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[text()='Main Item 2']"))));
        actions.moveToElement(item2).perform();
        WebElement subSub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='SUB SUB LIST »']")));
        actions.moveToElement(subSub).perform();
    }

    public boolean isSubSubItem1Displayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sub Sub Item 1']"))).isDisplayed();
    }
}

