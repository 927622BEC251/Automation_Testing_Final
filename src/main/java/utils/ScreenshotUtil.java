package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {

        try {
            // Screenshot edukkum
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // File name set pannum
            String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

            File dest = new File(path);

            // File copy pannum
            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}