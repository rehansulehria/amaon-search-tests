@test
Feature: This feature is to perform search on amzon.de and verify search results with below scenario:

  Scenario: User has Performed seach for Batman Comics, Verify Price, Title, Price postFix, match first product
  Prodcut Price with Serach Results.
    Given Perform Search for "Batman Comics"
    Then Verify Search Results are Greater than 0
    Then Verify Search Results Cotain word "Batman"
    Then Verify Price is Above 0 for First Item
    Then Verify Price has "€" postfix
    When click on first product page
    Then Verify Price and Title on Product Page


