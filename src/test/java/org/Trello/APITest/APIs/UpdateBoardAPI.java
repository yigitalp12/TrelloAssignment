package org.Trello.APITest.APIs;

import io.restassured.response.Response;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.*;
import static io.restassured.RestAssured.given;

public class UpdateBoardAPI {

    public Response sendUpdateBoardRequestWithBoardId(String updatedBoardName, String boardId) {
        response = given().queryParam("name", updatedBoardName).queryParam("key", apiKey).queryParam("token", token).
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                when().log().all().
                put(boardId);
        return response;
    }
}
