@tag
Feature: login

  @tag1
  Scenario: Login with valid credentials
    Given Open the browser and enter the valid URL
    When User enters valid username
    And User enters valid password
    When Click on login button
    Then User should be in homepage of the application

