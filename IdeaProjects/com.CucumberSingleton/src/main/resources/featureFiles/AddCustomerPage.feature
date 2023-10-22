Feature: To validate add customer functionalities for Guru99 telecom website

  Background: Basic Homepage navigation

    Given User navigates to Guru99 telecom website
    Then  User verifies the page title "Guru99 Telecom"

  Scenario: Validate the functionality of Add customer by blank submit.

    When User navigates to homepage of website
    And User clicks on Add Customer link
    And User validates page heading "Add Customer" on Add customer page
    And Clicks on Submit button
    Then validates alert message "please fill all fields" on the page

  Scenario Outline: Validate the functionality of Add Customer by entering name only.

    When User navigates to homepage of website
    And User clicks on Add Customer link
    And User validates page heading "Add Customer" on Add customer page
    And User selects <backgroundtype> background check
    And User enters <firstname> in First name field
    And User enters <lastname> in Last name field
    And User clears data in name fields
    Then User should be able to view "Customer name must not be blank" validation message
    And Clicks on Submit button
    Then validates alert message "please fill all fields" on the page
    Examples:
      | backgroundtype | firstname | lastname |
      | Done           | Mukesh    | Otwani   |
      | Pending        | Raghav    | Pal      |

  Scenario Outline: Validate functionality of Add customer by entering name and valid email only.

    When User navigates to homepage of website
    And User clicks on Add Customer link
    And User validates page heading "Add Customer" on Add customer page
    And User selects <backgroundtype> background check
    And User enters <firstname> in First name field
    And User enters <lastname> in Last name field
    And User enters <emailValue> in email field
    And User clears data in email field
    And User clears data in name fields
    Then User should be able to view "Customer name must not be blank" validation message
    And User should be able to view "Email-ID must not be blank" validation message
    And Clicks on Submit button
    Then validates alert message "please fill all fields" on the page
    Examples:
      | backgroundtype | firstname | lastname | emailValue              |
      | Done           | Ravi      | Shukla   | ravi_shuki99@gmail.com  |
      | Pending        | Ajay      | Shukla   | Ajay.shukla99@gmail.com |

  Scenario Outline: Validate functionality of Add customer by entering name and invalid email only.

    When User navigates to homepage of website
    And User clicks on Add Customer link
    And User validates page heading "Add Customer" on Add customer page
    And User selects <backgroundtype> background check
    And User enters <firstname> in First name field
    And User enters <lastname> in Last name field
    And User enters <emailValue> in email field
    And User clears data in name fields
    Then User should be able to view "Customer name must not be blank" validation message
    And User should be able to view "Email-ID is not valid" validation message
    Examples:
      | backgroundtype | firstname | lastname | emailValue    |
      | Done           | Ravi      | Shukla   | ravi_shuki99  |
      | Pending        | Ajay      | Shukla   | Ajay.shukla99 |

  Scenario Outline: Validate functionality of Add customer by entering valid data along with invalid mobile number.

    When User navigates to homepage of website
    And User clicks on Add Customer link
    And User validates page heading "Add Customer" on Add customer page
    And User selects <backgroundtype> background check
    And User enters <firstname> in First name field
    And User enters <lastname> in Last name field
    And User enters <emailValue> in email field
    And User enters <messagevalue> in message field
    And User enters <mobileno> in mobile number field
    Then User should be able to view "Characters are not allowed" validation message

    Examples:
      | backgroundtype | firstname | lastname | emailValue              | messagevalue | mobileno |
      | Done           | Ravi      | Shukla   | ravi_shuki99@gmail.com  | message      | xyz      |
      | Pending        | Ajay      | Shukla   | Ajay.shukla99@gmail.com | message      | abc      |

  Scenario Outline: Validate functionality of Add customer by entering valid data.

    When User navigates to homepage of website
    And User clicks on Add Customer link
    And User validates page heading "Add Customer" on Add customer page
    And User selects <backgroundtype> background check
    And User enters <firstname> in First name field
    And User enters <lastname> in Last name field
    And User enters <emailValue> in email field
    And User enters <messagevalue> in message field
    And User enters <mobileno> in mobile number field
    And Clicks on Submit button

    Examples:
      | backgroundtype | firstname | lastname | emailValue              | messagevalue | mobileno |
      | Done           | Ravi      | Shukla   | ravi_shuki99@gmail.com  | message      | +91      |
      | Pending        | Ajay      | Shukla   | Ajay.shukla99@gmail.com | message      | +91      |





    


