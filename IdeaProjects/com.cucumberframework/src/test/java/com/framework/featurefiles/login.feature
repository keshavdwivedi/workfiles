#Author: keshudwivedi17@gmail.com
Feature: To Test the login functionality of website

  Background:
    Given I click on signin Link


  Scenario: To test login by blank submit
    When I click on Login button
    Then I validate error message shown to user


  Scenario: To test login by invalid credentials
    When I Enter invalid credentials
    Then I validate error message for scenario
