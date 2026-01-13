package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {

	private WebDriver driver;
	private Date timeStamp = new Date();

	public TestUtils(WebDriver driver) {
		
		this.driver = driver;
	
	}

	public void scrollPageAndScreenShot(int valueWhereToStop, String screenShotOrder) throws IOException, InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,arguments[0])", valueWhereToStop);
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File myScreenshots = ts.getScreenshotAs(OutputType.FILE);
		String fileName = timeStamp.toString().replace(":", "-") + "_" + screenShotOrder;
		
		FileUtils.copyFile(myScreenshots, new File("screenshots/" + fileName + ".jpg"));
	}

	public void takeScreenshot(String testName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File myScreenshots = ts.getScreenshotAs(OutputType.FILE);
		
		String fileName = timeStamp.toString().replace(":", "-") + "_" + testName;
		FileUtils.copyFile(myScreenshots, new File("screenshots/" + fileName + ".jpg"));
	}
}




















