package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsAccounts;
import utils.UtilsCommon;

public class MyStepdefsAccounts {

    @Given("^El dominio de accounts esta levantado$")
    public void elDominioDeAccountsEstaLevantado() {
        UtilsCommon.serviceIsUp("accounts");
    }

    @When("^Se realiza una peticion \"([^\"]*)\" al endpoint accounts con el body \"([^\"]*)\"$")
    public void seRealizaUnaPeticionAlEndpointAccountsConElBody(String httpMethod, String httpBody) throws Throwable {
        UtilsAccounts.searchAccounts(httpMethod, httpBody);
    }

    @Then("^El servicio de accounts nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioDeAccountsNosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        UtilsAccounts.compareAccounts(expectedResponse, UtilsAccounts.response);
    }

}
