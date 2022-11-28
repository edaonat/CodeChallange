package stepdefinitions;

import io.cucumber.java.en.*;
import static hooks.Hooks.spec;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utilities.TXTReader.*;
import static utilities.TXTWriter.*;

public class Objective01StepDefs {
    Response response;
    JsonPath json;
    String idBoard;
    String idList;

    @Given("user sends a post request for a board creation")
    public void user_sends_a_post_request_for_a_board_creation() {
        spec.pathParams("first",1,"second","boards");
        response=given().spec(spec).queryParam("key", ConfigReader.getProperty("Trello_Key"))
                .queryParam("token", ConfigReader.getProperty("Trello_Token"))
                .queryParam("name", "Automation Board").contentType(ContentType.JSON)
                .when().post("/{first}/{second}/");
        response.then().statusCode(200);
        //response.prettyPrint();

    }

    @When("board name as a {string} should be validated")
    public void board_name_as_a_should_be_validated(String boardName) {
        json =response.jsonPath();
        Assert.assertTrue(json.getString("name").equals(boardName));

    }
    @Given("user sends a post request for a list creation")
    public void user_sends_a_post_request_for_sa_list_creation_with() {
        //user read the board id in that txt file
         idBoard=readFile(ConfigReader.getProperty("ApiData")).trim();

        spec.pathParams("first",1,"second","lists");
        response=given().spec(spec).queryParam("key", ConfigReader.getProperty("Trello_Key"))
                .queryParam("token", ConfigReader.getProperty("Trello_Token"))
                .queryParam("idBoard",idBoard)
                .queryParam("name", "Plentific").contentType(ContentType.JSON)
                .when().post("/{first}/{second}/");
        response.then().statusCode(200);
       // response.prettyPrint();

    }
    @Given("user sends a post request for card creation with {string}")
    public void user_sends_a_post_request_for_card_creation_with(String cardName) {
        //user read the list id in that txt file
        idList=readFile(ConfigReader.getProperty("ApiDataForCards")).trim();

        spec.pathParams("first",1,"second","cards");
        response=given().spec(spec).queryParam("key", ConfigReader.getProperty("Trello_Key"))
                .queryParam("token", ConfigReader.getProperty("Trello_Token"))
                .queryParam("idList",idList)
                .queryParam("name",cardName)
                .contentType(ContentType.JSON)
                .when().post("/{first}/{second}/");
        response.then().statusCode(200);
        //response.prettyPrint();
    }
    @When("card name as a {string} should be validated")
    public void card_name_as_a_should_be_validated(String cardName) {
        json =response.jsonPath();
        Assert.assertTrue(json.getString("name").equals(cardName));

    }
    @Then("user saves the board data")
    public void user_Saves_The_Board_Data() {
        HashMap<String,Object> actualData = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);
        saveBoardData(actualData,ConfigReader.getProperty("ApiData"));
    }

    @Then("user saves the list data")
    public void user_Saves_The_List_Data() {
        HashMap<String,Object> data = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);
        saveListData(data,ConfigReader.getProperty("ApiDataForCards"));
    }

    @Then("user saves the first card's data")
    public void user_Saves_The_First_CardS_Data() {
        HashMap<String, Object> cardIds = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);
        saveCardIds(cardIds, ConfigReader.getProperty("CardIds"));

        }
    @Given("user sends a put request to edit first card's name as a {string}")
    public void user_sends_a_put_request_to_edit_first_card_s_name_as_a(String newName) {
        spec.pathParams("first",1,"second","cards","third",readFileCardId(ConfigReader.getProperty("CardIds"),"First Card"));
        response=given().spec(spec).queryParam("key", ConfigReader.getProperty("Trello_Key"))
                .queryParam("token", ConfigReader.getProperty("Trello_Token"))
                .queryParam("name",newName)
                .contentType(ContentType.JSON)
                .when().put("/{first}/{second}/{third}/");
        response.then().statusCode(200);
        //response.prettyPrint();
    }
    @When("edited card name as a {string} should be validated")
    public void edited_card_name_as_a_should_be_validated(String newName) {
        json =response.jsonPath();
        Assert.assertTrue(json.getString("name").equals(newName));
    }
    @Given("user sends a delete request to delete {string}")
    public void user_sends_a_delete_request_to_delete(String card) {
        spec.pathParams("first",1,"second","cards","third",readFileCardId(ConfigReader.getProperty("CardIds"),card));
        response=given().spec(spec).queryParam("key", ConfigReader.getProperty("Trello_Key"))
                .queryParam("token", ConfigReader.getProperty("Trello_Token"))
                .contentType(ContentType.JSON)
                .when().delete("/{first}/{second}/{third}/");
        response.then().statusCode(200);
        //response.prettyPrint();
    }
    @Given("user sends a post request to add a {string} to the {string}")
    public void user_sends_a_post_request_to_add_a_to_the(String comment, String card) {
        spec.pathParams("first",1,"second","cards","third",readFileCardId(ConfigReader.getProperty("CardIds"),card),"fourth","actions","fifth","comments");
        response=given().spec(spec).queryParam("key", ConfigReader.getProperty("Trello_Key"))
                .queryParam("token", ConfigReader.getProperty("Trello_Token"))
                .queryParam("text",comment)
                .contentType(ContentType.JSON)
                .when().post("/{first}/{second}/{third}/{fourth}/{fifth}/");
        response.then().statusCode(200);
        //response.prettyPrint();
    }
    @Then("user validates comment section as {string}")
    public void user_Validates_Comment_Section_As(String comment) {
        json=response.jsonPath();
        Assert.assertTrue(json.getString("display.entities.comment.text").equals(comment));

    }
}

