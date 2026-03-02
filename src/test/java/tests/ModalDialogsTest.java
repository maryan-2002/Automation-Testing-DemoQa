package tests;
 
 
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.HomePage;
import pages.ModalDialogsPage;
 
public class ModalDialogsTest extends BaseTest {
 
    @Test

    public void testModalDialogs() throws InterruptedException {
 
        HomePage home = new HomePage(getDriver());

        home.clickCard("Alerts, Frame & Windows");
 
        ModalDialogsPage modal = new ModalDialogsPage(getDriver());

        modal.openMenu();

        Thread.sleep(5000);

        modal.openSmallModal();

        Thread.sleep(5000);

        modal.closeModal();
 
        modal.openLargeModal();

        Thread.sleep(5000);

        modal.closeModal();

        getDriver().close();

    }

}


 
