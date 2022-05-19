Feature: Login feature

  Scenario: Create a note
    Given I wait for the "MainActivity" screen to appear
    When I press "fab"
    Then I should see "New Note"
