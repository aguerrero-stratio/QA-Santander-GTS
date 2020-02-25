package stepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import schemas.Payments.Payments;
import schemas.Payments.PaymentsList;
import utils.UtilsAccounts;
import utils.UtilsCommon;
import utils.UtilsPayments;


public class MyStepdefsPayments {

    @Then("^El servicio de payments MT103 nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioPaymentsMT103NosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        UtilsPayments.comparaRespuestaMT103(expectedResponse, UtilsPayments.response);
    }

    @Given("^El dominio de payments esta levantado$")
    public void elDominioDePaymentsEstaLevantado() {
        UtilsCommon.serviceIsUp("payments");
    }

    @When("^Se realiza un request \"([^\"]*)\" al endpoint payments con el parametro \"([^\"]*)\" y el valor \"([^\"]*)\"$")
    public void seRealizaUnRequestAlEndpointPaymentsConElParametroYElValor(String httpMethod, String parameter, String value) throws Throwable {
        UtilsPayments.searchPayments(httpMethod, parameter, value);
    }

    @Then("^El servicio de payments nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioDePaymentsNosDevuelveLaRespuesta(String pathInput) throws Throwable {
        UtilsPayments.comparePayments(pathInput, UtilsPayments.response);
    }

    @When("^Se realiza un request \"([^\"]*)\" al endpoint payments MT103 con el parametro \"([^\"]*)\"$")
    public void seRealizaUnRequestEndpointPaymentsMt103ConParametro(String request, String parameter){
        UtilsPayments.peticionPaymentsMt103(request, parameter);
    }
}
