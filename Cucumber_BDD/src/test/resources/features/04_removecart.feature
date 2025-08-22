Feature: Remove item from cart

  Scenario: Remove product from shopping basket after signing in
    Given I open eBay website
    And I go to sign in page
    And I type my email address
    And I press continue button
    And I type my password
    And I press sign in button

    When I visit my shopping cart
    And I find the product in my basket
    And I click remove button for that product 
    Then I see the product is gone from basket
    And I see empty cart message