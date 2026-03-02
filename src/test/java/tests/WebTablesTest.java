package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WebTablesPage;


public class WebTablesTest extends BaseTest {
	 WebTablesPage webTable;


	    //Add Record
	@Test
	 public void verifyAddingNewRecord() {

	     webTable = new WebTablesPage(getDriver());

	     webTable.navigateToWebTables();
	     webTable.clickAdd();
	     webTable.fillForm("John", "Doe", "john@test.com");
	     webTable.submitAndWaitForRecord("john@test.com");

	     webTable.searchAndWait("john@test.com", "john@test.com");
	     Assert.assertTrue(webTable.isEmailDisplayed("john@test.com"),"Record was NOT found after adding!");
	     }

	    //Edit Record
	    @Test
	    public void verifyEditingRecord() {

	        webTable = new WebTablesPage(getDriver());

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

	    //Delete Record
	    @Test
	    public void verifyDeletingRecord() {

	        webTable = new WebTablesPage(getDriver());
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
