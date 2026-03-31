package org.ivan.pages;

import org.ivan.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    private By searchInput = By.id("search-bar");
    private By searchResults = By.cssSelector("a.post-user");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchUser(String username) {
        WebElement input = waitForClickable(searchInput);
        input.clear();

        typeSlowly(input, username);

        waitForVisible(searchResults);
    }

    public void openUser(String username) {
        By user = By.xpath("//a[@class='post-user' and contains(text(), '" + username + "')]");
        waitForClickable(user).click();
    }
}