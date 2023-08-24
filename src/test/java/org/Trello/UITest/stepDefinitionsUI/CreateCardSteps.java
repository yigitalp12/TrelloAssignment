package org.Trello.UITest.stepDefinitionsUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCardSteps {
    @When("user add a new list with title {string} to the board")
    public void userAddANewListWithTitleToTheBoard(String listTitle) {
        SetupSteps.boardPage.addAnotherListWithTitle(listTitle);
    }

    @And("User adds a card with title {string} to the new list")
    public void userAddsACardWithTitleToTheNewList(String cardTitle) {
        SetupSteps.boardPage.addCardWithTitle(cardTitle);
    }

    @Then("The list {string} and card {string} should be added to the board")
    public void theListAndCardShouldBeAddedToTheBoard(String listTitle, String cardTitle) {
        SetupSteps.boardPage.assertThatCardAndListCreatedSuccessfully(listTitle, cardTitle)
                .deleteBoard()
                .assertThatBoardDeletedSuccessfully();
    }
}
