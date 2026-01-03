package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver driver) {
    	
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
    	
        return driver.findElement(locator);
    }

    protected void click(By locator) {
    	
        find(locator).click();
    }

    protected void sendKeys(By locator, String text) {
    	
        find(locator).clear();
        find(locator).sendKeys(text);
    }
    
    protected String getText (By locator) {
    	
    	return find(locator).getText();
    }
}