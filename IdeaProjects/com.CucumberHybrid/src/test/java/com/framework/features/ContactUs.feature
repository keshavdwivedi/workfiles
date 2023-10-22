Feature: To test the Contact us feature of application

  Background:
    When user opens browser and navigates to test url

  Scenario Outline: To test contact us form with blank submit

    Given user should be on home page
    When user clicks on contact us link
    Then user is navigated to contact us page
    And  user clicks on Send button
    Then user is shown validation message <validationMessage>
    Examples:
      | validationMessage     |
      | Invalid email address. |


  Scenario Outline: To test contact us form with selection of subject only
    Given  user should be on home page
    When user clicks on contact us link
    Then user is navigated to contact us page
    And user selects <subject> from subject heading dropdown
    And user clicks on Send button
    Then user is shown validation message <validationMessage>
    Examples:
      | subject          | validationMessage     |
      | Webmaster        | Invalid email address. |
      | Customer service | Invalid email address. |

  Scenario Outline: To test contact us form by entering subject and email
    Given  user should be on home page
    When user clicks on contact us link
    Then user is navigated to contact us page
    And user selects <subject> from subject heading dropdown
    And user enters <email> in email field
    And user clicks on Send button
    Then user is shown validation message <validationMessage>
    Examples:
      | subject          | email           | validationMessage            |
      | Customer service | test1@gmail.com | The message cannot be blank. |
      | Webmaster        | test2@gmail.com | The message cannot be blank. |


  Scenario Outline: To test contact us form by entering valid data
    Given  user should be on home page
    When user clicks on contact us link
    Then user is navigated to contact us page
    And user selects <subject> from subject heading dropdown
    And user enters <email> in email field
    And user enters random message in message field
    And user clicks on Send button
    Then user is shown success message <successMessage>

    Examples:
      | subject          | email           | successMessage                                       |
      | Customer service | test1@gmail.com | Your message has been successfully sent to our team. |
      | Webmaster        | test2@gmail.com | Your message has been successfully sent to our team. |






