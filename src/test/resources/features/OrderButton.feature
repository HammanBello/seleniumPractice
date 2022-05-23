@OrderButtonTest
Feature: As a customer I want to access to the command validation popup
  Scenario Outline: Perform login with valid credentials then add a product to cart then
    Given User is on homepage
    When click on the product
    And click on the add to cart button
    And click on the shopping cart button at the top right
    And User clicks on button "Commander"
    Then The order validation pop-up should appear
    Examples:
      | email                | password    |
      | ndorichnel@gmail.com | Nd0r\|chnel |


