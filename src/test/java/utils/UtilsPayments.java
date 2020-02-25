package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import schemas.Payments.*;
import schemas.Payments.Events.PaymentEvents;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UtilsPayments {

    public static Response response = null;

    public static void searchPayments(String httpMethod, String parameters, String values) {
        String query = getQuery(parameters, values);
        response = UtilsCommon.executeRequestWithParameters(httpMethod, query, "", "payments");
        assertEquals("Correct status code returned", 200, response.getStatusCode());
    }

    public static void peticionPaymentsMt103(String httpMethod, String path) {
        response = UtilsCommon.executeRequestWithPath(httpMethod, path, "events", "mt103");
        assertEquals("Correct status code returned", 200, response.getStatusCode());
    }

    public static void searchEventsPayments(String httpMethod, String path) {
        response = UtilsCommon.executeRequestWithPath(httpMethod, path, "events", "payments");
        assertEquals("Correct status code returned", 200, response.getStatusCode());
    }

    private static String getQuery(String parameters, String values) {
        String query;
        if (parameters.equals("account_id")) {
            query = "?" + parameters + "=" + values;
        } else {
            query = buildQuery(parameters, values);
        }
        return query + "&pageNumber=0&pageSize=1000";
    }

    private static String buildQuery(String parameters, String values) {
        String[] parametersArray = parameters.split(",");
        String[] valuesArray = values.split(",");
        StringBuilder query = new StringBuilder("?");
           for (int i = 0; i < parametersArray.length; i ++) {
               query.append(parametersArray[i]).append(",").
                       append(valuesArray[i]).append(",");
        }
        return StringUtils.chop(query.toString());
    }

    public static void comparePayments(String localJsonFilePath, Response httpResponse) throws FileNotFoundException {

        String path = "src/test/resources/json/" + localJsonFilePath;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Payments expectedPaymentsResponse = gson.fromJson(bufferedReader, Payments.class);
        Payments actualPaymentsResponse = httpResponse.as(Payments.class, ObjectMapperType.GSON);

        assertEquals("Payment Documents Found", expectedPaymentsResponse.getDocuments().getTotalRegistersFound(),
                actualPaymentsResponse.getDocuments().getTotalRegistersFound());
        assertEquals("Payment Documents Retrieved", expectedPaymentsResponse.getDocuments().getRetrieved(),
                actualPaymentsResponse.getDocuments().getRetrieved());
        assertAllPaymentsFields(actualPaymentsResponse.getPaymentsList(), expectedPaymentsResponse.getPaymentsList());
    }

    private static void assertAllPaymentsFields(List<PaymentsList> expectedPaymentsList,
                                                List<PaymentsList> actualPaymentsList) {

        actualPaymentsList.sort(Comparator.comparing(PaymentsList::getPaymentId));
        expectedPaymentsList.sort(Comparator.comparing(PaymentsList::getPaymentId));

        for (int i=0; i < actualPaymentsList.size(); i++) {
            assertEquals("Payment Id", expectedPaymentsList.get(i).getPaymentId(), actualPaymentsList.get(i).getPaymentId());
            assertEquals("Payment Transaction Status", expectedPaymentsList.get(i).getTransactionStatus().getStatus(),
                    actualPaymentsList.get(i).getTransactionStatus().getStatus());
            assertEquals("Payment Transaction Reason", expectedPaymentsList.get(i).getTransactionStatus().getReason(),
                    actualPaymentsList.get(i).getTransactionStatus().getReason());
            assertEquals("Payment Transaction Status Date", expectedPaymentsList.get(i).getStatusDate(),
                    actualPaymentsList.get(i).getStatusDate());
            assertEquals("Payment Transaction Cancellation Status",
                    expectedPaymentsList.get(i).getCancellationStatus().getTransactionCancellationStatus(),
                    actualPaymentsList.get(i).getCancellationStatus().getTransactionCancellationStatus());
            assertEquals("Payment Issue Date", expectedPaymentsList.get(i).getIssueDate(),
                    actualPaymentsList.get(i).getIssueDate());
            assertEquals("Payment Value Date", expectedPaymentsList.get(i).getValueDate(),
                    actualPaymentsList.get(i).getValueDate());
            assertEquals("Payment Amount", expectedPaymentsList.get(i).getPaymentAmount().getAmount(),
                    actualPaymentsList.get(i).getPaymentAmount().getAmount());
            assertEquals("Payment Currency", expectedPaymentsList.get(i).getPaymentAmount().getCurrency(),
                    actualPaymentsList.get(i).getPaymentAmount().getCurrency());
            assertPaymentOriginatorData(expectedPaymentsList.get(i).getOriginatorData(),
                    actualPaymentsList.get(i).getOriginatorData());
            assertPaymentBeneficiaryData(expectedPaymentsList.get(i).getBeneficiaryData(),
                    actualPaymentsList.get(i).getBeneficiaryData());
            assertEquals("Payment Tracker Detail", expectedPaymentsList.get(i).getPaymentTrackerDetailResponse(),
                    actualPaymentsList.get(i).getPaymentTrackerDetailResponse());
        }

    }

    private static void assertPaymentOriginatorData(OriginatorData expectedOriginatorData,
                                                    OriginatorData actualOriginatorData) {
        assertEquals("Originator Account Id", expectedOriginatorData.getAccountId(),
                actualOriginatorData.getAccountId());
        assertEquals("Originator Agent", expectedOriginatorData.getAgent(),
                actualOriginatorData.getAgent());
        assertEquals("Originator Agent Name", expectedOriginatorData.getAgentName(),
                actualOriginatorData.getAgentName());
        assertEquals("Originator Agent Country", expectedOriginatorData.getAgentCountry(),
                actualOriginatorData.getAgentCountry());
        assertEquals("Originator Agent Location", expectedOriginatorData.getAgentLocation(),
                actualOriginatorData.getAgentLocation());
    }

    private static void assertPaymentBeneficiaryData(BeneficiaryData expectedBeneficiaryData,
                                                     BeneficiaryData actualBeneficiaryData) {
        assertEquals("Beneficiary Name", expectedBeneficiaryData.getBeneficiaryName(),
                actualBeneficiaryData.getBeneficiaryName());
        assertEquals("Beneficiary Credit Account Type", expectedBeneficiaryData.getCreditorCreditAccount().getIdType(),
                actualBeneficiaryData.getCreditorCreditAccount().getIdType());
        assertEquals("Beneficiary Credit Account Id", expectedBeneficiaryData.getCreditorCreditAccount().getAccountId(),
                actualBeneficiaryData.getCreditorCreditAccount().getAccountId());
        assertEquals("Beneficiary Agent", expectedBeneficiaryData.getAgent(), actualBeneficiaryData.getAgent());
        assertEquals("Beneficiary Agent Name", expectedBeneficiaryData.getAgentName(),
                actualBeneficiaryData.getAgentName());
        assertEquals("Beneficiary Agent Country", expectedBeneficiaryData.getAgentCountry(),
                actualBeneficiaryData.getAgentCountry());
        assertEquals("Beneficiary Agent Location", expectedBeneficiaryData.getAgentLocation(),
                actualBeneficiaryData.getAgentLocation());
    }

    public static void comparaRespuestaMT103(String pathInput, Response jsonOutput) throws Exception {
        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        MT103 expectedMT103Response = gson.fromJson(bufferedReader, MT103.class);
        MT103 mt103Response = jsonOutput.as(MT103.class, ObjectMapperType.GSON);

        assertEquals(expectedMT103Response.getMt103CopyFile(), mt103Response.getMt103CopyFile());

    }

    public static void comparePaymentsEvents(String localJsonFilePath, Response httpResponse) throws FileNotFoundException {
        String path = "src/test/resources/json/" + localJsonFilePath;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        PaymentEvents expectedPaymentsResponse = gson.fromJson(bufferedReader, PaymentEvents.class);
        PaymentEvents actualPaymentsResponse = httpResponse.as(PaymentEvents.class, ObjectMapperType.GSON);

        assertEquals(expectedPaymentsResponse, actualPaymentsResponse);

    }

}
