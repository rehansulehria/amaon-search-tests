@test
Feature: This feature is to perform search on amzon.de and verify search results with below scenario:

  Scenario: User has Performed seach for Batman Comics, Verify Price, Title, Price postFix, Rating,
  match first product Product Price with Serach Results.
    Given Perform Search for "Batman Comics"
    Then Verify Search Results are Greater than 0
    And Verify Search Results Cotain word "Batman"
    And Verify Price is Above 0 for First Item
    Then Verify Price has "€" postfix
    Then Verify Rating is displayed
    Then Verify Price is same on Product Page
    And  Verify Title is same on Product Page
