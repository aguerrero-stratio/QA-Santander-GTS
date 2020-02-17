package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import schemas.Accounts.Accounts;
import schemas.Accounts.AccountsList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class UtilsAccounts {

    public static Response response = null;

    public static void searchAccounts(String httpMethod, String httpBody) {
        response = UtilsCommon.executeRequestWithBody(httpMethod, httpBody, WebServiceEndPoints.SEARCH.getUrl(),
                WebServiceEndPoints.DOMAIN_ACCOUNTS.getUrl());
        assertEquals("Correct status code returned",  200, response.getStatusCode());
    }

    public static void compareAccounts(String pathInput, Response jsonOutput) throws Exception {
        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        Accounts expectedAccountsResponse = gson.fromJson(bufferedReader, Accounts.class);
        Accounts accountsResponse = jsonOutput.as(Accounts.class, ObjectMapperType.GSON);

        if (matchNoExistingAccount(pathInput)) {
            compareNoExistingAccounts(accountsResponse.getAccountsList(), expectedAccountsResponse.getAccountsList());
        } else {
            assertAllAccountsFields(accountsResponse.getAccountsList(), expectedAccountsResponse.getAccountsList());
        }
    }


    private static void assertAllAccountsFields(List<AccountsList> accountsResponse,
                                         List<AccountsList> expectedAccountsResponse) throws Exception {
        if (accountsResponse.stream().noneMatch(Objects::nonNull)) {
            throw new Exception("Data source has only null values for Accounts domain");
        }
        expectedAccountsResponse.sort(Comparator.comparing(AccountsList::getAccountId));
        accountsResponse.sort(Comparator.comparing(AccountsList::getAccountId));
        for (int i=0; i < accountsResponse.size(); i++) {
            assertEquals("Accounts AccountId", accountsResponse.get(i).getAccountId(),
                    expectedAccountsResponse.get(i).getAccountId());
            assertEquals("Accounts Display Number", accountsResponse.get(i).getDisplayNumber(),
                    expectedAccountsResponse.get(i).getDisplayNumber());
            assertEquals("Accounts Alias", accountsResponse.get(i).getAlias(),
                    expectedAccountsResponse.get(i).getAlias());
            assertEquals("Accounts Type", accountsResponse.get(i).getType(),
                    expectedAccountsResponse.get(i).getType());
            assertEquals("Accounts Description", accountsResponse.get(i).getDescription(),
                    expectedAccountsResponse.get(i).getDescription());
            assertEquals("Accounts Status", accountsResponse.get(i).getStatus(),
                    expectedAccountsResponse.get(i).getStatus());
            assertEquals("Accounts Country", accountsResponse.get(i).getCountry(),
                    expectedAccountsResponse.get(i).getCountry());
            assertEquals("Accounts Agent", accountsResponse.get(i).getAgent(),
                    expectedAccountsResponse.get(i).getAgent());
            assertEquals("Accounts Agent Description", accountsResponse.get(i).getAgentDescription(),
                    expectedAccountsResponse.get(i).getAgentDescription());
            assertEquals("Accounts Corporate Name", accountsResponse.get(i).getCorporateName(),
                    expectedAccountsResponse.get(i).getCorporateName());
            assertEquals("Accounts Subsidiary Name", accountsResponse.get(i).getSubsidiaryName(),
                    expectedAccountsResponse.get(i).getSubsidiaryName());
            assertEquals("Accounts Last Transaction Date", accountsResponse.get(i).getLastTransactionDate(),
                    expectedAccountsResponse.get(i).getLastTransactionDate());
            assertEquals("Accounts Amount Main Balance", accountsResponse.get(i).getAmountMainBalance(),
                    expectedAccountsResponse.get(i).getAmountMainBalance());
            assertEquals("Accounts Currency Code Main Balance",
                    accountsResponse.get(i).getCurrencyCodeMainBalance(),
                    expectedAccountsResponse.get(i).getCurrencyCodeMainBalance());
            assertEquals("Accounts Last Update Main Balance",
                    accountsResponse.get(i).getLastUpdateMainBalance(),
                    expectedAccountsResponse.get(i).getLastUpdateMainBalance());
            assertEquals("Accounts Amount Available Balance",
                    accountsResponse.get(i).getAmountAvailableBalance(),
                    expectedAccountsResponse.get(i).getAmountAvailableBalance());
            assertEquals("Accounts Currency Code Available Balance",
                    accountsResponse.get(i).getCurrencyCodeAvailableBalance(),
                    expectedAccountsResponse.get(i).getCurrencyCodeAvailableBalance());
            assertEquals("Accounts Last Update Available Balance",
                    accountsResponse.get(i).getCurrencyCodeAvailableBalance(),
                    expectedAccountsResponse.get(i).getCurrencyCodeAvailableBalance());
            assertEquals("Accounts Amount Pending Balance", accountsResponse.get(i).getAmountPendingBalance(),
                    expectedAccountsResponse.get(i).getAmountPendingBalance());
            assertEquals("Accounts Currency Code Pending Balance",
                    accountsResponse.get(i).getCurrencyCodePendingBalance(),
                    expectedAccountsResponse.get(i).getCurrencyCodePendingBalance());
            assertEquals("Accounts Last Update Pending Balance",
                    accountsResponse.get(i).getLastUpdatePendingBalance(),
                    expectedAccountsResponse.get(i).getLastUpdatePendingBalance());
            assertEquals("Accounts Amount With Holding Balance",
                    accountsResponse.get(i).getAmountWithholdingBalance(),
                    expectedAccountsResponse.get(i).getAmountWithholdingBalance());
            assertEquals("Accounts Currency Code With Holding Balance",
                    accountsResponse.get(i).getCurrencyCodeWithholdingBalance(),
                    expectedAccountsResponse.get(i).getCurrencyCodeWithholdingBalance());
            assertEquals("Accounts Last Update With Holding Balance",
                    accountsResponse.get(i).getLastUpdateWithholdingBalance(),
                    expectedAccountsResponse.get(i).getLastUpdateWithholdingBalance());
            assertEquals("Accounts Amount Over Draft Limit", accountsResponse.get(i).getAmountOverdraftLimit(),
                    expectedAccountsResponse.get(i).getAmountOverdraftLimit());
            assertEquals("Accounts Currency CodeOverdraft Limit",
                    accountsResponse.get(i).getAmountOverdraftLimit(),
                    expectedAccountsResponse.get(i).getAmountOverdraftLimit());
            assertEquals("Accounts Last Update Overdraft Limit",
                    accountsResponse.get(i).getLastUpdateOverdraftLimit(),
                    expectedAccountsResponse.get(i).getLastUpdateOverdraftLimit());
            assertEquals("Accounts Last Update Swift Payment",
                    accountsResponse.get(i).getLastUpdateSwiftPayment(),
                    expectedAccountsResponse.get(i).getLastUpdateSwiftPayment());
            assertEquals("Accounts Has Swift Payments",
                    accountsResponse.get(i).getHasSwiftPayments(),
                    expectedAccountsResponse.get(i).getHasSwiftPayments());
        }
    }

    private static void compareNoExistingAccounts (List<AccountsList> accountsResponse,
                                                   List<AccountsList> expectedAccountsResponse) {
        boolean accountsResponseNullsOnly = accountsResponse.stream().noneMatch(Objects::nonNull);
        boolean expectedAccountsResponseNullsOnly = expectedAccountsResponse.stream().noneMatch(Objects::nonNull);
        assertEquals(accountsResponseNullsOnly,expectedAccountsResponseNullsOnly);
    }

    private static boolean matchNoExistingAccount(String pathInput) {
        Pattern pattern = Pattern.compile("NoExisting\\w+.json");
        Matcher matcher = pattern.matcher(pathInput);
        return matcher.find();
    }

}
