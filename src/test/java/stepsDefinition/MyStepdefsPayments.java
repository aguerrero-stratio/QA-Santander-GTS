package stepsDefinition;

import cucumber.api.PendingException;
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
import utils.WebServiceEndPoints;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.List;


public class MyStepdefsPayments {

    //private String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradepayments";
    private Response response = null;
    private ResponseBody responseBody = null;
    private RequestSpecification request = null;

    public MyStepdefsPayments() throws IOException {
    }


    @Given("^Realizamos una petición al endpoint user$")
    public void realizamos_una_petición_al_endpoint_user() throws IOException {


        String baseURI = utils.UtilsCommon.getBaseURIEnvironment() + WebServiceEndPoints.DOMAIN_ACCOUNTS.getUrl() + WebServiceEndPoints.GET_USER.getUrl();
        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get();

        UtilsPayments.compareUserAccount("user.json",response);
    }

    @When("^Realizamos una petición al endpoint GET Payment$")
    public void realizamosUnaPeticiónAlEndpointGETPayment() {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(utils.UtilsCommon.getBaseURIEnvironment() + WebServiceEndPoints.DOMAIN_PAYMENTS.getUrl() + WebServiceEndPoints.GET_PAYMENTS.getUrl());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);

    }

    @Then("^Nos devuelve la respuesta correcta$")
    public void nosDevuelveLaRespuestaCorrecta() throws FileNotFoundException {

        UtilsPayments.comparePayments("payments.json",response);

    }

    @When("^Realizamos una petición al endpoint con el criterio de busqueda PaymentID \"([^\"]*)\"$")
    public void realizamosUnaPeticiónAlEndpointConElCriterioDeBusquedaPaymentID(String arg0) throws Throwable {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(utils.UtilsCommon.getBaseURIEnvironment() + WebServiceEndPoints.DOMAIN_PAYMENTS.getUrl() + WebServiceEndPoints.GET_PAYMENTS_BY_ID.getUrl() + arg0);

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);
    }

    @Then("^Nos devuelve la respuesta con el criterio de busqueda PaymentID \"([^\"]*)\"$")
    public void nosDevuelveLaRespuestaConElCriterioDeBusquedaPaymentID(String arg0) throws Throwable {

        List<PaymentsList> paymentsLists;

        Payments payments = response.as(Payments.class, ObjectMapperType.GSON);

        paymentsLists = payments.getPaymentsList();

        for(int i = 0; i< paymentsLists.size(); i++){

            Assert.assertTrue(paymentsLists.get(i).getPaymentId().equals(arg0));

        }

    }

    @Then("^El servicio de payments MT103 nos devuelve la respuesta \"([^\"]*)\"$")
    public void elServicioPaymentsMT103NosDevuelveLaRespuesta(String expectedResponse) throws Throwable {
        UtilsPayments.comparaRespuestaMT103(expectedResponse, UtilsPayments.response);
    }

    @When("^Realizamos una petición al endpoint con el criterio de busqueda User account_id \"([^\"]*)\"$")
    public void realizamosUnaPeticiónAlEndpointConElCriterioDeBusquedaUserAccount_id(String arg0) throws Throwable {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(utils.UtilsCommon.getBaseURIEnvironment() + WebServiceEndPoints.DOMAIN_PAYMENTS.getUrl() + WebServiceEndPoints.GET_PAYMENTS_ACCOUNT_ID.getUrl() + arg0 + "&pageNumber=0&pageSize=1000");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);

    }

    @Then("^Nos devuelve la respuesta con el criterio de busqueda User account id \"([^\"]*)\"$")
    public void nosDevuelveLaRespuestaConElCriterioDeBusquedaUserAccountId(String arg0) throws Throwable {

        List<PaymentsList> paymentsLists;

        Payments payments = response.as(Payments.class, ObjectMapperType.GSON);

        paymentsLists = payments.getPaymentsList();

        for(int i = 0; i< paymentsLists.size(); i++){

            Assert.assertTrue(paymentsLists.get(i).getOriginatorData().getAccountId().equals(arg0));

        }

    }

    @Given("^El dominio de payments esta levantado$")
    public void elDominioDePaymentsEstaLevantado() {
        UtilsCommon.serviceIsUp("payments");
    }

    @When("^Se realiza un request \"([^\"]*)\" al endpoint payments con el parametro \"([^\"]*)\"$")
    public void seRealizaUnRequestAlEndpointPaymentsConElParametro(String arg0, String arg1){

            UtilsPayments.hagounapeticionGET(arg0,arg1);
    }

    @When("^Se realiza un request \"([^\"]*)\" al endpoint payments MT103 con el parametro \"([^\"]*)\"$")
    public void seRealizaUnRequestEndpointPaymentsMt103ConParametro(String request, String parameter){
        UtilsPayments.peticionPaymentsMt103(request, parameter);
    }
}
