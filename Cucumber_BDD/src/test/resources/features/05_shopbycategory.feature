Feature: Shop by category

  Scenario: Browse Electronics category from menu
    Given I am on eBay homepage
    When I move mouse over categories menu
    And I choose Electronics from the list
    Then I view Electronics category products page
    And I return back to main homepage 