package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        

        String destinationPath = "screenshots/" + fileName;
        File destinationFile = new File(destinationPath);
        
        try {
        	
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("Screenshot saved: " + destinationPath);
            
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
        
        return destinationPath;
    }
    
    
    
    
}



















