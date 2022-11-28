@AllTests
@Objective02
Feature:Objective02
    Background:User logins in Trello page
        Given user goes to the Trello login page
        Then user verifies that on Trello login page
        When user enters their email as a "trellofortest@gmail.com" and clicks continue button
        And user enters their password as a "Trellofortest.123" and clicks submit button
        Then user verifies that on Plentific Test page
        Given user clicks on the Automation Board
        Then user verifies that on Automation Board

    Scenario: TC01_objective02 happy path scenario
        Given user verifies that on Plentific list
        Then user verifies there are 2 cards on that board
        Then user verifies there is a card with a comment
        When user clicks on the card which has a comment
        And user verifies that there is a current comment
        When user clicks on the write a comment section
        Then user sends "new comment" in that comment area
        And user clicks on the save button
        Then user verifies that there is a new comment
        Then user closes the card
        Then user sets the card as done
        When user clicks on the card which has a comment
        Then user verifies that third card is on Done list

    Scenario: TC02_comment with just space is acceptable in the comment section but not acceptable in the edit section
        Given user clicks on the card which has a comment
        When user clicks on the write a comment section
        Then user sends a space " " as a character to the comment section
        And user clicks on the save button
        Then user verifies that there is a new comment
        When user clicks on the edit section
        Then user deletes the space
        Then user sends a space " " as a character to the edit section
        And user verifies that there is a "You haven't typed anything!" error
        And user verifies that save button is disabled
        Then user clicks on the exit button
        And user deletes that comment






