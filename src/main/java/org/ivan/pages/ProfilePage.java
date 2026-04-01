package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProfilePage extends BasePage {

    private By postImages = By.cssSelector("div.gallery-item div.post-img img");

    public void openPostByIndex(int index) {

        List<WebElement> posts = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(postImages)
        );

        WebElement post = posts.get(index);

        waitForClickable(post).click();
    }

    @FindBy(css = "h2")
    private WebElement profileUsername;

    @FindBy(css = "img[src*='imgur']")
    private List<WebElement> posts;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileUsername() {
        return waitForVisible(profileUsername).getText();
    }

    public int getPostsCount() {
        return waitForAllVisible(posts).size();
    }

}