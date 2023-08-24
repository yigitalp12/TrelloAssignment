package org.Trello.UITest.stepDefinitionsUI;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.Trello.UITest.pages.HomePage;
import org.Trello.UITest.utils.PropertiesLoader;
import org.Trello.UITest.pages.BoardPage;
import org.Trello.UITest.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SetupSteps {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static BoardPage boardPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertiesLoader.getTrelloURL());
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        boardPage = new BoardPage(driver);
    }

    @After
    public void terminate() {
        driver.quit();
    }
}
