package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By loginNavButton = By.xpath("//a[contains(text(),'Login')]");
    private By usernameInput = By.id("defaultLoginFormUsername");
    private By passwordInput = By.id("defaultLoginFormPassword");
    private By loginButton = By.id("sign-in-button");


    private By toastError = By.cssSelector(".toast-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginNavButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    public void login(String username, String password) {
        WebElement userField = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));

        userField.click();
        userField.clear();
        userField.sendKeys(username);
        userField.sendKeys(Keys.TAB);

        passField.click();
        passField.clear();
        passField.sendKeys(password);
        passField.sendKeys(Keys.TAB);

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        submitBtn.click();
    }

    public String getErrorToastMessage() {
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastError));
        return toast.getText();
    }

    public void waitForSuccessfulLogin() {
        wait.until(ExpectedConditions.urlContains("/posts/all"));
    }
}