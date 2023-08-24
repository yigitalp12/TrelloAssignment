package org.Trello.APITest.APIs;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.*;

public class DeleteBoardAPI {

    public Response sendDeleteRequestWithBoardId(String boardId) {
        response = given().queryParam("key", apiKey).queryParam("token", token).
                when().log().all().
                delete(boardId);
        return response;
    }
}
