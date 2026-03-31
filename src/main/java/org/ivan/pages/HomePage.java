package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private By newPostButton = By.cssSelector("a[href='/posts/create']");
    private By posts = By.cssSelector("div[class*='post']:not([class*='comment'])");
    private By profileButton = By.id("nav-link-profile");
    private By searchButton = By.id("nav-link-search");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoaded() {
        waitForVisible(newPostButton);
    }

    public void waitForHomeUrl() {
        waitForUrlContains("/posts/all");
    }

    public void openProfile() {
        waitForClickable(profileButton).click();
    }

    public int getPostsCount() {
        waitForVisible(posts);
        List<WebElement> allPosts = driver.findElements(posts);
        return allPosts.size();
    }

    public void openFirstPost() {
        waitForClickable(posts).click();
    }

    public void openSearch() {
        waitForClickable(searchButton).click();
    }
}