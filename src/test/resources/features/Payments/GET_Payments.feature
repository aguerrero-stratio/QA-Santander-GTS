@Payments
Feature: GET_Payments

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los Pagos mediante distintos parámetros únicos o anidados (Account_Id, Bic, ...) para poder ver el detalle de los mismos

  Background:
    Given El dominio de payments esta levantado

  Scenario Outline: Casuisticas de busqueda de Pagos

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" al endpoint payments con el parametro "<paymentFilter>" y el valor "<value>"
    Then El servicio de payments nos devuelve la respuesta "/Payments/Output/GET/Payments/<jsonOutputBody>"
    Examples:
      | paymentFilter                         | value                                 | jsonOutputBody          |
      | account_id                            | ES8100490075473000562155              | accountId.json          |
      | account_id,status                     | ES8100490075473000562155,RJCT  | accountIdAndStatus.json |
#      | account_id,pageNumber,pageSize        | ES8100490075473000562155,0,1000       | accountId.json          |
#      | paymentId,d23742b8-1741-4ee6-a6a1-4d3fe2498f59               | paymentId.json   |
#      | searchText,d23742b8-1741-4ee6-a6a1-4d3fe2498f59,currency,EUR | paymentId.json   |
#      | searchText, 123123123                                        | noResults.json   |
#      |                                                              | noFilter.json    |
# ES8100490075473000562155


#  @Ignore
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


