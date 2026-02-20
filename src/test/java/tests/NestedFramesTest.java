package tests;
 
 
import org.testng.annotations.Test;
 
import base.BaseTest;
 
public class NestedFramesTest extends BaseTest {
 
    @Test
    public void testNestedFrames() throws InterruptedException {
 
        HomePage home = new HomePage(driver);
        home.clickCard("Alerts, Frame & Windows");
 
        NestedFramesPage page = new NestedFramesPage(driver);
        page.openMenu();
        Thread.sleep(5000);
        page.switchToParentFrame();
        System.out.println("Parent Text: " + page.getBodyText());
 
        page.switchToChildFrame();
        System.out.println("Child Text: " + page.getBodyText());
 
        driver.switchTo().defaultContent();
        driver.close();
    }

}
