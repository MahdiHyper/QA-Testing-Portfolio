package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenshotUtil;

import pages.BasePage;
import pages.LoginPage;

public class BaseTest {

    protected String URL = "https://www.saucedemo.com/";
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
    	
        driver = new EdgeDriver();
        BasePage.setDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(URL);
        driver.manage().deleteAllCookies();
        
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
    	
    	if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            ScreenshotUtil.takeScreenshot(driver, testName);
        }
    	
        if (driver != null) {
            driver.quit();
        }
    }
}