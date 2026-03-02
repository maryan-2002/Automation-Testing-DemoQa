package tests;
 
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.HomePage;
import pages.SelectablePage;
 
public class SelectableTest extends BaseTest {
 
    @Test
    public void testSelectable() throws InterruptedException {
 
        HomePage home = new HomePage(getDriver());
        home.clickCard("Interactions");
 
        SelectablePage selectable = new SelectablePage(getDriver());
        selectable.openMenu();
        Thread.sleep(5000);
 
        selectable.selectListItem(2);
//        Thread.sleep(5000);
        Assert.assertTrue(selectable.isSelected(2));
        Thread.sleep(5000);
        selectable.clickGridTab();
        selectable.clickGridItemThree();
        Thread.sleep(5000);
        Assert.assertTrue(selectable.isGridItemActive(),
                "Grid item is not active");
        System.out.println("Grid item selected successfully");
        getDriver().close();
    }

}
