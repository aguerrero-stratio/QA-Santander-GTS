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

    @When("^El workflow con nombre \"([^\"]*)\" se ejecuta$")
    public void elWorkflowConNombreSeEjecuta(String arg0) {

        preparacionEntornoSteps.sendRequestToEndPoint("workflowExecutions/" + arg0);

    }

    @When("^Se aplica la QR \"([^\"]*)\"$")
    public void seAplicaLaQR(String QR) {

        preparacionEntornoSteps.validateQR(QR);

    }


    @Then("^El resultado del workflow \"([^\"]*)\" es \"([^\"]*)\"$")
    public void elResultadoDelWorkflowEs(String id, String estado) {

        preparacionEntornoSteps.validateWorkflowExecution(id,estado);

    }

    @Then("^La QR \"([^\"]*)\" funciona correctamente$")
    public void laQRFuncionaCorrectamente(String id){

        preparacionEntornoSteps.validateQualityRule(id);

    }
}
