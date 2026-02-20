package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class WidgetsMenuTest extends WidgetsMenu {

    @BeforeMethod
    public void setup() {
        openMenuPage();
    }


    @Test
    public void TC_WDG_026_Verify_submenu_appears_when_hovering_over_main_menu_item_2() {
        hoverMainItem2();
        Assert.assertTrue(isSubMenuDisplayed());
    }

    @Test
    public void TC_WDG_027_Verify_user_can_open_sub_submenu() {
        openSubSubMenu();
        Assert.assertTrue(isSubSubItem1Displayed());
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }
}

