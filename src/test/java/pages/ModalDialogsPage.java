package QABootcamo_Maven.AxsosAcademy;
 
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class ModalDialogsPage extends BasePage {
 
    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }
 
    By modalMenu = By.xpath("//span[text()='Modal Dialogs']");
    By smallModalBtn = By.id("showSmallModal");
    By largeModalBtn = By.id("showLargeModal");
    By modalBody = By.cssSelector(".modal-content .modal-body");
    By closeBtn = By.cssSelector(".modal-content .btn-close");
 
    public void openMenu() {
        jsClick(driver.findElement(modalMenu));
    }
 
    public void openSmallModal() {
//        driver.findElement(smallModalBtn).click();
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(smallModalBtn));
 
        jsClick(element);
    }
 
    public void openLargeModal() {
//        driver.findElement(largeModalBtn).click();
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(largeModalBtn));
 
        jsClick(element);
    }
 
 
    public void closeModal() {
//        driver.findElement(closeBtn).click();
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtn));
 
        jsClick(element);
    }
}