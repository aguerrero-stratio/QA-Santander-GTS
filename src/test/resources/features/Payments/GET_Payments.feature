@Manual
Feature: GET_Payments

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los Pagos mediante distintos parámetros únicos o anidados (Account_Id, Bic, ...) para poder ver el detalle de los mismos

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de busqueda de Pagos

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" con el parametro "<paymentFilter>"
    Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
    Examples:
      | paymentFilter                                                | jsonOutputBody                                 |
      | account_id,ES8500490072052610475299                          | /Payments/Output/GET_Payments/accountId.json   |
      | paymentId,d23742b8-1741-4ee6-a6a1-4d3fe2498f59               | /Payments/Output/GET_Payments/paymentId.json   |
      | searchText,d23742b8-1741-4ee6-a6a1-4d3fe2498f59,currency,EUR | /Payments/Output/GET_Payments/paymentId.json   |
      | searchText, 123123123                                        | /Payments/Output/GET_Payments/noResults.json   |
      |                                                              | /Payments/Output/GET_Payments/noFilter.json    |

  Scenario: Búsqueda aleatoria de pagos
    When Se realiza una request aleatoria de "10" busquedas
    Then En la respuesta se incluye el parametro de busqueda

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


