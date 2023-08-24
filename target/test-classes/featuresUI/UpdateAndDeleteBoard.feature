Feature: Update Trello Board Title

  Scenario: User updates the title of a Trello board and deletes it
    Given User is logged in to Trello
    And User has a Trello board with title "Mobile Test Automation Process"
    When User updates the board title to "Updated Mobile Test Automation Process"
    Then The board title should be "Updated Mobile Test Automation Process"
    When User deletes the board with title "Updated Mobile Test Automation Process"
    Then The board "Updated Mobile Test Automation Process" should be deleted