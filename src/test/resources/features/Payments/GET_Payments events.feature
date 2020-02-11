@Manual
Feature: GET_Payments events

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los Eventos asociados a un Pago mediante el PaymentID para poder ver el detalle de los mismos

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de búsqueda de eventos de un Pago

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" con el parametro "<paymentId>"
    Then El servicio nos devuelve la respuesta "Payments/Output/GET_Payments_Events/<jsonOutputBody>"
    Examples:
      | paymentId                            | jsonOutputBody                  |
      | a2f4bd30-1365-4c2c-948b-43b257c38881 | paymentCompletedWithEvents.json |
      | qaf4bd30-1365-4c2c-948b-43b257c388qa | paymentOpenWithEvents.json      |
      | qa24bd30-1365-4c2c-948b-43b257c388qa | paymentRejectedWithEvents.json  |

  Scenario Outline: Casuisticas erroneas de busqueda de eventos de un Pago
    When Se realiza un request "GET" con el parametro "<paymentId>"
    Then El servicio nos devuelve la respuesta "<codeId>"
    Examples:
      | paymentId                            | codeId |
      | b22bcce7-6f39-4e52-9d6f-f9dc9432d797 | 204    |
      | Test1                                | 404    |


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


