package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserProfilePage extends BasePage {

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    private WebDriver driver;
    private WebDriverWait wait;

    private By onlyPostImage = By.xpath("//img[contains(@src,'imgur')]");

    private By posts = By.cssSelector("img[src*='imgur']");
    public void openPost() {
        waitForClickable(posts).click();
    }
}

