package steps;

import au.com.bytecode.opencsv.CSVReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.io.*;
import java.util.Arrays;
import static io.restassured.RestAssured.*;

/**
 * PreparacionEntornoSteps
 */
public class PreparacionEntornoSteps {

    private Response res = null; //Response
    private String baseURI = System.getProperty("baseURI");
    private String userSparta = System.getProperty("userSparta");
    private String passSparta = System.getProperty("passSparta");
    private ValidatableResponse validatableResponse = null;
    public static final char SEPARATOR = ',';
    public static final char QUOTE = '"';

    // Ejecución script para obtener el usuario y el mesosphere_id necesario para conectarnos a la API de Sparta
    Process p = Runtime.getRuntime().exec("python3 src/test/resources/scripts/sso.py --url "+ baseURI + "#/ --user "+ userSparta +" --password "+ passSparta);

    private BufferedReader stdInput = new BufferedReader(new
            InputStreamReader(p.getInputStream()));

    private String outputScript = stdInput.readLine();

    // División de la respuesta del script para tener el usuario y el mesosphere_id por separado
    private String[] primerSplit = outputScript.split(": ");
    private String outputSplit = primerSplit[1];
    private String[] segundoSplit = outputSplit.split("; ");
    private String mesosphere = segundoSplit[0];
    private String  user = segundoSplit[1];

    public PreparacionEntornoSteps() throws IOException {
    }

    /**
     * checkStatusSparta
     */
    @Step
    public void checkStatusSparta (){

        res = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/x-www-form-urlencoded").when().get(baseURI + "#");

        int statusCode = res.getStatusCode();

        Assert.assertEquals("Correct status code returner",statusCode , 200);


        String output = "Sparta está operativo";

        System.out.println(output);

    }

    /**
     * autentificacionCorrecta
     */
    @Step
    public void autentificacionCorrecta(){

        System.out.println(user);
        System.out.println(mesosphere);

    }

    /**
     * sendRequestToEndPoint
     */
    @Step
    public void sendRequestToEndPoint(String endPoint){

        res = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/x-www-form-urlencoded").when().get(baseURI + endPoint);

        int statusCode = res.getStatusCode();

        Assert.assertEquals("Correct status code returner",statusCode , 200);


    }


    /**
     * fileExists
     */
    @Step
    public void fileExists(String fileName){
        //Declaramos la ruta del archivo
        String rutaArchivo = "src/test/resources/files/" + fileName;

        File ficheroComparador = new File(rutaArchivo);

        if(ficheroComparador.exists()){
            System.out.println("El fichero existe");
        }else
            System.out.println("El fichero no se encuentra o no existe en la ruta especificada");
    }

    /**
     * comparisonFiles
     */
    @Step
    public void comparisonFiles (String fileOutput, String fileComparison) throws IOException {

        //Declaramos la ruta del archivo
        String rutaArchivo = "src/test/resources/files/" + fileOutput;

        File ficheroOutputWF = new File(rutaArchivo);

        if(ficheroOutputWF.exists()){
            System.out.println("El fichero de salida del workflow existe");
        }else
            System.out.println("El fichero de salida del workflow no se encuentra o no existe en la ruta especificada");

        //Definimos los lectores de los ficheros
        CSVReader reader = null;
        CSVReader reader2 = null;

        reader = new CSVReader(new FileReader("src/test/resources/files/" + fileOutput), SEPARATOR, QUOTE);
        String[] nextLine = null;

        reader2 = new CSVReader(new FileReader("src/test/resources/files/" + fileComparison), SEPARATOR, QUOTE);
        String[] nextLine2 = null;

        //Realizamos la comparación fila por fila de ambos ficheros
        for (int i = 0; (nextLine = reader.readNext()) != null && (nextLine2 = reader2.readNext()) != null; i++) {

            if (!(Arrays.toString(nextLine).equals(Arrays.toString(nextLine2)))) {
                System.out.println("KO: Está fallando la fila " + (i + 1) + " del archivo Output del Workflow");
                System.out.println(Arrays.toString(nextLine) + "  ||  " + Arrays.toString((nextLine2)));
            }
        }

    }

}
