package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.HomePage;
import org.ivan.pages.LoginPage;
import org.ivan.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void openProfilePage() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.login("bekriiski", "Bekriiski5");

        HomePage home = new HomePage(driver);
        home.openProfile();

        ProfilePage profile = new ProfilePage(driver);
        Assert.assertFalse(profile.getProfileUsername().isEmpty(), "Profile username is empty!");
    }
}