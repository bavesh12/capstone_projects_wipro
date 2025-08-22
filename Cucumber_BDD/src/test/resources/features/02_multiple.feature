Feature: eBay Search Functionality

Scenario Outline: Multiple search functionality
Given I am in to eBay Homepage
When I search for "<searchItem>"
And I click the search button
Then I navigate back to home page 

Examples: 
| searchItem |
| laptop     |
| smartphone | 
| headphones |
| watch      |
| camera     |