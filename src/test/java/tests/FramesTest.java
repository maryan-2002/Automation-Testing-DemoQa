package tests;
 
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.FramesPage;
import pages.HomePage;
 
public class FramesTest extends BaseTest {
 
    @Test
    public void testFrames() throws InterruptedException {
 
        HomePage home = new HomePage(getDriver());
        home.clickCard("Alerts, Frame & Windows");
 
        FramesPage frames = new FramesPage(getDriver());
        frames.openMenu();
        Thread.sleep(5000);
 
        frames.switchToFrame1();
        String text1 = getDriver().findElement(org.openqa.selenium.By.id("sampleHeading")).getText();
        Assert.assertEquals(text1, "This is a sample page");
        frames.switchToDefault();
 
        frames.switchToFrame2();
        String text2 = getDriver().findElement(org.openqa.selenium.By.id("sampleHeading")).getText();
        Assert.assertEquals(text2, "This is a sample page");
        frames.switchToDefault();
        getDriver().close();
    }

}
