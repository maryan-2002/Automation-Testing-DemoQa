package tests;

import base.BaseTest;
import pages.CheckBoxPage;

import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
 
	CheckBoxPage checkBox;
 
    @Test

    public void verifySelectHomeCheckbox() throws InterruptedException {

        checkBox = new CheckBoxPage(driver);
        checkBox.navigateToCheckbox();
        Thread.sleep(5000);
        checkBox.clickExpandAll();
        Thread.sleep(5000);
        driver.close();
 
     

    }
 
   

}

 /*

    // ============================
    // TC_EL_004 - Select multiple checkboxes
    // ============================
    @Test
    public void verifyMultipleCheckboxSelection() {
        checkBox = new CheckBoxPage(driver);

        checkBox.navigateToCheckbox();
        checkBox.expandAllTree();
        checkBox.selectMultipleCheckboxes();

        Assert.assertTrue(checkBox.areDesktopAndDocumentsSelected(),
                "Desktop and Documents checkboxes are NOT both selected!");
    }
}
*/