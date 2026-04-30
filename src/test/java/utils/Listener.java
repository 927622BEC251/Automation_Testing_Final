package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import org.openqa.selenium.*;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Listener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + result.getName() + ".png");
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}