package tests;
import org.testng.annotations.*;
public class WidgetsAutoCompleteTest extends WidgetsAutoComplete {
    @BeforeMethod
    public void setup(){
    	openAutoComplete();
 	   }
    @Test
    public void TC_WDG_003_Verify_suggestions_appear_in_multiple_color_field(){
        typeMultipleColor("re");
    }
    @Test
    public void TC_WDG_004_Verify_user_can_select_color_in_multiple_field(){
        typeMultipleColor("re");
        selectMultipleColor("Red");
    }
    @Test
    public void TC_WDG_005_Verify_user_can_select_multiple_colors() {
        typeMultipleColor("re");
        selectMultipleColor("Red");
        typeMultipleColor("bl");
        selectMultipleColor("Blue");
    }
    @Test
    public void TC_WDG_006_Verify_user_can_remove_selected_colors() {
        typeMultipleColor("re");
        selectMultipleColor("Red");
        removeMultipleColor("Red");
    }
    @Test
    public void TC_WDG_007_Verify_suggestions_appear_in_single_color_field() {
        typeSingleColor("re");
    }
    @Test
    public void TC_WDG_008_Verify_user_can_select_color_in_single_field(){
        typeSingleColor("re");
        selectSingleColor("Red");
    }

    @Test
    public void TC_WDG_009_Verify_no_suggestions_for_invalid_input_in_single_field(){
        typeSingleColor("jsam");
    }
    @Test
    public void TC_WDG_010_Verify_no_suggestions_for_invalid_input_in_multiple_field(){
        typeMultipleColor("jsam");
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }

}

