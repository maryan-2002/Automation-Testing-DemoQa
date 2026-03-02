package pages;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;
public class PracticeForm extends BaseSetup{
    public void openPracticeForm() {
    	 startBrowser();
    	 NavigateForms();
    	 WebElement practiceForm=getDriver().findElement(By.xpath("//span[text()='Practice Form']"));
    	 practiceForm.click();
    }
    public void fillMandatory(String firstName,String lastName,String gender,String mobile){
    	WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(5));
    	WebElement firstNameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
    	firstNameField.sendKeys(firstName);
    	getDriver().findElement(By.id("lastName")).sendKeys(lastName);
        selectGender(gender);
        getDriver().findElement(By.id("userNumber")).sendKeys(mobile);
    }
    public void selectGender(String gender){
        if(gender!=null&&!gender.isEmpty()){
        	getDriver().findElement(By.xpath("//label[text()='" + gender + "']")).click();
        }
    }
    public void submitForm() {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(8));
        WebElement submit=getDriver().findElement(By.id("submit"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'center'});", submit);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        }
        catch (Exception e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",submit);
        }
    }

    public void fillAllFields(){
        fillMandatory("Ghada", "Sawallha", "Female", "0591234567");
        setDateOfBirth("18 Feb 2026");
        fillEmail("ghada@test.com");
        WebElement subjects=getDriver().findElement(By.id("subjectsInput"));
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);
        selectHobby("Sports");
        selectHobby("Reading");
        getDriver().findElement(By.id("currentAddress")).sendKeys("Birzeit, Palestine");
        selectState("NCR");
        selectCity("Delhi");
    }
    public void fillEmail(String Email){
    	getDriver().findElement(By.id("userEmail")).sendKeys(Email);
    }

    public void setDateOfBirth(String dateOfBirth){
        WebElement dob=getDriver().findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dob.sendKeys(dateOfBirth);
        dob.sendKeys(Keys.ENTER);
    }
    public void selectHobby(String Hobby) {
    	getDriver().findElement(By.xpath("//label[text()='" + Hobby + "']")).click();

    }
    public void selectState(String State) {
        WebElement stateInput=getDriver().findElement(By.id("react-select-3-input"));
        stateInput.sendKeys(State);
        stateInput.sendKeys(Keys.ENTER);    	
    }

    
    public void selectCity(String City) {
        WebElement cityInput=getDriver().findElement(By.id("react-select-4-input"));
        cityInput.sendKeys(City);
        cityInput.sendKeys(Keys.ENTER);
    }
    
    
}



