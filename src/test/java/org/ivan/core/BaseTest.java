package org.ivan.core;

import org.ivan.listeners.ScreenshotListener;
import org.ivan.listeners.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class BaseTest implements WebDriverProvider {

    protected WebDriver driver;

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