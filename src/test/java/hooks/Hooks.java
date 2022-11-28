package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.Driver;

public class Hooks {
    public static RequestSpecification spec;
    @Before(value="@Api")
    public void baseUrlSetup(){
        spec=new RequestSpecBuilder().setBaseUri("https://api.trello.com").build();
    }
    @After
    public void closeBrowser(){
        Driver.closeDriver();
    }

}
