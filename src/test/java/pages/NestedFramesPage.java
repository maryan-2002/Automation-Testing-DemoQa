package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    By nestedFramesMenu = By.xpath("//span[text()='Nested Frames']");
    By parentFrame = By.id("frame1");
    By childFrame = By.tagName("iframe");

    public void openMenu() {
        jsClick(getDriver().findElement(nestedFramesMenu));
    }

    public void switchToParentFrame() {
    	getDriver().switchTo().frame(getDriver().findElement(parentFrame));
    }

    public void switchToChildFrame() {
    	getDriver().switchTo().frame(getDriver().findElement(childFrame));
    }

    public String getBodyText() {
        return getDriver().findElement(By.tagName("body")).getText();
    }
}

