package utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static net.serenitybdd.rest.RestRequests.given;

public class Utils_Sparta {

    // Ejecución script para obtener el usuario y el mesosphere_id necesario para conectarnos a la API de Sparta
    static Process p;

    static {
        try {
            p = Runtime.getRuntime().exec("python3 /home/jmtaborda/Documentos/Workspace/spartaAutomatedTest/src/test/resources/scripts/sso.py --url https://gts-sparta.sgcto-int.stratio.com/gts-sparta/#/ --user sparta --password stratio");
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

    // Variables globales
    private static Response resQueryExecution = null;
    private static String baseURI = "https://gts-sparta.sgcto-int.stratio.com:443/gts-sparta";
    private ValidatableResponse validatableResponse = null;
    private Response res;
    private static Response resQuery;

    public Utils_Sparta() throws IOException {
    }


    public static void executeWorkflow(String idWorkflow) throws InterruptedException {

        boolean fin = false;

        resQuery = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when().post(baseURI + "/workflows/run/" + idWorkflow);


        String idExecution = resQuery.getBody().asString().replaceAll("\"","");

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


    public static String createCrossDataTable(String sqlStatement){

        resQuery = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when().body(sqlStatement).post(baseURI + "/crossdata/queries");

        String output1 = resQuery.getBody().asString();

        return output1;
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

        resQuery = given().relaxedHTTPSValidation()
                .body(post)
                .header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/json").when()
                //.param("WorkflowExecutionVariables",post)
                .contentType("application/json")
                .post(baseURI + "/workflows/runWithVariables");


        String idExecution = resQuery.getBody().asString().replaceAll("\"","");

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
}
