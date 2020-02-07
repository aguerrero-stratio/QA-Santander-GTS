@Manual
Feature: GET_Payments Pain 002

  Como usuario quiero tener en el dominio de Payments un endpoint que me devuelva el fichero Pain002 de una cuenta en formato .xml para poder ver el detalle del mismo

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de busqueda de Cuentas

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" con el parametro "<accountId>"
    Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
    Examples:
      | accountId                | jsonOutputBody                                                  |
      | ES8500490072052610475299 | /Payments/Output/GET_Payments_Pain002/correctPain002.json       |
      | ES8500490072052610475290 | /Payments/Output/GET_Payments_Pain002/incorrectAccountId.json   |

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


