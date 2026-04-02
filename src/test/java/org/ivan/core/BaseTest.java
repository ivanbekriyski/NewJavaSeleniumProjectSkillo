package org.ivan.core;

import org.ivan.listeners.ScreenshotListener;
import org.ivan.listeners.WebDriverProvider;
import org.ivan.pages.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;

@Listeners(ScreenshotListener.class)
public class BaseTest implements WebDriverProvider {

    protected WebDriver driver;

    @BeforeSuite
    public void cleanScreenshots() {
        File folder = new File("screenshots");
        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }
    }

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get("http://training.skillo-bg.com:4300");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}