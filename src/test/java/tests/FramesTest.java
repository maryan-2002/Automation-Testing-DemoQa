package QABootcamo_Maven.AxsosAcademy;
 
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import base.BaseTest;
 
public class FramesTest extends BaseTest {
 
    @Test
    public void testFrames() throws InterruptedException {
 
        HomePage home = new HomePage(driver);
        home.clickCard("Alerts, Frame & Windows");
 
        FramesPage frames = new FramesPage(driver);
        frames.openMenu();
        Thread.sleep(5000);
 
        frames.switchToFrame1();
        String text1 = driver.findElement(org.openqa.selenium.By.id("sampleHeading")).getText();
        Assert.assertEquals(text1, "This is a sample page");
        frames.switchToDefault();
 
        frames.switchToFrame2();
        String text2 = driver.findElement(org.openqa.selenium.By.id("sampleHeading")).getText();
        Assert.assertEquals(text2, "This is a sample page");
        frames.switchToDefault();
        driver.close();
    }
}