package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs_Enterprise {

    private String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradeenterprises/enterprises/XXX";

    @Given("^El dominio de \"([^\"]*)\" esta levantado$")
    public void elDominioDeEstaLevantado(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

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

}
