Feature: Trello Update Board API Testing

  Scenario: Successful update of board name
    Given the Trello update board API endpoint is "https://api.trello.com/1/boards/"
    And I have a valid API key and token
    And I have a recently created board with name "Test Board"
    When I send a PUT request to update the board name to "Updated Board"
    Then the response status code should be 200
    And the response body contains the updated board name "Updated Board"
    And I send a DELETE request to delete a board with ID
    Then the response status code should be 200