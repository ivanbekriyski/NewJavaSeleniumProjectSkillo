package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PostTests extends BaseTest {



    @Test
    public void postsAreVisibleOnHomePage() throws Exception {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");

        System.out.println("CURRENT URL AFTER LOGIN = " + driver.getCurrentUrl());
    }

    @Test
    public void shouldOpenPostDetailsWhenUserClicksOnPost() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForSuccessfulLogin();

        HomePage home = new HomePage(driver);
        home.openFirstPost();

        Assert.assertTrue(driver.getCurrentUrl().contains("/posts/"), "Post details did not open!");
    }

    @Test
    public void likeLoraPost() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForSuccessfulLogin();

        SearchPage search = new SearchPage(driver);
        search.searchUser("Lora");
        search.openUser("Lora");

        UserProfilePage userProfile = new UserProfilePage(driver);
        userProfile.openPost();

        PostDetailsPage post = new PostDetailsPage(driver);

        int before = post.getLikesCount();
        post.clickLike();
        int after = post.getLikesCount();

        Assert.assertTrue(after > before, "Like count did not increase!");
    }

    @Test
    public void userCanLikeAnotherUsersPost() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForSuccessfulLogin();

        SearchPage search = new SearchPage(driver);
        search.searchUser("Lora");
        search.openUser("Lora");

        ProfilePage profile = new ProfilePage(driver);
        profile.openPostByIndex(0);

        PostDetailsPage post = new PostDetailsPage(driver);

        int before = post.getLikesCount();
        post.clickLike();
        int after = post.getLikesCount();

        Assert.assertTrue(after > before, "Like count did not increase!");
    }
}