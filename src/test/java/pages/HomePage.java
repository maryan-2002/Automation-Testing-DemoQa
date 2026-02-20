package QABootcamo_Maven.AxsosAcademy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
//To click on a category card on the home page we need like Interactions and Alerts, Frame & Windows
    public void clickCard(String cardName) {
        WebElement card = driver.findElement(
                By.xpath("//div[@class='card-body']/h5[text()='" + cardName + "']")
        );
        jsClick(card);
    }
}

