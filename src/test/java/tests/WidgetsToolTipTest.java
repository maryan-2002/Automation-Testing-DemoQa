package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class WidgetsToolTipTest extends WidgetsToolTip {

    @BeforeMethod
    public void setup() {
        openToolTipPage();
    }

    @Test
    public void TC_WDG_022_Verify_tooltip_appears_when_hovering_over_button() {
        hoverOverButton();
        Assert.assertTrue(isToolTipDisplayed());
    }

    @Test
    public void TC_WDG_023_Verify_tooltip_disappears_when_mouse_removed() {
        hoverOverButton();
        moveMouseAway();
        Assert.assertTrue(isToolTipHidden());
    }

    @Test
    public void TC_WDG_024_Verify_tooltip_appears_when_hovering_over_text_field() {
        hoverOverTextField();
        Assert.assertTrue(isToolTipDisplayed());
    }

    @Test
    public void TC_WDG_025_Verify_tooltip_disappears_when_mouse_removed() {
        hoverOverTextField();
        moveMouseAway();
        Assert.assertTrue(isToolTipHidden());
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }
}

