Feature: Create a new Trello board

  Scenario: User creates a new board
    Given User is logged in to Trello
    When User creates a new board with title "Test Automation Process"
    Then The board "Test Automation Process" should be created successfully