package QABootcamo_Maven.AxsosAcademy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
	public class PracticeFormTest extends PracticeForm{
	    @BeforeMethod
	    public void setup(){
	 	    openPracticeForm();
	 	   }
	    @Test
	    public void TC_PF_001_Verify_user_can_submit_form_by_filling_all_fields(){
	        fillAllFields();
	        submitForm();
	    }
	    @Test
	    public void TC_PF_002_Verify_that_user_can_submit_form_by_filling_Mandatory_fileds_only(){
	    	fillMandatory("Ghada","Sawallha","Female","0598473621");
	    	submitForm();
	    	}
	    @Test
	    public void TC_PF_003_Verify_that_user_can_not_submit_form_when_keeping_all_fields_empty(){
	    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	    	submitForm();
	    }
	    @Test
	    public void TC_PF_004_Verify_that_user_Can_not_submit_form_if_user_keep_First_Name_empty_but_fiiling_other_mandatory_fields(){
	    	fillMandatory("","Sawallha","Female","0598473621");
	    	submitForm();
	    }
	    @Test
	    public void TC_PF_005_Verify_that_user_Can_not_submit_form_if_user_keep_Last_Name_empty_but_fiiling_other_mandatory_fields(){
	        fillMandatory("Ghada","","Female","0598473621");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_006_Verify_that_user_Can_not_submit_form_if_user_keep_Mobile_empty_but_fiiling_other_mandatory_fields(){
	        fillMandatory("Ghada","Sawallha","Female","");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_007_Verify_that_user_Can_not_submit_form_if_user_keep_Gender_empty_but_fiiling_other_mandatory_fields(){
	    	fillMandatory("Ghada","Sawallha","","0598473621");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_008_Verify_that_user_can_use_Letters_symbols_and_numbers_in_the_First_Name_field(){
	        fillMandatory("Gha@1","Sawallha","Female","0598473621");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_009_Verify_that_user_can_use_Letters_symbols_and_numbers_in_the_Last_Name_field(){
	        fillMandatory("Ghada","Saw58@","Female","0598473621");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_010_Verify_that_user_can_not_submit_form_using_invalid_email_format_in_Email_Field(){
	        fillMandatory("Ghada","Sawallha","Female","0598473621");
	        fillEmail("ghada.sawallha");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_011_Verify_that_user_can_only_choose_one_gender(){
	        fillMandatory("Ghada","Sawallha","Female","0598473621");
	        selectGender("Male");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_012_Verify_that_user_cannot_use_letters_or_special_characters_in_Mobile_field(){
	        fillMandatory("Ghada","Sawallha","Female","05984Gha@#");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_013_Verify_that_user_can_not_use_less_than_10_Digits_in_Mobile_Field(){
	        fillMandatory("Ghada","Sawallha","Female","05984");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_014_Verify_that_user_can_not_use_more_than_10_Digits_in_Mobile_Field(){
	        fillMandatory("Ghada","Sawallha","Female","05984736210");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_015_Verify_that_user_can_not_use_future_date_in_Date_of_Birth_Field(){
	        fillMandatory("Ghada","Sawallha","Female","0598473621");
	        setDateOfBirth("07 Oct 2050");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_016_Verify_that_user_can_choose_more_than_one_hobby(){
	        fillMandatory("Ghada","Sawallha","Female","0598473621");
	        selectHobby("Reading");
	        selectHobby("Music");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_017_Verify_that_user_can_choose_state_from_the_dropdown_list(){
	        fillMandatory("Ghada","Sawallha","Female","0598473621");
	        selectState("NCR");
	        submitForm();
	    }
	    @Test
	    public void TC_PF_018_Verify_that_user_can_choose_city_from_the_dropdown_list(){
	        fillMandatory("Ghada","Sawallha","Female","0598473621");
	        selectState("NCR");
	        selectCity("Delhi");
	        submitForm();
	    }

	    @AfterMethod
	    public void quitDemoQA(){
	        driver.quit();
	    }
	}


