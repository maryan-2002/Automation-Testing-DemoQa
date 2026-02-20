package QABootcamo_Maven.AxsosAcademy;
 
 
import org.testng.annotations.Test;
 
import base.BaseTest;
 
public class ModalDialogsTest extends BaseTest {
 
    @Test

    public void testModalDialogs() throws InterruptedException {
 
        HomePage home = new HomePage(driver);

        home.clickCard("Alerts, Frame & Windows");
 
        ModalDialogsPage modal = new ModalDialogsPage(driver);

        modal.openMenu();

        Thread.sleep(5000);

        modal.openSmallModal();

        Thread.sleep(5000);

        modal.closeModal();
 
        modal.openLargeModal();

        Thread.sleep(5000);

        modal.closeModal();

        driver.close();

    }

}

 