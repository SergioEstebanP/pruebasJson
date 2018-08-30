package stepsDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exampleSteps.ExampleSteps;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

import java.util.HashMap;
import java.util.Map;

public class StepsDefinitions {

    private ExampleSteps exampleSteps = new ExampleSteps();
    private Map<String, String> map = new HashMap<>();

    @When("^I request to do '(.*)' operation to get a user by:$")
    public void iRequestToDoOperationToGetAuser(String operation, Map<String, String> parameters) {
        this.map.putAll(parameters);
        switch (operation.toLowerCase()) {
            case "get":
                exampleSteps.getUser(operation, map);
                break;
        }
    }

    @Then("^I should get a response with:$")
    public void iShouldGetAResponseWith(Map<String, String> parameters) {
        this.map.putAll(parameters);
        Response response = Serenity.sessionVariableCalled("response");
        exampleSteps.compareResponse(parameters, response);
    }

    @And("^The status code must be (.*)$")
    public void theStatusCodeMustBe(int statusCode) {
        exampleSteps.verifyStatusCode(statusCode);
    }
}
