package tests;
 
 
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import base.BaseTest;
 
public class AlertsTest extends BaseTest {
 
    @Test
    public void testAlerts() throws InterruptedException {
 
        HomePage home = new HomePage(driver);
        home.clickCard("Alerts, Frame & Windows");
 
        AlertsPage alerts = new AlertsPage(driver);
        alerts.openMenu();
        Thread.sleep(5000);
 
        // Simple Alert
        alerts.clickSimpleAlert();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button");
        alert.accept();
        Thread.sleep(5000);
 
        // Confirm Alert with ok
        alerts.clickConfirmAlert();
        Thread.sleep(5000);
        alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(alerts.getConfirmResult(), "You selected Ok");
        Thread.sleep(5000);
     // Confirm Alert with cancel
        alerts.clickConfirmAlert();
		Thread.sleep(5000);
		alert = driver.switchTo().alert();
		alert.dismiss();
		Thread.sleep(5000);
		Assert.assertEquals(alerts.getConfirmResult(), "You selected Cancel");

        // Prompt Alert
        alerts.clickPromptAlert();
        Thread.sleep(5000);
        alert = driver.switchTo().alert();
        alert.sendKeys("HII");
        alert.accept();
        Thread.sleep(5000);
        Assert.assertEquals(alerts.getPromptResult(), "You entered HII");
        driver.close();
    }

}
