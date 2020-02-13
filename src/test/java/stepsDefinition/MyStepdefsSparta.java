package stepsDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import utils.UtilsSparta;

import java.util.List;


public class MyStepdefsSparta {

    @Given("^Ejecutamos el workflow \"([^\"]*)\" con parametro NAME \"([^\"]*)\" y VALUE \"([^\"]*)\"$")
    public void ejecutamosElWorkflowConParametroNAMEYVALUE(String idWorkflow, String name, String value) throws InterruptedException {

        UtilsSparta.executeWorkflowWithParameters(idWorkflow,name,value);

    }

    @Given("^Sparta operativo en la url \"([^\"]*)\"$")
    public void spartaEstaOperativo(String url) {

        //Request to /appStatus to verify the service up
        UtilsSparta.spartaServiceUp(url);

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

    @And("^Se aplican las reglas de calidad \"([^\"]*)\" con resultado \"([^\"]*)\"$")
    public void seAplicanLasReglasDeCalidadYElResultadoEs(String idQR, String resultQR) {
        // Write code here that turns the phrase above into concrete actions
        UtilsSparta.checkWorkflowQualityrules(idQR,resultQR);
    }

    @And("^Se comprueba que el resultado obtenido \"([^\"]*)\" coincide con el resultado esperado en XDATA \"([^\"]*)\"$")
    public void seCompruebaQueElResultadoObtenidoCoincideConElResultadoEsperadoEnXDATA(String tableNameActual, String tableNameExpected){

        String actual = UtilsSparta.searchCrossDataTable(tableNameActual);

        String expected = UtilsSparta.searchCrossDataTable(tableNameExpected);

        Assert.assertTrue(actual == expected);

    }

    @Then("^Se borra la tabla de XDATA \"([^\"]*)\"$")
    public void seBorraLaTablaDeXDATA(String tableName){

        UtilsSparta.deleteCrossDataTable(tableName);

    }

    @Then("^Se aplican las siguientes reglas de calidad con resultado$")
    public void seAplicanLasSiguientesReglasDeCalidadConResultado(@NotNull DataTable Qrules) {
        List<String> listOfQR = Qrules.asList(String.class);
        System.out.println("Resultado - " + listOfQR.get(0));
        System.out.println("Name - " + listOfQR.get(1));
    }

    @Then("^Se recogen los ficheros de la carpeta origen \"([^\"]*)\"$")
    public void seRecogenLosFicherosDeLaCarpetaOrigen(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Se copian a una carpeta destino \"([^\"]*)\"$")
    public void seCopianAUnaCarpetaDestino(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Se comprueba que todos los ficheros de la \"([^\"]*)\" han sido copiados en el destino \"([^\"]*)\"$")
    public void seCompruebaQueTodosLosFicherosDeLaHanSidoCopiadosEnElDestino(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Se comprueba el \"([^\"]*)\" del ultimo resultado almacenado en la tabla de XDATA \"([^\"]*)\"$")
    public void seCompruebaElDelUltimoResultadoAlmacenadoEnLaTablaDeXDATA(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Se crea en XDATA la tabla \"([^\"]*)\" con la ruta hdfs \"([^\"]*)\"$")
    public void seCreaEnXDATALaTablaConLaRutaHdfs(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Se ejecuta el workflow con Id \"([^\"]*)\" seleccionando como input las tablas:$")
    public void seEjecutaElWorkflowConIdSeleccionandoComoInputLasTablas(String idWorkflow, DataTable Ltables) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^El resultado obtenido se guarda en la BBDD \"([^\"]*)\"$")
    public void elResultadoObtenidoSeGuardaEnLaBBDD(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Se comprueba que el resultado almacenado en BBDD \"([^\"]*)\" coincide con el resultado esperado en BBDD \"([^\"]*)\"$")
    public void seCompruebaQueElResultadoAlmacenadoEnBBDDCoincideConElResultadoEsperadoEnBBDD(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
