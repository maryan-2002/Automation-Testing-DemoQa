package QABootcamo_Maven.AxsosAcademy;
import org.testng.Assert;
import org.testng.annotations.*;
public class WidgetsSlidersTest extends WidgetsSliders {
    @BeforeMethod
    public void setup(){
    	openSliders();
 	   }
    @Test
    public void TC_WDG_015_Verify_slider_moves_when_user_enters_valid_value() {
        typeSliderValue("50");
        Assert.assertEquals(getSliderValue(),"50");
    }

    @Test
    public void TC_WDG_016_Verify_slider_does_not_move_when_user_enters_invalid_value() {
        String before=getSliderValue();
        typeSliderValue("abc");
        String after=getSliderValue();
        Assert.assertEquals(after, before);
    }

    @Test
    public void TC_WDG_017_Verify_slider_does_not_move_when_user_enters_negative_number() {
        typeSliderValue("-10");
        String after=getSliderValue();
        Assert.assertNotEquals(after,"-10");
    }

    @Test
    public void TC_WDG_018_Verify_slider_does_not_move_when_user_enters_more_than_100() {
        typeSliderValue("150");
        String after=getSliderValue();
        Assert.assertNotEquals(after,"150");
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }

}
