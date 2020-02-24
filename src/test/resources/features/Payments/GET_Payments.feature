@Payments
Feature: GET_Payments

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los Pagos mediante distintos parámetros únicos o anidados (Account_Id, Bic, ...) para poder ver el detalle de los mismos

  Background:
    Given El dominio de payments esta levantado

  Scenario Outline: Casuisticas de busqueda de Pagos

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" al endpoint payments con el parametro "<paymentFilter>"
    Then El servicio payments nos devuelve la respuesta "/Payments/Output/GET_Payments/<jsonOutputBody>"
    Examples:
      | paymentFilter                                                | jsonOutputBody   |
      | account_id=ES8100490075473000562155                          | accountId.json   |
      | paymentId,7ec3f8b0-05fb-423c-8b6b-320918c1062b               | paymentId.json   |
      | account_id,ES8100490075473000562155,status,ACSP              | accountId.json   |
#      | searchText,d23742b8-1741-4ee6-a6a1-4d3fe2498f59,currency,EUR | paymentId.json   |
#      | searchText, 123123123                                        | noResults.json   |
#      |                                                              | noFilter.json    |

#  Scenario: Búsqueda aleatoria de pagos
#    When Se realiza una request aleatoria de "10" busquedas
#    Then En la respuesta se incluye el parametro de busqueda
#
#  Scenario Outline: Control de errores
#
#  Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo
#
#    When Se realiza un request erronea "<errorRequest>"
#    Then El servicio nos devuelve la respuesta "/errorResponse/<errorResponse>"
#    Examples:
#      | errorRequest       | errorResponse         |
#      | Bad Request        | badRequest.json       |
#      | Unauthorized       | unauthorized.json     |
#      | Forbidden          | forbidden.json        |
#      | Not found          | notFound.json         |
#      | Method nor allowed | methodNotAllowed.json |


