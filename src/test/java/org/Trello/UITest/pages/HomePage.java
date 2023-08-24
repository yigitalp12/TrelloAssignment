package org.Trello.UITest.pages;

import org.Trello.UITest.utils.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class HomePage {
    private final WaitUtils waitUtils;

    @FindBy(css = ".board-tile.mod-add")
    private WebElement addBoardButton;

    @FindBy(xpath = "//input[contains(@class, 'nch-textfield__input')]")
    private WebElement titleField;

    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    private WebElement createButton;

    @FindBy(css = ".board-title-text")
    private WebElement boardTitleElement;

    public HomePage(WebDriver driver) {
        waitUtils = WaitUtils.getInstance(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public HomePage assertThatHomePageIsDisplayed() {
        Assert.assertTrue(addBoardButton.isDisplayed());
        return this;
    }

    public HomePage createBoard(String boardTitle) {
        addBoardButton.click();
        titleField.sendKeys(boardTitle);
        waitUtils.waitForElementToBeClickable(createButton);
        createButton.click();
        return this;
    }
}
