package tests;
 
 
import java.time.Duration;
 
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.BrowserWindowsPage;
import pages.HomePage;
 
public class BrowserWindowsTest extends BaseTest {
 
    @Test

    public void testBrowserWindows() throws InterruptedException {
 
        HomePage home = new HomePage(getDriver());
        

        // click on the category 

        home.clickCard("Alerts, Frame & Windows");

        BrowserWindowsPage page = new BrowserWindowsPage(getDriver());

        Thread.sleep(5000);

        page.openMenu();

        Thread.sleep(5000);

        String parent = getDriver().getWindowHandle();
 
        // new tab

        page.clickNewTab();

        Thread.sleep(5000);

        page.switchToNewWindow();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("sample"));

        new WebDriverWait(getDriver(), Duration.ofSeconds(10));
 
        getDriver().close();

        getDriver().switchTo().window(parent);
 
        // new window

        page.clickNewWindow();

        Thread.sleep(5000);

        page.switchToNewWindow();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("sample"));

        new WebDriverWait(getDriver(), Duration.ofSeconds(10));
 
        getDriver().close();

        getDriver().switchTo().window(parent);

        //new window msg

        page.clickMessageWindow();

        Thread.sleep(5000);

        page.switchToNewWindow();

        getDriver().close();

        getDriver().switchTo().window(parent);

        new WebDriverWait(getDriver(), Duration.ofSeconds(10));
 
        getDriver().close();

    }

}


 
