package stepsDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.UtilsSparta;


public class MyStepdefsSparta {

    @Given("^Ejecutamos el workflow \"([^\"]*)\" con parametro NAME \"([^\"]*)\" y VALUE \"([^\"]*)\"$")
    public void ejecutamosElWorkflowConParametroNAMEYVALUE(String idWorkflow, String name, String value) throws InterruptedException {

        UtilsSparta.executeWorkflowWithParameters(idWorkflow,name,value);

    }

    @Given("^Sparta esta operativo$")
    public void spartaEstaOperativo() {

        //Request to /appStatus to verify the service up
        UtilsSparta.spartaServiceUp();

    }

    @When("^Se ejecuta el workflow con Id \"([^\"]*)\"$")
    public void seEjecutaElWorkflowConId(String idWorkflow) throws InterruptedException {

        //Execute workflow without parameters
        UtilsSparta.executeWorkflow(idWorkflow);

    }

    @Then("^Se crea en XDATA la tabla \"([^\"]*)\" con el hdfs-output del workflow \"([^\"]*)\"$")
    public void seCreaEnXDATALaTablaConElHdfsOutputDelWorkflow(String tableName, String hdfsPath) {
        UtilsSparta.createCrossDataTable(tableName,hdfsPath);
    }

    @And("^Se aplican las reglas de calidad \"([^\"]*)\" y el resultado es \"([^\"]*)\"$")
    public void seAplicanLasReglasDeCalidadYElResultadoEs(String idQR, String resultQR) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Se comprueba que el resultado obtenido \"([^\"]*)\" coincide con el resultado esperado en XDATA \"([^\"]*)\"$")
    public void seCompruebaQueElResultadoObtenidoCoincideConElResultadoEsperadoEnXDATA(String tableNameActual, String tableNameExpected){

        String actual = UtilsSparta.searchCrossDataTable(tableNameActual);

        String expected = UtilsSparta.searchCrossDataTable(tableNameExpected);

        Assert.assertTrue(actual== expected);

    }

    @Then("^Se borra la tabla de XDATA \"([^\"]*)\"$")
    public void seBorraLaTablaDeXDATA(String tableName){

        UtilsSparta.deleteCrossDataTable(tableName);

    }
}
