package tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
public class WidgetsProgressBarTest extends WidgetsProgressBar{
    @BeforeMethod
    public void setup() {
        openProgressBarPage();
    }
    @Test
    public void TC_WDG_019_Verify_progress_bar_starts_when_clicking_Start_button() throws InterruptedException {
        String before=getProgressValue();
        clickStartStopButton();         
        Thread.sleep(2000);
        String after=getProgressValue();
        Assert.assertNotEquals(after,before);
    }

    @Test
    public void TC_WDG_020_Verify_progress_bar_stops_when_clicking_Stop_button()   {
        clickStartStopButton();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        String startedValue=getProgressValue();
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath("//div[@role='progressbar']"),"aria-valuenow",startedValue)));
        clickStartStopButton();
        wait.until(ExpectedConditions.textToBe(By.id("startStopButton"),"Start"));
        String valueAfterStop=getProgressValue();
        String valueAfterWait=getProgressValue();
        Assert.assertEquals(valueAfterStop,valueAfterWait);
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }
}

