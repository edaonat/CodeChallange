package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.BoardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Objective02StepDefs {
    BoardPage boardPage= new BoardPage();
    LoginPage loginPage= new LoginPage();
    @Given("user goes to the Trello login page")
    public void user_goes_to_the_trello_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @Then("user enters their email as a {string} and clicks continue button")
    public void user_enters_their_email_as_a_and_clicks_continue_button(String email) {
        loginPage.emailTextBox.sendKeys(email);
        loginPage.continueButton.click();
    }
    @Then("user enters their password as a {string} and clicks submit button")
    public void user_enters_their_password_as_a_and_clicks_submit_button(String password) {
        ReusableMethods.waitFor(3);
        loginPage.passwordTextBox.sendKeys(password);
        ReusableMethods.waitAndClick(loginPage.loginButton);
    }
    @Then("user verifies that on Trello login page")
    public void user_verifies_that_on_page() {
        ReusableMethods.waitAndVerify(loginPage.loginToTrello);
    }
    @Then("user verifies that there is an error message")
    public void user_verifies_that_there_is_an_error_message() {
        ReusableMethods.fluentWait(loginPage.noAccountThisUsername,5);
        ReusableMethods.waitAndVerify(loginPage.noAccountThisUsername);
    }
    @Then("user enters their password as a {string} and clicks login button")
    public void user_enters_their_password_as_a_and_clicks_login_button(String password)   {
        ReusableMethods.waitFor(3);
        loginPage.passwordTextBox.sendKeys(password);
        ReusableMethods.waitAndClick(loginPage.continueButton);
    }
    @Then("user verifies that there is an error message about no match")
    public void user_Verifies_That_There_Is_An_Error_Message_About_NoMatch()   {
        ReusableMethods.fluentWait(loginPage.errorMessage,3);
        ReusableMethods.waitAndVerify(loginPage.errorMessage);
    }
    @Then("user verifies that on Plentific Test page")
    public void user_Verifies_That_On_Plentific_Test_Page() {
        ReusableMethods.waitAndVerify(boardPage.plentificTest);
    }
    @Given("user clicks on the Automation Board")
    public void user_clicks_on_the_automation_board() {
        boardPage.automationBoard.click();
    }
    @Then("user verifies that on Automation Board")
    public void user_verifies_that_on_automation_board() {
        ReusableMethods.waitAndVerify(boardPage.automationBoardText);
    }
    @Given("user verifies that on Plentific list")
    public void user_verifies_that_on_plentific_list()  {
        ReusableMethods.fluentWait(boardPage.plentificListText,3);
        ReusableMethods.waitAndVerify(boardPage.plentificListText);
    }
    @Then("user verifies there are {int} cards on that board")
    public void user_verifies_there_are_cards_on_that_board(Integer num) {
        ReusableMethods.waitFor(2);
        int numOfCard= (boardPage.cards).size();
        Assert.assertTrue(numOfCard==num);
        //System.out.println(numOfCard);
    }
    @Then("user verifies there is a card with a comment")
    public void user_verifies_there_is_a_card_with_a_comment() {
        ReusableMethods.waitAndVerify(boardPage.commentIcon);
    }
    @When("user clicks on the card which has a comment")
    public void user_clicks_on_the_card_which_has_a_comment() {
        ReusableMethods.waitAndClick(boardPage.thirdCard);
    }
    @Then("user verifies that there is a current comment")
    public void user_verifies_that_there_is_a_current_comment() {
        int currentCommentNum=(boardPage.currentComment).size();
        Assert.assertTrue(currentCommentNum==1);
        //System.out.println(currentCommentNum);
    }
    @When("user clicks on the write a comment section")
    public void user_clicks_on_the_write_a_comment_section() {
        ReusableMethods.waitAndClick(boardPage.writeComment);
    }
    @Then("user sends {string} in that comment area")
    public void user_Sends_In_That_Comment_Area(String comment) {
        boardPage.writeComment.sendKeys(comment);
    }
    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        ReusableMethods.waitAndClick(boardPage.saveComment);
    }
    @Then("user verifies that there is a new comment")
    public void user_verifies_that_there_is_a_new_comment() {
        ReusableMethods.waitAndVerify(boardPage.newComment);
    }
    @Then("user sets the card as done")
    public void user_Sets_The_Card_As_Done() {
        ReusableMethods.waitFor(2);
        ReusableMethods.moveToElement(boardPage.thirdCard,boardPage.doneCard);
        ReusableMethods.waitFor(3);
    }
    @Then("user closes the card")
    public void user_Closes_The_Card() {
        ReusableMethods.waitAndClick(boardPage.close);
    }
    @And("user verifies that third card is on Done list")
    public void user_Verifies_That_Third_Card_Is_On_Done_List() {
        ReusableMethods.waitFor(5);
        ReusableMethods.waitAndVerify(boardPage.doneList);
    }
    @Then("user verifies that save button is disabled")
    public void user_verifies_that_save_button_is_disabled() {
        Assert.assertFalse(boardPage.disableSaveButton.isEnabled());
    }
    @Then("user sends a space {string} as a character to the comment section")
    public void userSendsASpaceAsACharacterToTheCommentSection(String space) {
        boardPage.writeComment.sendKeys(space);
    }
    @When("user clicks on the edit section")
    public void user_clicks_on_the_edit_section() {
        ReusableMethods.waitAndClick(boardPage.editButton);
    }
    @Then("user deletes the space")
    public void user_deletes_the_space() {
        new Actions(Driver.getDriver()).sendKeys(Keys.BACK_SPACE).perform();
        ReusableMethods.waitFor(3);
    }
    @Then("user verifies that there is a {string} error")
    public void user_verifies_that_there_is_a_error(String error) {
        Assert.assertEquals(boardPage.emptyError.getText(),error);
    }
    @Then("user sends a space {string} as a character to the edit section")
    public void user_Sends_A_Space_As_A_Character_To_The_Edit_Section(String space) {
        ReusableMethods.waitFor(3);
        boardPage.editTextArea.click();
        boardPage.editTextArea.sendKeys(space);
    }
    @Then("user clicks on the exit button")
    public void user_Clicks_On_The_Exit_Button() {
        boardPage.cancel.click();
    }
    @When("user deletes that comment")
    public void user_Deletes_That_Comment() {
        boardPage.deleteButton.click();
        ReusableMethods.fluentWait(boardPage.deleteConfirm,3);
        boardPage.deleteConfirm.click();
    }
}
