Feature: Get product description

  Scenario: View product details in new window
    When I searched for "laptop"
    And I scroll down the page
    And I click on product picture 
    And I move to new browser tab
    And I close new tab and go back 