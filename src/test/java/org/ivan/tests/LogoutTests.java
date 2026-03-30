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
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage header = new HeaderPage(driver);

        loginPage.openLoginPage();
        loginPage.login("bekriiski", "Bekriiski5");
        loginPage.waitForSuccessfulLogin();

        header.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("/users/login"));
    }
}