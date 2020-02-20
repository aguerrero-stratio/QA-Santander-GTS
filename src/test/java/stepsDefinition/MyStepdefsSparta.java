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

import java.io.IOException;


public class MyStepdefsSparta {

    @Given("^Ejecutamos el workflow \"([^\"]*)\" con parametro NAME \"([^\"]*)\" y VALUE \"([^\"]*)\"$")
    public void ejecutamosElWorkflowConParametroNAMEYVALUE(String idWorkflow, String name, String value) throws InterruptedException {

        UtilsSparta.executeWorkflowWithParameters(idWorkflow,name,value);

    }

    @Given("^Sparta operativo en la url \"([^\"]*)\"$")
    public void spartaEstaOperativo(String urlStatusSparta) {

        //Request to /appStatus to verify the service up
        UtilsSparta.spartaServiceUp(urlStatusSparta);

    }

    @When("^Se ejecuta el workflow con Id \"([^\"]*)\"$")
    public void seEjecutaElWorkflowConId(String idWorkflow) throws InterruptedException {

        //Execute workflow without parameters
        System.out.println("Ejecutar el flujo en Sparta con ID: "+idWorkflow);
        UtilsSparta.executeWorkflow(idWorkflow);

    }

    @Then("^Se crea en XDATA la tabla \"([^\"]*)\" con el hdfs-output del workflow \"([^\"]*)\"$")
    public void seCreaEnXDATALaTablaConElHdfsOutputDelWorkflow(String tableName, String hdfsPath) {

        //Create table in XDATA
        //System.out.println("TABLE: "+tableName);
        //System.out.println("PATH: "+ hdfsPath);
        System.out.println("Crear la Tabla: "+tableName+" en XDATA con el hdfspath "+hdfsPath);
        UtilsSparta.createCrossDataTable(tableName,hdfsPath);
    }

    @And("^Se comprueba que el resultado obtenido \"([^\"]*)\" coincide con el resultado esperado en XDATA \"([^\"]*)\"$")
    public void seCompruebaQueElResultadoObtenidoCoincideConElResultadoEsperadoEnXDATA(String tableNameActual, String tableNameExpected){

        //Ask for the data contained into the XDATA table.
        String actual = UtilsSparta.searchCrossDataTable(tableNameActual);
        String expected = UtilsSparta.searchCrossDataTable(tableNameExpected);

        //System.out.println("tableNameActual - " + actual);
        //System.out.println("tableNameExpected - " + expected);

        //Check the result of the test.
        System.out.println("Comprobar que la Tabla: "+tableNameActual+" en XDATA coincide con la Tabla "+tableNameExpected);
        if (actual.equals(expected)) {
            Assert.assertEquals("The result of the "+tableNameActual+ " and the "+tableNameExpected+" are the same", actual, expected);
        }else{
            Assert.assertFalse("The result of the "+tableNameActual+ " and the "+tableNameExpected+"aren't the same", false);
        }
    }

    @Then("^Se borra la tabla de XDATA \"([^\"]*)\"$")
    public void seBorraLaTablaDeXDATA(String tableNameToDelete){

        //System.out.println("Se borra la tabla - " + tableName);
        //Delete the tables used for the test
        System.out.println("Borrar la Tabla: "+tableNameToDelete+" en XDATA");
        UtilsSparta.deleteCrossDataTable(tableNameToDelete);

    }

    @Then("^Se aplican las siguientes reglas de calidad con resultado$")
    public void seAplicanLasSiguientesReglasDeCalidadConResultado(@NotNull DataTable Qrules) {

        //Check the results of the Quality Rules.
        UtilsSparta.checkWorkflowQualityrules(Qrules);
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
    public void seCreaEnXDATALaTablaConLaRutaHdfs(String tableName, String hdfsPath) {
        // Write code here that turns the phrase above into concrete actions
        //Create table in XDATA
        System.out.println("Crear la Tabla: "+tableName+" en XDATA con el hdfspath "+hdfsPath);
        UtilsSparta.createCrossDataTable(tableName,hdfsPath);
    }

    @Then("^Se ejecuta el workflow con Id \"([^\"]*)\" seleccionando como input las tablas:$")
    public void seEjecutaElWorkflowConIdSeleccionandoComoInputLasTablas(String idWorkflow, DataTable Ltables) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^El resultado obtenido se guarda en la BBDD \"([^\"]*)\"$")
    public void elResultadoObtenidoSeGuardaEnLaBBDD(String arg0) throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        //OneVIEW

        throw new PendingException();
    }

    @And("^Se comprueba que el resultado almacenado en BBDD \"([^\"]*)\" coincide con el resultado esperado en BBDD \"([^\"]*)\"$")
    public void seCompruebaQueElResultadoAlmacenadoEnBBDDCoincideConElResultadoEsperadoEnBBDD(String arg0, String arg1) throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        // OneVIEW

        throw new PendingException();
    }

    @Then("^Se comprueba el valor de validacion de la regla de volumetria \"([^\"]*)\" almacenado en la tabla de XDATA \"([^\"]*)\"$")
    public void seCompruebaElValorDeValidacionDeLaReglaDeVolumetriaAlmacenadoEnLaTablaDeXDATA(String qrVolumetricName, String tableName){

        // Check the volumetric rules
        UtilsSparta.checkVolumetricRule(qrVolumetricName,tableName);
    }
}