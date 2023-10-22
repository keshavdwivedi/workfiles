#Author: keshudwivedi17@gmail.com

Feature: To Test the Signup Feature of Website

  Background:
    Given I click on signin link

  Scenario: Blank submit on signup page
    When Signup field is displayed
    Then I check for Title
"""
Login - My Store
"""
    Then I click on Signup button

  Scenario: Invalid Email on signup page
    When Signup field is displayed
    Then I Enter Invalid email
    Then I click on Signup button

  Scenario: Valid Email on signup page
    When Signup field is displayed
    Then I Enter valid email
    Then I click on Signup button



