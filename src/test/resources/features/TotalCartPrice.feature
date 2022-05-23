@TotalCartPrice
Feature: As a customer I want to add many product in the cart and see the total price
  Scenario Outline: Perform login with valid credentials then add a product to cart then see the total price
    Given User is on homepage
    When User clicks on the basket icon of the products "first product 1", "first product 2", "first product 3" to add to the basket
    And click on the shopping cart button at the top right
    Then User should see the sum total of the prices of the items in the cart
    Examples:
      | email                | password    |
      | ndorichnel@gmail.com | Nd0r\|chnel |


