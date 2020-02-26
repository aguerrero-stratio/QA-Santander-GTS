@Payments @All
Feature: GET_Payments

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los Pagos mediante distintos parámetros únicos o anidados (Account_Id, Bic, ...) para poder ver el detalle de los mismos

  Background:
    Given El dominio de payments esta levantado

  Scenario Outline: Casuisticas de busqueda de Pagos

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" al dominio payments con el parametro "<paymentFilter>" y el valor "<value>"
    Then El servicio de payments nos devuelve la respuesta "/Payments/Output/GET/Payments/<jsonOutputBody>"
    Examples:
      | paymentFilter                      | value                                 | jsonOutputBody          |
      | account_id                         | ES8100490075473000562155              | accountId.json          |
      | paymentId                          | 7ec3f8b0-05fb-423c-8b6b-320918c1062b  | paymentId.json          |
      | amountFrom,amountTo                | 100,2000                              | amountFromTo.json       |
      | account_id,status                  | ES8100490075473000562155,RJCT         | accountIdAndStatus.json |
      | currency,idType,reason,status      | EUR,001,G000,RJCT                     | severalFilters.json      |
      | searchText                         | 423c                                  | searchText.json         |

  @Ignore
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