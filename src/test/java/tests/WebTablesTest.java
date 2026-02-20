package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WebTablesPage;


public class WebTablesTest extends BaseTest {
	 WebTablesPage webTable;

	    // ============================
	    // TC_EL_007 - Add Record
	    // ============================

	@Test
	 public void verifyAddingNewRecord() {

	     webTable = new WebTablesPage(driver);

	     webTable.navigateToWebTables();
	     webTable.clickAdd();
	     webTable.fillForm("John", "Doe", "john@test.com");
	     webTable.submitAndWaitForRecord("john@test.com");

	     webTable.searchAndWait("john@test.com", "john@test.com");
	     Assert.assertTrue(webTable.isEmailDisplayed("john@test.com"),"Record was NOT found after adding!");
	     }

	    // ============================
	    // TC_EL_008 - Edit Record
	    // ============================

	    @Test
	    public void verifyEditingRecord() {

	        webTable = new WebTablesPage(driver);

	        webTable.navigateToWebTables();

	        // Add record first (precondition)
	        webTable.clickAdd();
	        webTable.fillForm("John", "Doe", "john@test.com");
	        webTable.submitAndWaitForRecord("john@test.com");


	        // Edit
	        webTable.clickEditByEmail("john@test.com");

	      webTable.fillForm("Johnny", "Doe", "john@test.com");
	       webTable.submitAndWaitForRecord("john@test.com");

	      Assert.assertTrue(webTable.isRecordPresent("Johnny"),
	                "Record was NOT updated successfully!");
	    }

	    // ============================
	    // TC_EL_009 - Delete Record
	    // ============================

	    @Test
	    public void verifyDeletingRecord() {

	        webTable = new WebTablesPage(driver);
	        webTable.navigateToWebTables();
	        // Add record first
	        webTable.clickAdd();
	        webTable.fillForm("John", "Doe", "john@test.com");
		     webTable.submitAndWaitForRecord("john@test.com");

	        // Delete
	        webTable.clickDeleteByEmail("john@test.com");

	       Assert.assertFalse(webTable.isRecordPresent("john@test.com"),
	                "Record was NOT deleted!");
	    }
}
