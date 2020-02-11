@Manual
Feature: GET_Payments Pain 002

  Como usuario quiero tener en el dominio de Payments un endpoint que me devuelva el fichero Pain002 de una cuenta en formato .xml para poder ver el detalle del mismo

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de busqueda de Cuentas

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" con el parametro "<accountId>"
    Then El servicio nos devuelve la respuesta "/Payments/Output/GET_Payments_Pain002/<jsonOutputBody>"
    Examples:
      | accountId                | jsonOutputBody            |
      | ES8500490072052610475299 | correctPain002.json       |
      | ES8500490072052610475290 | incorrectAccountId.json   |

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


