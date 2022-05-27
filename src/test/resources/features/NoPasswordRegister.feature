@NoPasswdSignIn
Feature: Sign In without password
  Scenario Outline: As a customer I cannot sign in without password
Given The user is on Registration page
And The user fill "email", "Password" fields
And the user leaves the "confirmation password" field blank
When The user click on "Inscription" button
Then user receives error message due to empty confirm password field
Examples:
|email                           |password|
|sehajpreet.nicholi@orperfect.com|hqqps2J$|