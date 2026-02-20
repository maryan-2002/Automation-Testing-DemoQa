package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTablesPage {

	 WebDriver driver;
	    WebDriverWait wait;

	    public WebTablesPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // ================= LOCATORS =================

	    By elementsCard = By.xpath("//h5[text()='Elements']");
	    By webTablesMenu = By.xpath("//span[text()='Web Tables']");
	    By addButton = By.id("addNewRecordButton");
	    By firstName = By.id("firstName");
	    By lastName = By.id("lastName");
	    By email = By.id("userEmail");
	    By age = By.id("age");
	    By salary = By.id("salary");
	    By department = By.id("department");

	    By submitButton = By.id("submit");
	    By searchBox = By.id("searchBox");

	    // ================= NAVIGATION =================

	    public void navigateToWebTables() {

	        closeDemoQAAds();

	        WebElement elements = wait.until(
	                ExpectedConditions.elementToBeClickable(elementsCard));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", elements);

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", elements);

	        clickSidebarMenuItem(webTablesMenu);

	        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
	    }

	    // ================= ACTIONS =================

	    public void clickAdd() {
	        WebElement add = wait.until(
	                ExpectedConditions.elementToBeClickable(addButton));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", add);
	    }

	    public void fillForm(String fName, String lName, String mail) {
	        driver.findElement(firstName).clear();
	        driver.findElement(firstName).sendKeys(fName);

	        driver.findElement(lastName).clear();
	        driver.findElement(lastName).sendKeys(lName);

	        driver.findElement(email).clear();
	        driver.findElement(email).sendKeys(mail);

	        driver.findElement(age).clear();
	        driver.findElement(age).sendKeys("30");

	        driver.findElement(salary).clear();
	        driver.findElement(salary).sendKeys("5000");

	        driver.findElement(department).clear();
	        driver.findElement(department).sendKeys("QA");
	    }

	    public void submitAndWaitForRecord(String emailValue) {

	        WebElement submitBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(submitButton));

	        submitBtn.click();
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.className("modal-content")));
	        wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//*[text()='" + emailValue + "']")));
	    }
	    
	    public boolean isRecordPresent(String Value) {
	        int count = driver.findElements(
	                By.xpath("//td[normalize-space()='" + Value + "']")
	        ).size();
	        return count > 0;
	    }

	    public void clickEditByEmail(String emailValue) {
	        By editLocator = By.xpath("//td[normalize-space()='" + emailValue + "']/ancestor::tr//span[@title='Edit']");
	            WebElement editBtn = wait.until(
	                    ExpectedConditions.elementToBeClickable(editLocator)
	            );
	        editBtn.click();
	    }

	    public void clickDeleteByEmail(String emailValue) {
	    	By deleteLocator = By.xpath("//td[normalize-space()='" + emailValue + "']/ancestor::tr//span[@title='Delete']");
	        WebElement deleteBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(deleteLocator)
	        );
	        deleteBtn.click();
	    }

	    // ================= UTILITIES =================

	    public void closeDemoQAAds() {
	        try {
	            Thread.sleep(1000);
	            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	            for (WebElement frame : iframes) {
	                ((JavascriptExecutor) driver)
	                        .executeScript("arguments[0].remove();", frame);
	            }
	        } catch (Exception e) {
	            System.out.println("No ads found");
	        }
	    }

	    public void clickSidebarMenuItem(By menuItem) {
	        WebElement item = wait.until(
	                ExpectedConditions.elementToBeClickable(menuItem));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", item);

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", item);
	    }
	    
	    public void searchAndWait(String keyword, String emailToFind) {

	        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	        search.clear();
	        search.sendKeys(keyword);

	        By emailCell =  By.xpath("//td[normalize-space()='" + emailToFind + "']");

	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.presenceOfElementLocated(emailCell)
	        ));
	    }
	    

	    public boolean isEmailDisplayed(String email) {
	        return driver.findElements(
	                By.xpath("//td[normalize-space()='" + email + "']")
	        ).size() > 0;
	    }

}
