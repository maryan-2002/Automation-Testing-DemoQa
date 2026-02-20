package QABootcamo_Maven.AxsosAcademy;
 
 
import org.testng.annotations.Test;
 
import base.BaseTest;
 
 
public class SortableTest extends BaseTest {
 
    @Test
    public void testSortable() throws InterruptedException {
 
        HomePage home = new HomePage(driver);
        home.clickCard("Interactions");
 
        SortablePage sortable = new SortablePage(driver);
        sortable.openMenu();
        Thread.sleep(5000);
        sortable.reverseList();
        Thread.sleep(2000);
        driver.close();
    }
}