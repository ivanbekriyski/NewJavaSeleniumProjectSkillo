package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(id = "search-bar")
    private WebElement searchInput;

    private By resultsLocator = By.cssSelector("a.post-user");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchUser(String username) {
        type(searchInput, username);

        wait.until(driver -> driver.findElements(resultsLocator).size() > 0);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsLocator));
    }

    public void openUser(String username) {

        for (int attempt = 0; attempt < 5; attempt++) {
            try {
                List<WebElement> results = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsLocator)
                );

                for (WebElement user : results) {
                    if (user.getText().trim().equals(username)) {
                        click(user);
                        waitForUrlContains("/users/");
                        return;
                    }
                }

                wait.until(ExpectedConditions.stalenessOf(results.get(0)));

            } catch (StaleElementReferenceException ignored) {}
        }

        throw new RuntimeException("User '" + username + "' not found!");
    }
}