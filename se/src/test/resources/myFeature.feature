Feature: This is my dummyfeature file

  Scenario: Add two numbers
    Given Calculator is started
    And The Calculator exists
    When I enter "123" into the calculator
    And I press "+"
    And I enter "12" into the calculator
    And I press "="
    Then the Calculator displays "135"
    And I Close Calculator
