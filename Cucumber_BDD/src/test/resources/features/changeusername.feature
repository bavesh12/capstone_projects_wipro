Feature: Update username

  Scenario: Successfully modify the username
    Given I log into eBay with valid credentials
    When I hover over the profile icon
    And I navigate to account preferences
    And I click on personal information
    And I select edit username option
    And I update the username to "saibavesh6665"
    And I re-login after username change 
    Then the username should be updated on my account
  