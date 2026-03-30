package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By likeButton = By.cssSelector("i.like.fa-heart");
    private By likesCount = By.xpath("//strong[contains(text(),'likes')]");

    public PostDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By firstPost = By.cssSelector("img.post-img");

    public int getLikesCount() {
        WebElement likes = wait.until(ExpectedConditions.visibilityOfElementLocated(likesCount));
        String text = likes.getText().trim(); // "12 likes"
        return Integer.parseInt(text.split(" ")[0]);
    }

    public void clickLikeButton() {
        WebElement likeBtn = wait.until(ExpectedConditions.elementToBeClickable(likeButton));
        likeBtn.click();
        wait.until(ExpectedConditions.attributeContains(likeButton, "class", "liked"));
    }


    public void openFirstPost() {
        WebElement post = wait.until(ExpectedConditions.elementToBeClickable(firstPost));
        post.click();
    }
}