package stepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsCommon;
import utils.UtilsTransactions;


public class MyStepdefsTransaction {

    @Given("^El dominio de transactions esta levantado$")
    public void elDominioDeTransactionsEstaLevantado() {
        UtilsCommon.serviceIsUp("transactions");
    }

    @When("^Realizamos una peticion \"([^\"]*)\" al endpoint Transaction con el body \"([^\"]*)\"$")
    public void realizamosUnaPeticionAlEndpointTransactionConElBody(String httpMethod, String httpBody) {
        UtilsTransactions.searchTransactions(httpMethod, httpBody);
    }


    @Then("^El endpoint Transacion nos devuelve la respuesta \"([^\"]*)\"$")
    public void elEndpointTransacionNosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        UtilsTransactions.compareTransaction(expectedResponse, UtilsTransactions.response);
    }

}
