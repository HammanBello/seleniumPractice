@login
Feature: As a customer I want to login so that I can shop

  Scenario Outline: Perform login with valid credentials
    Given user is at the login page
    When  user is logging-in with "<email>" "<password>"
    Then  he should be at the home page

    Examples:
      | email                | password    |
      | ndorichnel@gmail.com | Nd0r\|chnel |
