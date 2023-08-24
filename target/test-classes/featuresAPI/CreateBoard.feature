Feature: Trello Create Board API Testing

  Scenario: Successful board creation
    Given the Trello create board API endpoint is "https://api.trello.com/1/boards/"
    And I have a valid API key and token
    When I send a POST request to create a board with name "Test Board"
    Then the response status code should be 200
    And the response body contains "Test Board"
    And I send a DELETE request to delete a board with ID
    Then the response status code should be 200