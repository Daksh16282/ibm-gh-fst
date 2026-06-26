@activity3
Feature: Testing with Tags

  Background: User is on the Page
    Given User is on the page

  @SimpleAlert @SmokeTest
  Scenario: Testing with Simple Alert
    When User clicks the Simple Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert
    And Read the result text

  @ConfirmAlert
  Scenario: Testing with Simple Alert
    When User clicks the Confirm Alert button
    Then Alert opens
    And Read the text from it and print it
    And Close the alert with Cancel
    And Read the result text

  @PromptAlert
  Scenario Outline: Testing with Simple Alert
    When User clicks the Prompt Alert button
    Then Alert opens
    And Read the text from it and print it
    And Write a custom message in it
    And Close the alert
    And Read the result text
