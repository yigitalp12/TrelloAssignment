package org.Trello.APITest.stepDefinitionsAPI;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.Trello.APITest.APIs.CreateBoardAPI;
import org.Trello.APITest.APIs.DeleteBoardAPI;
import org.Trello.APITest.APIs.GetBoardAPI;
import org.Trello.APITest.APIs.UpdateBoardAPI;
import org.junit.Assert;

public class CommonAPISteps {

    public static Response response;
    public static String apiKey;
    public static String token;
    public static CreateBoardAPI createBoardAPI;
    public static DeleteBoardAPI deleteBoardAPI;
    public static GetBoardAPI getBoardAPI;
    public static UpdateBoardAPI updateBoardAPI;

    @BeforeStep
    public void setUp() {
        createBoardAPI = new CreateBoardAPI();
        getBoardAPI = new GetBoardAPI();
        deleteBoardAPI = new DeleteBoardAPI();
        updateBoardAPI = new UpdateBoardAPI();
    }

    @And("I have a valid API key and token")
    public void validAPIKeyAndToken() {
        apiKey = "a3b5b46218f51e23fd8902608bf45ad5";
        token = "ATTA518b7b9ba572f36db7121ed1422716df4cc7f8e9eea4f41a5de43d325fadbf7aF908FEF1";
    }

    @And("I have a recently created board with name {string}")
    public void recentlyCreatedBoardWithName(String boardName) {
        createBoardAPI.postCreateBoardRequest(boardName);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}
