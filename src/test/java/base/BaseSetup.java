package base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseSetup{
	
	// Thread safe driver instance
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver(){
        return driver.get();
    }
    
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().get("https://demoqa.com/");
    }
    public void NavigateForms(){
        WebElement Forms=getDriver().findElement(By.xpath("//div[@class='card-body']/h5[text()='Forms']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Forms);
    }   
    public void NavigateWidgets(){
        WebElement Widgets=getDriver().findElement(By.xpath("//div[@class='card-body']/h5[text()='Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Widgets);
    }

    }


