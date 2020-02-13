package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsCommon;

public class MyStepdefsEnterprise {

    private String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradeenterprises/enterprises/";

    @When("^Realizamos una peticion \"([^\"]*)\" al endpoint Enterprise con \"([^\"]*)\"$")
    public void realizamosUnaPeticionAlEndpointEnterpriseCon(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Nos devuelve la respuesta \"([^\"]*)\"$")
    public void nosDevuelveLaRespuesta(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^El dominio de enterprises esta levantado$")
    public void elDominioDeEnterprisesEstaLevantado() {
        UtilsCommon.serviceIsUp("enterprises");
    }
}
