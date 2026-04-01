package org.ivan.pages;

import org.ivan.pages.BasePage;
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
        waitForClickable(searchInput).clear();
        searchInput.sendKeys(username);

        wait.until(driver -> {
            List<WebElement> results = driver.findElements(resultsLocator);
            return results.size() > 0;
        });

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsLocator));
    }

    public void openUser(String username) {

        By resultsLocator = By.cssSelector("a.post-user");

        for (int attempt = 0; attempt < 5; attempt++) {
            try {
                List<WebElement> results = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsLocator)
                );

                System.out.println("=== SEARCH RESULTS ===");
                for (WebElement user : results) {
                    System.out.println("RESULT: [" + user.getText() + "]");
                }
                System.out.println("======================");

                for (WebElement user : results) {
                    if (user.getText().trim().equals(username)) {

                        waitForClickable(user).click();

                        waitForUrlContains("/users/");

                        return;
                    }
                }

                wait.until(ExpectedConditions.stalenessOf(results.get(0)));

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected, retrying... attempt " + attempt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        throw new RuntimeException("User '" + username + "' not found or could not be clicked!");
    }
    }