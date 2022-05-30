@Registration
Feature: Regular registration
Scenario Outline: As a newcomer I can register to the application with my email address
Given The user is on Registration page
  And   enter an "email", "password" and confirm password
When  The user click on "Inscription" button
Then  he should be at the home page
Examples:
|email            |password |
|test34@gmail.com |tesT12345|