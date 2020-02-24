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
import schemas.Sparta.QualityRules.QualityRule;
import schemas.Sparta.Workflow.SpartaWorkflowExecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class

import static net.serenitybdd.rest.RestRequests.given;

public class UtilsSparta {
    // Ejecución script para obtener el usuario y el mesosphere_id necesario para conectarnos a la API de Sparta
    private static String outputScriptCommand;

    //Contructor
    static {
        try {
            // Obtain the localpath from the computer
            String getLocalPath = new BufferedReader(new InputStreamReader(Runtime.getRuntime()
                    .exec("pwd")
                    .getInputStream())).readLine();
            System.out.println("LOCALPATH: "+ getLocalPath);

            // Execute a python script to connect to messos.
            outputScriptCommand = new BufferedReader(new InputStreamReader(Runtime.getRuntime()
                    .exec("python3 "+ getLocalPath +"/src/test/resources/scripts/sso.py --url https://gts-sparta.sgcto-int.stratio.com/gts-sparta/#/ --user sparta --password stratio")
                    .getInputStream())).readLine();
            System.out.println("COOKIE: "+ outputScriptCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // División de la respuesta del script para tener el usuario y el mesosphere_id por separado
    private static String[] primerSplit = outputScriptCommand.split(": ");
    private static String outputSplit = primerSplit[1];
    private static String[] segundoSplit = outputSplit.split("; ");
    private static String mesosphere = segundoSplit[0];
    private static String user = segundoSplit[1];
    private static String getIdExecutionforQR;

    // Variables globales
    private static Response resQueryExecution = null;
    private static String baseURI = WebServiceEndPoints.BASE_URI_DEV_SPARTA.getUrl();
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

        //Define local variables to execute the Workflow
        boolean fin = false;
        boolean failed = false;
        Gson gson = new Gson();
        String status = null;

        //Launch the Workflow Execution
        response = httpRequest.post(baseURI + WebServiceEndPoints.WORKFLOW_RUN.getUrl() + idWorkflow);

        //Check if the workflow ID exists.
        Assert.assertEquals("Workflow "+idWorkflow+" not found "+ response.getBody().asString(),200, response.getStatusCode());

        //Get IdExecution
        String idExecution = response.getBody().asString().replaceAll("\"","");
        setidExecutionforQR(idExecution);
        System.out.println("Obtener el ID de ejecucion: "+getIdExecutionforQR+" asociado al ID de workflow "+idWorkflow);

        while (!fin) {

            response = httpRequest.get(baseURI + WebServiceEndPoints.WORKFLOW_EXECUTION.getUrl() + idExecution);
            status = response.getBody().asString();

            // Finish the execution with a valid result.
            if (status.contains("Finished")) {
                fin = true;
                failed = false;
            }

            // Finish the execution with a Failed result.
            if (status.contains("Failed")) {
                fin = true;
                failed = true;
            }
            Thread.sleep(10000);
        }

        //System.out.println("El Workflow: "+idWorkflow+" ,ha finalizado");
        SpartaWorkflowExecution spartaWorkflowExecution = gson.fromJson(status, SpartaWorkflowExecution.class);
        System.out.println("Workflow Name: "+spartaWorkflowExecution.getGenericDataExecution().getWorkflow().getName());
        //System.out.println("Workflow Description: "+spartaWorkflowExecution.getGenericDataExecution().getWorkflow().getDescription());

        //Check the result of the execution of the workflow.
        Assert.assertFalse("The execution of the Workflow "+idWorkflow+" finished with an Status "
                + spartaWorkflowExecution.getStatuses().get(0).getState() +"Info: "+ spartaWorkflowExecution.getStatuses().get(0).getStatusInfo(), failed);
    }

    public static void executeWorkflowWithParameters(DataTable idWokflowWithParameters) throws InterruptedException {

        //Define local variables to execute the Workflow with parameters
        List<List<String>> idWorkflowWithParametersFromTest = idWokflowWithParameters.asLists(String.class);
        String idWorkflow = idWorkflowWithParametersFromTest.get(0).get(1);

        boolean fin = false;
        boolean failed = false;

        Gson gsonWithParameters = new Gson();
        String statusWithParameters = null;

        //Create the Json parameters structure to add to the workflow Execution.
        String workflowId ="{\"workflowId\":\"" + idWorkflow + "\",";
        StringBuilder arrayOfParameters = new StringBuilder();

        for(int indexParameter = 1;indexParameter < idWorkflowWithParametersFromTest.size();indexParameter++){

            arrayOfParameters.append("{\"name\":\"").append(idWorkflowWithParametersFromTest.get(indexParameter).get(0)).append("\",\"value\":\"").append(idWorkflowWithParametersFromTest.get(indexParameter).get(1)).append("\"}");

            if (indexParameter < idWorkflowWithParametersFromTest.size()-1){
                arrayOfParameters.append(",");
            }
        }

        String postAWorkflowWithParameters = workflowId+"\"variables\":["+arrayOfParameters+"]}";

        System.out.println("Parametros :"+ postAWorkflowWithParameters + " asociados al workflow " + idWorkflow);

        //Execute the workflowID with the parameters defined.
        response = httpRequest.body(postAWorkflowWithParameters).post(baseURI + WebServiceEndPoints.WORKFLOW_RUNWITHVARIABLES.getUrl());

        //Check if the workflow ID exists.
        Assert.assertEquals("Workflow "+idWorkflow+" not found "+ response.getBody().asString(),200, response.getStatusCode());

        //Set the ID workflow execution for check the Quality rules.
        String idExecution = response.getBody().asString().replaceAll("\"","");
        setidExecutionforQR(idExecution);
        System.out.println("Obtener el ID de ejecucion: "+getIdExecutionforQR+" asociado al ID de workflow "+idWorkflow);

        // Check the result of the workflow execution.
        while (!fin) {

            response = httpRequest.get(baseURI + WebServiceEndPoints.WORKFLOW_EXECUTION.getUrl() + idExecution);
            statusWithParameters = response.getBody().asString();

            // Finish the execution with a valid result.
            if (statusWithParameters.contains("Finished")) {
                fin = true;
                failed = false;
            }

            // Finish the execution with a Failed result.
            if (statusWithParameters.contains("Failed")) {
                fin = true;
                failed = true;
            }
            Thread.sleep(10000);
        }

        //System.out.println("El Workflow: "+idWorkflow+" ,ha finalizado");
        SpartaWorkflowExecution spartaWorkflowExecution = gsonWithParameters.fromJson(statusWithParameters, SpartaWorkflowExecution.class);
        System.out.println("Workflow Name: "+spartaWorkflowExecution.getGenericDataExecution().getWorkflow().getName());
        //System.out.println("Workflow Description: "+spartaWorkflowExecution.getGenericDataExecution().getWorkflow().getDescription());

        //Check the result of the execution of the workflow.
        Assert.assertFalse("The execution of the Workflow "+idWorkflow+" finished with an Status "
                + spartaWorkflowExecution.getStatuses().get(0).getState() +"Info: "+ spartaWorkflowExecution.getStatuses().get(0).getStatusInfo(), failed);
    }

    public static void checkWorkflowQualityrules(DataTable qualityRules) {

        //Fit the quality rules and their expected value into Strings Lists
        List<List<String>> listOfQualityRulesFromTest = qualityRules.asLists(String.class);

        System.out.println("Comprobar las QualityRules "+listOfQualityRulesFromTest.toString());

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
        Assert.assertEquals(
                "QR Obtained from API: " +arrayOfQualityRulestoFromTheJson.length+
                        "\n QR Passed as argument from test: " +listOfQualityRulesFromTest.size()+
                        "\n QR Matches: " +numberOfQualityRuleChecked+
                        "\n QR NOT Matches: "+ (arrayOfQualityRulestoFromTheJson.length-numberOfQualityRuleChecked),
                        listOfQualityRulesFromTest.size(),numberOfQualityRuleChecked);

        // If the Number of QR doesn't match from test and obtained.
        Assert.assertEquals(
                "The number of QR passed as argument" + listOfQualityRulesFromTest.size()
                        + "\n aren't the same than the obtained from Sparta"+ arrayOfQualityRulestoFromTheJson.length,
                listOfQualityRulesFromTest.size(),arrayOfQualityRulestoFromTheJson.length);
    }

    public static void createCrossDataTable(String tableName, String hdfsPath){

        //SQL Statements for create Table
        String sqlToSend = "{\"query\":\"CREATE TABLE "+tableName+" USING parquet OPTIONS (path = '"+hdfsPath+"',header = TRUE)\"}";

        //Create table on XDATA
        response = httpRequest.body(sqlToSend).post(baseURI + "/crossdata/queries");

        //System.out.println("RESPONSE RECEIVED "+ response.asString());
        //Check if the table is created correctly.
        Assert.assertEquals("Is not possible to create the table "+tableName+" review the response received "+response.asString(),200,response.getStatusCode());
    }


    public static String searchCrossDataTable(String tableName){

        //Make the SQL Statement to get the data
        String sqlSelectData = "{\"query\":\"SELECT * FROM "+tableName+"\"}";

        //Get the data stored into the table to compare Actual and Expected
        response = httpRequest.body(sqlSelectData).post(baseURI + "/crossdata/queries");

        //Save and return the data obtained.
        String outputTable = response.getBody().asString();

        return outputTable;
    }

    public static void deleteCrossDataTable(String tableName){

        //Make the SQL Statement to delete the table.
        String sqlDeleteTable = "{\"query\":\"DROP TABLE "+tableName+"\"}";

        //Create table
        response = httpRequest.body(sqlDeleteTable).post(baseURI + "/crossdata/queries");

        //System.out.println("RESPONSE RECEIVED "+ response.asString());
        //Check if the table is deleted correctly.
        Assert.assertEquals("Is not possible to delete the table "+tableName+" review the response received "+response.asString(),200,response.getStatusCode());
    }


    public static void spartaServiceUp(String urlStatusSparta){

        String baseURI = WebServiceEndPoints.BASE_URI_SPARTA_SWAGGER.getUrl() + WebServiceEndPoints.SPARTA_SWAGGER_STATUS.getUrl();

        response = httpRequest.get(urlStatusSparta);

        // Get the status code from the Response.
        // We should get a status code of 200.
        int statusCode = response.getStatusCode();
        System.out.println("Statuscode del URL API "+urlStatusSparta+" de SPARTA: "+ response.asString());

        // Assert that correct status code is returned.
        Assert.assertEquals("Correct status code returned",  200 /*expected value*/, statusCode /*actual value*/);
    }


    public static void checkVolumetricRule(String qrVolumetricName, String tableName) {

        //Make the SQL Statement to search for the last validation value associated to the quality volumetric rule.
        String sqlSelectValidationValue = "{\"query\":\"SELECT validation FROM "+tableName+" WHERE name =\\\""+qrVolumetricName+"\\\" AND validation_ts=(SELECT MAX(validation_ts) FROM "+tableName+")\"}";

        //Ask for the intormation to the API
        response = httpRequest.body(sqlSelectValidationValue).post(baseURI + "/crossdata/queries");

        //System.out.println("RESPONSE "+ response.asString());

        //Check if the table value is OK.
        Assert.assertTrue("The value of validation rule " + qrVolumetricName + " received is " + response.asString(), response.asString().contains("OK"));
    }


}
