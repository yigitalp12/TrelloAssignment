Feature: Trello Get Specific Board API Testing

  Scenario: Successful retrieval of a specific board and delete recently created board
    Given the Trello get specific board API endpoint is "https://api.trello.com/1/boards"
    And I have a valid API key and token
    And I have a recently created board with name "test board"
    When I send a GET request to retrieve the board with ID
    Then the response status code should be 200
    And the response body contains the board name "test board"
    When I send a DELETE request to delete a board with ID
    Then the response status code should be 200
