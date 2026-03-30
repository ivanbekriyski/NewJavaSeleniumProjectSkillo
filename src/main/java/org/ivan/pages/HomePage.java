package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By posts = By.cssSelector("div[class*='post']:not([class*='comment'])");

    private By profileButton = By.id("nav-link-profile");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openProfile() {
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profile.click();
    }

    public int getPostsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(posts));
        return driver.findElements(posts).size();
    }

    public void openFirstPost() {
        WebElement firstPost = wait.until(ExpectedConditions.elementToBeClickable(posts));
        firstPost.click();
    }

    private By searchButton = By.id("nav-link-search");

    public void openSearch() {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        search.click();
    }
}