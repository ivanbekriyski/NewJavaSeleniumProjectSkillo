package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By onlyPostImage = By.xpath("//img[contains(@src,'imgur')]");

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By firstPost = By.cssSelector("img[src='https://i.imgur.com/y5CdE46.jpg']");

    public void openFirstPost() {
        WebElement post = wait.until(ExpectedConditions.elementToBeClickable(firstPost));
        post.click();
    }

    public void openPost() {
        WebElement post = wait.until(ExpectedConditions.elementToBeClickable(onlyPostImage));
        post.click();
    }
}

