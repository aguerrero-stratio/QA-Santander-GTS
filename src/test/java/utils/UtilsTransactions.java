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

    public static void compareTransaction(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Transactions expectedTransactionsResponse = gson.fromJson(bufferedReader, Transactions.class);
        Transactions transactionsResponse = jsonOutput.as(Transactions.class, ObjectMapperType.GSON);

        assertEquals(transactionsResponse, expectedTransactionsResponse);

    }



}
