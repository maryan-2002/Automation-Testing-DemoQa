package tests;
 
 
import java.time.Duration;
 
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.Test;
 
import base.BaseTest;
 
public class BrowserWindowsTest extends BaseTest {
 
    @Test

    public void testBrowserWindows() throws InterruptedException {
 
        HomePage home = new HomePage(driver);

        // click on the category 

        home.clickCard("Alerts, Frame & Windows");

        BrowserWindowsPage page = new BrowserWindowsPage(driver);

        Thread.sleep(5000);

        page.openMenu();

        Thread.sleep(5000);

        String parent = driver.getWindowHandle();
 
        // new tab

        page.clickNewTab();

        Thread.sleep(5000);

        page.switchToNewWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("sample"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        driver.close();

        driver.switchTo().window(parent);
 
        // new window

        page.clickNewWindow();

        Thread.sleep(5000);

        page.switchToNewWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("sample"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        driver.close();

        driver.switchTo().window(parent);

        //new window msg

        page.clickMessageWindow();

        Thread.sleep(5000);

        page.switchToNewWindow();

        driver.close();

        driver.switchTo().window(parent);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        driver.close();

    }

}


 
