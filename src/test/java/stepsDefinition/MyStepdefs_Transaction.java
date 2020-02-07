package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;


public class MyStepdefs_Transaction {

    private String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradetransactions/";
    private RequestSpecification request = RestAssured.given()
            .relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123",
                    "X-B3-SpanId","123","X-B3-TraceId","123");
    private Response response = null;

    public MyStepdefs_Transaction(){
    }

    @Given("^El dominio de Transaction esta levantado$")
    public void elDominioDeTransactionEstaLevantado() throws IOException, ParseException {
        response = request.get(baseURI + "transactions/accounts/search");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);
    }

    @When("^Realizamos una peticion al endpoint \"([^\"]*)\" Transaction con el body \"([^\"]*)\"$")
    public void realizamosUnaPeticionAlEndpointTransactionConElBody(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Nos devuelve la respuesta \"([^\"]*)\"$")
    public void nosDevuelveLaRespuesta(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
