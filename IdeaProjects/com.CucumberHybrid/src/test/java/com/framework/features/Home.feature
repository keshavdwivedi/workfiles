Feature: To test the Search feature of application

  Background:
    When user opens browser and navigates to test url


  Scenario: To test search functionality with blank submit
    Given user should be on home page
    And search textfield should be visible
    When user clicks on search button
    Then user should be displayed validation message "Please enter a search keyword"

  Scenario Outline: To test search product functionality with valid products

    Given user should be on home page
    And search textfield should be visible
    When user enters <productname> in search field
    And user clicks on search button
    Then user should be displayed appropriate product listing

    Examples:

      | productname |
      | shirts      |
      | blouse      |

