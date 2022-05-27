@SocialNetworkLogin
Feature: Regular login with Google
Scenario Outline: As a user I can login directly with my google account
Given user is at the login page
When The user click on <social_network> icon
Then The user is redirected to a <social_network>
But An error page appears
Examples:
  |social_network|
  | google       |
