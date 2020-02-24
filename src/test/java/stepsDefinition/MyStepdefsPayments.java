package stepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsCommon;
import utils.UtilsPayments;


public class MyStepdefsPayments {

    @Given("^El dominio de payments esta levantado$")
    public void elDominioDePaymentsEstaLevantado() {
        UtilsCommon.serviceIsUp("payments");
    }

    @When("^Se realiza un request \"([^\"]*)\" al endpoint payments con el parametro \"([^\"]*)\" y el valor \"([^\"]*)\"$")
    public void seRealizaUnRequestAlEndpointPaymentsConElParametroYElValor(String httpMethod, String parameter, String value) throws Throwable {
        UtilsPayments.searchPayments(httpMethod, parameter, value);
    }

    @Then("^El servicio de payments nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioDePaymentsNosDevuelveLaRespuesta(String pathInput) throws Throwable {
        UtilsPayments.comparePayments(pathInput, UtilsPayments.response);
    }
}
