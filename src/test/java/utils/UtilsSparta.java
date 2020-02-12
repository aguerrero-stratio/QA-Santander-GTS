package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static net.serenitybdd.rest.RestRequests.given;

public class UtilsSparta {

    // Ejecución script para obtener el usuario y el mesosphere_id necesario para conectarnos a la API de Sparta
    static Process p;

    static {
        try {
            p = Runtime.getRuntime().exec("python3 /home/jmtaborda/Documentos/Workspace/QA-Santander-GTS/src/test/resources/scripts/sso.py --url https://gts-sparta.sgcto-int.stratio.com/gts-sparta/#/ --user sparta --password stratio");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedReader stdInput = new BufferedReader(new
            InputStreamReader(p.getInputStream()));

    private static String outputScript;

    static {
        try {
            outputScript = stdInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // División de la respuesta del script para tener el usuario y el mesosphere_id por separado
    private static String[] primerSplit = outputScript.split(": ");
    private static String outputSplit = primerSplit[1];
    private static String[] segundoSplit = outputSplit.split("; ");
    private static String mesosphere = segundoSplit[0];
    private static String user = segundoSplit[1];
    private static String getIdExecutionforQR;

    // Variables globales
    private static Response resQueryExecution = null;
    private static String baseURI = "https://gts-sparta.sgcto-int.stratio.com:443/gts-sparta";
    private ValidatableResponse validatableResponse = null;
    private Response res;
    //******************************************************//
    private static Request request = null;
    private static Response response = null;
    private static RequestSpecification httpRequest = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when();

    public UtilsSparta() throws IOException {
    }

    private static String getidExecutionforQR(){

            return getIdExecutionforQR;
    }

    private static void setidExecutionforQR(String getIdExecutionforQR){

        UtilsSparta.getIdExecutionforQR = getIdExecutionforQR;
    }


    public static void executeWorkflow(String idWorkflow) throws InterruptedException {

        boolean fin = false;

        response = httpRequest.post(baseURI + "/workflows/run/" + idWorkflow);

        String idExecution = response.getBody().asString().replaceAll("\"","");

        System.out.println(idExecution);

        setidExecutionforQR(idExecution);

        while (!fin) {

            response = httpRequest.get(baseURI + "/workflowExecutions/" + idExecution);

            String status = response.getBody().asString();

            if (status.contains("Finished")) {
                fin = true;
            }
            Thread.sleep(10000);
        }
    }

    public static void checkWorkflowQualityrules(String qualityRules,String qualityRulesresponse){

        //response = httpRequest.post(baseURI + "/workflows/run/" + idWorkflow);

        //String idExecution = response.getBody().asString().replaceAll("\"","");

        String workflowExecution = getidExecutionforQR();

        //System.out.println(idExecution);
    }


    public static void createCrossDataTable(String tableName, String hdfsPath){

        //SQL Statements for create dataTable
        String sqlCreate = "{\\n  \\\"query\\\": \\\"CREATE EXTERNAL TABLE "+ tableName + " STORED AS PARQUET LOCATION \\'" + hdfsPath + "\\'\\\"\\n}";

        //Create table
        response = httpRequest.body(sqlCreate).post(baseURI + "/crossdata/queries");

        //VALIDAR LA RESPUESTA
        String outputTable = response.getBody().asString();

    }


    public static String searchCrossDataTable(String tableName){

        //SQL Statements for search dataTable
        String sqlSearch = "{\\n  \\\"query\\\": \\\"SELECT FROM * " + tableName + "\\\"\\n}";

        //Search table
        response = httpRequest.body(sqlSearch).post(baseURI + "/crossdata/queries");

        //Save the response
        String outputTable = response.getBody().asString();

        return outputTable;
    }

    public static void deleteCrossDataTable(String tableName){
        //SQL Statements for create dataTable
        String sqlCreate = "{\\n  \\\"query\\\": \\\"DROP TABLE "+ tableName + "\\'\\\"\\n}";

        //Create table
        response = httpRequest.body(sqlCreate).post(baseURI + "/crossdata/queries");

        //VALIDAR LA RESPUESTA
        String outputTable = response.getBody().asString();
    }


    public static void executeWorkflowWithParameters(String idWorkflow, String name, String value) throws InterruptedException {

        boolean fin = false;

        String post = "{\n" +
                "  \"workflowId\": \"" + idWorkflow + "\",\n" +
                "  \"variables\": [\n" +
                "    {\n" +
                "      \"name\": \"" + name + "\",\n" +
                "      \"value\": \"" + value + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        response = given().relaxedHTTPSValidation()
                .body(post)
                .header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when()
                //.param("WorkflowExecutionVariables",post)
                .contentType("application/json")
                .post(baseURI + "/workflows/runWithVariables");


        String idExecution = response.getBody().asString().replaceAll("\"","");

        System.out.println(idExecution);


        while (!fin){

            resQueryExecution = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when().get(baseURI + "/workflowExecutions/" + idExecution);

            String status = resQueryExecution.getBody().asString();

            if (status.contains("Finished")){
                fin = true;
            }
            Thread.sleep(10000);
        }
    }

    public static void spartaServiceUp(String url){

        // If the input url is null then use the default baseURI, in the other case use the input baseURI
        baseURI = Objects.requireNonNullElse(url, "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus");

        response = httpRequest.get(baseURI);

        // Get the status code from the Response.
        // We should get a status code of 200.
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals("Correct status code returned",  200 /*expected value*/, statusCode /*actual value*/);

    }


}
