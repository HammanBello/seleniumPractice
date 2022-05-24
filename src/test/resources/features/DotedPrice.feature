@DotedPrice
Feature: As a customer I want to access to the home page and see product with doted prices
Scenario Outline: Doted Price Verification
Given User is on homepage
When User scroll to the bottom of the page
Then user have to see an article with a <doted_price>
Examples:
    |doted_price  |
    |3.99         |
    |4.55         |