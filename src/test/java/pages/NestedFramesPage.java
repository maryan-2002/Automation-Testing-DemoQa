package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    By nestedFramesMenu = By.xpath("//span[text()='Nested Frames']");
    By parentFrame = By.id("frame1");
    By childFrame = By.tagName("iframe");

    public void openMenu() {
        jsClick(driver.findElement(nestedFramesMenu));
    }

    public void switchToParentFrame() {
        driver.switchTo().frame(driver.findElement(parentFrame));
    }

    public void switchToChildFrame() {
        driver.switchTo().frame(driver.findElement(childFrame));
    }

    public String getBodyText() {
        return driver.findElement(By.tagName("body")).getText();
    }
}

