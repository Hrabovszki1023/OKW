Feature: This is my dummyfeature file

  Scenario: Calculating with the four basic arithmetic operations
    Given I use the calculater
    When I enter "1" into the calculator
    And I add "200"
    And I subtract "200"
    And I divide by "555"
    And I multiply by "555"
    Then the calculated result is "1"
