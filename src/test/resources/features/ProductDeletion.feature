@ProductDeletion
Feature: As a customer I want to remove a product from cart's products
  Scenario Outline: Add a product to cart then remove it
Given user is at the login page
When user is logging-in with "<email>" "<password>"
  And click on the product
  And click on the add to cart button
  And click on the shopping cart button at the top right
  And click on the delete button to delete the product in the cart
Then we observe in the list that the basket is modified, the product has been deleted

   Examples:
     | email                | password   |
     | hambello30@gmail.com | azertyuiop |