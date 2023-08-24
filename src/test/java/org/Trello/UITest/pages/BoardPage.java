package org.Trello.UITest.pages;

import org.Trello.UITest.stepDefinitionsUI.SetupSteps;
import org.Trello.UITest.utils.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class BoardPage {
    private final WaitUtils waitUtils;

    @FindBy(css = ".HKTtBLwDyErB_o")
    private WebElement boardTitle;

    @FindBy(css = ".aT0m6qQxTMOyb8")
    private WebElement updateBoardTitle;

    @FindBy(xpath = "//span[@class='placeholder']")
    private WebElement addAnotherListButton;

    @FindBy(xpath = "//input[@class='list-name-input']")
    private WebElement enterListTitleField;

    @FindBy(css = ".confirm")
    private WebElement confirmAddCardButton;

    @FindBy(xpath = "//textarea[@class='list-card-composer-textarea js-card-title']")
    private WebElement enterCardTitleField;

    @FindBy(xpath = "//button[contains(@aria-label, 'Show menu')]")
    private WebElement menuIcon;

    @FindBy(css = ".js-card-details")
    private WebElement cardDetail;

    @FindBy(xpath = "//a[contains(text(), 'Close board')]")
    private WebElement closeBoardButton;

    @FindBy(xpath = "//input[@value='Close']")
    private WebElement confirmCloseButton;

    @FindBy(xpath = "//h1[@data-testid='close-board-big-message']")
    private WebElement boardCloseTitle;

    public BoardPage(WebDriver driver) {
        waitUtils = WaitUtils.getInstance(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public BoardPage assertThatBoardCreatedSuccessfully(String expectedBoardTitle) {
        Assert.assertTrue(expectedBoardTitle.equals(boardTitle.getText()));
        return this;
    }

    public BoardPage deleteBoard() {
        clickOnMenu();
        waitUtils.waitForElementToBeClickable(closeBoardButton);
        closeBoardButton.click();
        waitUtils.waitForElementToBeClickable(confirmCloseButton);
        confirmCloseButton.click();
        return this;
    }

    public BoardPage updateBoardTitle(String updatedBoardTitle) {
        boardTitle.click();
        updateBoardTitle.sendKeys(updatedBoardTitle);
        updateBoardTitle.sendKeys(Keys.RETURN);
        return this;
    }

    public BoardPage addAnotherListWithTitle(String listTitle) {
        addAnotherListButton.click();
        waitUtils.waitForElementToBeClickable(enterListTitleField);
        enterListTitleField.sendKeys(listTitle);
        enterListTitleField.sendKeys(Keys.RETURN);
        return this;
    }

    public BoardPage addCardWithTitle(String cardTitle) {
        SetupSteps.driver.findElement(By.cssSelector(".js-list:nth-child(" + getCreatedListCount() + ") .js-add-a-card")).click();
        enterCardTitleField.click();
        enterCardTitleField.sendKeys(cardTitle);
        enterCardTitleField.sendKeys(Keys.RETURN);
        return this;
    }

    public void assertThatBoardDeletedSuccessfully() {
        Assert.assertTrue(boardCloseTitle.isDisplayed());
    }

    public BoardPage assertThatBoardTitleUpdatedSuccessfully(String updatedBoardTitle) {
        Assert.assertTrue(boardTitle.getText().equals(updatedBoardTitle));
        return this;
    }

    public BoardPage assertThatCardAndListCreatedSuccessfully(String listTitle, String cardTitle) {
        String xpathExpression = String.format("//textarea[contains(@aria-label, '%s')]", listTitle);
        WebElement listTitleElem = SetupSteps.driver.findElement(By.xpath(xpathExpression));
        xpathExpression = String.format("//span[contains(text(), '%s')]", cardTitle);
        WebElement cardTitleElem = SetupSteps.driver.findElement(By.xpath(xpathExpression));
        Assert.assertTrue(listTitleElem.isDisplayed());
        Assert.assertTrue(cardTitleElem.isDisplayed());
        return this;
    }

    private void clickOnMenu() {
        menuIcon.click();
    }

    private int getCreatedListCount() {
        int size = SetupSteps.driver.findElements(By.xpath("//span[@class=\"js-add-a-card\"]")).size();
        return size;
    }
}
