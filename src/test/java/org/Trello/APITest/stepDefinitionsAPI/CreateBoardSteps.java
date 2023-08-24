package org.Trello.APITest.stepDefinitionsAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.createBoardAPI;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.response;
import static org.junit.Assert.assertTrue;

public class CreateBoardSteps {

    @Given("the Trello create board API endpoint is {string}")
    public void theTrelloCreateBoardAPIEndpointIs(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    @When("I send a POST request to create a board with name {string}")
    public void sendPOSTRequestToCreateABoardWithName(String boardName) {
        createBoardAPI.postCreateBoardRequest(boardName);
    }

    @And("the response body contains {string}")
    public void theResponseBodyContains(String boardName) {
        assertTrue(response.getBody().asString().contains("\"name\":\"" + boardName + "\""));
    }
}
