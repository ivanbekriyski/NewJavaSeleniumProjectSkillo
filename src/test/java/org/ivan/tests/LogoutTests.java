package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.HeaderPage;
import org.ivan.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test
    public void logoutSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");

        login.waitForUrlContains("/posts/all");

        HeaderPage header = new HeaderPage(driver);
        header.logout();

        login.waitForUrlContains("/users/login");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/users/login"),
                "Logout was not successful!"
        );
    }
}