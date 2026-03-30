package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By logoutButton = By.xpath("//i[contains(@class,'fa-sign-out-alt')]");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.urlContains("/users/login"));
    }
}