package tests;
import org.testng.Assert;
import org.testng.annotations.*;
public class WidgetsTabsTest extends WidgetsTabs {
    @BeforeMethod
    public void setup() {
        openTabsPage();
    }
    @Test
    public void TC_WDG_021_Verify_user_can_switch_between_tabs() {
        clickOriginTab();
        Assert.assertTrue(isOriginContentDisplayed());
        clickUseTab();
        Assert.assertTrue(isUseContentDisplayed());
        clickWhatTab();
        Assert.assertTrue(isWhatContentDisplayed());
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }
}

