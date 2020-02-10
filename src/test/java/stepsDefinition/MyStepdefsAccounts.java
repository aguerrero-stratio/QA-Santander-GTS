package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.UtilsCommon;

public class MyStepdefsAccounts {

    @Given("^El dominio de \"([^\"]*)\" esta levantado$")
    public void elDominioDeEstaLevantado(String Domain){

        UtilsCommon.serviceIsUp(Domain);
    }


    @When("^Se realiza un request \"([^\"]*)\" con el parametro \"([^\"]*)\"$")
    public void seRealizaUnRequestConElParametro(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^El servicio nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioNosDevuelveLaRespuesta(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Se realiza un request erronea \"([^\"]*)\"$")
    public void seRealizaUnRequestErronea(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
