package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import schemas.Transactions.Transactions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.junit.Assert.assertEquals;

public class UtilsEnterprise {

    public static Response response = null;

    public static void searchEnterpriseByID(String httpMethod, String parameter) {
        response = UtilsCommon.executeRequestWithParameters(httpMethod, parameter,WebServiceEndPoints.GET_ENTERPRISES_BY_ID.getUrl(), WebServiceEndPoints.DOMAIN_ENTERPRISE.getUrl());
        restAssuredThat(response -> response.statusCode(200));
    }

    public static void searchEnterpriseByInvalidID(String httpMethod, String parameter) {
        response = UtilsCommon.executeRequestWithParameters(httpMethod, parameter,WebServiceEndPoints.GET_ENTERPRISES_BY_ID.getUrl(), WebServiceEndPoints.DOMAIN_ENTERPRISE.getUrl());
        restAssuredThat(response -> response.statusCode(404));
    }

    public static void compareTransaction(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Transactions expectedTransactionsResponse = gson.fromJson(bufferedReader, Transactions.class);
        Transactions transactionsResponse = jsonOutput.as(Transactions.class, ObjectMapperType.GSON);

        assertEquals(transactionsResponse, expectedTransactionsResponse);

    }
}
