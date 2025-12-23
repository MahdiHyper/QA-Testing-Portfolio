package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Page.BasePage;
import Page.LoginPage;

public class BaseTest {

	protected String siteURL = "https://www.saucedemo.com/";

	protected WebDriver driver;
	protected BasePage basePage;
	protected LoginPage loginPage;

	@BeforeClass
	public void setup() {
		
		driver = new EdgeDriver();
		driver.get(siteURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		basePage = new BasePage();
		basePage.setDriver(driver);

		loginPage = new LoginPage();

	}
	
	@BeforeMethod
	public void beforeEveryTest() {
		
		driver.get(siteURL);
		loginPage = new LoginPage();
	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}
	}
}