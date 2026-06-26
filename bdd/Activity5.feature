@activity5
Feature: Login Test

  Scenario Outline: Testing Login with Example
    Given the user is on the login page
    When the user enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then get the confirmation text message and verify message as "Invalid credentials"

  Example:
    | Usernames | Passwords |
    | admin1          | password2   |
