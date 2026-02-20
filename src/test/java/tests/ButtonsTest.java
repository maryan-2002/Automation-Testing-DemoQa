package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;


public class ButtonsTest  extends BaseTest {

	  ButtonsPage buttons;

	    // ============================
	    // TC_EL_010 - Double Click
	    // ============================
	    @Test
	    public void verifyDoubleClickButton() {
	        buttons = new ButtonsPage(driver);
	        buttons.navigateToButtons();
	        buttons.doubleClickButton();
	        Assert.assertTrue(buttons.isDoubleClickMessageDisplayed(),
	                "Double click message NOT displayed!");
	    }

	    // ============================
	    // TC_EL_011 - Right Click
	    // ============================
	    @Test
	    public void verifyRightClickButton() {
	        buttons = new ButtonsPage(driver);
	        buttons.navigateToButtons();
	        buttons.rightClickButton();
	        Assert.assertTrue(buttons.isRightClickMessageDisplayed(),
	                "Right click message NOT displayed!");
	    }

	    // ============================
	    // TC_EL_012 - Dynamic Click
	    // ============================
	    @Test
	    public void verifyDynamicClickButton() {
	        buttons = new ButtonsPage(driver);
	        buttons.navigateToButtons();
	        buttons.dynamicClickButton();
	        Assert.assertTrue(buttons.isDynamicClickMessageDisplayed(),
	                "Dynamic click message NOT displayed!");
	    }
	    
}
