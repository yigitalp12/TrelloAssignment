package org.Trello.APITest.stepDefinitionsAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.*;
import static org.junit.Assert.assertTrue;

public class UpdateBoardSteps {
    
    @Given("the Trello update board API endpoint is {string}")
    public void theTrelloUpdateBoardAPIEndpointIs(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a PUT request to update the board name to {string}")
    public void sendPUTRequestToUpdateTheBoardNameTo(String updatedBoardName) {
        updateBoardAPI.sendUpdateBoardRequestWithBoardId(updatedBoardName, createBoardAPI.getCreatedBoardId());
    }

    @And("the response body contains the updated board name {string}")
    public void theResponseBodyContainsTheUpdatedBoardName(String expectedBoardName) {
        assertTrue(response.getBody().asString().contains("\"name\":\"" + expectedBoardName + "\""));
    }
}
