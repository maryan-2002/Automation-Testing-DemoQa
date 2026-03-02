package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;


public class ButtonsTest  extends BaseTest {

	  ButtonsPage buttons;
	    @Test
	    public void verifyDoubleClickButton() {
	        buttons = new ButtonsPage(getDriver());
	        buttons.navigateToButtons();
	        buttons.doubleClickButton();
	        Assert.assertTrue(buttons.isDoubleClickMessageDisplayed(),
	                "Double click message NOT displayed!");
	    }

	    @Test
	    public void verifyRightClickButton() {
	        buttons = new ButtonsPage(getDriver());
	        buttons.navigateToButtons();
	        buttons.rightClickButton();
	        Assert.assertTrue(buttons.isRightClickMessageDisplayed(),
	                "Right click message NOT displayed!");
	    }

	    @Test
	    public void verifyDynamicClickButton() {
	        buttons = new ButtonsPage(getDriver());
	        buttons.navigateToButtons();
	        buttons.dynamicClickButton();
	        Assert.assertTrue(buttons.isDynamicClickMessageDisplayed(),
	                "Dynamic click message NOT displayed!");
	    }
	    
}
