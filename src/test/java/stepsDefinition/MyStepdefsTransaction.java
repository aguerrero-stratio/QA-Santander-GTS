package stepsDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.UtilsCommon;
import utils.UtilsTransactions;

import static org.junit.Assert.assertEquals;


public class MyStepdefsTransaction {

    private Response response = null;

    public MyStepdefsTransaction(){
    }

    @When("^Realizamos una peticion \"([^\"]*)\" al endpoint Transaction con el body \"([^\"]*)\"$")
    public void realizamosUnaPeticionAlEndpointTransactionConElBody(String httpMethod, String httpBody) {
        response = UtilsCommon.executeRequest(httpMethod, httpBody,"/accounts/search", "transactions");
        assertEquals("Correct status code returned",  200, response.getStatusCode());

    }

    @Then("^El endpoint Transacion nos devuelve la respuesta \"([^\"]*)\"$")
    public void elEndpointTransacionNosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        UtilsTransactions.compareTransaction(expectedResponse, response);
    }

}
