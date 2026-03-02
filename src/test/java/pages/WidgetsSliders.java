package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;

public class WidgetsSliders extends BaseSetup {
	public void openSliders() {
        startBrowser();
        NavigateWidgets();
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        WebElement Sliders=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Slider']")));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", Sliders);
    }
	public void typeSliderValue(String value) {
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement sliderInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("sliderValue")));
        sliderInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        sliderInput.sendKeys(value);
        sliderInput.sendKeys(Keys.ENTER);
	}
	public String getSliderValue() {
        return getDriver().findElement(By.id("sliderValue")).getAttribute("value");
	}
	
	

}

