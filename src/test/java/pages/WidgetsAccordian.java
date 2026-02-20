package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WidgetsAccordian extends BaseSetup {
    public void openAccordian(){
   	 startBrowser();
   	 NavigateWidgets();
   	 WebElement Accordian=driver.findElement(By.xpath("//span[text()='Accordian']"));
   	 Accordian.click();
   }
    public void clickSecondAccordion() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement secondAccordion=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Where does it come from?']")));
        secondAccordion.click();    
        }
}

