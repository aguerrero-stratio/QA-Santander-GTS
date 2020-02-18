package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsCommon;
import utils.UtilsEnterprise;

public class MyStepdefsEnterprise {

    @When("^Realizamos una peticion \"([^\"]*)\" al endpoint Enterprise con \"([^\"]*)\"$")
    public void realizamosUnaPeticionAlEndpointEnterpriseCon(String httpMethod, String httpParameter) throws Throwable {
        UtilsEnterprise.searchEnterpriseByID(httpMethod, httpParameter);
        //throw new PendingException();
    }

    @When("^Realizamos una peticion \"([^\"]*)\" al endpoint Enterprise con \"([^\"]*)\" invalido$")
    public void realizamosUnaPeticionAlEndpointEnterpriseConIdInvalido(String httpMethod, String httpParameter) throws Throwable {
        UtilsEnterprise.searchEnterpriseByInvalidID(httpMethod, httpParameter);
        //throw new PendingException();
    }

    @Then("^Nos devuelve la respuesta \"([^\"]*)\"$")
    public void nosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        UtilsEnterprise.compareTransaction(expectedResponse, UtilsEnterprise.response);
        //throw new PendingException();
    }

    @Given("^El dominio de enterprises esta levantado$")
    public void elDominioDeEnterprisesEstaLevantado() {
        UtilsCommon.serviceIsUp("enterprises");
    }
}
