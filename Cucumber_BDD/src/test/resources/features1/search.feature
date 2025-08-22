Feature: Search functionality on eBay

Scenario Outline: User can search for different items on eBay
Given the eBay homepage is loaded
When the user enters "<searchItem>" in the search bar
And clicks the search button
Then the search results page for "<searchItem>" should be displayed

Examples:
  | searchItem |
  | Laptop     |
  | iPhone     |
  | Headphones |
  | Camera     |
  | Book       | 