Feature: eBay Login Functionality

Scenario: Successful login to eBay account
  Given I access the eBay login page
  When I enter my registered email address
  And I proceed to the next step
  And I provide my account password
  And I complete the authentication process
  Then I should be successfully logged into my eBay account