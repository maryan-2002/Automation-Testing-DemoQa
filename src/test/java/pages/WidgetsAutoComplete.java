package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;
public class WidgetsAutoComplete extends BaseSetup{
    public void openAutoComplete(){
      	 startBrowser();
      	 NavigateWidgets();
      	 WebElement AutoComplete=getDriver().findElement(By.xpath("//span[text()='Auto Complete']"));
      	 AutoComplete.click();
      }
    public void typeMultipleColor(String text) {
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        WebElement inputMultipleColor=wait.until(ExpectedConditions.elementToBeClickable(By.id("autoCompleteMultipleInput")));
        inputMultipleColor.sendKeys(text);
    }
    public void selectMultipleColor(String color){
    	WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        WebElement SelectMultiple=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + color + "']")));
        SelectMultiple.click();
    }
    public void removeMultipleColor(String color) {
    	getDriver().findElement(By.xpath("//div[contains(@class,'multi-value__remove')]")).click();
    }

    public void typeSingleColor(String text) {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement inputSingleColor=wait.until(ExpectedConditions.elementToBeClickable(By.id("autoCompleteSingleInput")));
        inputSingleColor.clear();
        inputSingleColor.sendKeys(text);
    }
    
    public void selectSingleColor(String color) {
    	WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement SelectSingle=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + color + "']")));
        SelectSingle.click();
    }
    
}

