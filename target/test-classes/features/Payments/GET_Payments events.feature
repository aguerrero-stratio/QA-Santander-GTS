@Manual
Feature: GET_Payments events

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los Eventos asociados a un Pago mediante el PaymentID para poder ver el detalle de los mismos

  Background:
    Given El dominio de "Payments" esta levantado

  Scenario Outline: Casuisticas de búsqueda de eventos de un Pago

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" con el parametro "<paymentId>"
    Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
    Examples:
      | paymentId                                                    | jsonOutputBody                                 |


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


