@SocialNetworkLogin
Feature: Regular login with Google
Scenario Outline: As a user I can login directly with my google account
Given user is at the login page
When The user click on Google icon
And The user is redirected to a Google Auth page where he types his google's "<email>" and "<password>"
Then he should be at the home page
Examples:
  |email                   |password      |
  |fafnirfafnir6@gmail.com |Mimosamimosa1.|
