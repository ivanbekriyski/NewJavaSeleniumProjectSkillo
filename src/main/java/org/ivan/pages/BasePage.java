package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> waitForAllVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }

    public void typeSlowly(WebElement element, String text) {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));

            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.or(
                            ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.post-user")),
                            ExpectedConditions.attributeContains(element, "value", String.valueOf(c))
                    ));
        }
    }
}