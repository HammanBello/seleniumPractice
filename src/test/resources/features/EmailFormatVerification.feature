@InvalidEmail
Feature: As a user I want to access to the login page and see an error message when i put an invalid email adress
Scenario Outline: Email format Verification
Given user is at the login page
And The user fill the email's field with value "<email>"
When the user clicks on the next field
Then An error appears to report invalid email syntax
Examples:
|email        |
|237pk69@gmail|