package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By profileUsername = By.xpath("//h2");

    private By firstPost = By.cssSelector("img[src='https://i.imgur.com/y5CdE46.jpg']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProfileUsername() {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(profileUsername));
        return username.getText().trim();
    }


    public void openFirstPost() {
        WebElement post = wait.until(ExpectedConditions.elementToBeClickable(firstPost));
        post.click();
    }
}