Feature: Checking Data on Cowin Dashboard for state and district
  I want to check data for specific state and district on cowin dashboard

  Scenario: Validate vaccine data on dashboard for specific state and district
    Given user navigate to cowin website
    When user clicks on cowin dashboard link
    And user switches to dashboard tab
    And user selects state "Uttar Pradesh" from state dropdown
    And user selects district "Lucknow" from district dropdown
    Then user validates todays count of vaccination should be "20,233"
