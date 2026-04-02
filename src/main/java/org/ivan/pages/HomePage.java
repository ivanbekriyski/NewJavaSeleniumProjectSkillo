package org.ivan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='/posts/create']")
    private WebElement newPostButton;

    @FindBy(css = "div[class*='post']:not([class*='comment'])")
    private List<WebElement> posts;

    @FindBy(id = "nav-link-profile")
    private WebElement profileButton;

    @FindBy(id = "nav-link-search")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoaded() {
        waitForVisible(newPostButton);
        waitForVisible(profileButton);
    }
    public void openProfile() {
        click(profileButton);
    }

    public int getPostsCount() {
        return waitForAllVisible(posts).size();
    }

    public void openFirstPost() {
        click(posts.get(0));
    }

    public void openSearch() {
        click(searchButton);
    }
}