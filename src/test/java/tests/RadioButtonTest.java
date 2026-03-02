package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RadioButtonPage;

public class RadioButtonTest extends BaseTest{
	RadioButtonPage radioPage;


    @Test
    public void verifySelectingYesRadioButton() {

        radioPage = new RadioButtonPage(getDriver());

        radioPage.navigateToRadioButton();

        radioPage.clickYesRadio();

        String message = radioPage.getSelectedMessage();

        Assert.assertEquals(message, "Yes",
                "Message is NOT displaying 'Yes'");
    }

    @Test
    public void verifyNoRadioButtonIsDisabled() {

        radioPage = new RadioButtonPage(getDriver());

        radioPage.navigateToRadioButton();

        Assert.assertTrue(radioPage.isNoRadioDisabled(),
                "No radio button is NOT disabled!");
    }
}
