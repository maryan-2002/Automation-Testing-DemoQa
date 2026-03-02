package tests;
 
 
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.HomePage;
import pages.SortablePage;
 
 
public class SortableTest extends BaseTest {
 
    @Test
    public void testSortable() throws InterruptedException {
 
        HomePage home = new HomePage(getDriver());
        home.clickCard("Interactions");
 
        SortablePage sortable = new SortablePage(getDriver());
        sortable.openMenu();
        Thread.sleep(5000);
        sortable.reverseList();
        Thread.sleep(2000);
        getDriver().close();
    }

}
