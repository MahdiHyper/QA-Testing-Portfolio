package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected static WebDriver driver;

	public void setDriver(WebDriver driver) {

		BasePage.driver = driver;
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void click(By locator) {
		find(locator).click();
	}

	public String getText(By locator) {
		return find(locator).getText();
	}

	public void set(By locator, String text) {
		find(locator).sendKeys(text);
	}

	public void navigateTo(String url) {
		driver.get(url);
	}
}