package org.Trello.APITest.stepDefinitionsAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.*;
import static org.junit.Assert.assertTrue;

public class GetBoardSteps {

    @Given("the Trello get specific board API endpoint is {string}")
    public void theTrelloGetSpecificBoardAPIEndpointIs(String apiUrl) {
        RestAssured.baseURI = apiUrl;
    }

    @When("I send a GET request to retrieve the board with ID")
    public void sendGetSpecificBoardRequest() {
        getBoardAPI.sendGetSpecificBoardRequest(createBoardAPI.getCreatedBoardId());
    }

    @And("the response body contains the board name {string}")
    public void verifyResponseBodyContainsBoardName(String boardName) {
        assertTrue(response.getBody().asString().contains("\"name\":\"" + boardName + "\""));
    }
}
