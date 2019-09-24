package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.io.IOException;


public class PreparacionStepDefinition {

    @Steps
    private  PreparacionEntornoSteps preparacionEntornoSteps;


    @Given("^Sparta esta operativo$")
    public void spartaEstaOperativo() {
        preparacionEntornoSteps.checkStatusSparta();
    }

    @And("^La autentificacion con la plataforma es correcta$")
    public void laAutentificacionConLaPlataformaEsCorrecta() {
        preparacionEntornoSteps.autentificacionCorrecta();
    }

    @When("^Realizamos llamadas a \"([^\"]*)\"$")
    public void realizamosLlamadasA(String arg0) throws Throwable {
        preparacionEntornoSteps.sendRequestToEndPoint(arg0);

    }

}
