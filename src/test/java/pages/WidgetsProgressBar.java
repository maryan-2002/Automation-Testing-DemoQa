package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;
public class WidgetsProgressBar extends BaseSetup {
    public void openProgressBarPage(){
        startBrowser();
        NavigateWidgets();
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        WebElement progressBarMenu=getDriver().findElement(By.xpath("//span[text()='Progress Bar']"));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", progressBarMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startStopButton")));
    }
    public void clickStartStopButton() {
    	getDriver().findElement(By.id("startStopButton")).click();
    }

    public String getProgressValue() {
        return getDriver().findElement(By.xpath("//div[@role='progressbar']")).getAttribute("aria-valuenow");
    }

}

