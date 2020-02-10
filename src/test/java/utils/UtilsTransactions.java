package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import schemas.Accounts.Accounts;
import schemas.Accounts.AccountsList;
import schemas.Transactions.Transactions;
import schemas.Transactions.TransactionsListResponse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class UtilsTransactions {

    private static List<TransactionsListResponse> itemLists;
    private static List<TransactionsListResponse> itemListsFile;

    public static void compareTransaction(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();

        Transactions json = gson.fromJson(bufferedReader, Transactions.class);

        Transactions transactions = jsonOutput.as(Transactions.class, ObjectMapperType.GSON);

        itemLists = transactions.getTransactionsListResponse();
        itemListsFile = json.getTransactionsListResponse();


        for(int i = 0; i< itemLists.size(); i++){

            TransactionsListResponse item = itemLists.get(i);
            TransactionsListResponse itemFile = itemListsFile.get(i);

            if(item.equals(itemFile)){

                System.out.println("Transaction Nº " + i + " es correcta");

            }else{
                System.out.println("Transaction Nº " + i + " es incorrecta");

            }

        }
    }



}
