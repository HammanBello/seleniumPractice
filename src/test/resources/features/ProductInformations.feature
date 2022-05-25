@ProductInformation
Feature: As a customer I want to see detailed information of a product
Scenario Outline: look at detailed information of a product
Given User is on homepage
When User click on a product
Then Spawn a popup on the page with description of the article and the exact price
Examples:
  |-|
