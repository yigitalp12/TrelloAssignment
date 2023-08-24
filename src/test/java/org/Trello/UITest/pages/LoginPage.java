package org.Trello.UITest.pages;

import org.Trello.UITest.utils.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private final WaitUtils waitUtils;

    @FindBy(id = "user")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement continueButton;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        waitUtils = WaitUtils.getInstance(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public LoginPage login(String username, String password) {
        usernameField.sendKeys(username);
        continueButton.click();
        waitUtils.waitForElementToBeClickable(loginButton);
        passwordField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public LoginPage assertThatLoginPageIsDisplayed() {
        Assert.assertTrue(usernameField.isDisplayed());
        return this;
    }
}
