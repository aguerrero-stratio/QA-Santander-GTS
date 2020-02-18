package utils;

import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import schemas.MigracionWorkflows.MigracionWorkflow;
import schemas.Sparta.QualityRule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class


import static net.serenitybdd.rest.RestRequests.given;

public class UtilsSparta {

    // Ejecución script para obtener el usuario y el mesosphere_id necesario para conectarnos a la API de Sparta
    static Process p;

    static {
        try {
            p = Runtime.getRuntime().exec("python3 /home/alejandrosanchez/Documentos/Workspace/QA-Santander-GTS/src/test/resources/scripts/sso.py --url https://gts-sparta.sgcto-int.stratio.com/gts-sparta/#/ --user sparta --password stratio");
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
    private static String baseURI = "https://gts-sparta.sgcto-int.stratio.com/gts-sparta";
    private ValidatableResponse validatableResponse = null;
    private Response res;
    //******************************************************//
    private static Request request = null;
    private static Response response = null;
    private static RequestSpecification httpRequest = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when();

    public UtilsSparta() throws IOException {
    }

    @Test
    public void migracion() throws IOException {

        String [] idWorkflow = {"abadf8fc-af8a-4845-a139-62996acc6746"
                ,"07957f4c-1a82-4e74-8811-8dc822195319"
                ,"42202ef4-9cb9-47ab-92ca-7b3c1d045c3f"
                ,"53c71108-effb-430d-bb08-bf758b2bdee9"};

        downloadWorkflowJson(idWorkflow);
    }

    public static void downloadWorkflowJson(String[] idWorkflow) throws IOException {

        for (String s : idWorkflow) {

            Response responseMigracion = null;


            responseMigracion = given().relaxedHTTPSValidation().header("Cookie", user + "; " + mesosphere).header("Content-Type", "application/json").when().get("https://gts-sparta.sgcto-int.stratio.com:443/gts-sparta/workflows/download/" + s);

            String responseString = responseMigracion.getBody().asString();

            MigracionWorkflow migracionWorkflow = responseMigracion.as(MigracionWorkflow.class, ObjectMapperType.GSON);


            File myObj = new File("src/test/resources/files/" + migracionWorkflow.getName() + ".json");

            FileWriter myWriter = new FileWriter("src/test/resources/files/" + migracionWorkflow.getName() + ".json");

            myWriter.write(responseString);

            myWriter.close();

            System.out.println(responseString);

        }

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
        setidExecutionforQR(idExecution);

        System.out.println("ID de ejecucion: "+getIdExecutionforQR+" asociado al ID de workflow "+idWorkflow);

        while (!fin) {

            response = httpRequest.get(baseURI + "/workflowExecutions/" + idExecution);

            String status = response.getBody().asString();

            if (status.contains("Finished")) {
                fin = true;
            }
            Thread.sleep(10000);
        }

    }

    public static void checkWorkflowQualityrules(DataTable qualityRules) {

        //Fit the quality rules and their expected value into Strings Lists
        List<List<String>> listOfQualityRulesFromTest = qualityRules.asLists(String.class);

        //Get the execution Id from a WorkFlow to check their quality rules
        String idWorkflowExecution = getidExecutionforQR();

        // Only for Testing purposes
        //String idWorkflowExecution = "f915ee73-64a3-4da6-bc7e-d1289662002f"; // Mix KO + OK
        //String idWorkflowExecution = "99a92b7f-645d-4258-8fb3-5396d59e873e"; // all KO
        //String idWorkflowExecution = "48dfd9c1-5df6-4fec-8f96-f1154b2ab1da"; // all OK


        // Ask for the QualityRulesList associated to a IdworkflowExecution.
        response = httpRequest.get(baseURI + "/qualityRuleResults/executionId/" + idWorkflowExecution);
        String listOfQualityRulesObtained = response.asString();

        //Transform a JSON reponse into qualityRules Array objects
        Gson gson = new Gson();
        QualityRule[] arrayOfQualityRulestoFromTheJson = gson.fromJson(listOfQualityRulesObtained, QualityRule[].class);

        int numberOfQualityRuleChecked = 0;

        // Match the quality rule name obtained from the query and the quality rule name passed as parameter from the test
        for (List<String> strings : listOfQualityRulesFromTest) {
            for (QualityRule qualityRule : arrayOfQualityRulestoFromTheJson) {
                //When find a match of names, then check the expected result with the result obtained from the query
                if (strings.get(0).equals(qualityRule.getQualityRuleName().trim())) {
                    //Check the number of QR that accomplish the expected result
                    if ((strings.get(1).equals("OK")) && (qualityRule.getSatisfied())) {
                        //System.out.println("QR OK: "+strings.get(0));
                        numberOfQualityRuleChecked++;
                    } else if ((strings.get(1).equals("KO")) && (!qualityRule.getSatisfied())){
                        //System.out.println("QR KO: "+strings.get(0));
                        numberOfQualityRuleChecked++;
                    }
                }
            }
        }

        // If the expected result is not equal to the execution result, the test ends and store the results.
        Assert.assertEquals("\n QR CHECKED: " +arrayOfQualityRulestoFromTheJson.length+ "\n PASSED: " +numberOfQualityRuleChecked+ "\n NOT PASSED: "+ (arrayOfQualityRulestoFromTheJson.length-numberOfQualityRuleChecked),
                listOfQualityRulesFromTest.size(),numberOfQualityRuleChecked);
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

    public static void spartaServiceUp(String urlStatusSparta){

        // If the input url is null then use the default baseURI, in the other case use the input baseURI
        urlStatusSparta = Objects.requireNonNullElse(urlStatusSparta, "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/");

        response = httpRequest.get(urlStatusSparta);

        // Get the status code from the Response.
        // We should get a status code of 200.
        int statusCode = response.getStatusCode();

        System.out.println("Statuscode: "+statusCode);
        // Assert that correct status code is returned.
        Assert.assertEquals("Correct status code returned",  200 /*expected value*/, statusCode /*actual value*/);

    }


}
