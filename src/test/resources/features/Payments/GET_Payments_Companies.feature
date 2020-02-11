@Manual
Feature: GET_Payments_Companies

  Como usuario quiero tener en el dominio de Payments un endpoint que me permita consultar las empresas con el servicio de Pain002 para poder generar el fichero .xml del mismo

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de consulta de empresas

  Como usuario quiero realizar satisfactoriamente distintas consultas de empresas para validar que el servicio muestra la información correctamente

    When Se realiza un request "GET" con el parametro "<jsonInputBody>"
    Then El servicio nos devuelve la respuesta "Payments/Output/GET_Payments_Company/<jsonOutputBody>"
    Examples:
      | jsonInputBody | jsonOutputBody                    |
      | Test1         | companyWithoutAccountPain002.json |
      | Test3         | companyNoExist.json               |


  Scenario: Busqueda de empresa
    When Se realiza un request "GET" con el parametro "Test1"
    Then El servicio nos devuelve la respuesta "Payments/Output/Post_Payments_Company/newCompanyPain002.json"


  Scenario Outline: Control de errores

  Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

    When Se realiza un request erronea "<errorRequest>"
    Then El servicio nos devuelve la respuesta "/errorResponse/<errorResponse>"
    Examples:
      | errorRequest       | errorResponse         |
      | Bad Request        | badRequest.json       |
      | Unauthorized       | unauthorized.json     |
      | Forbidden          | forbidden.json        |
      | Not found          | notFound.json         |
      | Method nor allowed | methodNotAllowed.json |