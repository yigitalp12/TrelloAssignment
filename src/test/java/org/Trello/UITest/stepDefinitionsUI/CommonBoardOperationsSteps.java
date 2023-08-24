package org.Trello.UITest.stepDefinitionsUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.Trello.UITest.utils.PropertiesLoader;

public class CommonBoardOperationsSteps {

    @Given("User is logged in to Trello")
    public void user_is_logged_in_to_trello() {
        SetupSteps.loginPage.assertThatLoginPageIsDisplayed()
                .login(PropertiesLoader.getTrelloUsername(), PropertiesLoader.getTrelloPassword());
    }

    @And("User has a Trello board with title {string}")
    public void user_has_a_trello_board_with_title(String initialBoardTitle) {
        SetupSteps.homePage.assertThatHomePageIsDisplayed()
                .createBoard(initialBoardTitle);
    }
}
