@AllTests
@Objective01
@Api
Feature: Objective 01

    Scenario Outline:TC01_create a board
      Given user sends a post request for a board creation
      When board name as a "<boardName>" should be validated
      Then user saves the board data
      Examples: test data
      |boardName|
      |Automation Board|

    Scenario: TC02_create a list on that board
      Given user sends a post request for a list creation
      Then user saves the list data

    Scenario Outline: TC03_create 3 cards on that board
      Given user sends a post request for card creation with "<cardName>"
      When card name as a "<cardName>" should be validated
      Then user saves the first card's data
      Examples: test data
      |cardName|
      |First Card|
      |Second Card|
      |Third Card |

      Scenario Outline: TC04_edit one of the cards
        Given user sends a put request to edit first card's name as a "<newName>"
        When edited card name as a "<newName>" should be validated
        Examples: test data
        |newName|
        |First Edit|

      Scenario Outline: TC05_delete one of the cards
        Given user sends a delete request to delete "<Card>"
        Examples: test data
        |Card|
        |Second Card|

      Scenario Outline: TC06_add a comment to one of the cards
        Given user sends a post request to add a "<comment>" to the "Third Card"
        Then user validates comment section as "<comment>"
    Examples: test data
        |comment|
        |Adding a new comment|

