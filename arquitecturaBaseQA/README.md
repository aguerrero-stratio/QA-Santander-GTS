-D# Arquetipo QA Squad Financiero

Arquetipo de framework para la integración del producto de Stratio con las herramientas y utilidades necesarias para realizar los procesos de QA referentes a Sparta y a microservicios.
La arquitectura está basada en:
 ```S
                RestAssured + SerenityBDD + Cucumber 
```
 ### Pre-requisitos 📋

Entorno de Sparta operativo, urls del mismo y creedenciales de acceso.


### Instalación 🔧

El proyecto está configurado por capas. Las tres capas principales son:

* Features: Escritas en lenguage Gherkin y compuestas por Scenarios, describen las funcionalidades/requisitos a probar.


```
Feature: HU_002_Validacion inicial del estado de Sparta

  Validaciones necesarias en Sparta previas a la ingesta de datos en Landing

  Background: Sparta esta operativo
    Given Sparta esta operativo

    Scenario: Control sobre el API de Sparta
      When Lanzo una llamada al endpoint "/workflowExecutions"
      Then Sparta devuelve "Las ultimas ejecuciones de workflows"

    Scenario: Validacion de ficheros csv comparadores
      And Existe el fichero csv comparador "tc_company_registration_details_201811_TRFLanding.csv"
      Then El proceso puede iniciarse
```

* StepDefinitions: Capa en donde se relaciona cada uno de los steps del Scenario con los métodos de código.
```
    @Given("^Sparta esta operativo$")
    public void spartaEstaOperativo() {

        preparacionEntornoSteps.checkStatusSparta();

    }

    @When("^Lanzo una llamada al endpoint \"([^\"]*)\"$")
    public void lanzoUnaLlamadaAlEndpoint(String arg0) throws Throwable {

        preparacionEntornoSteps.sendRequestToEndPoint(arg0);
    }
```

* Steps: Capa donde se implementa el código que ejecutan los métodos de la capa StepDefinitions.
```
    @Step
    public void checkStatusSparta (){

        res = given().relaxedHTTPSValidation().header("Cookie",user + "; "+ mesosphere).header("Content-Type","application/x-www-form-urlencoded").when().get(baseURI);

        int statusCode = res.getStatusCode();

        Assert.assertEquals("Correct status code returner",statusCode , 200);


        String output = "Sparta está operativo";

        System.out.println(output);

    }

    @Step
    public void autentificacionCorrecta(){

        System.out.println(user);
        System.out.println(mesosphere);

    }
```


## Ejecutando las pruebas ⚙️

Para construir el proyecto de pruebas, lo realizaremos a través de maven, añadiendo los parámetros de URL de Sparta, Usuario y Contraseña: 

```

mvn clean verify -DbaseURI="url de sparta" -DuserSparta="usuario de Sparta" - DpassSparta="contraseña de Sparta"
```


## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Herramienta de software para la gestión y construcción de proyectos Java
* [Cucumber](https://cucumber.io/) - Herramienta de software utilizada por los programadores de computadoras que admite el desarrollo basado en el comportamiento
* [RestAssured](http://rest-assured.io/) - Framework para realizar Test de servicios REST
* [SerenityBDD](http://www.thucydides.info/#/) - Herramienta que nos facilita hacer BDD y genera reportes completos de los resultados de nuestras pruebas


## Versionado 📌

1.0.0 Trabajo inicial de creación del framework

## Autores ✒️

* **Juan Manuel Taborda Carpintero** - *Trabajo Inicial* - [jmtaborda](jmtaborda@stratio.com)


---
⌨️ con ❤️ por [jmtaborda](jmtaborda@stratio.com) 😊
