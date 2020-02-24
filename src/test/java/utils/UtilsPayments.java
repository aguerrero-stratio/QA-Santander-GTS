package utils;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import schemas.Payments.BeneficiaryData;
import schemas.Payments.OriginatorData;
import schemas.Payments.Payments;
import schemas.Payments.PaymentsList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UtilsPayments {

    public static Response response = null;


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

        assertEquals("Payment Documents Found", paymentsResponse.getDocuments().getTotalRegistersFound(),
                expectedPaymentsResponse.getDocuments().getTotalRegistersFound());
        assertEquals("Payment Documents Retrieved", paymentsResponse.getDocuments().getRetrieved(),
                expectedPaymentsResponse.getDocuments().getRetrieved());
        assertAllPaymentsFields(paymentsResponse.getPaymentsList(), expectedPaymentsResponse.getPaymentsList());
    }


    private static void assertAllPaymentsFields(List<PaymentsList> paymentsList, List<PaymentsList> expectedPaymentList) {

        paymentsList.sort(Comparator.comparing(PaymentsList::getPaymentId));
        expectedPaymentList.sort(Comparator.comparing(PaymentsList::getPaymentId));

        for (int i=0; i < paymentsList.size(); i++) {
            assertEquals("Payment Id", paymentsList.get(i).getPaymentId(), expectedPaymentList.get(i).getPaymentId());
            assertEquals("Payment Transaction Status", paymentsList.get(i).getTransactionStatus().getStatus(),
                    expectedPaymentList.get(i).getTransactionStatus().getStatus());
            assertEquals("Payment Transaction Reason", paymentsList.get(i).getTransactionStatus().getReason(),
                    expectedPaymentList.get(i).getTransactionStatus().getReason());
            assertEquals("Payment Transaction Status Date", paymentsList.get(i).getStatusDate(),
                    expectedPaymentList.get(i).getStatusDate());
            assertEquals("Payment Transaction Cancellation Status",
                    paymentsList.get(i).getCancellationStatus().getTransactionCancellationStatus(),
                    expectedPaymentList.get(i).getCancellationStatus().getTransactionCancellationStatus());
            assertEquals("Payment Issue Date", paymentsList.get(i).getIssueDate(),
                    expectedPaymentList.get(i).getIssueDate());
            assertEquals("Payment Value Date", paymentsList.get(i).getValueDate(),
                    expectedPaymentList.get(i).getValueDate());
            assertEquals("Payment Amount", paymentsList.get(i).getPaymentAmount().getAmount(),
                    expectedPaymentList.get(i).getPaymentAmount().getAmount());
            assertEquals("Payment Currency", paymentsList.get(i).getPaymentAmount().getCurrency(),
                    expectedPaymentList.get(i).getPaymentAmount().getCurrency());
            assertPaymentOriginatorData(paymentsList.get(i).getOriginatorData(),
                    expectedPaymentList.get(i).getOriginatorData());
            assertPaymentBeneficiaryData(paymentsList.get(i).getBeneficiaryData(),
                    expectedPaymentList.get(i).getBeneficiaryData());
            assertEquals("Payment Tracker Detail", paymentsList.get(i).getPaymentTrackerDetailResponse(),
                    expectedPaymentList.get(i).getPaymentTrackerDetailResponse());
        }

    }

    private static void assertPaymentOriginatorData(OriginatorData originatorData, OriginatorData expectedOriginatorData) {
        assertEquals("Originator Account Id", originatorData.getAccountId(), expectedOriginatorData.getAccountId());
        assertEquals("Originator Agent", originatorData.getAgent(), expectedOriginatorData.getAgent());
        assertEquals("Originator Agent Name", originatorData.getAgentName(), expectedOriginatorData.getAgentName());
        assertEquals("Originator Agent Country", originatorData.getAgentCountry(), expectedOriginatorData.getAgentCountry());
        assertEquals("Originator Agent Location", originatorData.getAgentLocation(), expectedOriginatorData.getAgentLocation());
    }

    private static void assertPaymentBeneficiaryData(BeneficiaryData beneficiaryData,
                                                     BeneficiaryData expectedBeneficiaryData) {
        assertEquals("Beneficiary Name", beneficiaryData.getBeneficiaryName(), expectedBeneficiaryData.getBeneficiaryName());
        assertEquals("Beneficiary Credit Account Type", beneficiaryData.getCreditorCreditAccount().getIdType(),
                expectedBeneficiaryData.getCreditorCreditAccount().getIdType());
        assertEquals("Beneficiary Credit Account Id", beneficiaryData.getCreditorCreditAccount().getAccountId(),
                expectedBeneficiaryData.getCreditorCreditAccount().getAccountId());
        assertEquals("Beneficiary Agent", beneficiaryData.getAgent(), expectedBeneficiaryData.getAgent());
        assertEquals("Beneficiary Agent Name", beneficiaryData.getAgentName(), expectedBeneficiaryData.getAgentName());
        assertEquals("Beneficiary Agent Country", beneficiaryData.getAgentCountry(), expectedBeneficiaryData.getAgentCountry());
        assertEquals("Beneficiary Agent Location", beneficiaryData.getAgentLocation(), expectedBeneficiaryData.getAgentLocation());
    }


}
