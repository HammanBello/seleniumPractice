@ShortCredential
Feature:Sign In without password
Scenario Outline:As a customer I cannot sign in without password
Given The user is on Registration page
And enter an "email", "password" and confirm password
When The user click on "Inscription" button
Then The user is not redirected to the Home Page
And The message "email must be an email password must be longer than or equal to 8 characters" is displayed
Examples:
|email|password|
|test |te      |