package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.UtilsCommon;
import utils.UtilsTransactions;


public class MyStepdefsTransaction {

    private String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradetransactions/";
    private RequestSpecification request = RestAssured.given()
            .relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123",
                    "X-B3-SpanId","123","X-B3-TraceId","123");
    private Response response = null;

    public MyStepdefsTransaction(){
    }

    @Given("^El dominio de \"([^\"]*)\" esta levantado$")
    public void elDominioDeEstaLevantado(String Domain){

        UtilsCommon.serviceIsUp(Domain);

    }

    @When("^Realizamos una peticion \"([^\"]*)\" al endpoint Transaction con el body \"([^\"]*)\"$")
    public void realizamosUnaPeticionAlEndpointTransactionConElBody(String arg0, String arg1) throws Throwable {

    }

    @Then("^Nos devuelve la respuesta \"([^\"]*)\"$")
    public void nosDevuelveLaRespuesta(String arg0) throws Throwable {

        UtilsTransactions.compareTransaction(arg0,response);

    }

}
