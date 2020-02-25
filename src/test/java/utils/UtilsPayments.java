package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import schemas.Payments.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UtilsPayments {

    public static Response response = null;

    public static void comparaRespuestaMT103(String pathInput, Response jsonOutput) throws Exception {
        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        MT103 expectedMT103Response = gson.fromJson(bufferedReader, MT103.class);
        MT103 mt103Response = jsonOutput.as(MT103.class, ObjectMapperType.GSON);

        assertEquals(expectedMT103Response.getMt103CopyFile(), mt103Response.getMt103CopyFile());

    }

    public static void searchPayments(String httpMethod, String parameters, String values) throws InterruptedException {
        String query = getQuery(parameters, values);
        response = UtilsCommon.executeRequestWithParameters(httpMethod, query,
                "", "payments");
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

    public static void comparePayments(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Payments expectedPaymentsResponse = gson.fromJson(bufferedReader, Payments.class);
        Payments paymentsResponse = jsonOutput.as(Payments.class, ObjectMapperType.GSON);

        assertEquals("Payment Documents Found", expectedPaymentsResponse.getDocuments().getTotalRegistersFound(),
                paymentsResponse.getDocuments().getTotalRegistersFound());
        assertEquals("Payment Documents Retrieved", expectedPaymentsResponse.getDocuments().getRetrieved(),
                paymentsResponse.getDocuments().getRetrieved());
        assertAllPaymentsFields(paymentsResponse.getPaymentsList(), expectedPaymentsResponse.getPaymentsList());
    }


    private static void assertAllPaymentsFields(List<PaymentsList> expectedPaymentsList, List<PaymentsList> paymentsList) {

        paymentsList.sort(Comparator.comparing(PaymentsList::getPaymentId));
        expectedPaymentsList.sort(Comparator.comparing(PaymentsList::getPaymentId));

        for (int i=0; i < paymentsList.size(); i++) {
            assertEquals("Payment Id", expectedPaymentsList.get(i).getPaymentId(), paymentsList.get(i).getPaymentId());
            assertEquals("Payment Transaction Status", expectedPaymentsList.get(i).getTransactionStatus().getStatus(),
                    paymentsList.get(i).getTransactionStatus().getStatus());
            assertEquals("Payment Transaction Reason", expectedPaymentsList.get(i).getTransactionStatus().getReason(),
                    paymentsList.get(i).getTransactionStatus().getReason());
            assertEquals("Payment Transaction Status Date", expectedPaymentsList.get(i).getStatusDate(),
                    paymentsList.get(i).getStatusDate());
            assertEquals("Payment Transaction Cancellation Status",
                    expectedPaymentsList.get(i).getCancellationStatus().getTransactionCancellationStatus(),
                    paymentsList.get(i).getCancellationStatus().getTransactionCancellationStatus());
            assertEquals("Payment Issue Date", expectedPaymentsList.get(i).getIssueDate(),
                    paymentsList.get(i).getIssueDate());
            assertEquals("Payment Value Date", expectedPaymentsList.get(i).getValueDate(),
                    paymentsList.get(i).getValueDate());
            assertEquals("Payment Amount", expectedPaymentsList.get(i).getPaymentAmount().getAmount(),
                    paymentsList.get(i).getPaymentAmount().getAmount());
            assertEquals("Payment Currency", expectedPaymentsList.get(i).getPaymentAmount().getCurrency(),
                    paymentsList.get(i).getPaymentAmount().getCurrency());
            assertPaymentOriginatorData(expectedPaymentsList.get(i).getOriginatorData(),
                    paymentsList.get(i).getOriginatorData());
            assertPaymentBeneficiaryData(expectedPaymentsList.get(i).getBeneficiaryData(),
                    paymentsList.get(i).getBeneficiaryData());
            assertEquals("Payment Tracker Detail", expectedPaymentsList.get(i).getPaymentTrackerDetailResponse(),
                    paymentsList.get(i).getPaymentTrackerDetailResponse());
        }

    }

    private static void assertPaymentOriginatorData(OriginatorData expectedOriginatorData, OriginatorData originatorData) {
        assertEquals("Originator Account Id", expectedOriginatorData.getAccountId(), originatorData.getAccountId());
        assertEquals("Originator Agent", expectedOriginatorData.getAgent(), originatorData.getAgent());
        assertEquals("Originator Agent Name", expectedOriginatorData.getAgentName(), originatorData.getAgentName());
        assertEquals("Originator Agent Country", expectedOriginatorData.getAgentCountry(), originatorData.getAgentCountry());
        assertEquals("Originator Agent Location", expectedOriginatorData.getAgentLocation(), originatorData.getAgentLocation());
    }

    private static void assertPaymentBeneficiaryData(BeneficiaryData expectedBeneficiaryData,
                                                     BeneficiaryData beneficiaryData) {
        assertEquals("Beneficiary Name", expectedBeneficiaryData.getBeneficiaryName(),
                beneficiaryData.getBeneficiaryName());
        assertEquals("Beneficiary Credit Account Type", expectedBeneficiaryData.getCreditorCreditAccount().getIdType(),
                beneficiaryData.getCreditorCreditAccount().getIdType());
        assertEquals("Beneficiary Credit Account Id", expectedBeneficiaryData.getCreditorCreditAccount().getAccountId(),
                beneficiaryData.getCreditorCreditAccount().getAccountId());
        assertEquals("Beneficiary Agent", expectedBeneficiaryData.getAgent(), beneficiaryData.getAgent());
        assertEquals("Beneficiary Agent Name", expectedBeneficiaryData.getAgentName(),
                beneficiaryData.getAgentName());
        assertEquals("Beneficiary Agent Country", expectedBeneficiaryData.getAgentCountry(),
                beneficiaryData.getAgentCountry());
        assertEquals("Beneficiary Agent Location", expectedBeneficiaryData.getAgentLocation(),
                beneficiaryData.getAgentLocation());
    }

    public static void peticionPaymentsMt103(String petition, String parameter){
        response = UtilsCommon.executeRequestWithParametersMt103(petition, parameter,"","payments", "mt103");
    }



}
