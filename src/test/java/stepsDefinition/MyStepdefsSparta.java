package stepsDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utils.UtilsSparta;


public class MyStepdefsSparta {

    private String output1 = null;
    private String output2 = null;
    //String param = System.getProperty("my_parameter1");
    //private String baseURI = param;

    public MyStepdefsSparta() {
    }

    @Then("^Comparamos ambos y el resultado coincide$")
    public void comparamosAmbosYElResultadoCoincide() {

        Assert.assertEquals(output2, output1);

    }

    @Given("^Ejecutamos el workflow \"([^\"]*)\"$")
    public void ejecutamosElWorkflow(String idWorkflow) throws InterruptedException {

        UtilsSparta.executeWorkflow(idWorkflow);

    }


    @And("^Creamos la tabla en crossdata \"([^\"]*)\" del workflow con la ruta de parquet \"([^\"]*)\"$")
    public void creamosLaTablaEnCrossdataDelWorkflowConLaRutaDeParquet(String tablaCrossdata, String rutaParquet) throws Throwable {

        String requestBody = "{\n" +
                "  \"query\": \"CREATE EXTERNAL TABLE " + tablaCrossdata + " STORED AS PARQUET LOCATION '" + rutaParquet + "'\"\n" +
                "}";

        UtilsSparta.createCrossDataTable(requestBody);


    }

    @Given("^Obtenemos el output del workflow actual \"([^\"]*)\"$")
    public void obtenemosElOutputDelWorkflowActual(String tablaCrossdata)  {

        String requestBody = "{\n" +
                "  \"query\": \"SELECT * FROM " + tablaCrossdata + "\"\n" +
                "}";

        output1 = UtilsSparta.createCrossDataTable(requestBody);

        System.out.println(output1);

    }

    @Given("^Obtenemos el output del workflow esperado \"([^\"]*)\"$")
    public void obtenemosElOutputDelWorkflowEsperado(String tablaCrossdata)  {

        String requestBody = "{\n" +
                "  \"query\": \"SELECT * FROM " + tablaCrossdata + "\"\n" +
                "}";

        output2 = UtilsSparta.createCrossDataTable(requestBody);

        System.out.println(output2);

    }

    @Given("^Ejecutamos el workflow \"([^\"]*)\" con parametro NAME \"([^\"]*)\" y VALUE \"([^\"]*)\"$")
    public void ejecutamosElWorkflowConParametroNAMEYVALUE(String idWorkflow, String name, String value) throws InterruptedException {

        UtilsSparta.executeWorkflowWithParameters(idWorkflow,name,value);


    }
}
