Feature: To validate Homepage functionalities for Guru99 telecom website

  Background: Basic Homepage navigation

    Given User navigates to Guru99 telecom website
    Then  User verifies the page title "Guru99 Telecom"

  @run
  Scenario: Validate links on homepage of website

    When User navigates to homepage of website
    And  User validates the homepage main heading "Guru99 telecom"
    Then User verifies the count of homepage links
    And  User validates all links text on homepage
      | Linktext                    |
      | Add Customer                |
      | Add Tariff Plan to Customer |
      | Add Tariff Plan             |
      | Pay Billing                 |

  Scenario Outline: Validate functionality of links on homepage
    When User navigates to homepage of website
    And User clicks on <homePagelinktext> link
    And User validates <pageTitle> for the navigated page
    Then User navigates back to homepage of website
    Examples:
      | homePagelinktext            | pageTitle                          |
      | Add Customer                | Guru99 Telecom Add Customer        |
      | Add Tariff Plan             | Guru99 Add Tariff Plan to Customer |
      | Add Tariff Plan to Customer | Guru99 telecom                     |
      | Pay Billing                 | Guru99 Telecom Billing             |






