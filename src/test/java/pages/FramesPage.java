package QABootcamo_Maven.AxsosAcademy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    By framesMenu = By.xpath("//span[text()='Frames']");
    By frame1 = By.id("frame1");
    By frame2 = By.id("frame2");

    public void openMenu() {
        jsClick(driver.findElement(framesMenu));
    }

    public void switchToFrame1() {
        driver.switchTo().frame(driver.findElement(frame1));
    }

    public void switchToFrame2() {
        driver.switchTo().frame(driver.findElement(frame2));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
