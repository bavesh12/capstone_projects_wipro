Feature: Add item to cart

  Scenario: Successfully add an item to the cart
    Given I go to homepage
    And I go on the login page 
    And I enter valid username
    And I click on continue 
    And I enter valid password
    And I click sign in button 
    Then I should be logged in successfully  

    When I am on a product page
    And I add the product to cart
    And I go to the cart
    Then The product should be displayed in the cart 