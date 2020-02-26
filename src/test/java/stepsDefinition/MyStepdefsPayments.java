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

    @When("^Se realiza un request \"([^\"]*)\" al dominio payments con el parametro \"([^\"]*)\" y el valor \"([^\"]*)\"$")
    public void seRealizaUnRequestAlDominioPaymentsConElParametroYElValor(String httpMethod, String parameter, String value) {
        UtilsPayments.searchPayments(httpMethod, parameter, value);
    }

    @Then("^El servicio de payments nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioDePaymentsNosDevuelveLaRespuesta(String localJsonFilePath) throws Throwable {
        UtilsPayments.comparePayments(localJsonFilePath, UtilsPayments.response);
    }

    @When("^Se realiza un request \"([^\"]*)\" al dominio payments MT103 con el path \"([^\"]*)\"$")
    public void seRealizaUnRequestAlDominioPaymentsMT103ConElPath(String httpMethod, String path) {
        UtilsPayments.peticionPaymentsMt103(httpMethod, path);
    }

    @Then("^El servicio de payments MT103 nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioPaymentsMT103NosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        UtilsPayments.comparaRespuestaMT103(expectedResponse, UtilsPayments.response);
    }

    @When("^Se realiza un request \"([^\"]*)\" al dominio payments events con el path \"([^\"]*)\"$")
    public void seRealizaUnRequestAlDominioPaymentsEventsConElPath(String httpMethod, String path) {
        UtilsPayments.searchEventsPayments(httpMethod, path);
    }

    @Then("^El servicio de payments events nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioDePaymentsEventsNosDevuelveLaRespuesta(String localJsonFilePath) throws Throwable {
        UtilsPayments.comparePaymentsEvents(localJsonFilePath, UtilsPayments.response);
    }


}
