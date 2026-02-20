package QABootcamo_Maven.AxsosAcademy;
import org.testng.annotations.*;
public class WidgetsAccordianTest extends WidgetsAccordian{
    @BeforeMethod
    public void setup(){
    	openAccordian();
 	   }
    @Test
    public void TC_WDG_001_Verify_accordion_section_expands_when_clicked(){
    	clickSecondAccordion();

    }
    @Test
    public void TC_WDG_002_Verify_accordion_section_collapses_when_clicked_again(){
    	clickSecondAccordion();
    	clickSecondAccordion();
    }
    @AfterMethod
    public void quitDemoQA(){
        driver.quit();
    }



}
