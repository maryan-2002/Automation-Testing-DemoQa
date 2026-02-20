package pages;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PracticeForm extends BaseSetup{
    public void openPracticeForm() {
    	 startBrowser();
    	 NavigateForms();
    	 WebElement practiceForm=driver.findElement(By.xpath("//span[text()='Practice Form']"));
    	 practiceForm.click();
    }
    public void fillMandatory(String firstName,String lastName,String gender,String mobile){
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	WebElement firstNameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
    	firstNameField.sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        selectGender(gender);
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
    }
    public void selectGender(String gender){
        if(gender!=null&&!gender.isEmpty()){
            driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
        }
    }
    public void submitForm() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement submit=driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", submit);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        }
        catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",submit);
        }
    }

    public void fillAllFields(){
        fillMandatory("Ghada", "Sawallha", "Female", "0591234567");
        setDateOfBirth("18 Feb 2026");
        fillEmail("ghada@test.com");
        WebElement subjects=driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);
        selectHobby("Sports");
        selectHobby("Reading");
        driver.findElement(By.id("currentAddress")).sendKeys("Birzeit, Palestine");
        selectState("NCR");
        selectCity("Delhi");
    }
    public void fillEmail(String Email){
    	driver.findElement(By.id("userEmail")).sendKeys(Email);
    }

    public void setDateOfBirth(String dateOfBirth){
        WebElement dob=driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dob.sendKeys(dateOfBirth);
        dob.sendKeys(Keys.ENTER);
    }
    public void selectHobby(String Hobby) {
        driver.findElement(By.xpath("//label[text()='" + Hobby + "']")).click();

    }
    public void selectState(String State) {
        WebElement stateInput=driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys(State);
        stateInput.sendKeys(Keys.ENTER);    	
    }

    
    public void selectCity(String City) {
        WebElement cityInput=driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys(City);
        cityInput.sendKeys(Keys.ENTER);
    }
    
    
}



