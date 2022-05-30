@ShortPasswordReset
Feature: Reset of password
Scenario Outline: As a user I can't reset my password with a new too short
Given user is at the login page
And The user click on "mot de passe oublié"
And The user fill the form with his an "email" and an invalid "password"
When The user click on "Réinitialiser" button
Then the message "Le mot de passe doit avoir au moins 8 caractères" is displayed
Examples:
|email                |password|
|hambello30@gmail.com |te      |