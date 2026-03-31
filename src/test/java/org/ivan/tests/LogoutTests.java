package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.HeaderPage;
import org.ivan.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test
    public void logoutSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForSuccessfulLogin();

        HeaderPage header = new HeaderPage(driver);
        header.logout();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginPageUrl();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/users/login"),
                "Logout was not successful!"
        );
    }
}