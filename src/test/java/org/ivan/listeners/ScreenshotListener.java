package org.ivan.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((WebDriverProvider) testClass).getDriver();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String screenshotName = result.getName() + "_" + System.currentTimeMillis() + ".png";
        File dest = new File("screenshots/" + screenshotName);

        dest.getParentFile().mkdirs();

        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
    }
}