package org.Trello.APITest.stepDefinitionsAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.createBoardAPI;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.deleteBoardAPI;

public class DeleteBoardSteps {

    @Given("the Trello delete board API endpoint is {string}")
    public void theTrelloDeleteBoardAPIEndpointIs(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a DELETE request to delete a board with ID")
    public void sendDELETERequestToDeleteABoardWithID() {
        deleteBoardAPI.sendDeleteRequestWithBoardId(createBoardAPI.getCreatedBoardId());
    }
}
