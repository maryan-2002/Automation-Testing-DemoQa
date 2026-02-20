package QABootcamo_Maven.AxsosAcademy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseSetup{
    WebDriver driver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }
    public void NavigateForms(){
        WebElement Forms=driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Forms']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Forms);
    }   
    public void NavigateWidgets(){
        WebElement Widgets=driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Widgets);
    }

    }

