@Manual
Feature: GET_Payments_Companies

  Como usuario quiero tener en el dominio de Payments un endpoint que me permita consultar las empresas con el servicio de Pain002 para poder generar el fichero .xml del mismo

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de consulta de empresas

  Como usuario quiero realizar satisfactoriamente distintas consultas de empresas para validar que el servicio muestra la información correctamente

    When Se realiza un request "GET" con el parametro "<jsonInputBody>"
    Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
    Examples:
      | jsonInputBody | jsonOutputBody                                                         |
      | Test1         | Payments/Output/GET_Payments_Company/companyWithoutAccountPain002.json |
      | Test3         | Payments/Output/GET_Payments_Company/companyNoExist.json               |


  Scenario: Busqueda de empresa
    When Se realiza un request "GET" con el parametro "Test1"
    Then El servicio nos devuelve la respuesta "Payments/Output/Post_Payments_Company/newCompanyPain002.json"


  Scenario Outline: Control de errores

  Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

    When Se realiza una request erronea "GET" "<errorRequest>"
    Then El servicio nos devuelve la respuesta "<errorResponse>"
    Examples:
      | errorRequest       | errorResponse                        |
      | Bad Request        | /errorResponse/badRequest.json       |
      | Unauthorized       | /errorResponse/unauthorized.json     |
      | Forbidden          | /errorResponse/forbidden.json        |
      | Not found          | /errorResponse/notFound.json         |
      | Method nor allowed | /errorResponse/methodNotAllowed.json |