package QABootcamo_Maven.AxsosAcademy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectablePage extends BasePage {

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    By selectableMenu = By.xpath("//span[text()='Selectable']");
    By listTab = By.id("demo-tab-list");
    By gridTab = By.id("demo-tab-grid");
    By gridItemThree = By.xpath("//li[text()='Three']");
    public void openMenu() {
        jsClick(driver.findElement(selectableMenu));
    }

    public void selectListItem(int index) {
        driver.findElement(listTab).click();
        driver.findElement(By.xpath("//ul[@id='verticalListContainer']/li[" + index + "]")).click();
    }

    public boolean isSelected(int index) {
        return driver.findElement(
                By.xpath("//ul[@id='verticalListContainer']/li[" + index + "]")
        ).getAttribute("class").contains("active");
    }
    public void clickGridTab() {
    	driver.findElement(gridTab).click();
    }

    public void clickGridItemThree() {
    	driver.findElement(gridItemThree).click();
    }

    public boolean isGridItemActive() {
    	WebElement element = driver.findElement(gridItemThree);
    	return element.getAttribute("class").contains("active");
    }
}
