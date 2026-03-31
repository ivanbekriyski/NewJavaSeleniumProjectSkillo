package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostDetailsPage extends BasePage {

    private By likeButton = By.cssSelector("i.fa-heart");
    private By likesCount = By.cssSelector("p.post-likes"); // <-- правилният локатор

    public PostDetailsPage(WebDriver driver) {
        super(driver);
    }

    public int getLikesCount() {
        String text = waitForVisible(likesCount).getText(); // "3 likes"
        return Integer.parseInt(text.split(" ")[0]);        // взимаме само числото
    }

    public void clickLike() {
        waitForClickable(likeButton).click();
    }
}