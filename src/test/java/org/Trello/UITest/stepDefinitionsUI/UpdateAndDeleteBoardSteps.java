package org.Trello.UITest.stepDefinitionsUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateAndDeleteBoardSteps {

    @When("User updates the board title to {string}")
    public void user_updates_the_board_title_to(String updatedBoardTitle) {
        SetupSteps.boardPage.updateBoardTitle(updatedBoardTitle);
    }

    @When("User deletes the board with title {string}")
    public void userDeletesTheBoardWithTitle(String boardTitle) {
        SetupSteps.boardPage.deleteBoard();
    }

    @Then("The board title should be {string}")
    public void the_board_title_should_be(String expectedBoardTitle) {
        SetupSteps.boardPage.assertThatBoardTitleUpdatedSuccessfully(expectedBoardTitle);
    }

    @Then("The board {string} should be deleted")
    public void theBoardShouldBeDeleted(String boardTitle) {
        SetupSteps.boardPage.assertThatBoardDeletedSuccessfully();
    }
}
