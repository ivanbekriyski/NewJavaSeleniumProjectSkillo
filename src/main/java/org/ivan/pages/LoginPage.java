package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.id("defaultLoginFormUsername");
    private By passwordInput = By.id("defaultLoginFormPassword");
    private By signInButton = By.id("sign-in-button");
    private By errorToast = By.cssSelector("div.toast-error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://training.skillo-bg.com:4300/users/login");
    }

    public void login(String username, String password) {
        waitForVisible(usernameInput).sendKeys(username);
        waitForVisible(passwordInput).sendKeys(password);
        waitForClickable(signInButton).click();
    }

    public void waitForSuccessfulLogin() {
        waitForClickable(By.id("search-bar"));
    }

    public void waitForLoginPageUrl() {
        waitForUrlContains("/users/login");
    }

    public String getErrorToastMessage() {
        return waitForVisible(errorToast).getText();
    }
}