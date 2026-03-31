package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.HomePage;
import org.ivan.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithBekriiskiAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("bekriiski", "Bekriiski5");

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoaded();
        homePage.waitForHomeUrl();

        Assert.assertTrue(driver.getCurrentUrl().contains("/posts/all"),
                "Login with bekriiski was not successful!");
    }

    @Test
    public void invalidLoginShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("bekriiski", "wrongPass");

        Assert.assertTrue(loginPage.getErrorToastMessage().toLowerCase().contains("wrong"),
                "Error toast not shown!");
    }
}