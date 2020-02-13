package stepsDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsErrors;

public class MyStepdefsErrors {

    @When("^Se realiza una peticion \"([^\"]*)\" erronea \"([^\"]*)\" al dominio \"([^\"]*)\" con el endpoint \"([^\"]*)\"$")
    public void seRealizaUnaPeticionErroneaAlDominioConElEndpoint(String httpMethod, String errorRequest,
                                                                  String domain, String endPoint) {
        UtilsErrors.errorRequest(httpMethod, errorRequest, domain, endPoint);
    }

    @Then("^El servicio nos devuelve la respuesta con informacion del error correspondiente a \"([^\"]*)\"$")
    public void elServicioNosDevuelveLaRespuestaConInformacionDelErrorCorrespondienteA(String errorRequest) {
        UtilsErrors.verifyErrorResponse(errorRequest);
    }
}
