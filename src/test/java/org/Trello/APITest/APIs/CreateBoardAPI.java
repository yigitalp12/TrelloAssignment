package org.Trello.APITest.APIs;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.*;

public class CreateBoardAPI {

    private String boardId = null;

    public Response postCreateBoardRequest(String boardName) {
        response = given().queryParam("name", boardName).queryParam("key", apiKey).queryParam("token", token).
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                when().log().all().
                post();
        return response;
    }

    public String getCreatedBoardId() {
        boardId = response.jsonPath().getString("id");
        return boardId;
    }
}

