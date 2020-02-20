package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import schemas.Accounts.Accounts;
import schemas.Accounts.AccountsList;
import schemas.Payments.Payments;
import schemas.Payments.PaymentsList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;


public class UtilsPayments {

    private static List<AccountsList> itemLists;
    private static List<AccountsList> itemListsFile;
    public static Response response = null;


    public static void compareUserAccount(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Accounts json = gson.fromJson(bufferedReader, Accounts.class);

        Accounts accounts = jsonOutput.as(Accounts.class, ObjectMapperType.GSON);

        itemLists = accounts.getAccountsList();
        itemListsFile = json.getAccountsList();


        for (int i = 0; i < itemLists.size(); i++) {

            AccountsList item = itemLists.get(i);
            AccountsList itemFile = itemListsFile.get(i);

            if (item.equals(itemFile)) {

                System.out.println("Cuenta Nº " + i + " es correcta");

            } else {
                System.out.println("Cuenta Nº " + i + " es incorrecta");

            }

        }
    }

    public static void searchPayments(String httpMethod, String parameters, String filters) {

        response = UtilsCommon.executeRequestWithParameters(httpMethod, parameters + "&pageNumber=0&pageSize=1000", "", "payments");

        assertEquals("Correct status code returned", 200, response.getStatusCode());
    }

    public static void comparePayments(String pathInput, Response jsonOutput) throws FileNotFoundException {

        List<PaymentsList> paymentsLists;
        List<PaymentsList> paymentsListsFile;

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Payments json = gson.fromJson(bufferedReader, Payments.class);

        Payments payments = jsonOutput.as(Payments.class, ObjectMapperType.GSON);

        paymentsLists = payments.getPaymentsList();
        paymentsListsFile = json.getPaymentsList();


        for (int i = 0; i < paymentsLists.size(); i++) {

            PaymentsList item = paymentsLists.get(i);
            PaymentsList itemFile = paymentsListsFile.get(i);

            if (item.equals(itemFile)) {
                System.out.println("Payment Nº " + i + " es correcta");
            } else {
                fail("Payment Nº " + i + " es incorrecta");
            }

        }
    }


    public static void hagounapeticionGET(String arg0, String arg1) {

        response = UtilsCommon.executeRequestWithParameters(arg0,"?"+arg1 +"&pageNumber=0&pageSize=1000","","payments");

        System.out.println("RESPONSE: "+ response.asString());
    }


}
