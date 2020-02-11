package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefsErrors {
    @When("^Se realiza una request erronea \"([^\"]*)\"$")
    public void seRealizaUnaRequestErronea(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^El servicio nos devuelve la respuesta erronea \"([^\"]*)\"$")
    public void elServicioNosDevuelveLaRespuestaErronea(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
