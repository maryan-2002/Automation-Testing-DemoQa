package QABootcamo_Maven.AxsosAcademy;
import org.testng.annotations.*;
public class WidgetsDatePickerTest extends WidgetsDatePicker{
    @BeforeMethod
    public void setup(){
    	openDatePicker();
 	   }
    @Test
    public void TC_WDG_011_Verify_user_can_type_date_manually(){
        typeSelectDate("02/18/2026");
    }

    @Test
    public void TC_WDG_012_Verify_invalid_date_is_not_accepted(){
        typeSelectDate("02/40/2026");
    }

    @Test
    public void TC_WDG_013_Verify_user_can_select_date_and_time(){
        typeDateAndTime("February 18, 2026 3:47 PM");
    }

    @Test
    public void TC_WDG_014_Verify_invalid_manual_input_not_accepted_Date_And_Time(){
        typeDateAndTime("Ghada");
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }

}
