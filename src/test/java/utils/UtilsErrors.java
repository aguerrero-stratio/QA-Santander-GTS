package utils;

import com.google.common.collect.ImmutableMap;
import io.restassured.response.Response;
import org.openqa.selenium.InvalidArgumentException;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilsErrors {

    private static Response response = null;

    private static Map<String, Integer> httpErrorCodes
            = ImmutableMap.of("Bad Request", 400, "Not Found", 404,
            "Method Not Allowed", 405, "Unauthorized", 401,
            "Forbidden", 403);


    public static void errorRequest(String httpMethod, String httpErrorMessage, String domain, String endPoint) {
       String httpBody = getHttpBody(httpErrorMessage);
       String mutatedHttpMethod = mutatesHttpMethod(httpMethod, httpErrorMessage);

       response = UtilsCommon.executeRequest(mutatedHttpMethod, httpBody, endPoint, domain);
       Integer expectedStatusCode = getStatusCode(httpErrorMessage).orElseThrow(() ->
               new InvalidArgumentException("Error Request Message Not Found"));
       Integer statusCode = response.getStatusCode();

       assertEquals("Correct status code returned",  expectedStatusCode, statusCode);
    }

    public static void verifyErrorResponse(String httpErrorMessage) {
        assertTrue(response.getBody().asString().contains(httpErrorMessage));
    }

    private static Optional<Integer> getStatusCode(String httpErrorMessage) {
        return Optional.of(httpErrorCodes.get(httpErrorMessage));
    }

    private static String mutatesHttpMethod(String httpMethod, String httpErrorMessage) {
        if (httpErrorMessage.equals("Method Not Allowed")) {
            return httpMethod.equals("POST") ? "GET" : "POST";
        }
        return httpMethod;
    }

    private static String getHttpBody(String httpErrorMessage) {
        if (httpErrorMessage.equals("Bad Request")) {
            return "HttpErrors/Input/badRequest.json";
        }
        return "HttpErrors/Input/emptyRequest.json";
    }

}
