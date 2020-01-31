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
import schemas.Payments;
import schemas.PaymentsList;
import utils.Utils_Payments;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class MyStepdefs_Payments {

    private String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradepayments";
    private Response response = null;
    private ResponseBody responseBody = null;
    private RequestSpecification request = null;

    public MyStepdefs_Payments() throws IOException {
    }


    @Given("^Realizamos una petición al endpoint user$")
    public void realizamos_una_petición_al_endpoint_user() throws IOException {


        baseURI = "https://gts-kong.sgcto-int.stratio.com/onetradeaccounts/users/1/accounts";
        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get();

        Utils_Payments.compareUserAccount("user.json",response);


    }


    @Given("^El dominio de Payment esta levantado$")
    public void elDominioDePaymentEstaLevantado() throws FileNotFoundException {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(baseURI + "/payments?pageNumber=0&pageSize=1000&status=ACSP");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);

    }

    @When("^Realizamos una petición al endpoint GET Payment$")
    public void realizamosUnaPeticiónAlEndpointGETPayment() {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(baseURI + "/payments?pageNumber=0&pageSize=1000&status=ACSP");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);




    }

    @Then("^Nos devuelve la respuesta correcta$")
    public void nosDevuelveLaRespuestaCorrecta() throws FileNotFoundException {

        Utils_Payments.comparePayments("payments.json",response);

    }

    @When("^Realizamos una petición al endpoint con el criterio de busqueda PaymentID \"([^\"]*)\"$")
    public void realizamosUnaPeticiónAlEndpointConElCriterioDeBusquedaPaymentID(String arg0) throws Throwable {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(baseURI + "/payments?pageNumber=0&pageSize=1000&paymentId=" + arg0);

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

    @When("^Realizamos una petición al endpoint con el criterio de busqueda User account_id \"([^\"]*)\"$")
    public void realizamosUnaPeticiónAlEndpointConElCriterioDeBusquedaUserAccount_id(String arg0) throws Throwable {

        request = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123","X-B3-SpanId","123","X-B3-TraceId","123");

        response = request.get(baseURI + "/payments?account_id=" + arg0 + "&pageNumber=0&pageSize=1000");

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

}
