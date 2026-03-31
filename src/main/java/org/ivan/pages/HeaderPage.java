package org.ivan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private By logoutIcon = By.cssSelector("i.fa-sign-out-alt");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        waitForClickable(logoutIcon).click();
    }
}