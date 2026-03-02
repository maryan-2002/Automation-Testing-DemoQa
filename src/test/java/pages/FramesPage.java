package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    By framesMenu = By.xpath("//span[text()='Frames']");
    By frame1 = By.id("frame1");
    By frame2 = By.id("frame2");

    public void openMenu() {
        jsClick(getDriver().findElement(framesMenu));
    }

    public void switchToFrame1() {
    	getDriver().switchTo().frame(getDriver().findElement(frame1));
    }

    public void switchToFrame2() {
    	getDriver().switchTo().frame(getDriver().findElement(frame2));
    }

    public void switchToDefault() {
    	getDriver().switchTo().defaultContent();
    }
}
