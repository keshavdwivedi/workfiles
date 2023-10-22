Feature: Checking Data on Cowin Dashboard
  I want to check data for all india on cowin dashboard

  Scenario: Validate vaccine data on dashboard for all india
    Given user navigate to cowin website
    When user clicks on cowin dashboard link
    And user switches to dashboard tab
    Then user validates todays count of vaccination should be "62,92,019"