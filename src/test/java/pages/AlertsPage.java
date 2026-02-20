package pages;
 
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class AlertsPage extends BasePage {
 
    public AlertsPage(WebDriver driver) {

        super(driver);

    }
 
    By alertsMenu = By.xpath("//span[text()='Alerts']");

    By simpleAlert = By.id("alertButton");

    By confirmButton = By.id("confirmButton");

    By promptButton = By.id("promtButton");

    By confirmResult = By.id("confirmResult");

    By promptResult = By.id("promptResult");

// to click on alart button

    public void openMenu() {

        jsClick(driver.findElement(alertsMenu));

    }

//simple alart button

    public void clickSimpleAlert() {

        driver.findElement(simpleAlert).click();

    }

// confirm alart button

    public void clickConfirmAlert() {

        WebElement element =

                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
 
        jsClick(element);

    }
 
 
    

    public String getConfirmResult() {

        return driver.findElement(confirmResult).getText();

    }

//prompt alart button

    public void clickPromptAlert() {

        WebElement element =

                wait.until(ExpectedConditions.visibilityOfElementLocated(promptButton));
 
        jsClick(element);

    }
 
    public String getPromptResult() {

        return driver.findElement(promptResult).getText();

    }

}


 
