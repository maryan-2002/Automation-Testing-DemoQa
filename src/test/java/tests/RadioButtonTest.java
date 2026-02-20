package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RadioButtonPage;

public class RadioButtonTest extends BaseTest{
	RadioButtonPage radioPage;

    // ============================
    // TC_EL_005
    // ============================

    @Test
    public void verifySelectingYesRadioButton() {

        radioPage = new RadioButtonPage(driver);

        radioPage.navigateToRadioButton();

        radioPage.clickYesRadio();

        String message = radioPage.getSelectedMessage();

        Assert.assertEquals(message, "Yes",
                "Message is NOT displaying 'Yes'");
    }

    // ============================
    // TC_EL_006
    // ============================

    @Test
    public void verifyNoRadioButtonIsDisabled() {

        radioPage = new RadioButtonPage(driver);

        radioPage.navigateToRadioButton();

        Assert.assertTrue(radioPage.isNoRadioDisabled(),
                "No radio button is NOT disabled!");
    }
}
