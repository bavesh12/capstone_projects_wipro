Feature: Language selection

  Scenario: Change website language to German
    Given I make browser window full size
    And I go to main homepage
    When I hover mouse on language selector
    And I pick German language option
    Then the website language changes to German 