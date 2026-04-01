package org.ivan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(css = "i.fa-sign-out-alt")
    private WebElement logoutIcon;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        waitForClickable(logoutIcon).click();
    }
}