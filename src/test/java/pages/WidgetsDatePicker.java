package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class WidgetsDatePicker extends BaseSetup {
    public void openDatePicker() {
        startBrowser();
        NavigateWidgets();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement datePicker=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Date Picker']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", datePicker);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datePickerMonthYearInput")));
    }
    public void typeSelectDate(String date){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dataInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("datePickerMonthYearInput")));
        dataInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dataInput.sendKeys(date);
        dataInput.sendKeys(Keys.ENTER);
    }
    public void typeDateAndTime(String value) {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dataInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("dateAndTimePickerInput")));
        dataInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dataInput.sendKeys(value);
        dataInput.sendKeys(Keys.ENTER);
    }
    public String getDateValue() {
        return driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
    }

    public String getDateTimeValue() {
        return driver.findElement(By.id("dateAndTimePickerInput")).getAttribute("value");
    }

}

