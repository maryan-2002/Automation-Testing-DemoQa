package tests;
 
 
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.HomePage;
import pages.NestedFramesPage;
 
public class NestedFramesTest extends BaseTest {
 
    @Test
    public void testNestedFrames() throws InterruptedException {
 
        HomePage home = new HomePage(getDriver());
        home.clickCard("Alerts, Frame & Windows");
 
        NestedFramesPage page = new NestedFramesPage(getDriver());
        page.openMenu();
        Thread.sleep(5000);
        page.switchToParentFrame();
        System.out.println("Parent Text: " + page.getBodyText());
 
        page.switchToChildFrame();
        System.out.println("Child Text: " + page.getBodyText());
 
        getDriver().switchTo().defaultContent();
        getDriver().close();
    }

}
