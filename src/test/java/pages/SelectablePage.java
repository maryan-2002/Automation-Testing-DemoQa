package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class SelectablePage extends BasePage {

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    By selectableMenu = By.xpath("//span[text()='Selectable']");
    By listTab = By.id("demo-tab-list");
    By gridTab = By.id("demo-tab-grid");
    By gridItemThree = By.xpath("//li[text()='Three']");
    public void openMenu() {
        jsClick(getDriver().findElement(selectableMenu));
    }

    public void selectListItem(int index) {
    	getDriver().findElement(listTab).click();
    	getDriver().findElement(By.xpath("//ul[@id='verticalListContainer']/li[" + index + "]")).click();
    }

    public boolean isSelected(int index) {
        return getDriver().findElement(
                By.xpath("//ul[@id='verticalListContainer']/li[" + index + "]")
        ).getAttribute("class").contains("active");
    }
    public void clickGridTab() {
    	getDriver().findElement(gridTab).click();
    }

    public void clickGridItemThree() {
    	getDriver().findElement(gridItemThree).click();
    }

    public boolean isGridItemActive() {
    	WebElement element = getDriver().findElement(gridItemThree);
    	return element.getAttribute("class").contains("active");
    }
}
