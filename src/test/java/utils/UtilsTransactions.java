package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import schemas.Transactions.Transactions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;


public class UtilsTransactions {

    public static Response response = null;


    public static void compareTransaction(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Transactions expectedTransactionsResponse = gson.fromJson(bufferedReader, Transactions.class);
        Transactions transactionsResponse = jsonOutput.as(Transactions.class, ObjectMapperType.GSON);

        assertEquals(transactionsResponse, expectedTransactionsResponse);

    }

    public static void searchTransactions(String httpMethod, String httpBody) {

       /* Response responseTest = RestAssured.given().relaxedHTTPSValidation().headers("X-B3-ParentSpanId","123","X-B3-Sampled","123",
                "X-B3-SpanId","123","X-B3-TraceId","123",
                "accept", "", "Content-Type", "application/json").body("{\n" +
                "  \"_from\": 0,\n" +
                "  \"_limit\": 1000,\n" +
                "  \"accountsCountriesList\": [\n" +
                "    {\n" +
                "      \"accountId\": \"4\",\n" +
                "      \"country\": \"EN\"\n" +
                "    }\n" +
                "  ]\n" +
                "}").post("https://gts-kong.sgcto-int.stratio.com/onetradetransactions/transactions/accounts/search"); */


        response = UtilsCommon.executeRequest(httpMethod, httpBody,"/accounts/search", "transactions");

        assertEquals("Correct status code returned",  200, response.getStatusCode());
    }

}
