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
        login.openLoginPage();
        login.login("bekriiski", "Bekriiski5");

        Thread.sleep(3000);
        System.out.println("CURRENT URL AFTER LOGIN = " + driver.getCurrentUrl());
    }

    @Test
    public void openPostDetailsPage() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.login("bekriiski", "Bekriiski5");
        login.waitForSuccessfulLogin();

        HomePage home = new HomePage(driver);
        home.openFirstPost();

        Assert.assertTrue(driver.getCurrentUrl().contains("/posts/"), "Post details did not open!");
    }

    @Test
    public void likeLoraPost() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.login("bekriiski", "Bekriiski5");
        login.waitForSuccessfulLogin();

        Thread.sleep(2000);

        SearchPage search = new SearchPage(driver);

        Thread.sleep(1500);

        search.searchUser("Lora");

        search.openUser("Lora");


         UserProfilePage userProfile = new UserProfilePage(driver);
         userProfile.openPost();

        PostDetailsPage post = new PostDetailsPage(driver);

        int before = post.getLikesCount();
        post.clickLikeButton();
        Thread.sleep(1500);
        int after = post.getLikesCount();

        Assert.assertTrue(after > before, "Like count did not increase!");
    }
}