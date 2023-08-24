package org.Trello.UITest.stepDefinitionsUI;

import io.cucumber.java.en.*;
import static org.Trello.UITest.stepDefinitionsUI.SetupSteps.boardPage;
import static org.Trello.UITest.stepDefinitionsUI.SetupSteps.homePage;

public class CreateBoardSteps {

    @When("User creates a new board with title {string}")
    public void user_creates_a_new_board_with_title(String boardTitle) {
        homePage.assertThatHomePageIsDisplayed()
                .createBoard(boardTitle);
    }

    @Then("The board {string} should be created successfully")
    public void the_board_should_be_created(String expectedBoardTitle) {
        boardPage.assertThatBoardCreatedSuccessfully(expectedBoardTitle)
                .deleteBoard()
                .assertThatBoardDeletedSuccessfully();
    }
}
