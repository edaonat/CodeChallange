@AllTests
@Login
Feature: Trello login

  Scenario:TC01_user logins in Trello page
    Given user goes to the Trello login page
    Then user verifies that on Trello login page
    When user enters their email as a "trellofortest@gmail.com" and clicks continue button
    And user enters their password as a "Trellofortest.123" and clicks submit button
    Then user verifies that on Plentific Test page

  Scenario: TC02_user logins in Trello page with the wrong credentials
    Given user goes to the Trello login page
    Then user verifies that on Trello login page
    When user enters their email as a "aaaa123" and clicks continue button
    And user enters their password as a "aaaa123" and clicks login button
    Then user verifies that there is an error message

  Scenario: TC03_user logins in Trello page with the true email wrong password
    Given user goes to the Trello login page
    Then user verifies that on Trello login page
    When user enters their email as a "trellofortest@gmail.com" and clicks continue button
    And user enters their password as a "aaaa123" and clicks submit button
    Then user verifies that there is an error message about no match

