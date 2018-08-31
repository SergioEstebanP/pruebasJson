package exampleSteps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;
import responseObjects.User;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;

public class ExampleSteps {

    // BASE URI
    public static final String URI = "https://reqres.in/api";

    // ENDPOINTS
    public static final String USER = "/users";

    // PRIVATE METHODS
    private RequestSpecification spec = rest().baseUri(URI).contentType(ContentType.JSON).when();

    public Response executeRequest(RequestSpecification spec, String method, String endpoint) {
        Response response;

        switch (method) {
            case "GET":
                response = spec.get(endpoint);
                break;
            case "POST":
                response = spec.post(endpoint);
                break;
            case "DELETE":
                response = spec.delete(endpoint);
                break;
            case "PUT":
                response = spec.put(endpoint);
                break;
            default:
                response = spec.get(endpoint);
                break;
        }
        return response;
    }

    User usuario = new User();

    // STEPS
    @Step
    public void getUser (String operation, Map<String, String> parameters) {
        usuario.setId(Integer.parseInt(parameters.get("id")));

        String endpoint = URI + USER + "/" + parameters.get("id");
        Response response = executeRequest(spec, operation.toUpperCase(), endpoint);
        Serenity.setSessionVariable("response").to(response);
    }

    @Step
    public void compareResponse(Map<String, String> parameters, Response response) {
        usuario.setName(parameters.get("first_name"));
        usuario.setLastName(parameters.get("last_name"));
        usuario.setAvatar(parameters.get("avatar"));

        ResponseBodyData bodyData = response.getBody();
        User usuarioJsonRespuesta = new User(new JSONObject(bodyData.asString()).getJSONObject("data"));
        Assert.assertTrue(usuario.equals(usuarioJsonRespuesta));
    }

    @Step
    public void verifyStatusCode(int statusCode) {
        Response response = Serenity.sessionVariableCalled("response");
        Assert.assertEquals("The status code is incorrect, something in the operation went wrong", statusCode, response.getStatusCode());
    }
}
