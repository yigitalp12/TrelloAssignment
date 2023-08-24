package org.Trello.UITest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static WaitUtils instance;
    private WebDriver driver;
    private WebDriverWait wait;

    private WaitUtils(WebDriver driver, Duration timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeoutInSeconds);
    }

    public static WaitUtils getInstance(WebDriver driver, Duration timeoutInSeconds) {
        if (instance == null) {
            instance = new WaitUtils(driver, timeoutInSeconds);
        }
        return instance;
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
