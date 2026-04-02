package org.ivan.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PostDetailsPage extends BasePage {

    @FindBy(css = "i.like.fa-heart")
    private WebElement likeButton;

    @FindBy(xpath = "//i[contains(@class,'like')]/following::strong[1]")
    private WebElement likesCount;

    @FindBy(css = "input[formcontrolname='content']")
    private WebElement commentInput;

    private By commentLocator = By.cssSelector("div.comment-content");

    public PostDetailsPage(WebDriver driver) {
        super(driver);
    }

    public int getLikesCount() {
        String text = waitForVisible(likesCount).getText();
        return Integer.parseInt(text.split(" ")[0]);
    }

    public void clickLike() {
        click(likeButton);
    }

    public boolean isLiked() {
        return likeButton.getAttribute("class").contains("fas");
    }

    public void waitForLikesToChange(int before) {
        wait.until(driver -> {
            int current = Integer.parseInt(likesCount.getText().split(" ")[0]);
            return current != before;
        });
    }

    public void addComment(String text) {
        type(commentInput, text + Keys.ENTER);
    }

    public void waitForCommentToAppear(String text) {
        wait.until(driver -> {
            List<WebElement> comments = driver.findElements(commentLocator);
            if (comments.isEmpty()) return false;
            return comments.get(comments.size() - 1).getText().trim().equals(text);
        });
    }

    public String getLastComment() {
        List<WebElement> comments = driver.findElements(commentLocator);
        return comments.get(comments.size() - 1).getText().trim();
    }
}