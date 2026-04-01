package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.HomePage;
import org.ivan.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithBekriiskiAccount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("bekriiski", "Bekriiski5");

        loginPage.waitForUrlContains("/posts/all");

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoaded();

        Assert.assertTrue(driver.getCurrentUrl().contains("/posts/all"),
                "Login with bekriiski was not successful!");
    }

    @Test
    public void invalidLoginShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("bekriiski", "wrongPass");

        String errorMessage = loginPage.getErrorToastMessage();

        Assert.assertTrue(errorMessage.toLowerCase().contains("wrong")
                        || errorMessage.toLowerCase().contains("invalid"),
                "Error toast not shown!");
    }
}