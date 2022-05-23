@CartModification
Feature: As a customer I want to update the quantity of cart's products
  Scenario Outline: Perform login with valid credentials then add a product to cart and update his quantity after adding it
Given user is at the login page
When user is logging-in with "<email>" "<password>"
  And remove all in cart
  And click on the product
  And click on the + button to increase the quantity of this product in the cart
  And click on the add to cart button
  And click on the product
  And click on the + button to increase the quantity of this product in the cart
  And click on the add to cart button
  And click on the shopping cart button at the top right
  Then we observe that the basket has been updated

Examples:
    | email                | password   |
    | hambello30@gmail.com | azertyuiop |