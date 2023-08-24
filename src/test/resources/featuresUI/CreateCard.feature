Feature: Create Trello Card

  Scenario: User creates a new card in a Trello board
    Given User is logged in to Trello
    And User has a Trello board with title "KNAB Testing Process"
    When user add a new list with title "In Progress" to the board
    And User adds a card with title "Test Card" to the new list
    Then The list "In Progress" and card "Test Card" should be added to the board