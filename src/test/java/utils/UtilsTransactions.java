package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import schemas.Transactions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class UtilsTransactions {

    public static Response response = null;

    public static void searchTransactions(String httpMethod, String httpBody) {
        response = UtilsCommon.executeRequestWithBody(httpMethod, httpBody,WebServiceEndPoints.ACCOUNT_SEARCH.getUrl(),
                WebServiceEndPoints.DOMAIN_TRANSACTION.getUrl());
        assertEquals("Correct status code returned",  200, response.getStatusCode());
    }

    public static void compareTransaction(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Transactions expectedTransactionsResponse = gson.fromJson(bufferedReader, Transactions.class);
        Transactions transactionsResponse = jsonOutput.as(Transactions.class, ObjectMapperType.GSON);

        assertTransactionDocuments(transactionsResponse.getDocuments(), expectedTransactionsResponse.getDocuments());

        if (UtilsCommon.matchNullValues(pathInput, "noneTransactions")) {
            assertNull("None Transactions Values", expectedTransactionsResponse.getTransactionsListResponse());
            assertEquals(transactionsResponse.getTransactionsListResponse(),
                         expectedTransactionsResponse.getTransactionsListResponse());
        } else {
            assertTransactionsList(transactionsResponse.getTransactionsListResponse(),
                    expectedTransactionsResponse.getTransactionsListResponse());
        }

    }

    private static void assertTransactionDocuments(Documents documents, Documents expectedDocuments) {
        assertEquals("Transaction Documents Retrieved", documents.getRetrieved(), expectedDocuments.getRetrieved());
        assertEquals("Transaction Documents Total Registers Found", documents.getTotalRegistersFound(),
                expectedDocuments.getTotalRegistersFound());
    }

    private static void assertTransactionsList(List<TransactionsListResponse> transactionsListResponse,
                                               List<TransactionsListResponse> expectedTransactionsListResponse) {
        expectedTransactionsListResponse.sort(Comparator.comparing(TransactionsListResponse::getAccountId));
        transactionsListResponse.sort(Comparator.comparing(TransactionsListResponse::getAccountId));
        for (int i = 0; i < transactionsListResponse.size(); i++) {
            assertEquals("Transactions List Account Id", transactionsListResponse.get(i).getAccountId(),
                    expectedTransactionsListResponse.get(i).getAccountId());
            assertEquals("Transactions List Display Number", transactionsListResponse.get(i).getDisplayNumber(),
                    expectedTransactionsListResponse.get(i).getDisplayNumber());
            assertEquals("Transactions List Alias", transactionsListResponse.get(i).getAlias(),
                    expectedTransactionsListResponse.get(i).getAlias());
            assertEquals("Transactions List Country", transactionsListResponse.get(i).getCountry(),
                    expectedTransactionsListResponse.get(i).getCountry());
            assertEquals("Transactions List Agent", transactionsListResponse.get(i).getAgent(),
                    expectedTransactionsListResponse.get(i).getAgent());
            assertTransactionsDataList(transactionsListResponse.get(i).getTransactionsDataList(),
                    expectedTransactionsListResponse.get(i).getTransactionsDataList());
        }
    }

    private static void assertTransactionsDataList(List<TransactionsDataList> transactionsDataList,
                                                   List<TransactionsDataList> expectedTransactionsDataList) {

        transactionsDataList.sort(Comparator.comparing(transactionsData ->
                transactionsData.getTransactionDetails().getTransactionId()));
        expectedTransactionsDataList.sort(Comparator.comparing(transactionsData ->
                transactionsData.getTransactionDetails().getTransactionId()));
        for (int i = 0; i < transactionsDataList.size(); i++) {
            assertEquals("Transactions Data TransactionId",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionId(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionId());
            assertEquals("Transactions Data Creation Date",
                    transactionsDataList.get(i).getTransactionDetails().getCreationDate(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getCreationDate());
            assertEquals("Transactions Data Processed Date",
                    transactionsDataList.get(i).getTransactionDetails().getProcessedDate(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getProcessedDate());
            assertEquals("Transactions Data Accounting Date",
                    transactionsDataList.get(i).getTransactionDetails().getAccountingDate(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getAccountingDate());
            assertEquals("Transactions Data Description",
                    transactionsDataList.get(i).getTransactionDetails().getDescription(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getDescription());
            assertEquals("Transactions Data Transaction Type",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionType(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionType());
            assertEquals("Transactions Data Transaction Category",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionCategory(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionCategory());
            assertEquals("Transactions Transaction Consolidated",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionConsolidated(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionConsolidated());
            assertEquals("Transactions Transaction Amount",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionAmount(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionAmount());
            assertEquals("Transactions Transaction Amount Currency",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionAmountCurrency(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionAmountCurrency());
            assertEquals("Transactions Transaction Balance Amount",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionBalanceAmount(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionBalanceAmount());
            assertEquals("Transactions Transaction Balance Amount Currency",
                    transactionsDataList.get(i).getTransactionDetails().getTransactionAmountCurrency(),
                    expectedTransactionsDataList.get(i).getTransactionDetails().getTransactionAmountCurrency());
            assertReferences(transactionsDataList.get(i).getTransactionDetails().getReferences(),
                            expectedTransactionsDataList.get(i).getTransactionDetails().getReferences());
            assertOperation(transactionsDataList.get(i).getTransactionDetails().getOperation(),
                            expectedTransactionsDataList.get(i).getTransactionDetails().getOperation());
        }
    }

    private static void assertReferences(References references, References expectedReferences) {
        assertEquals("References Transaction Batch Reference", references.getTransactionBatchReference(),
                expectedReferences.getTransactionBatchReference());
        assertEquals("References Transaction Client Reference", references.getTransactionClientReference(),
                expectedReferences.getTransactionClientReference());
        assertEquals("References Transaction Internal Reference", references.getTransactionInternalReference(),
                expectedReferences.getTransactionInternalReference());
    }

    private static void assertOperation(Operation operation, Operation expectedOperation) {
        assertEquals("Operation Swift Code", operation.getSwiftCode(), expectedOperation.getSwiftCode());
        assertEquals("Operation Local Transaction Code",
                operation.getLocalOperation().getLocalTransactionCode(),
                expectedOperation.getLocalOperation().getLocalTransactionCode());
        assertEquals("Operation Local Transaction Description",
                operation.getLocalOperation().getLocalTransactionDescription(),
                expectedOperation.getLocalOperation().getLocalTransactionDescription());
        assertEquals("Operation Additional Information",
                operation.getLocalOperation().getAdditionalInformation(),
                expectedOperation.getLocalOperation().getAdditionalInformation());
        assertEquals("Operation Customer Additional Information",
                operation.getCustomerOperation().getCustomerAdditionalInformation(),
                expectedOperation.getCustomerOperation().getCustomerAdditionalInformation());
        assertEquals("Operation Customer Transaction Code",
                operation.getCustomerOperation().getCustomerTransactionCode(),
                expectedOperation.getCustomerOperation().getCustomerTransactionCode());
        assertEquals("Operation Customer Transaction Description",
                operation.getCustomerOperation().getCustomerTransactionDescription(),
                expectedOperation.getCustomerOperation().getCustomerTransactionDescription());
    }

}
