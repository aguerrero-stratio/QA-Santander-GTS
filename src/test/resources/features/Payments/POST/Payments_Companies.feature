@Manual
Feature: POST_Payments_Companies

  Como usuario quiero tener en el dominio de Payments un endpoint que me permita dar de alta empresas con el servicio de Pain002 para poder generar el fichero .xml del mismo

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de creación de empresas

  Como usuario quiero realizar satisfactoriamente distintas creaciones de empresas para validar que el servicio se activa

    When Se realiza un request "POST" con el parametro "Payments/Input/POST_Payments_Company/<jsonInputBody>"
    Then El servicio nos devuelve la respuesta "Payments/Output/Post_Payments_Company/<jsonOutputBody>"
    Examples:
      | jsonInputBody          | jsonOutputBody           |
      | newCompanyPain002.json | newCompanyPain002.json   |
      | newCompanyPain002.json | companyAlreadyExist.json |


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