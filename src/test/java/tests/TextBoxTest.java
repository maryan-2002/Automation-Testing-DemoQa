package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TextBoxPage;
public class TextBoxTest extends BaseTest{
	
	TextBoxPage textBox;

    // ============================
    // TC_EL_001 - Positive Test
    // ============================

    @Test
    public void verifySubmitTextBoxWithValidData() throws InterruptedException {
    	System.out.println("I AM INSIDE TEST");
        
        textBox = new TextBoxPage(driver);

        textBox.navigateToTextBox();
       // driver.findElement(By.id("item-0")).click();
       // System.out.println(driver.getCurrentUrl());
        
        textBox.fillForm(
                "Maryan",
                "maryan@test.com",
                "Ramallah",
                "Palestine");

        //Thread.sleep(1000);
        textBox.clickSubmit();
        //System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(textBox.isOutputDisplayed(),
                "Output section is NOT displayed!");
    }

    // ============================
    // TC_EL_002 - Negative Test
    // ============================

    @Test
    public void verifyInvalidEmailValidation() {
        textBox = new TextBoxPage(driver);

        // Navigate to Text Box page
        textBox.navigateToTextBox();

        // Enter invalid email only
        textBox.enterEmailOnly("invalidEmail"); // missing '@'

        // Click submit
        textBox.clickSubmit();

        // Assert that HTML5 validation triggered
        Assert.assertTrue(textBox.isEmailFieldInvalid(),
                "Email validation did NOT trigger!");
    }
}
