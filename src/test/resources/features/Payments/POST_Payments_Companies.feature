@Manual
Feature: POST_Payments_Companies

  Como usuario quiero tener en el dominio de Payments un endpoint que me permita dar de alta empresas con el servicio de Pain002 para poder generar el fichero .xml del mismo

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de creación de empresas

  Como usuario quiero realizar satisfactoriamente distintas creaciones de empresas para validar que el servicio se activa

    When Se realiza un request "POST" con el parametro "<jsonInputBody>"
    Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
    Examples:
      | jsonInputBody                | jsonOutputBody                                                  |


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