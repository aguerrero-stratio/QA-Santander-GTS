package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.Utils_Sparta;


public class MyStepdefs_Sparta {

    private String output1 = null;
    private String output2 = null;
    //String param = System.getProperty("my_parameter1");
    //private String baseURI = param;

    public MyStepdefs_Sparta() {
    }

    @Then("^Comparamos ambos y el resultado coincide$")
    public void comparamosAmbosYElResultadoCoincide() {

        Assert.assertEquals(output2, output1);

    }

    @Given("^Ejecutamos el workflow \"([^\"]*)\"$")
    public void ejecutamosElWorkflow(String idWorkflow) throws InterruptedException {

        Utils_Sparta.executeWorkflow(idWorkflow);

    }


    @And("^Creamos la tabla en crossdata \"([^\"]*)\" del workflow con la ruta de parquet \"([^\"]*)\"$")
    public void creamosLaTablaEnCrossdataDelWorkflowConLaRutaDeParquet(String tablaCrossdata, String rutaParquet) throws Throwable {

        String requestBody = "{\n" +
                "  \"query\": \"CREATE EXTERNAL TABLE " + tablaCrossdata + " STORED AS PARQUET LOCATION '" + rutaParquet + "'\"\n" +
                "}";

        Utils_Sparta.createCrossDataTable(requestBody);


    }

    @Given("^Obtenemos el output del workflow actual \"([^\"]*)\"$")
    public void obtenemosElOutputDelWorkflowActual(String tablaCrossdata)  {

        String requestBody = "{\n" +
                "  \"query\": \"SELECT * FROM " + tablaCrossdata + "\"\n" +
                "}";

        output1 = Utils_Sparta.createCrossDataTable(requestBody);

        System.out.println(output1);

    }

    @Given("^Obtenemos el output del workflow esperado \"([^\"]*)\"$")
    public void obtenemosElOutputDelWorkflowEsperado(String tablaCrossdata)  {

        String requestBody = "{\n" +
                "  \"query\": \"SELECT * FROM " + tablaCrossdata + "\"\n" +
                "}";

        output2 = Utils_Sparta.createCrossDataTable(requestBody);

        System.out.println(output2);

    }

    @Given("^Ejecutamos el workflow \"([^\"]*)\" con parametro NAME \"([^\"]*)\" y VALUE \"([^\"]*)\"$")
    public void ejecutamosElWorkflowConParametroNAMEYVALUE(String idWorkflow, String name, String value) throws InterruptedException {

        Utils_Sparta.executeWorkflowWithParameters(idWorkflow,name,value);


    }
}
