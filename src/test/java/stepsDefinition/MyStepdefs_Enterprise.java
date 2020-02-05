package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs_Enterprise {
    @Given("^El dominio de \"([^\"]*)\" esta levantado$")
    public void elDominioDeEstaLevantado(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Realizamos una petición al endpoint de \"([^\"]*)\" con CompanyID \"([^\"]*)\"$")
    public void realizamosUnaPeticiónAlEndpointDeConCompanyID(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Nos devuelve la respuesta con el criterio de CompanyID \"([^\"]*)\"$")
    public void nosDevuelveLaRespuestaConElCriterioDeCompanyID(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Realizamos una petición bad request$")
    public void realizamosUnaPeticiónBadRequest() {
    }

    @Then("^Nos devuelve la respuesta (\\d+) \"([^\"]*)\"$")
    public void nosDevuelveLaRespuesta(int arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Realizamos una petición Unauthorized$")
    public void realizamosUnaPeticiónUnauthorized() {
    }

    @When("^Realizamos una petición Forbidden$")
    public void realizamosUnaPeticiónForbidden() {
    }

    @When("^Realizamos una petición Not found$")
    public void realizamosUnaPeticiónNotFound() {
    }

    @When("^Realizamos una petición Method not allowed$")
    public void realizamosUnaPeticiónMethodNotAllowed() {
    }
}
