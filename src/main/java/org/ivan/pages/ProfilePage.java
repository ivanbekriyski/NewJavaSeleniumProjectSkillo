package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePage extends BasePage {

    private By profileUsername = By.cssSelector("h2");
    private By posts = By.cssSelector("img[src*='imgur']");
    public void openPostByIndex(int index) {
        List<WebElement> allPosts = waitForAllVisible(posts);
        allPosts.get(index).click();
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileUsername() {
        return waitForVisible(profileUsername).getText();
    }

    public int getPostsCount() {
        waitForVisible(posts);
        return driver.findElements(posts).size();
    }
}