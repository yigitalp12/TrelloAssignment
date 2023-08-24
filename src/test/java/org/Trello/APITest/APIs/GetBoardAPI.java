package org.Trello.APITest.APIs;

import static io.restassured.RestAssured.given;
import static org.Trello.APITest.stepDefinitionsAPI.CommonAPISteps.*;

public class GetBoardAPI {

    public void sendGetSpecificBoardRequest(String boardId) {
        response = given().queryParam("key", apiKey).queryParam("token", token).
                when().log().all().
                get(boardId);
    }
}
