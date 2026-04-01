package org.ivan.tests;

import org.ivan.core.BaseTest;
import org.ivan.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTests extends BaseTest {

    @Test
    public void postsAreVisibleOnHomePage() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForUrlContains("/posts/all");

        HomePage home = new HomePage(driver);
        home.waitForLoaded();

        Assert.assertTrue(home.getPostsCount() > 0, "No posts are visible on the home page!");
    }

    @Test
    public void shouldOpenPostDetailsWhenUserClicksOnPost() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForUrlContains("/posts/all");

        HomePage home = new HomePage(driver);
        home.openFirstPost();

        Assert.assertTrue(driver.getCurrentUrl().contains("/posts/"),
                "Post details did not open!");
    }

    @Test
    public void likeKremKaramelPost() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForUrlContains("/posts/all");

        HomePage home = new HomePage(driver);
        home.waitForLoaded();

        SearchPage search = new SearchPage(driver);
        search.searchUser("KremKaramel");
        search.openUser("KremKaramel");

        ProfilePage profile = new ProfilePage(driver);
        profile.openPostByIndex(0);

        PostDetailsPage post = new PostDetailsPage(driver);

        int before = post.getLikesCount();
        post.clickLike();
        post.waitForLikesToChange(before);
        int after = post.getLikesCount();

        Assert.assertTrue(after > before, "Like count did not increase!");
    }

    @Test
    public void commentOnKremKaramelPost() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("bekriiski", "Bekriiski5");
        login.waitForUrlContains("/posts/all");

        HomePage home = new HomePage(driver);
        home.waitForLoaded();

        SearchPage search = new SearchPage(driver);
        search.searchUser("KremKaramel");
        search.openUser("KremKaramel");

        ProfilePage profile = new ProfilePage(driver);
        profile.openPostByIndex(0);

        PostDetailsPage post = new PostDetailsPage(driver);

        String comment = "Very nice post!";

        post.addComment(comment);
        post.waitForCommentToAppear(comment);

        Assert.assertEquals(post.getLastComment(), comment, "Comment was not added!");
    }
}