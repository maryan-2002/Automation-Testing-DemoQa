package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RadioButtonPage {
	WebDriver driver;
    WebDriverWait wait;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= LOCATORS =================

    By elementsCard = By.xpath("//h5[text()='Elements']");
    By radioButtonMenu = By.xpath("//span[text()='Radio Button']");

    By yesRadioLabel = By.xpath("//label[@for='yesRadio']");
    By noRadioInput = By.id("noRadio");

    By resultMessage = By.className("text-success");

    // ================= NAVIGATION =================

    public void navigateToRadioButton() {

        closeDemoQAAds();

        // Click Elements card
        WebElement elements = wait.until(
                ExpectedConditions.elementToBeClickable(elementsCard));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", elements);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", elements);

        // Click Radio Button from sidebar (CLICK TEXT ONLY)
        clickSidebarMenuItem(radioButtonMenu);

        // Wait until page loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(yesRadioLabel));

        System.out.println("Navigated to Radio Button page ✅");
    }

    // ================= ACTIONS =================

    public void clickYesRadio() {
        WebElement yes = wait.until(
                ExpectedConditions.elementToBeClickable(yesRadioLabel));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", yes);
    }

    // ================= VALIDATIONS =================

    public String getSelectedMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(resultMessage))
                .getText();
    }

    public boolean isNoRadioDisabled() {
        WebElement noRadio = driver.findElement(noRadioInput);
        return !noRadio.isEnabled();
    }

    // ================= UTILITIES =================

    public void closeDemoQAAds() {
        try {
            Thread.sleep(1000);
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            for (WebElement frame : iframes) {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].remove();", frame);
            }
        } catch (Exception e) {
            System.out.println("No ads found");
        }
    }

    public void clickSidebarMenuItem(By menuItem) {
        WebElement item = wait.until(
                ExpectedConditions.elementToBeClickable(menuItem));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", item);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", item);
    }
}
