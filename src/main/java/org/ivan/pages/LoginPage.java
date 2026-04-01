package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameInput;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordInput;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(css = "div.toast-error")
    private WebElement errorToast;

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
        waitForUrlContains("/posts/all");
    }

    public String getErrorToastMessage() {
        return waitForVisible(errorToast).getText();
    }
}