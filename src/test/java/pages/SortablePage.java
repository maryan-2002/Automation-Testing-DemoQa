package pages;
 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
 
public class SortablePage extends BasePage {
 
    Actions actions;
 
    public SortablePage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }
 
    By sortableMenu = By.xpath("//span[text()='Sortable']");
    By item1 = By.xpath("//div[text()='One']");
    By item2 = By.xpath("//div[text()='Two']");
    By item3 = By.xpath("//div[text()='Three']");
    By item4 = By.xpath("//div[text()='Four']");
    By item5 = By.xpath("//div[text()='Five']");
    By item6 = By.xpath("//div[text()='Six']");
 
    public void openMenu() {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(sortableMenu));
 
        jsClick(element);
    }
// to reverse the order in the list 
    public void reverseList() {
        actions.dragAndDrop(getDriver().findElement(item6), getDriver().findElement(item1)).perform();
        actions.dragAndDrop(getDriver().findElement(item5), getDriver().findElement(item1)).perform();
        actions.dragAndDrop(getDriver().findElement(item4), getDriver().findElement(item1)).perform();
        actions.dragAndDrop(getDriver().findElement(item3), getDriver().findElement(item1)).perform();
        actions.dragAndDrop(getDriver().findElement(item2), getDriver().findElement(item1)).perform();
    }
}
