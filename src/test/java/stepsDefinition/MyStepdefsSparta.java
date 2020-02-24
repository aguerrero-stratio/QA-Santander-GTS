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

    @When("^Se ejecuta el workflow con Id y parametros$")
    public void seEjecutaElWorkflowConIdYParametros(@NotNull DataTable idWokflowWithParameters) throws InterruptedException {

        //Execute workflow with parameters
        System.out.println("Ejecutar el flujo en Sparta con ID: "+idWokflowWithParameters.cells(0).get(0).get(1));
        UtilsSparta.executeWorkflowWithParameters(idWokflowWithParameters);

    }

    @Then("^Se crea en XDATA la tabla \"([^\"]*)\" con el hdfs-output del workflow \"([^\"]*)\"$")
    public void seCreaEnXDATALaTablaConElHdfsOutputDelWorkflow(String tableName, String hdfsPath) {

        //Create table in XDATA
        System.out.println("Crear la Tabla: "+tableName+" en XDATA con el hdfspath "+hdfsPath);
        UtilsSparta.createCrossDataTable(tableName,hdfsPath);
    }

    @And("^Se comprueba que el resultado obtenido \"([^\"]*)\" coincide con el resultado esperado en XDATA \"([^\"]*)\"$")
    public void seCompruebaQueElResultadoObtenidoCoincideConElResultadoEsperadoEnXDATA(String tableNameActual, String tableNameExpected){

        //Ask for the data contained into the XDATA table.
        String actual = UtilsSparta.searchCrossDataTable(tableNameActual);
        String expected = UtilsSparta.searchCrossDataTable(tableNameExpected);

        //Check the result of the test.
        //System.out.println("Comprobar que la Tabla: "+tableNameActual+" en XDATA coincide con la Tabla "+tableNameExpected);

        if (actual.equals(expected)) {
            Assert.assertEquals("The result of the "+tableNameActual+ " and the "+tableNameExpected+" are the same", actual, expected);
        }else{
            Assert.assertFalse("The result of the "+tableNameActual+ " and the "+tableNameExpected+" aren't the same", false);
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


    @When("^Se crea en XDATA la tabla \"([^\"]*)\" con la ruta hdfs \"([^\"]*)\"$")
    public void seCreaEnXDATALaTablaConLaRutaHdfs(String tableName, String hdfsPath) {
        // Write code here that turns the phrase above into concrete actions
        //Create table in XDATA
        System.out.println("Crear la Tabla: "+tableName+" en XDATA con el hdfspath "+hdfsPath);
        UtilsSparta.createCrossDataTable(tableName,hdfsPath);
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

    @Then("^Se comprueba que todos los ficheros de la listadeficheros han sido copiados en el destino \"([^\"]*)\"$")
    public void seCompruebaQueTodosLosFicherosDeLaListadeficherosHanSidoCopiadosEnElDestino(DataTable listaFicheros, String destination) {

        //
        // Write code here that turns the phrase above into concrete actions
    }

}