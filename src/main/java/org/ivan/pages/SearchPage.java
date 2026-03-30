package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;


    private By searchNavButton = By.cssSelector(
            "a[href='/users'], " +
                    "a[href*='users'], " +
                    "a.nav-link[href*='user'], " +
                    "i[class*='user'], " +
                    "a[routerlink='/users'], " +
                    "a[routerlink='/users/all']"
    );

    private By userResults = By.cssSelector(".users-container .user-info");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchNavButton)).click();
    }


    public void openUserByName(String username) {
        List<WebElement> users = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userResults));

        for (WebElement user : users) {
            if (user.getText().contains(username)) {
                user.click();
                return;
            }
        }

        throw new RuntimeException("User " + username + " not found in search results!");
    }

    private By searchInput = By.id("search-bar");
    private By searchResult = By.cssSelector("div.user-info");
    private By dropdownResults = By.cssSelector(".dropdown-user .post-user");

    public void searchUser(String username) {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        search.clear();

        for (char c : username.toCharArray()) {
            search.sendKeys(String.valueOf(c));
            try { Thread.sleep(200); } catch (Exception ignored) {}
        }

        selectUserFromDropdown(username);
    }

    public void openUser(String username) {
        By dropdownUser = By.xpath("//div[contains(@class,'dropdown-user')]//a[@class='post-user' and text()='" + username + "']");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUser));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    private void selectUserFromDropdown(String username) {
        List<WebElement> results = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownResults)
        );

        for (WebElement result : results) {
            if (result.getText().equalsIgnoreCase(username)) {
                result.click();
                return;
            }
        }

        throw new RuntimeException("User not found in dropdown: " + username);
    }

    private void slowType(WebElement element, String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Thread.sleep(300);
        }
    }
    }